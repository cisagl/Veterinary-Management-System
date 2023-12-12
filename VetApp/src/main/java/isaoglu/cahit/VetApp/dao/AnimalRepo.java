package isaoglu.cahit.VetApp.dao;

import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
    Animal findByName(String name);
    Animal findById(long id);
    boolean existsByNameAndSpeciesAndBreedAndGenderAndColorAndDateOfBirth(String name, String species, String breed, String gender, String color, LocalDate dateOfBirth);
    List<Animal> findByCustomer(Customer customer);

}
