package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.song.SongRepository;

import javax.persistence.Transient;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final SongRepository songRepository;


    public AuthorController(AuthorRepository authorRepository, SongRepository songRepository) {
        this.authorRepository = authorRepository;
        this.songRepository = songRepository;
    }


    @RequestMapping("/list")
    public String authorList(Model model, Author author){
        model.addAttribute("authors", authorRepository.findAllAuthors());

        //model.addAttribute("songNumber", authorRepository.countAllSongsByAuthor(long id));
//        Jak zdobyć ID autora do policzenia piosenek?
        return "authorList";
    }
    @RequestMapping("/list/{id}")
    public String authorSongs(Model model, @PathVariable("id") long id){
        model.addAttribute("songs", songRepository.findAllByAuthor(id));
        return "authorsSongs";
    }


}
