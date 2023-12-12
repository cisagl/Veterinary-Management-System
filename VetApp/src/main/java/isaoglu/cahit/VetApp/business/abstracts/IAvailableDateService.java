package isaoglu.cahit.VetApp.business.abstracts;
import isaoglu.cahit.VetApp.dto.request.availabledate.AvailableDateSaveRequest;
import isaoglu.cahit.VetApp.dto.request.availabledate.AvailableDateUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.availabledate.AvailableDateResponse;
import isaoglu.cahit.VetApp.entitiy.AvailableDate;

import java.util.List;

public interface IAvailableDateService {
    AvailableDate getById(long id);
    AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest);
    AvailableDateResponse update(long id, AvailableDateUpdateRequest availableDateUpdateRequest);
    void delete(long id);
    List<AvailableDate> findAll();
}
