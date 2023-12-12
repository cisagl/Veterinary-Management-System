package isaoglu.cahit.VetApp.dao;

import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    Customer findById(long id);
    boolean existsByMail(String mail);
}
