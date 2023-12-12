package isaoglu.cahit.VetApp.business.abstracts;
import isaoglu.cahit.VetApp.dto.request.doctor.DoctorSaveRequest;
import isaoglu.cahit.VetApp.dto.request.doctor.DoctorUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.doctor.DoctorResponse;
import isaoglu.cahit.VetApp.entitiy.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor getById(long id);
    DoctorResponse save(DoctorSaveRequest doctorSaveRequest);
    DoctorResponse update(long id, DoctorUpdateRequest doctorUpdateRequest);
    void delete(long id);
    List<Doctor> findAll();
}
