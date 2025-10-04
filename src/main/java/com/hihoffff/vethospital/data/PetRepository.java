package com.hihoffff.vethospital.data;

import com.hihoffff.vethospital.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findByName(String name);

    // поиск питомцев конкретного владельца
    List<Pet> findByOwnerId(Long owner);

    List<Pet> findByType(String type);
}
