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

    public void transfer(Integer norek1,Integer norek2, double amount){
        RekeningEntity rekening1 = rekeningRepo.findByNoRek(norek1);
        if (rekening1 == null){
            throw new RuntimeException("Norek 1 not valid");
        }
        if (rekening1.getSaldo()<amount){
            throw new RuntimeException("saldo tidak cukup");
        }
        rekening1.setSaldo(rekening1.getSaldo()-amount);
        rekeningRepo.save(rekening1);
//        Rekening 1 atau pengirim mengecek terlebih dahulu apakkah rekening ada atau tidak jika
//        Rekening 1 ada maka proses tranfer akan berlanjut dengan mengurangi saldo rekening1

        RekeningEntity rekening2 = rekeningRepo.findByNoRek(norek2);
        if (rekening2 == null){
            throw new RuntimeException("Norek 2 not valid");
        }
        rekening2.setSaldo(rekening2.getSaldo()+amount);
//        Jika rekening 2 tidak kosong atau tidak ada maka rekening 2 akan menerima saldo dari pengirim
//        atau dari rekening 1
    }
 }
