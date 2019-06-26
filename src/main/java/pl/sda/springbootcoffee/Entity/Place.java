package pl.sda.springbootcoffee.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "place")
    private Set<Coffee> coffee;

    @OneToOne
    private Adress adress;

    public Place(){

    }

    public Place(String name, Adress adress) {
        this.name = name;
        this.adress=adress;
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
        return coffee;
    }

    public void setCoffee(Set<Coffee> coffee) {
        this.coffee = coffee;
    }
}
