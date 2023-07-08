package Team2.youngcha.hellospring.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationForm {
    private String customerID;
    private String tableNo;
    private String numberOfPeople;
    private String hasCar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private String startTime;
    private String dishes;
    private String dishCounts;
    private LocalDateTime reservationDate;
    private List<Integer> peoples;
    private List<String> tableNos;
    private List<String> dishesList;
    private List<Integer> dishCountsLists;

    public List<String> getTableNos() {
        return tableNos;
    }

    public void setTableNos(List<String> tableNos) {
        this.tableNos = tableNos;
    }

    public List<String> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<String> dishesList) {
        this.dishesList = dishesList;
    }

    public List<Integer> getDishCountsLists() {
        return dishCountsLists;
    }

    public void setDishCountsLists(List<Integer> dishCountsLists) {
        this.dishCountsLists = dishCountsLists;
    }

    public List<Integer> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<Integer> peoples) {
        this.peoples = peoples;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getDishCounts() {
        return dishCounts;
    }

    public void setDishCounts(String dishCounts) {
        this.dishCounts = dishCounts;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public String getHasCar() {
        return hasCar;
    }

    public void setHasCar(String hasCar) {
        this.hasCar = hasCar;
    }

    public void printAll() {
        System.out.println("테이블 번호: "+
                tableNo +"인원수: "+
                numberOfPeople +"자차: "+
                hasCar +"예약날짜: "+
                startDate.toString() +"예약 시간: "+
                startTime +"메뉴: "+
                dishes +"수량: "+
                dishCounts);
    }
}
