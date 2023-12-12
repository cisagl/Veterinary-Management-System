package isaoglu.cahit.VetApp.api;

import isaoglu.cahit.VetApp.business.abstracts.IVaccineService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dto.request.vaccine.VaccineSaveRequest;
import isaoglu.cahit.VetApp.dto.request.vaccine.VaccineUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.vaccine.VaccineResponse;
import isaoglu.cahit.VetApp.entitiy.Vaccine;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/vaccines")
public class VaccineController {

    private final IVaccineService vaccineService;

    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping()
    public String home() {
        return "Aşılar";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findAll() {
        return this.vaccineService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine findById(@PathVariable("id") int id) {
        return this.vaccineService.getById(id);
    }

    @GetMapping("/animal")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findByAnimal(@RequestParam long id) {
        return this.vaccineService.findByAnimal(id);
    }

    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findAllByDates(@RequestParam LocalDate protectionStartDate, LocalDate protectionFinishDate){
        return this.vaccineService.findVaccinesInDateRange(protectionStartDate, protectionFinishDate);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineResponse save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        return this.vaccineService.save(vaccineSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse update(@Valid @PathVariable("id") int id, @RequestBody VaccineUpdateRequest vaccineUpdateRequest) {
        return this.vaccineService.update(id, vaccineUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        this.vaccineService.delete(id);
    }
}
