package pl.sda.springbootcoffee.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Adress adress;

    @OneToMany(mappedBy = "place")
    private Set<Coffee> coffees;

    public Place(){

    }

    public Place(String name, Adress adress, Set<Coffee> coffees) {
        this.name = name;
        this.adress=adress;
        this.coffees=coffees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Set<Coffee> getCoffee() {
        return coffees;
    }

    public void setCoffee(Set<Coffee> coffee) {
        this.coffees = coffees;
    }
}
