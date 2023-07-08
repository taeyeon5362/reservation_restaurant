package Team2.youngcha.hellospring.domain;

import Team2.youngcha.hellospring.util.BooleanToYNConverter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DynamicInsert
public class Customer {

    @Id
    private String cid;
    private String psw;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean emailReceive;
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean messageReceive;
    @Convert(converter = BooleanToYNConverter.class) @Column(columnDefinition = "tinytext default \"N\"")
    private Boolean isAdmin;
    @Column(columnDefinition = "varchar(10) default \"General\"")
    private String rank;
    @Column(name = "reservation_count")
    private int reservation_count = 0;

    public int getReservation_count() {
        return reservation_count;
    }

    public void setReservation_count(int reservation_count) {
        this.reservation_count = reservation_count;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEmailReceive() {
        return emailReceive;
    }

    public void setEmailReceive(Boolean emailReceive) {
        this.emailReceive = emailReceive;
    }

    public Boolean getMessageReceive() {
        return messageReceive;
    }

    public void setMessageReceive(Boolean messageReceive) {
        this.messageReceive = messageReceive;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}