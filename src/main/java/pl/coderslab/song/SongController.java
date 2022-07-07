package pl.coderslab.song;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @RequestMapping(value = "/add")
    public String addSongForm(){
        return "addSong";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addSong(){



        return "redirect:/song/list";
    }

    @RequestMapping(value = "/list")
    public String songList(Model model){
        model.addAttribute("songs",songRepository.findAllSongs());
        return "songList";
    }

    @RequestMapping(value = "details?ID=")
    @ResponseBody
    public String songDetails(@PathVariable("ID")long id){

        return "TU KIEDYŚ BĘDĄ SZCZEGÓŁY PIOSENKI";
    }
}
