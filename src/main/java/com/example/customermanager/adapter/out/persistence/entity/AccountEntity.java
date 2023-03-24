package com.example.customermanager.adapter.out.persistence.entity;

import com.example.customermanager.commons.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_account", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_type", nullable = false)
    private AccountType type;

    @Column(name = "des_username", nullable = false)
    private String username;

    @Column(name = "cod_password", nullable = false)
    private String password;

    @Column(name = "des_email", nullable = false)
    private String email;

    @Column(name = "flg_active", nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idt_customer", insertable = false, updatable = false)
    private CustomerEntity customer;

    @Column(name="idt_customer")
    private Long idtCustomer;
}
