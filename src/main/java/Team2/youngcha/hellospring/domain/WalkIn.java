package Team2.youngcha.hellospring.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class WalkIn extends Booking{

    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm") @Column(name = "walkInDate")
    private LocalDateTime walkInDate;
    private String guestCount;

    public LocalDateTime getWalkInDate() {
        return walkInDate;
    }

    public void setWalkInDate(LocalDateTime walkInDate) {
        this.walkInDate = walkInDate;
    }

    public String getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(String guestCount) {
        this.guestCount = guestCount;
    }
}
