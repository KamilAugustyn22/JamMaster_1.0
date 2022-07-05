package pl.coderslab.set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/set")
public class SongSetController {

    @RequestMapping("/list")
    public String listOfSets(){
        return "songSetList";
    }
}
