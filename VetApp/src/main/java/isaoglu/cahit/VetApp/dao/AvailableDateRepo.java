package isaoglu.cahit.VetApp.dao;

import isaoglu.cahit.VetApp.entitiy.AvailableDate;
import isaoglu.cahit.VetApp.entitiy.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
    AvailableDate findById(long id);
    boolean existsByAvailableDateAndDoctor(LocalDate availableDate, Doctor doctor);
    boolean existsByAvailableDate(LocalDate availableDate);
}
