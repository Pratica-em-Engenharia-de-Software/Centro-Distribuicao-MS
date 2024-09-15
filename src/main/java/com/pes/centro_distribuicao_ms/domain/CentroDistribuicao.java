package com.pes.centro_distribuicao_ms.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CD")
public class CentroDistribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String phone;
    private String email;
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Address address;
}
