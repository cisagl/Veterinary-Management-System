package isaoglu.cahit.VetApp.business.abstracts;
import isaoglu.cahit.VetApp.dto.request.vaccine.VaccineSaveRequest;
import isaoglu.cahit.VetApp.dto.request.vaccine.VaccineUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.vaccine.VaccineResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    Vaccine getById(long id);
    VaccineResponse save(VaccineSaveRequest vaccineSaveRequest);
    VaccineResponse update(long id, VaccineUpdateRequest vaccineUpdateRequest);
    void delete(long id);
    List<Vaccine> findByAnimal(long id);
    List<Vaccine> findVaccinesInDateRange(LocalDate protectionStartDate, LocalDate protectionFinishDate);
    List<Vaccine> findAll();
}
