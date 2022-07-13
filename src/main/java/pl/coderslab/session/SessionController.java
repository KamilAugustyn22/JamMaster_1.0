package pl.coderslab.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/")
    public String defaultView(){
        return "session";
    }

}
