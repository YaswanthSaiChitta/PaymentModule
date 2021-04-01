package com.cp.carApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.carApps.dao.PaymentRepository;
import com.cp.carApps.entities.Payment;
import com.cp.carApps.exceptions.PaymentServiceException;

@Service("paymentser")
@Transactional
public class PaymentService implements IPaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Transactional
	public Payment addPayment(Payment payment) {
		Optional<Payment> Payment1 = paymentRepository.findById(payment.getPaymentId());
		if (Payment1.isEmpty()) {
			return paymentRepository.saveAndFlush(payment);
		} else {
			throw new PaymentServiceException("Payment already exists");
		}
		
	}
	@Override
	@Transactional
	public Payment removePayment(long id) throws PaymentServiceException {
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			throw new PaymentServiceException("paymentId does not exist to delete");
		} else {
			paymentRepository.delete(payment.get());
			return payment.get();
		}
	}

	@Transactional
	public Payment updatePayment(long id, Payment payment) {
		Optional<Payment> payment1 = paymentRepository.findById(id);
		if (payment1.isEmpty()) {
			throw new PaymentServiceException("PaymentId not found");
		} else
			paymentRepository.save(payment);
		return payment;

	}

	@Transactional
	public Payment getPaymentDetails(long id) throws PaymentServiceException {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			throw new PaymentServiceException("PaymentId does not exist");
		}
		return payment.get();
	}

	@Transactional
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		List<Payment> payment = paymentRepository.findAll();
		if (payment.isEmpty()) {
			throw new PaymentServiceException("Payments not found");
		}
		return payment;
	}

	

	
}

