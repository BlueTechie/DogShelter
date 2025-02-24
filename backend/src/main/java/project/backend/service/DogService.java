package project.backend.service;

import project.backend.dto.DogDto;
import project.backend.dto.LightDogDto;
import project.backend.entity.DogEntity;

import java.util.List;

public interface DogService {

    // Returns ID and name of all dogs in the database
    List<LightDogDto> getAllDogs();

    // Returns a dog using its ID
    DogDto getDogById(long id);

    // Create a new dog in the database
    DogDto createDog(DogDto dog);

    // Check if the dog exists, update it and return the updated dog entity
    DogDto updateDog(long id, DogDto updatedDog);

    // Delete a dog by id
    void deleteDog(long id);

}
