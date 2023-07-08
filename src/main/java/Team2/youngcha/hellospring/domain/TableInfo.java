package Team2.youngcha.hellospring.domain;

import javax.persistence.*;

@Entity
public class TableInfo {

    @Id
    private int tableNumber;
    @Column(columnDefinition = "int default 4")
    private int people;
    private int places;

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
