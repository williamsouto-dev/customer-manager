package com.example.customermanager.adapter.out.persistence.repository;

import com.example.customermanager.adapter.out.persistence.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}
