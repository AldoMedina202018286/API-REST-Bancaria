package com.upc.edu.E03.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder

@NoArgsConstructor

@AllArgsConstructor

@Entity

@Table(name = "accounts")

public class Account {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nameCustomer ", length = 30, nullable = false)

    private String nameCustomer ;

    @Column(name = "numberAccount ", length = 13, nullable = false)

    private String numberAccount ;

}
