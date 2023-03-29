package com.spring.transaction.service;

import com.spring.transaction.model.entity.RekeningEntity;
import com.spring.transaction.model.repo.RekeningRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RekeningService {
    @Autowired
    private RekeningRepo rekeningRepo;

    public void create(RekeningEntity rekeningEntity){
        rekeningRepo.save(rekeningEntity);
    }

    public Iterable<RekeningEntity> findAll(){
        return rekeningRepo.findAll();
    }

    private void transfer(Integer norek1,Integer norek2, double amount){
        RekeningEntity rekening1 = rekeningRepo.findByNoRek(norek1);
        if (rekening1 == null){
            throw new RuntimeException("Norek 1 not valid");
        }
        if (rekening1.getSaldo()<amount){
            throw new RuntimeException("saldo tidak cukup");
        }
        rekening1.setSaldo(rekening1.getSaldo()-amount);
        rekeningRepo.save(rekening1);

        RekeningEntity rekening2 = rekeningRepo.findByNoRek(norek2);
        if (rekening2 == null){
            throw new RuntimeException("Norek 2 not valid");
        }
        rekening2.setSaldo(rekening2.getSaldo()+amount);
    }
 }
