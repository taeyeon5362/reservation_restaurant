package Team2.youngcha.hellospring.controller;

import Team2.youngcha.hellospring.domain.Menu;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.repository.IncomeChartDataRepository;
import Team2.youngcha.hellospring.responseBody.IncomeChartData;
import Team2.youngcha.hellospring.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Controller
public class ManagerController {

    @Autowired
    IncomeChartDataRepository repo;

    private final ManagerService managerService;

    // 생성자
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    // 매니저 메인 페이지 로더
    @GetMapping("/manager")
    public String managerPage() {
        return "Management";
    }

    // 대기리스트 메인 페이지 로더
    @GetMapping("/waitList")
    public String lists() {
        return "waitList";
    }

    // 현시간 이후의 예약 리스트 json으로 반환
    @GetMapping("/waitList/getList")
    @ResponseBody
    public List<Reservation> getWaitList() {
        return managerService.callWaitList();
    }

    /*
    웹에서 날아온 예약 정보를 토대로 기존 정보 수정
    1. 회원의 주문 횟수
    2. 회원의 등급
    3. 수입 기록
    4. 메뉴의 판매량 및 재고 수정
     */
    @PostMapping("/waitList")
    @ResponseBody
    public boolean todo(@RequestBody ReservationForm form) {
        managerService.reservationCountReallocation(form.getCustomerID());
        managerService.rankReallocation(form.getCustomerID());
        LocalDateTime now = managerService.setArrivalTime(form.getCustomerID(), form.getReservationDate());
        managerService.enrollIncome(form.getCustomerID(), form.getDishes(), form.getDishCounts(), now);
        managerService.editSaleCount(form.getCustomerID(), form.getReservationDate());

        return true;
    }

    // 기존 예약의 테이블 위치 재조정
    @GetMapping("/manager/tableReallocation")
    public String changeTable(@RequestParam(name = "customerID") String cid, @RequestParam(name = "tableNo") String tableNo, Model model) {
        if (managerService.changeTable(cid, tableNo))
            model.addAttribute("result", true);
        else
            model.addAttribute("result", false);
        return "TodayReservation";
    }

    // 테이블 설정 메인 페이지 로더
    @GetMapping("/manager/tableManage")
    public String createTableManagePage() {
        return "TableManage";
    }

    // 테이블 설정에 필요한 기존 테이블 정보 리스트 json 반환
    @GetMapping("/manager/tableManage/getTableLists")
    @ResponseBody
    public List<TableInfo> getTableLists(){
        return managerService.getTableLists();
    }

    // 웹에서 받은 정보를 토대로 테이블 정보 재설정
    @PostMapping("/manager/tableManage")
    @ResponseBody
    public boolean tableSetting(@RequestBody TableInfoForm form) {
        System.out.println(form.getTableInfo());
        managerService.joinTable(form.getTableInfo());
        return true;
    }

    // 메뉴 관리 메인 페이지 로더
    @GetMapping("/manager/dishManage")
    public String createDishPage() {
        return "dishManage";
    }

    // 웹에서 받은 정보를 토대로 메뉴의 정보 수정
    @PostMapping("/manager/dishManage")
    public String editDishes(@RequestParam(name = "dishInfo") Map<String, String> dishInfo) {
        managerService.editDishes(dishInfo);
        return "dishManage";
    }

    /*
    통계 그래프를 위한 정보를 모델에 심어 보냄
    1. 7일간의 일별 수입
    2. 7일간의 메뉴별 수입
    3. 7일간의 메뉴별 판매량
     */
    @GetMapping("/manager/Income")
    public String createIncomePage(Model model) {
        return "StatisticsGraph";
    }


    // 재고 관리 메인 페이지 로더
    @GetMapping("/manager/stock")
    public String createStockPage(){
        return "Stock";
    }

    @PostMapping("/manager/Income/data")
    @ResponseBody
    public ResponseEntity<?> createIncomePage_chart() {
        Collection<IncomeChartData> data = repo.getChartData();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/manager/stock/getStock")
    @ResponseBody
    public List<Menu> getMenuLists(){
        return managerService.listAllMenus();
    }

    @GetMapping("/Menu")
    public String home(Model model){
        Collection<IncomeChartData> incomeList = repo.getDishCount();

        Iterator<IncomeChartData> iterator = incomeList.stream().iterator();
        HashMap<String, Integer> returnMap = new HashMap<>();
        while(iterator.hasNext()){
            IncomeChartData next = iterator.next();
            String dish = next.getDish();
            Integer dishCount = next.getSumDishCount();
            returnMap.put(dish, dishCount);
        }

        model.addAttribute("incomeList", returnMap);
        return "Menu";
    }
}