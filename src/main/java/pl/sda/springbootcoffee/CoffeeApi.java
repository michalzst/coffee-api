package pl.sda.springbootcoffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
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

//    @EventListener(ApplicationReadyEvent.class) //taka jakby inicializacja bazy danych
//    public void get() {
//        Coffee coffee1 = new Coffee("Prima", "Black");
//        Coffee coffee2 = new Coffee("Czibo", "Black");
//        Coffee coffee3 = new Coffee("Jacobs", "Black");
//        coffeeRepo.save(coffee1);
//        coffeeRepo.save(coffee2);
//        coffeeRepo.save(coffee3);
//    }

    //  2 sposob - wstrzykiwanie do konstruktora -ten jest poprawny
    private CoffeeRepo coffeeRepo;

    @Autowired
    public CoffeeApi(CoffeeRepo coffeeRepo) {
        this.coffeeRepo = coffeeRepo;
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
        Optional<Coffee> byId= coffeeRepo.findById(coffee.getId());
        if(byId.isPresent()){
            coffeeRepo.save(coffee);
        }
    }

    @DeleteMapping //delete
    public void delete(@RequestParam Long id) {
        coffeeRepo.deleteById(id);
    }
}
