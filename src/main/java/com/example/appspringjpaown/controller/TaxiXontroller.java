package com.example.appspringjpaown.controller;

import com.example.appspringjpaown.model.Taxi;
import com.example.appspringjpaown.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaxiXontroller {

    @Autowired
    TaxiRepository taxiRepository;

    @RequestMapping(value = "/taxi", method = RequestMethod.GET)
    public List<Taxi> getAllTaxi(){
        List<Taxi> taxiList = taxiRepository.findAll();
        return taxiList;
    }

    @RequestMapping(value = "/taxi", method = RequestMethod.POST)
    public String addTaxi(@RequestBody Taxi taxi){
        taxiRepository.save(taxi);
        return "Muvvafaqiyatli qoshildi";
    }

    @RequestMapping(value = "/taxi/{id}", method = RequestMethod.GET)
    public Taxi getOneTaxi(@PathVariable Integer id){
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);
        if (optionalTaxi.isPresent()){
            Taxi taxi = optionalTaxi.get();
            return taxi;
        }
        return new Taxi();
    }

    @RequestMapping(value = "/taxi/{id}", method = RequestMethod.DELETE)
    public String deleteTaxi(@PathVariable Integer id){
        taxiRepository.deleteById(id);
        return "Muvaffaqiyatli ochirildi";
    }

    @RequestMapping(value = "/taxi/{id}", method = RequestMethod.PUT)
    public String updateTaxi(@PathVariable Integer id, @RequestBody Taxi taxi){
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);
        if (optionalTaxi.isPresent()){
            Taxi updatingTaxi = optionalTaxi.get();
            updatingTaxi.setDriverName(taxi.getDriverName());
            updatingTaxi.setDriverPhoneNumber(taxi.getDriverPhoneNumber());
            updatingTaxi.setCarNumber(taxi.getCarNumber());
            updatingTaxi.setCar(taxi.getCar());
            taxiRepository.save(updatingTaxi);
            return "Muvvafaqiyatli o'zgartirildi";
        }
        return "BUnday mashina topilmadi";
    }
}
