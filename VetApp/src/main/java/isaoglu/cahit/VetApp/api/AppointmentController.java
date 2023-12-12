package isaoglu.cahit.VetApp.api;

import isaoglu.cahit.VetApp.business.abstracts.IAppointmentService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dto.request.appointment.AppointmentSaveRequest;
import isaoglu.cahit.VetApp.dto.request.appointment.AppointmentUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.appointment.AppointmentResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Appointment;
import isaoglu.cahit.VetApp.entitiy.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping()
    public String home(){
        return "Randevular";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findAll(){
        return this.appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment findById(@PathVariable("id")int id){
        return this.appointmentService.getById(id);
    }

    @GetMapping("/date&doctor")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findByDatesAndDoctor(@RequestParam LocalDateTime startDate, LocalDateTime endDate,
                                                  @RequestBody Doctor doctor){
        return this.appointmentService.findByDateAndDoctor(startDate,endDate,doctor);
    }
    @GetMapping("/date&animal")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findByDatesAndAnimal(@RequestParam LocalDateTime startDate, LocalDateTime endDate,
                                                  @RequestBody Animal animal){
        return this.appointmentService.findByDateAndAnimal(startDate,endDate, animal);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest){
        return appointmentService.save(appointmentSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable("id") int id,@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        return appointmentService.update(id, appointmentUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.appointmentService.delete(id);
    }

}
