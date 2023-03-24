package com.example.customermanager.adapter.out.persistence.entity;

import com.example.customermanager.commons.annotation.Exclude;
import com.example.customermanager.commons.enums.CustomerStatus;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer", schema = "public")
public class CustomerEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "idt_customer", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "des_name", nullable = false)
    private String name;

    @Column(name = "des_fullname", nullable = false)
    private String fullName;

    @Column(name = "des_genre", nullable = false)
    private String genre;

    @Column(name = "dat_birth", nullable = false)
    private LocalDateTime dateBirth;

    @Column(name = "des_educational_level", nullable = false)
    private String educationalLevel;

    @Column(name = "des_mother_name", nullable = false)
    private String motherName;

    @Column(name = "des_phone", nullable = false)
    private String phone;

    @Column(name = "document", nullable = false)
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_status", nullable = false)
    private CustomerStatus status;

    @Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idt_address")
    private AddressEntity address;
}
