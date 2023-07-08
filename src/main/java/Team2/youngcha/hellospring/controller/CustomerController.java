package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/new")
    public String createForm() {
        return "SignUp";
    }


    @PostMapping("/customers/new")
    public String create(CustomerForm form) {
        Customer customer = new Customer();
        customer.setCid(form.getCid());
        customer.setEmail(form.getEmail());
        customer.setEmailReceive(CustomerService.SToBConvert(form.getEmailReceiveYn()));
        customer.setGender(form.getGender());
        customer.setName(form.getName());
        customer.setMessageReceive(CustomerService.SToBConvert(form.getSmsReceiveYn()));
        customer.setPsw(form.getPsw());
        customer.setPhoneNumber(form.getPhoneNumber());
        customer.setReservation_count(customer.getReservation_count());

        if (customerService.join(customer))
            return "redirect:/";
        else
            return "SignUp";
    }

    @GetMapping("/customers")
    public String list(Model model) {
        List<Customer> customers = customerService.findMember();
        model.addAttribute("customers", customers);
        return "customers/customerList";
    }

    @GetMapping("/customers/login")
    public String enterInfo() {
        return "Login";
    }

    @PostMapping("/customers/login")
    public String logIn(HttpSession session, LogInForm form) {
        if (customerService.LogIn(form.getUserID(), form.getUserPW())) {
            if (customerService.isAdmin(form.getUserID()))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            session.setAttribute("loginCheck", true);
            session.setAttribute("userID", form.getUserID());
            session.setAttribute("userEmail", customerService.findEmailByCid(form.getUserID()));
            session.setAttribute("userName", customerService.findNameByCid(form.getUserID()));


            System.out.println(String.valueOf(session.getAttribute("admin")));
            return "redirect:/";
        } else return "Login";
    }

    @GetMapping("/customers/logout")
    public String logOut(HttpSession session) {
        session.setAttribute("loginCheck", false);
        session.setAttribute("userID", null);

        return "redirect:/";
    }

    @GetMapping("/customers/findID")
    public String createFindIDPage() {
        return "FindID";
    }

    @PostMapping("/customers/findID")
    public String findID(@RequestParam(name = "findName") String name,
                         @RequestParam(name = "findPhone_1") String findPhone_1,
                         @RequestParam(name = "findPhone_2") String findPhone_2,
                         @RequestParam(name = "findPhone_3") String findPhone_3,
                         Model model
                         ) {
        String phoneNumber = findPhone_1 + findPhone_2 + findPhone_3;
        String cid = customerService.isAlreadyJoined(name, phoneNumber);
        model.addAttribute("cid", cid);
        return "FindID";
    }

    @GetMapping("/customers/findPW")
    public String createFindPWPage() {
        return "FindPW";
    }

    @PostMapping("/customers/findPW")
    public String findPW(@RequestParam(name = "findName") String name,
                         @RequestParam(name = "findPhone_1") String findPhone_1,
                         @RequestParam(name = "findPhone_2") String findPhone_2,
                         @RequestParam(name = "findPhone_3") String findPhone_3,
                         @RequestParam(name = "findID") String findID,
                         HttpSession session) {
        String phoneNumber = findPhone_1 + findPhone_2 + findPhone_3;
        if (customerService.findUserByPhoneNoAndNameAndCid(phoneNumber, name, findID)) {
            session.setAttribute("userID", findID);
            return "ChangePSW";
        }
        return "infoFault";
    }

    @PostMapping("/customers/changePSW")
    public String changePSW(@RequestParam(name = "newPSW") String newPSW, HttpSession session,Model model) {
        String userID = String.valueOf(session.getAttribute("userID"));
        Boolean result = customerService.changePSW(userID, newPSW);
        model.addAttribute("result", result);
        return "FindPW";
    }

    @GetMapping("/customers/idcheck")
    public String createTestPage(){
        return "jqueryExample";
    }

    @PostMapping("/customers/idChecks")
    @ResponseBody
    public boolean idDuplicateCheck(@RequestBody LogInForm form){
        System.out.println(form.getUserID());
        return customerService.checkIDDuplication(form.getUserID());
    }


}