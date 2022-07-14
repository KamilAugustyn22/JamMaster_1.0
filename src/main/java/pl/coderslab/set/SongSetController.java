package pl.coderslab.set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/set")
public class SongSetController {
    private final UserRepository userRepository;
    private final SongSetRepository songSetRepository;

    public SongSetController(UserRepository userRepository, SongSetRepository songSetRepository) {
        this.userRepository = userRepository;
        this.songSetRepository = songSetRepository;
    }

    @RequestMapping("/list")
    public String listOfSets(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        model.addAttribute("sets", songSetRepository.findAllSets());
        return "songSetList";
    }

    @GetMapping("/add")
    public String addSetForm(){
        return "addSet";
    }

    @PostMapping("/add")
    public String addSet(){
        return "redirect:/set/list";
    }
}
