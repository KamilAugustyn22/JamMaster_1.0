package pl.coderslab.song;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorController;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/song")
public class SongController {
    private final SongRepository songRepository;
    private final UserRepository userRepository;
    private final AuthorController authorController;

    public SongController(SongRepository songRepository, AuthorRepository authorRepository, UserRepository userRepository, AuthorController authorController) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
        this.authorController = authorController;
    }

    @GetMapping(value = "/add")
    public String addSongForm(){
        return "addSong";
    }
    @PostMapping(value = "/add")
    public String addSong(@RequestParam String title,@RequestParam String authorsName, @RequestParam Integer tempo,
                          @RequestParam String mtrm, @RequestParam String songKey, @RequestParam String introChords,
                          @RequestParam String verseChords, @RequestParam String reffChords, @RequestParam String bridgeChords,
                          @RequestParam String songText){
        User user = userRepository.readUserById(1);

        Author author = authorController.checkIfExists(authorsName);
        LocalDateTime created = LocalDateTime.now();

        songRepository.createSong(title, author, tempo, mtrm, songKey, introChords, verseChords, reffChords, bridgeChords, songText, user, created);

        return "redirect:/song/list";
    }

    @RequestMapping(value = "/list")
    public String songList(Model model){
        model.addAttribute("songs",songRepository.findAllSongs());
        return "songList";
    }

    @RequestMapping(value = "details?ID=:id")
    @ResponseBody
    public String songDetails(@PathVariable("id")long id){

        return "TU KIEDYŚ BĘDĄ SZCZEGÓŁY PIOSENKI";
    }
}
