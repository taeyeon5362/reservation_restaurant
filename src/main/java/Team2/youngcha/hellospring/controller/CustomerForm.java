package Team2.youngcha.hellospring.controller;

public class CustomerForm {
    private String cid;
    private String psw;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String emailReceiveYn;
    private String smsReceiveYn;
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

    public String getEmailReceiveYn() {
        return emailReceiveYn;
    }

    public void setEmailReceiveYn(String emailReceiveYn) {
        this.emailReceiveYn = emailReceiveYn;
    }

    public String getSmsReceiveYn() {
        return smsReceiveYn;
    }

    public void setSmsReceiveYn(String smsReceiveYn) {
        this.smsReceiveYn = smsReceiveYn;
    }

    public void printAll(){
        System.out.println(cid +" "+psw+" "+name+" "+email+" "+phoneNumber+" "+gender+" "+emailReceiveYn+" "+smsReceiveYn);
    }
}
