package isaoglu.cahit.VetApp.business.concretes;

import isaoglu.cahit.VetApp.business.abstracts.IDoctorService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dao.DoctorRepo;
import isaoglu.cahit.VetApp.dto.request.doctor.DoctorSaveRequest;
import isaoglu.cahit.VetApp.dto.request.doctor.DoctorUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.doctor.DoctorResponse;
import isaoglu.cahit.VetApp.entitiy.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorManager implements IDoctorService {

    private final DoctorRepo doctorRepo;
    private final IModelMapperService modelMapperService;

    @Override
    public Doctor getById(long id) {
        return this.doctorRepo.findById(id);
    }

    @Override
    public DoctorResponse save(DoctorSaveRequest doctorSaveRequest) {
        Doctor saveDoc = this.modelMapperService.forRequest().map(doctorSaveRequest, Doctor.class);
        System.out.println(saveDoc.getMail());
        if (this.doctorRepo.existsByMail(saveDoc.getMail())){
            throw new IllegalArgumentException("Mail adresi daha önce girilmiştir, lütfen farklı bir adres giriniz");
        }
        return this.modelMapperService.forResponse().map(this.doctorRepo.save(saveDoc), DoctorResponse.class);
    }

    @Override
    public DoctorResponse update(long id, DoctorUpdateRequest doctorUpdateRequest) {
        Doctor updateDoc = this.modelMapperService.forRequest().map(doctorUpdateRequest, Doctor.class);
        updateDoc.setId(id);
        if (this.doctorRepo.existsByMail(updateDoc.getMail())){
            throw new IllegalArgumentException("Mail adresi daha önce girilmiştir, lütfen farklı bir adres giriniz");
        }
        return modelMapperService.forResponse().map(this.doctorRepo.save(updateDoc), DoctorResponse.class);
    }

    @Override
    public void delete(long id) {
        this.doctorRepo.delete(this.getById(id));
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }
}
