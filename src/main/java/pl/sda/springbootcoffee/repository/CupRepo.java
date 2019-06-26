package pl.sda.springbootcoffee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootcoffee.Entity.Cup;

@Repository
public interface CupRepo extends CrudRepository<Cup,Long> {
}
