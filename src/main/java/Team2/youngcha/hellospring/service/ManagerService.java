package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.*;
import Team2.youngcha.hellospring.repository.ManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public int setTable(int tableCount) {
        int tableNo = 0;
        for (int i = 0; i < tableCount; i++) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableNumber(i + 1);
            tableInfo.setPeople(4);
            tableInfo.setPlaces(1);
            tableNo = managerRepository.saveTableInfo(tableInfo);
        }
        return tableNo;
    }

    public Optional<Reservation> findReservationByCidOnToday(String cid) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startRange = now.minusHours(now.getHour());
        LocalDateTime endRange = now.plusHours(24 - now.getHour());

        return managerRepository.getReservationByCidOnToday(cid, startRange, endRange);
    }

    public Boolean changeTable(String cid, String tableNo) {
        Optional<Reservation> result = findReservationByCidOnToday(cid);
        if (result.isPresent()) {
            Reservation reservation = result.get();
            List<Boolean> booleans = validateDuplicateTable(reservation, Integer.valueOf(reservation.getNumberOfPeople()));
            if (booleans.get(Integer.valueOf(tableNo) - 1)) {
                managerRepository.changeTableNo(reservation, tableNo);
                return true;
            }
        }
        return false;
    }


    private Boolean[] validateGuestCountTable(int guestCount, List<TableInfo> tables, Boolean[] validAry) {
        for (TableInfo tableInfo : tables) {
            if (tableInfo.getPeople() < guestCount) {
                validAry[tableInfo.getTableNumber() - 1] = false;
            }
        }
        return validAry;
    }

    public List<Boolean> validateDuplicateTable(Reservation targetReservation, int guestCount) {
        List<Reservation> reservationList = managerRepository.findByResDate(targetReservation.getReservationDate());
        List<TableInfo> tables = managerRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry, true);
        for (Reservation reservation : reservationList) {
            validAry[Integer.valueOf(reservation.getTableNo()) - 1] = false;
        }

        validateGuestCountTable(guestCount, tables, validAry);
        return Arrays.asList(validAry);
    }

    public void joinTable(List<String> tableList) {
        List<TableInfo> tables = managerRepository.getTables();
        int size = tables.size() - tableList.size();
        for (int i = 0; i < tableList.size(); i++) {
            Optional<TableInfo> singleTable = managerRepository.getSingleTable(i + 1);
            if (singleTable.isPresent()) {
                TableInfo myTable = singleTable.get();
                if (myTable.getPeople() != Integer.valueOf(tableList.get(i))) {
                    System.out.println(i + " " + myTable.getPeople() + " " + tableList.get(i));
                    managerRepository.setTablePeople(myTable, Integer.valueOf(tableList.get((i))));
                }
            } else {
                TableInfo newTable = new TableInfo();
                newTable.setTableNumber(i + 1);
                newTable.setPeople(Integer.valueOf(tableList.get(i)));
                newTable.setPlaces(1);
                managerRepository.saveTableInfo(newTable);
            }
        }
        if (size > 0) {
            for (int i = tableList.size(); i < tables.size(); i++) {
                managerRepository.destroyTable(managerRepository.getSingleTable(i + 1).get());
            }
        }
    }

    public void editDishes(Map<String, String> dishInfo) {
        for (String dish : dishInfo.keySet()) {
            Optional<Menu> result = managerRepository.isDishAlreadyExists(dish);
            if (result.isPresent())
                managerRepository.changeDishPrice(result.get(), Integer.valueOf(dishInfo.get(dish)));
            else {
                Menu newMenu = new Menu();
                newMenu.setDish(dish);
                newMenu.setPrice(Integer.valueOf(dishInfo.get(dish)));
                managerRepository.saveMenu(newMenu);
            }
        }
    }

    public List<Income> getIncome() {
        return managerRepository.getIncome();
    }

    public List<Long> getIncomeSum() {
        return managerRepository.getIncomeSum();
    }

    public List<LocalDate> getIncomeDate(){
        return managerRepository.getIncomeDate();
    }

    public Map<String, Integer> getDishWithProfit(List<Income> incomeList) {
        HashMap<String, Integer> result = new HashMap<>();
        for (Income income : incomeList) {
            if (result.containsKey(income.getDish()))
                result.replace(income.getDish(), result.get(income.getDish()) + income.getProfit());
            else result.put(income.getDish(), income.getProfit());
        }
        return result;
    }

    public Map<String, Integer> getDishWithCount(List<Income> incomeList) {
        HashMap<String, Integer> result = new HashMap<>();
        for (Income income : incomeList) {
            if (result.containsKey(income.getDish()))
                result.replace(income.getDish(), result.get(income.getDish()) + income.getDishCount());
            else result.put(income.getDish(), income.getDishCount());
        }
        return result;
    }

    public void rankReallocation(String ID) {
        managerRepository.rankReallocation(ID);
    }

    public void reservationCountReallocation(String ID) {
        managerRepository.reservationCountReallocation(ID);
    }

    public LocalDateTime setArrivalTime(String ID, LocalDateTime resDate) {
        return managerRepository.setArrivalTime(ID, resDate);
    }

    public void enrollIncome(String cid, String argDishes, String argDishCounts, LocalDateTime now) throws IllegalStateException {
        Optional<Customer> customer = managerRepository.findCustomer(cid);
        double discountRate = 0;
        if (customer.isPresent())
            discountRate = 1 - discount.get(customer.get().getRank()) / 100;
        else throw new IllegalStateException("없는 회원입니다.");
        String[] dishes = argDishes.split(",");
        String[] dishCounts = argDishCounts.split(",");
        for (int i = 0; i < dishes.length; i++) {
            Income income = new Income();
            income.setIncomeDate(now.toLocalDate());
            income.setDish(dishes[i]);
            income.setDishCount(Integer.valueOf(dishCounts[i]));
            income.setProfit((int) Math.round(managerRepository.getDishPrice(dishes[i]) * Integer.valueOf(Integer.valueOf(dishCounts[i])) * discountRate));

            managerRepository.saveIncome(income);
        }
    }

    public void editSaleCount(String ID, LocalDateTime resDate) {
        Reservation reservation = managerRepository.sendReservationDishCount(ID, resDate);

        String[] dishes = reservation.getDishes().split(",");
        String[] dishCounts = reservation.getDishCounts().split(",");

        for (int i = 0; i < dishes.length; i++) {
            managerRepository.changeDishSaleCount(dishes[i], dishCounts[i]);
            managerRepository.changeDishStock(dishes[i], dishCounts[i]);
        }
    }

    public List<Reservation> callWaitList() {
        LocalDateTime now = LocalDateTime.now();
        List<Reservation> resAfterNow = managerRepository.findResAfterNow(now);
        return resAfterNow;
    }

    public List<TableInfo> getTableLists() {
        List<TableInfo> tables = managerRepository.getTables();
        return tables;
    }

    public Map<LocalDate,Long> getIncomeInfo(){
        List<LocalDate> incomeDate = getIncomeDate();
        List<Long> incomeSum = getIncomeSum();
        HashMap<LocalDate, Long> returnMap = new HashMap<>();
        for(int i=0;i<incomeSum.size();i++){
            returnMap.put(incomeDate.get(i),incomeSum.get(i));
        }

        return returnMap;
    }

    public List<Menu> listAllMenus(){
        return managerRepository.listMenus();
    }


    private static final Map<String, Double> discount = Map.of("General", 3.0, "VIP", 5.0, "VVIP", 8.0);
}
