package pl.coderslab.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

@Controller
@RequestMapping("/session")
public class SessionController {
    private final UserRepository userRepository;

    public SessionController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String defaultView(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "sessions/session";
    }
    @RequestMapping("/create")
    public String createSession(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "sessions/createSession";
    }
    @RequestMapping("/join")
    public String joinSession(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "sessions/joinSession";
    }

}
