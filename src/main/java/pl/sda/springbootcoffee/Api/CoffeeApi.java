package pl.sda.springbootcoffee.Api;

import org.hibernate.mapping.Set;
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

@RestController
@RequestMapping("/pl/sda/springbootcoffee/Api")
public class CoffeeApi {
//    1 sposob - wstrzykiwanie do pola
//    @Autowired
//    private CoffeeRepo coffeeRepo;
//    koniec 1 sposobu

//    3 sposob - wstrzykiwanie do metody
//    private CoffeeRepo coffeeRepo;
//    @Autowired
//    public void setCoffeeRepo(CoffeeRepo coffeeRepo){
//        this.coffeeRepo=coffeeRepo;
//    }
//      koniec 3 sposobu

    @EventListener(ApplicationReadyEvent.class) //taka jakby inicializacja bazy danych
    public void get() {
        Coffee coffee1 = new Coffee("Jacobs", "Black");
        Coffee coffee2 = new Coffee("Tchibo", "White");
        Cup cupSmall = new Cup(Size.SMALL);
        Cup cupMedium = new Cup(Size.MEDIUM);
        Adress adress = new Adress("Kolumba 86", "Szczecin", "73-110");
        Place place = new Place("Columbus", adress);

        adressRepo.save(adress);
        cupRepo.save(cupSmall);
        cupRepo.save(cupMedium);
        placeRepo.save(place);

        coffee1.setCup(cupSmall);
        coffee1.setPlace(place);
        coffee2.setCup(cupMedium);
        coffee2.setPlace(place);

        coffeeRepo.save(coffee1);
        coffeeRepo.save(coffee2);
    }

    //  2 sposob - wstrzykiwanie do konstruktora (tu bazy dabych) -ten jest poprawny
    private CoffeeRepo coffeeRepo;
    private CupRepo cupRepo;
    private PlaceRepo placeRepo;
    private AdressRepo adressRepo;

    @Autowired
    public CoffeeApi(CoffeeRepo coffeeRepo, CupRepo cupRepo, PlaceRepo placeRepo, AdressRepo adressRepo) {
        this.coffeeRepo = coffeeRepo;
        this.cupRepo = cupRepo;
        this.placeRepo = placeRepo;
        this.adressRepo = adressRepo;
    }
    //  koniec 2 sposobu

    @GetMapping //get
    public Iterable<Coffee> getCoffee() {
        return coffeeRepo.findAll();
    }

    @PostMapping //post
    public void add(@RequestBody Coffee coffee) {
        coffeeRepo.save(coffee);
    }

    @PutMapping //put
    public void update(@RequestBody Coffee coffee) {
        Optional<Coffee> byId = coffeeRepo.findById(coffee.getId());
        if (byId.isPresent()) {
            coffeeRepo.save(coffee);
        }
    }

    @DeleteMapping //delete
    public void delete(@RequestParam Long id) {
        coffeeRepo.deleteById(id);
    }
}