package pl.sda.springbootcoffee.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlace;
    private String namePlace;

    @OneToOne
    private Adress adress;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "place")
    private Set<Coffee> coffees=new HashSet<>();

    public Set<Coffee> getCoffee() {
        return coffees;
    }

    public void setCoffee(Set<Coffee> coffees) {
        this.coffees = coffees;
    }

    public Place() {
    }

    public Place(String namePlace, Adress adress,Set<Coffee> coffees) {
        this.namePlace = namePlace;
        this.adress = adress;
        this.coffees = coffees;
    }

    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
