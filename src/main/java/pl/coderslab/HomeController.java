package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.song.Song;
import pl.coderslab.song.SongRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;


@Controller
public class HomeController {
    private final SongRepository songRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;

    public HomeController(SongRepository songRepository, AuthorRepository authorRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
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
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user){
//        User user = new User();
//        user.setName(name);
//        user.setSurname(surName);
//        user.setEmail(email);
//        user.setUsername(username);
//        user.setPassword(password);
        userRepository.createUser(user.getName(), user.getSurname(), user.getEmail(),user.getUsername(), user.getPassword());
        return "redirect:/login";
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
