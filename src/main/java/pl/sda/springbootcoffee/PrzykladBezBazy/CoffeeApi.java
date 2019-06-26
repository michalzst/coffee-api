//package pl.sda.springbootcoffee.PrzykladBezBazy;
//
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class CoffeeApi {
//
//    private List<Coffee2> coffeeList;
//
//    public CoffeeApi() {                  // potrzebne do konsruktora w przykladzie bez bazy danych
//        coffeeList = new ArrayList<>();
//    }
//
//    @EventListener(ApplicationReadyEvent.class) //taka jakby inicializacja bazy danych
//    public void get() {
//        Coffee2 coffee1 = new Coffee2(1L,"Prima", "Black");
//        Coffee2 coffee2 = new Coffee2(2L,"Czibo", "Black");
//        Coffee2 coffee3 = new Coffee2(3L,"Jacobs", "Black");
//        coffeeList.add(coffee1);
//        coffeeList.add(coffee2);
//        coffeeList.add(coffee3);
//    }
//
//    @GetMapping("/hello")
//    public String get(@RequestHeader(required = false, defaultValue = "PL") String lang) {
//        if (lang.equals("PL")) {
//            return "Czesc";
//        }
//        if (lang.equals("EN")) {
//            return "Hello";
//        }
//        return "Niepojemaju";
//    }
//
//    @GetMapping("/hello/{lang}")
//    public String get2(@PathVariable String lang) {
//        if (lang.equals("PL")) {
//            return "Czesc";
//        }
//        if (lang.equals("EN")) {
//            return "Hello";
//        }
//        return "Niepojemaju";
//    }
//
//    @GetMapping //get
//    public List<Coffee2> getCoffee() {
//        return coffeeList;
//    }
//
//    @PostMapping //post
//    public void add(@RequestBody Coffee2 coffee) {
//        coffeeList.add(coffee);
//    }
//
//    @PutMapping //put
//    public void update(@RequestBody Coffee2 coffee) {
//        Optional<Coffee2> first = coffeeList.stream().filter(element -> element.getId().equals(coffee.getId())) //update sle w streamie
//                .findFirst();
//        if (first.isPresent()) {
//            coffeeList.set(coffeeList.indexOf(first.get()), coffee);
//        }
//
////        Coffee foundElement=null; //to samo co wyzej tylko w forech
////        for (Coffee c : coffeeList) {
////            if (c.getId().equals(coffee.getId()) ) {
////               foundElement=c;
////            }
////        }
////        coffeeList.set(coffeeList.indexOf(foundElement),coffee);
//    }
//
//    @DeleteMapping //delete
//    public boolean delete(@RequestParam Long id) {
//        return coffeeList.removeIf((element -> element.getId().equals(id)));
////        Coffee coffee = null;
////        for (Coffee c : coffeeList) {
////            if (id == c.getId()) {
////                coffee=c;
////            }
////        }
////        coffeeList.remove(coffee);
//    }
//}
