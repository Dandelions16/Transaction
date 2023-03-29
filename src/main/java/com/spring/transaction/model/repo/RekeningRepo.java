package com.spring.transaction.model.repo;

import com.spring.transaction.model.entity.RekeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepo extends JpaRepository<RekeningEntity,Long> {

    public RekeningEntity findByNoRek(Integer norek);
}
