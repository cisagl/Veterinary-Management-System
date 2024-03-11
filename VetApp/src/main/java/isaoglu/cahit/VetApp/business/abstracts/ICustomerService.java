package isaoglu.cahit.VetApp.business.abstracts;

import isaoglu.cahit.VetApp.dto.request.customer.CustomerSaveRequest;
import isaoglu.cahit.VetApp.dto.request.customer.CustomerUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.customer.CustomerResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerService {


    Customer getById(long id);
    Customer getByName(String name);
    CustomerResponse save(CustomerSaveRequest customerSaveRequest);
    CustomerResponse update(long id, CustomerUpdateRequest customerUpdateRequest);
    void delete(long id);
    List<Customer> findAll();
}
