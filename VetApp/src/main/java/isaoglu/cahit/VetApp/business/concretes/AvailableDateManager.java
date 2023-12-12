package isaoglu.cahit.VetApp.business.concretes;

import isaoglu.cahit.VetApp.business.abstracts.IAvailableDateService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dao.AvailableDateRepo;
import isaoglu.cahit.VetApp.dto.request.availabledate.AvailableDateSaveRequest;
import isaoglu.cahit.VetApp.dto.request.availabledate.AvailableDateUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.availabledate.AvailableDateResponse;
import isaoglu.cahit.VetApp.entitiy.AvailableDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements IAvailableDateService {

    private final AvailableDateRepo availableDateRepo;
    private final IModelMapperService modelMapperService;


    @Override
    public AvailableDate getById(long id) {
        return this.availableDateRepo.findById(id);
    }

    @Override
    public AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate saveAvDate = this.modelMapperService.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        System.out.println(saveAvDate.getDoctor().getId());
        if (this.availableDateRepo.existsByAvailableDateAndDoctor(saveAvDate.getAvailableDate(), saveAvDate.getDoctor())) {
            throw new IllegalArgumentException(saveAvDate.getDoctor().getName() + " doktor " + saveAvDate.getAvailableDate() + " tarihinde zaten çalışıyor, lütfen farkı bir tarih giriniz");
        }
        return this.modelMapperService.forResponse().map(this.availableDateRepo.save(saveAvDate), AvailableDateResponse.class);
    }

    @Override
    public AvailableDateResponse update(long id, AvailableDateUpdateRequest availableDateUpdateRequest) {
        AvailableDate updateAvDate = this.modelMapperService.forRequest().map(availableDateUpdateRequest, AvailableDate.class);
        updateAvDate.setId(id);
        if (this.availableDateRepo.existsByAvailableDateAndDoctor(updateAvDate.getAvailableDate(), updateAvDate.getDoctor())) {
            throw new IllegalArgumentException("Doktor " + updateAvDate.getAvailableDate() + " tarihinde zaten çalışıyor, lütfen farkı bir tarih giriniz");
        }
        return this.modelMapperService.forResponse().map(this.availableDateRepo.save(updateAvDate), AvailableDateResponse.class);
    }

    @Override
    public void delete(long id) {
        this.availableDateRepo.delete(this.getById(id));
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }
}
