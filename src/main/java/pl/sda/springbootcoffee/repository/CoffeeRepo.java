package pl.sda.springbootcoffee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootcoffee.Entity.Coffee;

@Repository
public interface CoffeeRepo extends CrudRepository<Coffee,Long> {
}
