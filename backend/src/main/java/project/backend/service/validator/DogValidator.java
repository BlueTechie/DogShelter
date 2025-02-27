package project.backend.service.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import project.backend.dto.DogDto;
import project.backend.dto.ValidationErrorRestDto;
import project.backend.entity.DogEntity;
import project.backend.exception.ValidationException;
import project.backend.repository.DogRepository;
import project.backend.service.DogService;

@Component
@Slf4j
@RequiredArgsConstructor
public class DogValidator {

    public void validateDogName(String name) {
        System.out.printf("name: ->%s<-\n", name);
        if (name == null || !name.matches("[a-zA-Z ]+")){
            throw new ValidationException(
                new ValidationErrorRestDto("Name must only contain letters without spaces", null));
        }
    }

    public void validateDogAge(int age){
        if(age < 0 || age > 31){
            throw new ValidationException(
                new ValidationErrorRestDto("Age must be an integer between 1 and 30", null));
        }
    }

    public void validateDog(DogDto dog){
        validateDogName(dog.getName());
        validateDogAge(dog.getAge());
    }
}
