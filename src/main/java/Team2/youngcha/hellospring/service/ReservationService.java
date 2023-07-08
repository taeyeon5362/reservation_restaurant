package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.controller.ReservationForm;
import Team2.youngcha.hellospring.domain.Menu;
import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long join(String id,String email,String name, ReservationForm reservationForm) {
        List<Integer> peoples = reservationForm.getPeoples();
        String inputPeoples = "";
        for(int person:peoples){
            inputPeoples += person +",";
        }
        List<Integer> dishCountsLists = reservationForm.getDishCountsLists();
        String inputDishCountsLists = "";
        for(int dishcount : dishCountsLists){
            inputDishCountsLists += dishcount +"," ;
        }
        List<String> dishesList = reservationForm.getDishesList();
        String inputDishesList = "";
        for(String dish:dishesList){
            inputDishesList += dish+",";
        }
        LocalDate resDate = reservationForm.getStartDate();
        LocalTime resTime = timeConverter(reservationForm.getStartTime());
        List<String> tableNos = reservationForm.getTableNos();
        String inputTableNos = "";
        for(String tableNo:tableNos){
            inputTableNos += tableNo+",";
        }

        Reservation reservation = new Reservation();
        reservation.setCustomerID(id);
        reservation.setCustomerEmail(email);
        reservation.setCustomerName(name);
        reservation.setReservationDate(LocalDateTime.of(resDate,resTime));
        reservation.setTableNo(inputTableNos);
        reservation.setNumberOfPeople(inputPeoples);
        reservation.setDishes(inputDishesList);
        reservation.setDishCounts(inputDishCountsLists);
        reservation.setHasCar(SToBConvert(reservationForm.getHasCar()));

        reservationRepository.save(reservation);
        return reservation.getOid();
    }

    public Long tableReallocation(Long oid, String tableNo) {
        return reservationRepository.tableReallocation(oid, tableNo);

    }

    public static Boolean SToBConvert(String string) {
        return string.equals("O");
    }

    public List<Boolean> findValidTables(LocalDateTime reservationDate, String guestCount) {
        List<Reservation> resList = reservationRepository.findResByResDate(reservationDate.minusHours(2), reservationDate.plusHours(2));
        reservationRepository.findWalkInByDate(reservationDate);
        List<Boolean> booleans = validateDuplicateTable(resList, guestCount);

        return booleans;
    }

    public List<Boolean> findValidTables(LocalDateTime reservationDate, List<Integer> peoples){
        List<Reservation> resList = reservationRepository.findResByResDate(reservationDate.minusHours(2), reservationDate.plusHours(2));
        List<Boolean> booleans = validateDuplicateTable(resList, peoples);

        return booleans;
    }

    private Boolean[] validateGuestCountTable(String guestCount, List<TableInfo> tables, Boolean[] validAry) {
        if(guestCount.contains(",")) {
            String[] guestCountList = guestCount.split(",");
            for (TableInfo tableInfo : tables) {
                for (String guestCountInLoop : guestCountList) {
                    if (tableInfo.getPeople() < Integer.valueOf(guestCountInLoop)) {
                        validAry[tableInfo.getTableNumber() - 1] = false;
                    }
                }
                if (tableInfo.getPeople() < Integer.valueOf(guestCount)) {
                    validAry[tableInfo.getTableNumber() - 1] = false;
                }
            }
        }
        else {
            for (TableInfo tableInfo : tables) {
                if (tableInfo.getPeople() < Integer.valueOf(guestCount)) {
                    validAry[tableInfo.getTableNumber() - 1] = false;
                }
            }
        }
        return validAry;
    }

    public List<Boolean> validateDuplicateTable(List<Reservation> reservationList, String guestCount) {
        List<TableInfo> tables = reservationRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry, true);
        for (Reservation reservation : reservationList) {
            if (reservation.getTableNo().contains(",")) {
                String[] split = reservation.getTableNo().split(",");
                for (String tableNo : split)
                    validAry[Integer.valueOf(tableNo) - 1] = false;
            } else validAry[Integer.valueOf(reservation.getTableNo()) - 1] = false;
        }
        validateGuestCountTable(guestCount, tables, validAry);
        return Arrays.asList(validAry);
    }

    public List<Boolean> validateDuplicateTable(List<Reservation> reservationList, List<Integer> guestCount) {
        List<TableInfo> tables = reservationRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry, true);
        for (Reservation reservation : reservationList) {
            if (reservation.getTableNo().contains(",")) {
                String[] split = reservation.getTableNo().split(",");
                for (String tableNo : split)
                    validAry[Integer.valueOf(tableNo) - 1] = false;
            } else validAry[Integer.valueOf(reservation.getTableNo()) - 1] = false;
        }
        validateGuestCountTable(guestCount, tables, validAry);
        return Arrays.asList(validAry);
    }

    private Boolean[] validateGuestCountTable(List<Integer> guestCount, List<TableInfo> tables, Boolean[] validAry) {
        for(int i=0;i<tables.size();i++){
            for(int val:guestCount){
                if(tables.get(i).getPeople()<val){
                    validAry[i]=false;
                }
            }
        }
        return validAry;
    }


    public Boolean updateReservation(String cid, String sourceDate, String destDate, String guestCount, String tableNo) {
        LocalDateTime source = LocalDateTime.parse(sourceDate, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"));
        LocalDateTime dest = LocalDateTime.parse(destDate, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm"));
        Optional<Reservation> result = reservationRepository.findResByResDateAndCid(cid, source);
        if (result.isPresent()) {
            return reservationRepository.update(result.get(), dest, guestCount, tableNo);
        }
        return false;
    }

    public void reservationCountReallocation(String ID) {
        reservationRepository.reservationCountReallocation(ID);
    }

    public List<Reservation> getResListByCidAfterNow(String id) {
        LocalDateTime now = LocalDateTime.now();
        List<Reservation> result = reservationRepository.findByCustomerIDAfterNow(id,now);
        return result;
    }

    public void cancel(Long oid){
        reservationRepository.cancelReservation(oid);
    }

    public LocalTime timeConverter(String targetTime){
        int resultHour = 0;
        int resultMin = 0;
        String[] split = targetTime.split("[^0-9]");

        if(targetTime.contains("PM"))
            resultHour = Integer.valueOf(split[split.length-2])+12;
        else
            resultHour = Integer.valueOf(split[split.length-2]);

        resultMin = Integer.valueOf(split[split.length-1]);

        LocalTime parsedResTime = LocalTime.of(resultHour, resultMin);
        return parsedResTime;
    }

    public List<TableInfo> getTableList() {
        List<TableInfo> tableList = reservationRepository.getTables();
        return tableList;
    }

    public List<Menu> getAllList() {
        List<Menu> menuList = reservationRepository.getAllList();
        return menuList;
    }
}
