package isaoglu.cahit.VetApp.business.concretes;

import isaoglu.cahit.VetApp.business.abstracts.IAnimalService;
import isaoglu.cahit.VetApp.business.abstracts.ICustomerService;
import isaoglu.cahit.VetApp.core.modelmapper.IModelMapperService;
import isaoglu.cahit.VetApp.dao.AnimalRepo;
import isaoglu.cahit.VetApp.dao.CustomerRepo;
import isaoglu.cahit.VetApp.dto.request.animal.AnimalSaveRequest;
import isaoglu.cahit.VetApp.dto.request.animal.AnimalUpdateRequest;
import isaoglu.cahit.VetApp.dto.response.animal.AnimalResponse;
import isaoglu.cahit.VetApp.entitiy.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalManager implements IAnimalService {


    private final AnimalRepo animalRepo;
    private final CustomerRepo customerRepo;
    private final ICustomerService customerService;
    private final IModelMapperService modelMapperService;

    @Override
    public Animal getById(long id) {
        return this.animalRepo.findById(id);
    }
    @Override
    public Animal getByName(String name) {
        return this.animalRepo.findByName(name);
    }

    @Override
    public List<Animal> findByCustomer(long id) {
       return this.animalRepo.findByCustomer(this.customerRepo.findById(id));
    }

    @Override
    public AnimalResponse save(AnimalSaveRequest animalSaveRequest) {
        Animal saveAnimal = this.modelMapperService.forRequest().map(animalSaveRequest, Animal.class);
        if (this.animalRepo.existsByNameAndSpeciesAndBreedAndGenderAndColorAndDateOfBirth(
                saveAnimal.getName(),
                saveAnimal.getSpecies(),
                saveAnimal.getBreed(),
                saveAnimal.getGender(),
                saveAnimal.getColor(),
                saveAnimal.getDateOfBirth())){
            throw new IllegalArgumentException("Girilen bilgiler ile birebir uyuşan bir hayvan mevcut");
        } else if (!("MALE".equals(saveAnimal.getGender()) || "FEMALE".equals(saveAnimal.getGender()))) {
            throw new IllegalArgumentException("Cinsiyet sadece MALE veya FEMALE olabilir");
        }
        return modelMapperService.forResponse().map(this.animalRepo.save(saveAnimal), AnimalResponse.class);
    }

    @Override
    public AnimalResponse update(long id, AnimalUpdateRequest animalUpdateRequest) {
        Animal updateAnimal = this.modelMapperService.forRequest().map(animalUpdateRequest, Animal.class);
        updateAnimal.setId(id);
        if (this.animalRepo.existsByNameAndSpeciesAndBreedAndGenderAndColorAndDateOfBirth(
                updateAnimal.getName(),
                updateAnimal.getSpecies(),
                updateAnimal.getBreed(),
                updateAnimal.getGender(),
                updateAnimal.getColor(),
                updateAnimal.getDateOfBirth())){
            throw new IllegalArgumentException("Girilen bilgiler ile birebir uyuşan bir hayvan mevcut");
        } else if (!("MALE".equals(updateAnimal.getGender()) || "FEMALE".equals(updateAnimal.getGender()))) {
            throw new IllegalArgumentException("Cinsiyet sadece MALE veya FEMALE olabilir");
        }
        return modelMapperService.forResponse().map(this.animalRepo.save(updateAnimal), AnimalResponse.class);
    }


    @Override
    public void delete(long id) {
        this.animalRepo.delete(this.getById(id));
    }

    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }
}
