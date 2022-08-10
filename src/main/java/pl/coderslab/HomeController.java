package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.set.SongSetRepository;
import pl.coderslab.song.Song;
import pl.coderslab.song.SongRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

@Controller
public class HomeController {
    private final SongRepository songRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final SongSetRepository songSetRepository;

    public HomeController(SongRepository songRepository, AuthorRepository authorRepository, UserRepository userRepository, SongSetRepository songSetRepository) {
        this.songRepository = songRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
        this.songSetRepository = songSetRepository;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("liczbaPiosenek",songRepository.countAllSongs());
        model.addAttribute("authorsNumber",authorRepository.countAuthors());
        model.addAttribute("usersSongs", songRepository.countSongsByUser(1));
        model.addAttribute("usersSets",songSetRepository.countAllByUser(1));
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());

        Song lastSong = songRepository.findLastSong();
        model.addAttribute("title", lastSong.getTitle());
        model.addAttribute("author", lastSong.getAuthor());
        model.addAttribute("tempo", lastSong.getTempo());
        model.addAttribute("songKey", lastSong.getSongKey());
        return "index";
    }


    @RequestMapping("/about")
    public String aboutUs(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "about";
    }

    @RequestMapping("/forgot-password")
    public String forgotPassword(){
        return "forgotPassword";
    }
}
