package project.backend.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import project.backend.dto.DogDto;
import project.backend.dto.LightDogDto;
import project.backend.entity.DogEntity;
import project.backend.service.DogService;

import java.util.List;

@RestController
@RequestMapping(value = "/dogs")
@Slf4j
@AllArgsConstructor
public class DogController {

    private final DogService dogService;

    // Returns ID and name of all dogs in the database
    @GetMapping
    public ResponseEntity<List<LightDogDto>> getAllDogs() {
        return ResponseEntity.ok(dogService.getAllDogs());
    }

    // If no dog with the requested ID is found, 404 Not Found is returned
    @GetMapping("/{id}")
    public ResponseEntity<DogDto> getDogById(@PathVariable long id) {
        return ResponseEntity.ok(dogService.getDogById(id));
    }

    // Creates a dog
    @PostMapping
    public ResponseEntity<DogDto> createDog(@Valid @RequestBody DogDto dog) {
        return ResponseEntity.ok(dogService.createDog(dog));
    }

    // Check if the dog exists, update it and return the updated dog entity
    @PutMapping("/{id}")
    public ResponseEntity<DogDto> updateDog(@PathVariable long id, @Valid @RequestBody DogDto dog) {
        return ResponseEntity.ok(dogService.updateDog(id, dog));
    }

    // Delete a dog with a specified id
    @DeleteMapping("/{id}")
    public ResponseEntity<DogDto> deleteDog(@PathVariable long id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }


}
