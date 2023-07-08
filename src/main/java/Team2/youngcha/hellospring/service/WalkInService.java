package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Reservation;
import Team2.youngcha.hellospring.domain.TableInfo;
import Team2.youngcha.hellospring.domain.WalkIn;
import Team2.youngcha.hellospring.repository.WalkInRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class WalkInService {
    private final WalkInRepository walkInRepository;

    public WalkInService(WalkInRepository walkInRepository) {
        this.walkInRepository = walkInRepository;
    }

    public Long join(List<String> peoples, List<String> tableNos) {
        WalkIn walkIn = new WalkIn();

        String inputPeoples = "";
        String inputTableNo= "";
        for(int i=0;i<peoples.size();i++){
            inputTableNo += tableNos.get(i)+",";
            inputPeoples += tableNos.get(i)+",";
        }
        walkIn.setWalkInDate(LocalDateTime.now());
        walkIn.setGuestCount(inputPeoples);
        walkIn.setTableNo(inputTableNo);

        walkInRepository.save(walkIn);

        return walkIn.getOid();
    }

    public List<Boolean> validateDuplicateTable(List<String> people) {
        List<Reservation> reservationList = walkInRepository.findByResDate(LocalDateTime.now());
        List<WalkIn> walkInList = walkInRepository.findWalkInByDate(LocalDateTime.now());
        List<TableInfo> tables = walkInRepository.getTables();
        Boolean[] validAry = new Boolean[tables.size()];
        Arrays.fill(validAry,true);
        for(Reservation reservation : reservationList){
            if(!reservation.getTableNo().contains(","))
                validAry[Integer.valueOf(reservation.getTableNo())-1] = false;
            else{
                String[] split = reservation.getTableNo().split(",");
                for (String tableNo:split){
                    validAry[Integer.valueOf(tableNo)-1] = false;
                }
            }
        }

        for(WalkIn walkIn : walkInList){
            if(!walkIn.getTableNo().contains(","))
                validAry[Integer.valueOf(walkIn.getTableNo())-1] = false;
            else{
                String[] split = walkIn.getTableNo().split(",");
                for (String tableNo:split){
                    validAry[Integer.valueOf(tableNo)-1] = false;
                }
            }
        }

        validateGuestCountTable(people,tables,validAry);
        return Arrays.asList(validAry);
    }
    private Boolean[] validateGuestCountTable(List<String> people, List<TableInfo> tables, Boolean[] validAry){
        for(int i=0;i<tables.size();i++){
            for(String person:people){
                if(Integer.valueOf(person) > tables.get(i).getPeople()){
                    validAry[i] = false;
                }
            }
        }
        return validAry;
    }

    public List<WalkIn> listsWalkIn() {
        return walkInRepository.findAll();
    }

    public List<Boolean> checkTable(List<String> people){
        return validateDuplicateTable(people);
    }
}
