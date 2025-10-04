package com.hihoffff.vethospital.service;

import com.hihoffff.vethospital.data.OwnerRepository;
import com.hihoffff.vethospital.model.Owner;
import com.hihoffff.vethospital.model.Pet;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

     public Owner patch(Long id, Map<String,Object> updates){
         return ownerRepository.findById(id).map(
                 owner -> {
                     if(updates.containsKey("name")){owner.setName(updates.get("name").toString());}
                     if(updates.containsKey("phoneNumber")){owner.setPhoneNumber(updates.get("phoneNumber").toString());}
                     if(updates.containsKey("pets")){owner.setPets((List<Pet>) updates.get("pets"));}
                     return ownerRepository.save(owner);
                 }
         ).orElse(null);
     }
     public Owner update(Long id, Owner newOwner){
        return ownerRepository.findById(id).map(
                owner -> {
                    owner.setName(newOwner.getName());
                    owner.setPets(newOwner.getPets());
                    owner.setPhoneNumber(newOwner.getPhoneNumber());
                    return ownerRepository.save(owner);
                }
        ).orElse(null);
     }
     public List<Owner> findAll(){
         return ownerRepository.findAll();
     }

}
