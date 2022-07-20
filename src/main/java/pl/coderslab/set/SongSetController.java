package pl.coderslab.set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.song.Song;
import pl.coderslab.song.SongRepository;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;


@Controller
@RequestMapping("/set")
public class SongSetController {
    private final UserRepository userRepository;
    private final SongSetRepository songSetRepository;
    private final SongRepository songRepository;

    public SongSetController(UserRepository userRepository, SongSetRepository songSetRepository, SongRepository songRepository) {
        this.userRepository = userRepository;
        this.songSetRepository = songSetRepository;
        this.songRepository = songRepository;
    }

    @RequestMapping("/list")
    public String listOfSets(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        model.addAttribute("sets", songSetRepository.findAllSets(1));
        return "songSet/songSetList";
    }

    @GetMapping("/add")
    public String addSetForm(Model model){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        return "songSet/addSet";
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
        return "songSet/setDetails";
    }

    @RequestMapping("/{id}/addsong")
    public String addSongToSet(Model model, @PathVariable("id") long id){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        model.addAttribute("songs", songRepository.findAllSongs());
        model.addAttribute("setId", id);

        return "songSet/addSongToSet";
    }
    @RequestMapping("/{setId}/{songId}")
    public String addSongToSetAction(@PathVariable("setId")long setId, @PathVariable("songId")long songId){
        songSetRepository.addSongToSet(setId, songId);
        return "redirect:/set/songlist/"+setId;
    }
    @GetMapping("/{setId}/remove/{songId}")
    public String deleteSongFromSetView(Model model, @PathVariable("setId")long setId, @PathVariable("songId")long songId){
        User user = userRepository.readUserById(1);
        model.addAttribute("userNameAndSurname", user.getName() +" "+ user.getSurname());
        model.addAttribute("setId", setId);
        model.addAttribute("songId", songId);
        Song song = songRepository.readSongById(songId);
        model.addAttribute("songAuthor", song.getAuthor());
        model.addAttribute("songTitle", song.getTitle());
        return "songSet/deleteSongFromSet";
    }
    @PostMapping("/{setId}/remove/{songId}")
    public String deleteSongFromSet(@PathVariable("setId")long setId, @PathVariable("songId")long songId){
        songSetRepository.deleteSongFromSet(setId, songId);

        return "redirect:/set/songlist/"+setId;
    }
}
