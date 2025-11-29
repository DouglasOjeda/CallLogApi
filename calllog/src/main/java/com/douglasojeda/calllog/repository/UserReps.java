package com.douglasojeda.calllog.repository;

import com.douglasojeda.calllog.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReps extends JpaRepository<User, Integer> {
}
