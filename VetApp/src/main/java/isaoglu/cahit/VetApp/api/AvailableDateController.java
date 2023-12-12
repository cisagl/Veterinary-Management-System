package isaoglu.cahit.VetApp.api;

import isaoglu.cahit.VetApp.business.abstracts.IAvailableDateService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dto.request.availabledate.AvailableDateSaveRequest;
import isaoglu.cahit.VetApp.dto.request.availabledate.AvailableDateUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.availabledate.AvailableDateResponse;
import isaoglu.cahit.VetApp.entitiy.AvailableDate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/available-dates")
public class AvailableDateController {

    private final IAvailableDateService availableDateService;

    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }


    @GetMapping()
    public String home(){
        return "Müsait Günler";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDate> findAll(){
        return this.availableDateService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate findById(@PathVariable("id")int id){
        return this.availableDateService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDateResponse save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest){
        return this.availableDateService.save(availableDateSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse update(@Valid @PathVariable("id") int id, @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest){
        return this.availableDateService.update(id, availableDateUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.availableDateService.delete(id);
    }
}
