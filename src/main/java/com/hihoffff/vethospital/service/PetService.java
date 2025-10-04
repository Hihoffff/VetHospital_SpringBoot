package com.hihoffff.vethospital.service;

import com.hihoffff.vethospital.data.PetRepository;
import com.hihoffff.vethospital.model.Pet;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PetService {
    private final PetRepository petRepository;
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public Pet add(Pet pet){
        return petRepository.save(pet);
    }
    public void delete(Long id){
        petRepository.deleteById(id);
    }
    @Nullable
    public Pet getById(Long id){
        return petRepository.findById(id).orElse(null);
    }

    public Pet patch(Long id, Pet updatedPet){
        return petRepository.findById(id).map(
                pet -> {
                        if(updatedPet.getName() != null){
                            pet.setName(updatedPet.getName());
                        }
                        if(updatedPet.getAge() != null){
                            pet.setAge(updatedPet.getAge());
                        }
                        if(updatedPet.getType() != null){
                            pet.setType(updatedPet.getType());
                        }

                    return petRepository.save(pet);
                }
        ).orElse(null);
    }
    public Pet update(Long id, Pet newPet){
        return petRepository.findById(id).map(
                pet -> {
                    pet.setName(newPet.getName());
                    pet.setType(newPet.getType());
                    pet.setAge(newPet.getAge());
                    return petRepository.save(pet);
                }
        ).orElse(null);
    }
    public List<Pet> findAll(){
        return petRepository.findAll();
    }

}
