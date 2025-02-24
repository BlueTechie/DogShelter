package project.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.backend.enums.Color;
import project.backend.enums.Sex;

@Entity
@Table(name = "example")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable = false)
    private String name;

    @Min(value = 0, message = "Age must be a positive number")
    private int age;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Sex needs to be specified")
    private Sex sex;

    @NotNull(message = "Vaccination status needs to be specified")
    private boolean vaccinated;

    private Color color;




}
