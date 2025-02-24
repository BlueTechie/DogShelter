package project.backend.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.backend.entity.DogEntity;
import project.backend.enums.Color;
import project.backend.enums.Sex;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogDto{
    private long id;

    private String name;

    private int age;

    private Sex sex;

    private boolean vaccinated;

    private Color color;

}
