package com.payment.service;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.model.Payment;
import com.payment.repos.PayRepos;

@Service
public class PaymentImplement implements PaymentService {

	// Autowiring the Payment Repository extending JPA Repository .
	@Autowired
	private PayRepos repo;

	Logger log = LoggerFactory.getLogger(PaymentImplement.class);

//1.Method to fetching the List<>  payment details .	
	@Override
	public List<Payment> getPayment() {
		return repo.findAll();
	}

//2.Method to fetch payment details of one Particular Guest By PaymentId .
	@Override
	public Payment getPaymentById(int paymentId) {
		// TODO Auto-generated method stub

		return repo.findById(paymentId).orElse(null);
	}

//3.Method to Updating data of payment history by manager .
	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		Payment pay = repo.findById(payment.getPaymentId()).orElse(null);
		pay.setAmountPaid(payment.getAmountPaid());
		// pay.setDefaultRent(payment.getDefaultRent());
		pay.setDueAmount(payment.getDueAmount());
		pay.setDefaultRent(payment.getDefaultRent());

		pay.setPaymentMethod(payment.getPaymentMethod());
		pay.setSecurityDeposit(payment.getSecurityDeposit());
		pay.setNewDuesAmount(payment.getNewDuesAmount());
		return repo.save(pay);
	}

//4.Method to Call at the time when user is OnBoarding .
	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		Payment payments = new Payment();

		payments.setTransactionId(UUID.randomUUID().toString());
		double securityDeposit = payment.getSecurityDeposit();
		payments.setSecurityDeposit(securityDeposit);
		// double defaultRent = payment.getDefaultRent();
		// payments.setDefaultRent(defaultRent);
		double dueAmount = payment.getDueAmount();
		payments.setDueAmount(dueAmount);
		boolean onBoard = payment.isOnBoard();
		payments.setOnBoard(onBoard);
		double amountPaid = payment.getAmountPaid();
		payments.setAmountPaid(amountPaid);

		double currentRent = payment.getCurrentRent();
		payments.setCurrentRent(currentRent);
		double defaultRent = payment.getDefaultRent();
		payments.setDefaultRent(defaultRent);

		int remainder = payment.getRemainder();
		payments.setRemainder(remainder);

		double newDuesAmount = payment.getNewDuesAmount();
		payments.setNewDuesAmount(newDuesAmount);
		double count = securityDeposit + defaultRent;
		
		/* 1.first dueAmount will be calculated as   dueAmount = count = securityDeposit + roomRent;
		 * If remainder days is less than 30 and greater than 1 then dueAmount will store as :dueAmount =(roomRent / 30) *remainder;
		 */
		if (remainder < 30 && remainder > 1) {

			dueAmount = (defaultRent / 30) * remainder;
			dueAmount = count + dueAmount;
		} else if (remainder == 30) {
			dueAmount = securityDeposit + defaultRent;
		}
		/*
		 * If guest will onboard then a new dues amount will be calcualated as follows .
		 */
		if (onBoard == true) {
			payment.setDueAmount(dueAmount);
			newDuesAmount = dueAmount - amountPaid;
			payment.setNewDuesAmount(newDuesAmount);
		}
		repo.save(payment);
		return payment;
	}

//5.Fetching Payment Details By  Particular GuestId
	@Override
	public List<Payment> getPaymentByGuestId(String guestId) {
		// TODO Auto-generated method stub
		return repo.findAll();

	}

//6.Getting the dues Of particular Guest based on their id .
	@Override
	public double getDueAmountByGuestId(String guestId) {
		// TODO Auto-generated method stub
		return 0;
	}

//7.Posting the data of Guest After onBOarding .
	@Override
	public Payment addPaymentAfterOnBoar(Payment payment) {
		// Creating object of class Payment(Model).
		Payment payments = new Payment();
		// double dueAmount = payment.getDueAmount();
		// payments.setDueAmount(dueAmount);
		boolean onBoard = payment.isOnBoard();
		payments.setOnBoard(onBoard);
		double amountPaid = payment.getAmountPaid();
		payments.setAmountPaid(amountPaid);
		double currentRent = payment.getCurrentRent();
		payments.setCurrentRent(currentRent);
		double newDuesAmount = payment.getNewDuesAmount();
		payments.setNewDuesAmount(newDuesAmount);
		double defaultRent = payment.getDefaultRent();
		payments.setDefaultRent(defaultRent);
		// amountPaid = defaultRent + newDuesAmount;

		// currentRent = defaultRent + newDuesAmount ;
		if (onBoard == true && amountPaid == currentRent) {

			currentRent = defaultRent + newDuesAmount;
			payment.setCurrentRent(currentRent);
		} else if (onBoard == true && amountPaid != currentRent) {

			currentRent = defaultRent + newDuesAmount;
			newDuesAmount = currentRent - amountPaid;
		}

		repo.save(payment);
		return payment;
	}

}
