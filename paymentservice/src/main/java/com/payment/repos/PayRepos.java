package com.payment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.Payment;

import java.util.List;

@Repository
public interface PayRepos extends JpaRepository<Payment, Integer> {
    Payment findByGuestId(String guestId);
    List<Payment> findPaymentByGuestId(String guestId);
}
