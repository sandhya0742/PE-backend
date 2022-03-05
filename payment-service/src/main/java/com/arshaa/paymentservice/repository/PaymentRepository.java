package com.arshaa.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arshaa.paymentservice.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByGuestId(int guestId);
}
