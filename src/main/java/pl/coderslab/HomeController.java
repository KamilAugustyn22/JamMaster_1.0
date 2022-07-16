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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


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
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user){
        userRepository.createUser(user.getName(), user.getSurname(), user.getEmail(),user.getUsername(), user.getPassword());
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request){
        List<User>users = userRepository.findAllUsers();
        long id = 0;
        for(User user : users){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                id = user.getId();
            }
        }
        if(id == 0){
            return "login";
        }
        User user = userRepository.readUserById(id);
        HttpSession session = request.getSession();
        session.setAttribute("firstName", user.getName());
        session.setAttribute("lastName", user.getSurname());
        session.setAttribute("id", user.getId());
        return "redirect:/";
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
