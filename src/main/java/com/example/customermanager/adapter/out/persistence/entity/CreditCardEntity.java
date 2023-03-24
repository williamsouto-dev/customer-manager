package com.example.customermanager.adapter.out.persistence.entity;

import com.example.customermanager.commons.annotation.Exclude;
import com.example.customermanager.commons.enums.CreditCardStatus;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_card", schema = "public")
public class CreditCardEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "idt_credit_card", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Exclude
    @ManyToOne
    @JoinColumn(name = "idt_customer", nullable = false)
    private CustomerEntity customer;

    @Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idt_account", nullable = false)
    private AccountEntity account;

    @Column(name = "des_printed_name", nullable = false)
    private String printedName;

    @Column(name = "num_limit_card", nullable = false)
    private BigDecimal limit;

    @Column(name = "num_credit_card", nullable = false)
    private String number;

    @Column(name = "num_cvv", nullable = false)
    private String cvv;

    @Column(name = "dat_expiration", nullable = false)
    private LocalDateTime expiration;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_status", nullable = false)
    private CreditCardStatus status;
}
