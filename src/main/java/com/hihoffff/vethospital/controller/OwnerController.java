package com.hihoffff.vethospital.controller;

import com.hihoffff.vethospital.model.Owner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @GetMapping
    public List<Owner> getAll(){return null;}

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long id){return null;}


}
