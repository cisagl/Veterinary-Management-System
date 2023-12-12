package isaoglu.cahit.VetApp.api;

import isaoglu.cahit.VetApp.business.abstracts.IAnimalService;
import isaoglu.cahit.VetApp.business.abstracts.ICustomerService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dto.request.animal.AnimalSaveRequest;
import isaoglu.cahit.VetApp.dto.request.animal.AnimalUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.animal.AnimalResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final IAnimalService animalService;
    private final ICustomerService customerService;

    public AnimalController(IAnimalService animalService, ICustomerService customerService) {
        this.animalService = animalService;
        this.customerService = customerService;
    }

    @GetMapping()
    public String home(){
        return "Hayvanlar";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll(){
        return this.animalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal findById(@PathVariable("id") Long id){
        return this.animalService.getById(id);
    }

    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findByCustomer(@RequestParam long id){
        return this.animalService.findByCustomer(id);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public Animal findByName(@RequestParam String name){
        return this.animalService.getByName(name);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest){
        return animalService.save(animalSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@Valid @PathVariable("id") long id, @RequestBody AnimalUpdateRequest animalUpdateRequest){
        return this.animalService.update(id, animalUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.animalService.delete(id);
    }
}
