package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.song.SongRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final SongRepository songRepository;
    private final UserRepository userRepository;


    public AuthorController(AuthorRepository authorRepository, SongRepository songRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping("/list")
    public String authorList(Model model){
        model.addAttribute("authors", authorRepository.findAllAuthors());
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "author/authorList";
    }
    @RequestMapping("/{id}")
    public String authorSongs(Model model, @PathVariable("id") long id){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        Author author = authorRepository.readAuthorById(id);
        model.addAttribute("authorsName",author.getName());
        model.addAttribute("songs", songRepository.findAllByAuthor(id));
        return "author/authorsSongs";
    }


}
