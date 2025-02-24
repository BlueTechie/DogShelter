package project.backend.mapper;

import org.mapstruct.Mapper;
import project.backend.dto.DogDto;
import project.backend.dto.LightDogDto;
import project.backend.entity.DogEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DogMapper {

    // Convert a DTO to an entity
    DogEntity convertDtoToEntity(DogDto dogDto);

    // Convert a light Dto (with only an Id, a name and an age) to an entity
    DogEntity convertLightDtoToEntity(LightDogDto lightDogDto);

    // Convert a dog entity to a Dto
    DogDto convertEntityToDto(DogEntity dogEntity);

    // Convert an entity to a light dto (with only an id, name and age)
    LightDogDto convertEntityToLightDto(DogEntity dogEntity);

    // Convert list of entities to list of dtos
    List<DogDto> convertEntityListToDtoList(List<DogEntity> dogEntityList);

    // Convert list of entities to list of light dtos
    List<LightDogDto> convertEntityListToLightDtoList(List<DogEntity> dogEntityList);

}
