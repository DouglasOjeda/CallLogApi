package com.douglasojeda.calllog.controller;

import com.douglasojeda.calllog.model.phonenumber.PhoneNumber;
import com.douglasojeda.calllog.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    @Autowired
    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @GetMapping("/phone_numbers")
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumberService.getAllPhoneNumbers();
    }

    @GetMapping("/phone_numbers/{id}")
    public PhoneNumber getPhoneNumber(@PathVariable int id) {
        return phoneNumberService.getPhoneNumberById(id);
    }

    @PostMapping("/phone_numbers")
    public PhoneNumber addPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
        return phoneNumberService.addPhoneNumber(phoneNumber);
    }

    @PutMapping("/phone_numbers")
    public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber phoneNumber) {
        return phoneNumberService.updatePhoneNumber(phoneNumber);
    }

    @DeleteMapping("/Phone_numbers/{id}")
    public void deletePhoneNumber(@PathVariable int id) {
        phoneNumberService.deletePhoneNumberById(id);
    }

}
