package Team2.youngcha.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/Route")
    public String showRoute() {
        return "Route";
    }

}
