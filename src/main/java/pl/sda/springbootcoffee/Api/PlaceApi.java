package pl.sda.springbootcoffee.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import pl.sda.springbootcoffee.Entity.*;
import pl.sda.springbootcoffee.repository.AdressRepo;
import pl.sda.springbootcoffee.repository.CoffeeRepo;
import pl.sda.springbootcoffee.repository.CupRepo;
import pl.sda.springbootcoffee.repository.PlaceRepo;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/place-api")
public class PlaceApi {

    @EventListener(ApplicationReadyEvent.class) //taka jakby inicializacja bazy danych
    public void get() {

        // save cup
        Cup cupBig = new Cup(Size.BIG);
        Cup cupSmall = new Cup(Size.SMALL);
        cupRepo.save(cupBig);
        cupRepo.save(cupSmall);

        Adress adress = new Adress("Kolumba 86", "Szczecin", "73-110");
        adressRepo.save(adress);

        Place place = new Place();
        place.setNamePlace("Columbus");
        place.setAdress(adress);
        placeRepo.save(place);

        Coffee coffee1 = new Coffee();
        coffee1.setNameCoffee("Jacobs");
        coffee1.setTypeCoffee("Black");
        coffee1.setCup(cupSmall);
        coffee1.setPlace(place);
        coffeeRepo.save(coffee1);

        Coffee coffee2 = new Coffee();
        coffee2.setNameCoffee("Tchibo");
        coffee2.setTypeCoffee("White");
        coffee2.setCup(cupBig);
        coffee2.setPlace(place);
        coffeeRepo.save(coffee2);
    }

    //  2 sposob - wstrzykiwanie do konstruktora (tu bazy dabych) -ten jest poprawny
    private CoffeeRepo coffeeRepo;
    private CupRepo cupRepo;
    private PlaceRepo placeRepo;
    private AdressRepo adressRepo;

    @Autowired
    public PlaceApi(CoffeeRepo coffeeRepo, CupRepo cupRepo, PlaceRepo placeRepo, AdressRepo adressRepo) {
        this.coffeeRepo = coffeeRepo;
        this.cupRepo = cupRepo;
        this.placeRepo = placeRepo;
        this.adressRepo = adressRepo;
    }
    //  koniec 2 sposobu

    @GetMapping //get
    public Iterable<Place> getPlace() {
        return placeRepo.findAll();
    }

    @PostMapping //post
    public void add(@RequestBody Place place) {
        placeRepo.save(place);
    }

    @PutMapping //put
    public void update(@RequestBody Place place) {
        Optional<Place> byId = placeRepo.findById(place.getIdPlace());
        if (byId.isPresent()) {
            placeRepo.save(place);
        }
    }

    @DeleteMapping //delete
    public void delete(@RequestParam Long id) {
        placeRepo.deleteById(id);
    }
}
