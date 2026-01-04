package com.douglasojeda.calllog.repository;

import com.douglasojeda.calllog.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "DELETE FROM user_contacts WHERE user_id = :id OR contact_id = :id", nativeQuery = true)
    void deleteUserContactsRows(@Param("id") Long id);
}
