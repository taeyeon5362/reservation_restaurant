package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ManagerRepository {
    private final EntityManager entityManager;

    public ManagerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int saveTableInfo(TableInfo tableInfo) {
        entityManager.persist(tableInfo);
        TableInfo tableNo = entityManager.createQuery("select t from TableInfo t where t.tableNumber=:tableNo", TableInfo.class)
                .setParameter("tableNo", tableInfo.getTableNumber())
                .getSingleResult();

        return tableNo.getTableNumber();
    }

    public void saveIncome(Income income) {
        entityManager.persist(income);
    }

    public Optional<Customer> findCustomer(String cid) {
        try {
            return Optional.ofNullable(entityManager.find(Customer.class, cid));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Reservation> getReservationByCidOnToday(String cid, LocalDateTime startRange, LocalDateTime endRange) {
        try {
            Reservation result = entityManager.createQuery("select r from Reservation r where r.reservationDate between :startRange and :endRange and r.customerID=:cid", Reservation.class)
                    .setParameter("cid", cid)
                    .setParameter("startRange", startRange)
                    .setParameter("endRange", endRange)
                    .getSingleResult();
            return Optional.of(result);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Modifying(clearAutomatically = true)
    public void changeTableNo(Reservation reservation, String tableNo) {
        reservation.setTableNo(tableNo);
    }

    public List<Reservation> findByResDate(LocalDateTime localDateTime) {
        List<Reservation> result = entityManager.createQuery("select r from Reservation r where r.reservationDate between :minusHour and :plusHour", Reservation.class)
                .setParameter("minusHour", localDateTime.minusHours(2))
                .setParameter("plusHour", localDateTime.plusHours(2))
                .getResultList();
        return result;
    }

    public List<TableInfo> getTables() {
        return entityManager.createQuery("select t from TableInfo t", TableInfo.class)
                .getResultList();
    }

    public Optional<Menu> isDishAlreadyExists(String dish) {
        try {
            Menu menu = entityManager.find(Menu.class, dish);
            return Optional.of(menu);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void saveMenu(Menu dish) {
        entityManager.persist(dish);
    }

    @Modifying(clearAutomatically = true)
    public void changeDishPrice(Menu dish, int price) {
        dish.setPrice(price);
    }

    public List<Menu> listMenus() {
        List<Menu> result = entityManager.createQuery("select m from Menu m", Menu.class)
                .getResultList();
        return result;
    }

    public Optional<Menu> getMenuByDish(String dish) {
        try {
            Menu result = entityManager.find(Menu.class, dish);
            return Optional.ofNullable(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Long> getIncomeSum() {
        LocalDate now = LocalDate.now();
        List<Long> resultList = entityManager.createQuery("select sum(i.profit) as income from Income i where i.incomeDate between :startRange and :endRange GROUP BY i.incomeDate")
                .setParameter("startRange", now.minusDays(7))
                .setParameter("endRange", now)
                .getResultList();
        return resultList;
    }

    public List<LocalDate> getIncomeDate(){
        LocalDate now = LocalDate.now();
        List<LocalDate> resultList = entityManager.createQuery("select distinct i.incomeDate as incomeDate from Income i where i.incomeDate between :startRange and :endRange")
                .setParameter("startRange", now.minusDays(7))
                .setParameter("endRange", now)
                .getResultList();
        return resultList;
    }

    public List<Income> getIncome() {
        LocalDate now = LocalDate.now();
        List<Income> resultList = entityManager.createQuery("select i from Income i where i.incomeDate between :startRange and :endRange",Income.class)
                .setParameter("startRange", now.minusDays(7))
                .setParameter("endRange", now)
                .getResultList();
        return resultList;
    }

    @Modifying(clearAutomatically = true)
    public void rankReallocation(String ID) {
        Customer customer = entityManager.find(Customer.class, ID);
        int value = customer.getReservation_count();
        if (value >= 0 && value <= 3) {
            customer.setRank("General");
        } else if (value >= 4 && value <= 7) {
            customer.setRank("VIP");
        } else {
            customer.setRank("VVIP");
        }
    }

    public void reservationCountReallocation(String ID) {
        Customer customer = entityManager.find(Customer.class, ID);
        customer.setReservation_count(customer.getReservation_count() + 1);
    }

    @Modifying(clearAutomatically = true)
    public LocalDateTime setArrivalTime(String ID, LocalDateTime resDate) {
        Reservation reservation = entityManager.createQuery("select r from Reservation r where r.customerID=:cid and r.reservationDate=:resDate", Reservation.class)
                .setParameter("cid", ID)
                .setParameter("resDate", resDate)
                .getSingleResult();
        LocalDateTime now = LocalDateTime.now();
        reservation.setArrivalTime(now);
        return now;
    }

    public int getDishPrice(String dish) {
        try {
            return entityManager.createQuery("select m from Menu m where m.dish=:dish", Menu.class)
                    .setParameter("dish", dish)
                    .getSingleResult()
                    .getPrice();
        } catch (Exception e) {
            return 0;
        }
    }

    public Reservation sendReservationDishCount(String ID, LocalDateTime resDate) {
        Reservation reservation = entityManager.createQuery("select r from Reservation r where r.customerID=:cid and r.reservationDate=:resDate", Reservation.class)
                .setParameter("cid", ID)
                .setParameter("resDate", resDate)
                .getSingleResult();

        return reservation;
    }

    @Modifying(clearAutomatically = true)
    public void changeDishSaleCount(String dish, String dishCount) {
        Menu menu = entityManager.find(Menu.class, dish);
        int result = menu.getSalesCount() + Integer.valueOf(dishCount);
        menu.setSalesCount(result);
    }

    @Modifying(clearAutomatically = true)
    public void changeDishStock(String dish, String dishCounts) {
        Menu menu = entityManager.find(Menu.class, dish);
        int result = menu.getStock() - Integer.valueOf(dishCounts);
        menu.setStock(result);
    }

    public List<Reservation> findResAfterNow(LocalDateTime now) {
        List<Reservation> resultList = entityManager.createQuery("select r from Reservation r where r.reservationDate>=:now and r.arrivalTime=null", Reservation.class)
                .setParameter("now", now)
                .getResultList();

        return resultList;

    }

    public Optional<TableInfo> getSingleTable(int tableNo) {
        try {
            return Optional.ofNullable(entityManager.createQuery("select t from TableInfo t where t.tableNumber=:tableNo", TableInfo.class)
                    .setParameter("tableNo", tableNo)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public void destroyTable(TableInfo tableInfo){
        entityManager.remove(tableInfo);
    }

    @Modifying(clearAutomatically = true)
    public void setTablePeople(TableInfo table, int people){
        int i = entityManager.createQuery("Update TableInfo t SET t.people = :people where t.tableNumber=:tableNo")
                .setParameter("people", people)
                .setParameter("tableNo", table.getTableNumber())
                .executeUpdate();
        System.out.println(i);
    }

}
