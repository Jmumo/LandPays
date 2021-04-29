package com.example.LandPays.HouseManager;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class HouseController {
    private final HouseRepository houseRepository;
    private final HouseService houseService;
    @PostMapping("/addHouse")
    public void addHouse(@RequestBody House house){
       houseService.save(house);
    }
    @GetMapping("/houses")
    public List AllHouses(){

      return houseService.getAll();
    }

    @PostMapping("/update_rent")
    public void setEntry(@RequestBody Long UpdatedRent){
        houseService.UpadteRent(UpdatedRent);
    }
}
