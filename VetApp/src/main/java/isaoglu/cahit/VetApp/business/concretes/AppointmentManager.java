package isaoglu.cahit.VetApp.business.concretes;

import isaoglu.cahit.VetApp.business.abstracts.IAppointmentService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dao.AppointmentRepo;
import isaoglu.cahit.VetApp.dao.AvailableDateRepo;
import isaoglu.cahit.VetApp.dto.request.appointment.AppointmentSaveRequest;
import isaoglu.cahit.VetApp.dto.request.appointment.AppointmentUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.appointment.AppointmentResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Appointment;
import isaoglu.cahit.VetApp.entitiy.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements IAppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final AvailableDateRepo availableDateRepo;
    private final IModelMapperService modelMapperService;


    @Override
    public Appointment getById(long id) {
        return this.appointmentRepo.findById(id);
    }

    @Override
    public AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest) {
        Appointment saveAppointment = this.modelMapperService.forRequest().map(appointmentSaveRequest, Appointment.class);
        if (this.availableDateRepo.existsByAvailableDate(LocalDate.from(saveAppointment.getAppointmentDate()))){
            if (this.appointmentRepo.existsByAppointmentDate(saveAppointment.getAppointmentDate())){
                throw new IllegalArgumentException("Girilen saatte başka bir randevu mevcuttur.");
            } else {
                return this.modelMapperService.forResponse().map(this.appointmentRepo.save(saveAppointment), AppointmentResponse.class);
            }
        } else {
            throw new IllegalArgumentException("Doktor bu tarihte çalışmamaktadır!");
        }
    }

    @Override
    public AppointmentResponse update(long id, AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment updateAppointment = this.modelMapperService.forRequest().map(appointmentUpdateRequest, Appointment.class);
        updateAppointment.setId(id);
        if (this.availableDateRepo.existsByAvailableDate(LocalDate.from(updateAppointment.getAppointmentDate()))){
            if (this.appointmentRepo.existsByAppointmentDate(updateAppointment.getAppointmentDate())){
                throw new IllegalArgumentException("Girilen saatte başka bir randevu mevcuttur.");
            } else {
                return this.modelMapperService.forResponse().map(this.appointmentRepo.save(updateAppointment), AppointmentResponse.class);
            }
        } else {
            throw new IllegalArgumentException("Doktor bu tarihte çalışmamaktadır!");
        }
    }

    @Override
    public void delete(long id) {
        this.appointmentRepo.delete(this.getById(id));
    }

    @Override
    public List<Appointment> findByDateAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor) {
        return this.appointmentRepo.findByAppointmentDateBetweenAndDoctor(startDate, endDate, doctor);
    }

    @Override
    public List<Appointment> findByDateAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal) {
        return this.appointmentRepo.findByAppointmentDateBetweenAndAnimal(startDate, endDate, animal);
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }
}