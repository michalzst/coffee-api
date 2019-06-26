package pl.sda.springbootcoffee.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.sda.springbootcoffee.Entity.Cup;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoffee;
    private String nameCoffee;
    private String typeCoffee;

    @OneToOne
    private Cup cup;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "place_id_place", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Place place;

    public Coffee() {
    }

    public Coffee(String nameCoffee, String typeCoffee, Place place) {
        this.nameCoffee = nameCoffee;
        this.typeCoffee = typeCoffee;
        this.place=place;
    }

    public Long getIdCoffee() {
        return idCoffee;
    }

    public void setIdCoffee(Long idCoffee) {
        this.idCoffee = idCoffee;
    }

    public String getNameCoffee() {
        return nameCoffee;
    }

    public void setNameCoffee(String nameCoffee) {
        this.nameCoffee = nameCoffee;
    }

    public String getTypeCoffee() {
        return typeCoffee;
    }

    public void setTypeCoffee(String typeCoffee) {
        this.typeCoffee = typeCoffee;
    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
