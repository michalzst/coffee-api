package pl.sda.springbootcoffee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootcoffee.Entity.Adress;

@Repository
public interface AdressRepo extends CrudRepository<Adress,Long> {
}
