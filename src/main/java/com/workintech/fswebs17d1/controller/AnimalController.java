package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AnimalController {
    Map<Integer , Animal> animals;

    public AnimalController() {
        animals=new HashMap<>();
    }

    @GetMapping("/workintech/animal")
    public List getAnimal(){
        List<Animal> listOfAnimals = new ArrayList<>();
        Set<Integer> keys = animals.keySet();
        for(Integer key : keys){
            listOfAnimals.add(animals.get(key));
        }

        return listOfAnimals;
    }



    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalWithId(@PathVariable int id){
       return animals.get(id);
    }




    @PostMapping("/workintech/animal/{id}")
    public void setNameOfAnimal(@PathVariable int id , @RequestBody String name) {
        if(animals.containsKey(id)){
           animals.get(id).setName(name);
        }

    }

    @DeleteMapping("/workintech/animal/{id}")
    public void deleteAnimal(@PathVariable int id){
        animals.remove(id);

    }


     @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestBody Animal newAnimal){
        animals.put(newAnimal.getId() , newAnimal);
        return newAnimal;
     }


     @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(@PathVariable int id , Animal animal){
        animals.put(id , animal);
        return animal;
     }







}
