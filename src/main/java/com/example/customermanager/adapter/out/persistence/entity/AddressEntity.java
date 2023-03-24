package com.example.customermanager.adapter.out.persistence.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_address", nullable = false)
    private Long id;

    @Column(name = "des_street", nullable = false)
    private String street;

    @Column(name = "NUM_HOUSE", nullable = false)
    private Integer number;

    @Column(name = "des_district", nullable = false)
    private String district;

    @Column(name = "des_city", nullable = false)
    private String city;

    @Column(name = "des_state", nullable = false)
    private String state;
}
