package isaoglu.cahit.VetApp.dao;

import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Appointment;
import isaoglu.cahit.VetApp.entitiy.Doctor;
import isaoglu.cahit.VetApp.entitiy.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findById(long id);
    boolean existsByAppointmentDate(LocalDateTime appointmentDate);
    List<Appointment> findByAppointmentDateBetweenAndDoctor(LocalDateTime startDate,LocalDateTime endDate, Doctor doctor);
    List<Appointment> findByAppointmentDateBetweenAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);

}
