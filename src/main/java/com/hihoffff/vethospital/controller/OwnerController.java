package com.hihoffff.vethospital.controller;


import com.hihoffff.vethospital.model.Owner;
import com.hihoffff.vethospital.model.Pet;
import com.hihoffff.vethospital.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getAll(){return this.ownerService.findAll();}

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long id){
         return this.ownerService.getById(id);
    }

    @PostMapping
    public Owner addNew(@RequestBody Owner owner){
        for(Pet obj: owner.getPets()) {
            System.out.println(obj.getOwner());
        }
        return this.ownerService.add(owner);
    }

    @PutMapping("/{id}")
    public Owner update(@RequestBody Owner owner, @PathVariable Long id){
        return this.ownerService.update(id,owner);
    }

    @PatchMapping("/{id}")
    public Owner patch(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return this.ownerService.patch(id,updates);
    }
    @DeleteMapping("/{id}")
    public void patch(@PathVariable Long id){
        this.ownerService.delete(id);
    }

}
