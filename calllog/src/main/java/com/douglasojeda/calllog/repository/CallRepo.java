package com.douglasojeda.calllog.repository;

import com.douglasojeda.calllog.model.call.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepo extends JpaRepository<Call, Integer> {
}
