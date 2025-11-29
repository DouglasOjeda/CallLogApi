package com.douglasojeda.calllog.repository;

import com.douglasojeda.calllog.model.phonenumber.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {
}
