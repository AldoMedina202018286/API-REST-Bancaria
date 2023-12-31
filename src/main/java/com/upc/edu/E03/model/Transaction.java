package com.upc.edu.E03.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "createDate",nullable = false)
    private LocalDate createDate;
    @Column(name = "amount",nullable = false)
    private Double amount;
    @Column(name = "balance",nullable = false)
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false,
            foreignKey = @ForeignKey(name = "FK_transactions_accounts"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Account account;
}
