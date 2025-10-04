package com.hihoffff.vethospital.service;

import com.hihoffff.vethospital.data.OwnerRepository;
import com.hihoffff.vethospital.model.Owner;
import com.hihoffff.vethospital.model.Pet;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
     public OwnerService(OwnerRepository ownerRepository){
         this.ownerRepository = ownerRepository;
     }
     public Owner add(Owner owner){
         if(owner.getPets()!=null){
             for(Pet pet:owner.getPets()){
                 pet.setOwner(owner);
             }
         }
         return ownerRepository.save(owner);
     }
     public void delete(Long id){
         ownerRepository.deleteById(id);
     }
     @Nullable
     public Owner getById(Long id){
         return ownerRepository.findById(id).orElse(null);
     }

     public Owner patch(Long id, Owner updates){
         return ownerRepository.findById(id).map(
                 owner -> {
                     if(updates.getName() != null){
                         owner.setName(updates.getName());
                     }
                     if(updates.getPhoneNumber() != null){
                         owner.setPhoneNumber(updates.getPhoneNumber());
                     }
                     if(updates.getPets() != null){
                         if(!updates.getPets().isEmpty()){
                             owner.getPets().clear();  //для очистки объектов из БД
                             for(Pet pet:updates.getPets()){
                                 pet.setOwner(owner);
                                 owner.getPets().add(pet);
                             }
                         }
                     }
                     return ownerRepository.save(owner);
                 }
         ).orElse(null);
     }
     public Owner update(Long id, Owner newOwner){
        return ownerRepository.findById(id).map(
                owner -> {

                    owner.setName(newOwner.getName());
                    owner.setPhoneNumber(newOwner.getPhoneNumber());
                    if(newOwner.getPets()!=null){
                        owner.getPets().clear();  //для очистки объектов из БД
                        for(Pet pet:newOwner.getPets()){
                            pet.setOwner(owner);
                            owner.getPets().add(pet);
                        }

                    }
                    return ownerRepository.save(owner);
                }
        ).orElse(null);
     }
     public List<Owner> findAll(){
         return ownerRepository.findAll();
     }

}
