package com.pes.centro_distribuicao_ms.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CD")
public class CentroDistribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private String phone;
    private String email;
    

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Address address;
}
