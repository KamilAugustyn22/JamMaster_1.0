package pl.coderslab.song;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SongController {

    @RequestMapping("/add")
    public String addSong(){
        return "addSong";
    }
    @RequestMapping("/list")
    public String songList(){
        return "songList";
    }
}
