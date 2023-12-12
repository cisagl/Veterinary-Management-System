package isaoglu.cahit.VetApp.business.abstracts;

import isaoglu.cahit.VetApp.dto.request.animal.AnimalSaveRequest;
import isaoglu.cahit.VetApp.dto.request.animal.AnimalUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.animal.AnimalResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import isaoglu.cahit.VetApp.entitiy.Vaccine;

import java.util.List;

public interface IAnimalService {
    Animal getById(long id);
    Animal getByName(String name);
    List<Animal> findByCustomer(long id);
    AnimalResponse save(AnimalSaveRequest animalSaveRequest);
    AnimalResponse update(long id, AnimalUpdateRequest animalUpdateRequest);
    void delete(long id);
    List<Animal> findAll();
}
