package isaoglu.cahit.VetApp.api;

import isaoglu.cahit.VetApp.business.abstracts.ICustomerService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dto.request.customer.CustomerSaveRequest;
import isaoglu.cahit.VetApp.dto.request.customer.CustomerUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.customer.CustomerResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public String home(){
        return "Müşteriler";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findById(@PathVariable("id")int id){
        return this.customerService.getById(id);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public Customer findByName(@RequestParam String name){
        return this.customerService.getByName(name);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest){
        return this.customerService.save(customerSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@Valid @PathVariable("id") int id, @RequestBody CustomerUpdateRequest customerUpdateRequest){
        return this.customerService.update(id, customerUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }
}
