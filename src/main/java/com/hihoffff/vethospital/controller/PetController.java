package com.hihoffff.vethospital.controller;



import com.hihoffff.vethospital.model.Pet;
import com.hihoffff.vethospital.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAll(){return this.petService.findAll();}

    @GetMapping("/{id}")
    public Pet getById(@PathVariable Long id){
        return this.petService.getById(id);
    }

    @PostMapping
    public Pet addNew(@RequestBody Pet pet){return
            this.petService.add(pet);
    }

    @PutMapping("/{id}")
    public Pet update(@RequestBody Pet pet, @PathVariable Long id){
        return this.petService.update(id,pet);
    }

    @PatchMapping("/{id}")
    public Pet patch(@PathVariable Long id, @RequestBody Pet updates){
        return this.petService.patch(id,updates);
    }
    @DeleteMapping("/{id}")
    public void patch(@PathVariable Long id){
        this.petService.delete(id);
    }
}
