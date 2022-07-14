package pl.coderslab.set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;


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
        model.addAttribute("sets", songSetRepository.findAllSets(1));
        return "songSetList";
    }

    @GetMapping("/add")
    public String addSetForm(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "addSet";
    }

    @PostMapping("/add")
    public String addSet(@RequestParam String name){
        User user = userRepository.readUserById(1);
        songSetRepository.createSet(user, name);
        return "redirect:/set/list";
    }
    @RequestMapping("/songlist/{id}")
    public String songSetDetails(Model model, @PathVariable("id") long id){
        User user = userRepository.readUserById(1);
        SongSet songSet = songSetRepository.readSongSetById(id);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        model.addAttribute("setName", songSet.getName());
        model.addAttribute("setId", songSet.getId());
        model.addAttribute("songs", songSet.getSongList());
        return "setDetails";
    }
}
