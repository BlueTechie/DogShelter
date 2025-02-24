package project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.entity.DogEntity;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<DogEntity, Long> {
    List<DogEntity> findAllBy();
}
