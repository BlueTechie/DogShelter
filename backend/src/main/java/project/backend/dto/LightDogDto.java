package project.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.backend.enums.Color;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LightDogDto {
    private long id;

    @NotNull
    private String name;

    private int age;


}
