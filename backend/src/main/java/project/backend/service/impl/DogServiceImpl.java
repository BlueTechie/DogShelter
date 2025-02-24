package project.backend.service.impl;

import jakarta.validation.Valid;
import project.backend.dto.DogDto;
import project.backend.dto.LightDogDto;
import project.backend.entity.DogEntity;
import project.backend.exception.EntityNotFoundException;
import project.backend.mapper.DogMapper;
import project.backend.repository.DogRepository;
import project.backend.service.DogService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.backend.service.validator.DogValidator;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final DogValidator dogValidator;
    private final DogMapper dogMapper;

    // Get all dogs in the database
    @Override
    public List<LightDogDto> getAllDogs() {
        return dogMapper.convertEntityListToLightDtoList(dogRepository.findAll());
    }

    // Get a specific dog by its ID
    @Override
    public DogDto getDogById(long id) {
        DogEntity dog = dogRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Dog with ID" + id + " not found")
        );
        return dogMapper.convertEntityToDto(dog);
    }

    // Store a new dog entity in the database and validate the inputs
    @Override
    public DogDto createDog(@Valid DogDto dog) {
        dogValidator.validateDog(dog);
        DogEntity dogEntity = dogMapper.convertDtoToEntity(dog);
        DogDto receivedDogDto = dogMapper.convertEntityToDto(dogRepository.save(dogEntity));
        return receivedDogDto;
    }

    // Update an existing dog in the database
    @Override
    public DogDto updateDog(long id, DogDto dog) {
        dogValidator.validateDog(dog);
        DogEntity updatedDogEntity = dogRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Dog with ID" + id + " not found"));
        updatedDogEntity.setName(dog.getName());
        updatedDogEntity.setAge(dog.getAge());
        updatedDogEntity.setSex(dog.getSex());
        updatedDogEntity.setColor(dog.getColor());
        updatedDogEntity.setVaccinated(dog.isVaccinated());
        return dogMapper.convertEntityToDto(dogRepository.save(updatedDogEntity));
    }

    @Override
    public void deleteDog(long id) {
        if(!dogRepository.existsById(id)){
            throw new EntityNotFoundException("Dog with ID" + id + " not found");
        }
        dogRepository.deleteById(id);
    }
}
