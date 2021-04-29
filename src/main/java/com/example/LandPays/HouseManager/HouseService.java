package com.example.LandPays.HouseManager;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseService {
    private final HouseRepository houseRepository;

    public void save(House house) {
        houseRepository.save(house);
    }

    public List getAll() {
      return houseRepository.findAll();
    }

    public void UpadteRent(Long updatedRent) {
        List<House> houses = houseRepository.findAll();
        for (House H:
             houses) {
           H.setFee(updatedRent);
        }
        houseRepository.saveAll(houses);
    }
}
