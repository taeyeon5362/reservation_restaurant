package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Menu;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations/new")
    public String createReservationForm(Model model) {
        List<Menu> menuList = reservationService.getAllList();
        model.addAttribute("menuList", menuList);
        return "Reservation";
    }

    @GetMapping("/reservations/new/menu")
    @ResponseBody
    public List<Menu> getMenu() {
        return reservationService.getAllList();
    }

    @PostMapping("/reservations/new")
    @ResponseBody
    public Long createReservation(HttpSession session, @RequestBody ReservationForm reservationForm) {
        String ID = (String) session.getAttribute("userID");
        String email = (String) session.getAttribute("userEmail");
        String name = (String) session.getAttribute("userName");
        Long join = reservationService.join(ID, email, name, reservationForm);

        return join;
    }

    @GetMapping("/reservations/reallocate")
    public String createReallocationForm(HttpSession session, Model model) {
        List<Reservation> reservationList = reservationService.getResListByCidAfterNow(String.valueOf(session.getAttribute("id")));
        model.addAttribute("reservations", reservationList);
        return "/booking/ReallocationList";
    }

    @PostMapping("/reservations/reallocate")
    public String reallocateTable(@RequestParam(name = "oid") Long oid) {
        System.out.println(oid);
        reservationService.tableReallocation(oid, "4");
        return "redirect:/";
    }

    @GetMapping("/reservations/update")
    public String forwardToUpdatePage() {
        return "updateReservation";
    }

    @GetMapping("/reservations/selectTable")
    public String updateReservation(@RequestParam(name = "tableNo") String tableNo, HttpSession session, Model model) {
        String cid = String.valueOf(session.getAttribute("cid"));
        String sourceDate = String.valueOf(session.getAttribute("sourceDate"));
        String destDate = String.valueOf(session.getAttribute("destDate"));
        String guestCount = String.valueOf(session.getAttribute("guestCount"));
        model.addAttribute("result", reservationService.updateReservation(cid, sourceDate, destDate, guestCount, tableNo));
        return "UpdateResResultPage";
    }

    @GetMapping("/reservations/cancel")
    public String lists(HttpSession session, Model model) {
        List<Reservation> reservationList = reservationService.getResListByCidAfterNow(String.valueOf(session.getAttribute("userID")));
        model.addAttribute("reservationList", reservationList);
        return "booking/CancelReservation";
    }

    @GetMapping("/reservations/cancel/my")
    public String cancelReservation(@RequestParam(name = "cancelOid") Long oid) {
        reservationService.cancel(oid);
        return "redirect:/";
    }

    @GetMapping("/reservation/tableSelect")
    public String createTableSelect(Model model){
        List<TableInfo> tableList = reservationService.getTableList();
        model.addAttribute("tableList", tableList);

        return "tableSelect";
    }

    @PostMapping("/reservations/validTables")
    @ResponseBody
    public List<Boolean> getValidTables(@RequestBody ReservationForm reservationForm){
        LocalTime time = reservationService.timeConverter(reservationForm.getStartTime());
        LocalDateTime.of(reservationForm.getStartDate(),time).toString();
        return reservationService.findValidTables(LocalDateTime.of(reservationForm.getStartDate(),time), reservationForm.getPeoples());
    }
}