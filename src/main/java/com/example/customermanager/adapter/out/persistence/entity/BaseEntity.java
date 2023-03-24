package com.example.customermanager.adapter.out.persistence.entity;

import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Column(name = "dat_create", nullable = false)
    private LocalDateTime datCreate;

    @Column(name = "dat_update")
    private LocalDateTime datUpdate;

    @PrePersist
    private void setDatCreate() {
        this.datCreate = LocalDateTime.now();
    }

    @PreUpdate
    private void setDatUpdate() {
        this.datUpdate = LocalDateTime.now();
    }
}
