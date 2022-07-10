package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.song.Song;
import pl.coderslab.song.SongRepository;


@Controller
public class HomeController {
    private final SongRepository songRepository;
    private final AuthorRepository authorRepository;

    public HomeController(SongRepository songRepository, AuthorRepository authorRepository) {
        this.songRepository = songRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("liczbaPiosenek",songRepository.countAllSongs());
        model.addAttribute("authorsNumber",authorRepository.countAuthors());
        Song lastSong = songRepository.findLastSong();
        model.addAttribute("title", lastSong.getTitle());
        model.addAttribute("author", lastSong.getAuthor());
        model.addAttribute("tempo", lastSong.getTempo());
        model.addAttribute("songKey", lastSong.getSongKey());
        return "index";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/about")
    public String aboutUs(){
        return "about";
    }
}
