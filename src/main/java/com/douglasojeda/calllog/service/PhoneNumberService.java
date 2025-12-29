package com.douglasojeda.calllog.service;

import com.douglasojeda.calllog.model.phonenumber.PhoneNumber;
import com.douglasojeda.calllog.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    public PhoneNumber getPhoneNumberById(int id) {
        return phoneNumberRepository.findById(id).orElse(null);
    }

    public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    public void deletePhoneNumberById(int id) {
        phoneNumberRepository.deleteById(id);
    }
}
