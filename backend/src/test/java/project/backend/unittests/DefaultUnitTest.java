package project.backend.unittests;

import project.backend.basetest.TestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.backend.entity.DogEntity;
import project.backend.repository.DogRepository;
import project.backend.service.DogService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class DefaultUnitTest implements TestData {

    private DogService dogService;
    private DogRepository dogRepository;

    /*
    Use Mockito when to mock the return value of the methods.
     */
    //DogEntity dog = new DogEntity((long)5, "Buddy", 3, Sex.FEMALE, false, DogEntity.Color.BROWN);

    //DogEntity savedDog = dogRepository.save(dog);

    // Act
    //DogEntity foundDog = dogService.getDogById(savedDog.getId());

    // Assert
    //assertEquals(5, foundDog.id);

}
