package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class WalkInForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime walkInDate;
    private int guestCount;
    private List<String> peoples;
    private List<String> tableNos;

    public List<String> getTableNos() {
        return tableNos;
    }

    public void setTableNos(List<String> tableNos) {
        this.tableNos = tableNos;
    }

    public List<String> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<String> peoples) {
        this.peoples = peoples;
    }

    public LocalDateTime getWalkInDate() {
        return walkInDate;
    }

    public void setWalkInDate(LocalDateTime walkInDate) {
        this.walkInDate = walkInDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }
}
