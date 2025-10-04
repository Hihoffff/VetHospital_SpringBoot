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

    public Pet patch(Long id, Map<String,Object> updates){
        return petRepository.findById(id).map(
                pet -> {
                    if(updates.containsKey("name")){pet.setName(updates.get("name").toString());}
                    if(updates.containsKey("age")){pet.setAge((Byte)updates.get("age"));}
                    if(updates.containsKey("type")){pet.setType(updates.get("type").toString());}

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
