package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.WalkIn;
import Team2.youngcha.hellospring.service.WalkInService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WalkInController {
    private final WalkInService walkInService;

    public WalkInController(WalkInService walkInService) {
        this.walkInService = walkInService;
    }

    @GetMapping("/walkIn/new")
    public String createWalkInPage(){
        return "WalkIn";
    }

    @PostMapping("/walkIn/validTables")
    @ResponseBody
    public List<Boolean> checkValidTables(@RequestBody WalkInForm walkInForm) {
        return walkInService.checkTable(walkInForm.getPeoples());
    }

    @PostMapping("/walkIn/new")
    @ResponseBody
    public Long serviceWalkIn(@RequestBody WalkInForm walkInForm){
        return walkInService.join(walkInForm.getPeoples(), walkInForm.getTableNos());
    }

    @GetMapping("/walkIn")
    public String lists(Model model){
        List<WalkIn> walkIns = walkInService.listsWalkIn();
        model.addAttribute("walkIns", walkIns);
        return "/booking/ListWalkIn";
    }

}
