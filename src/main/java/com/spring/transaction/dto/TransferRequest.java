package com.spring.transaction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {

    private Integer norek1;
    private Integer norek2;
    private Double amount;
}
