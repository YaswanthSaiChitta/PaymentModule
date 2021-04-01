package com.cp.carApps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.carApps.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
