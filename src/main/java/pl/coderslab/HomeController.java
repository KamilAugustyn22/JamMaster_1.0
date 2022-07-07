package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.song.SongRepository;


@Controller
public class HomeController {
    private final SongRepository songRepository;

    public HomeController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("liczbaPiosenek",songRepository.countAllSongs());
        return "index";
    }
}
