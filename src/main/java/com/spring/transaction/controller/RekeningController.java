package com.spring.transaction.controller;

import com.spring.transaction.dto.TransferRequest;
import com.spring.transaction.model.entity.RekeningEntity;
import com.spring.transaction.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rekening")
public class RekeningController {
    @Autowired
    private RekeningService rekeningService;
    @PostMapping("/create")
    public ResponseEntity<RekeningEntity> create(@RequestBody RekeningEntity rekening){
        rekeningService.create(rekening);
        return ResponseEntity.ok(rekening);
    }
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transfer){
        rekeningService.transfer(transfer.getNorek1(),transfer.getNorek2(),transfer.getAmount());
    }
}
