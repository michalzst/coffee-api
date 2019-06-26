package pl.sda.springbootcoffee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootcoffee.Entity.Place;

@Repository
public interface PlaceRepo extends CrudRepository<Place,Long> {
}
