package com.spring.transaction.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_rekening")
public class RekeningEntity  implements Serializable {
    @Serial
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rekId;
    @Column(name = "rekening", nullable = false)
    private Integer noRek;
    @Column(name = "name",nullable = false,unique = true)
    private String name;
    @Column(name = "saldo")
    private Double saldo;
}
