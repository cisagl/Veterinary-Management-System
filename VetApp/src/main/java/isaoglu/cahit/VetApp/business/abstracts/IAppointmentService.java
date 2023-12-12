package isaoglu.cahit.VetApp.business.abstracts;
import isaoglu.cahit.VetApp.dto.request.appointment.AppointmentSaveRequest;
import isaoglu.cahit.VetApp.dto.request.appointment.AppointmentUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.appointment.AppointmentResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Appointment;
import isaoglu.cahit.VetApp.entitiy.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment getById(long id);
    AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest);
    AppointmentResponse update(long id, AppointmentUpdateRequest appointmentUpdateRequest);
    void delete(long id);
    List<Appointment> findByDateAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor);
    List<Appointment> findByDateAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);

    List<Appointment> findAll();
}
