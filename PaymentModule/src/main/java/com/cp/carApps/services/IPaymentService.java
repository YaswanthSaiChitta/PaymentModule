package com.cp.carApps.services;

import java.util.List;

import com.cp.carApps.entities.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);

	public Payment removePayment(long id);

	public Payment updatePayment(long id, Payment payment);

	public Payment getPaymentDetails(long id);

	public List<Payment> getAllPaymentDetails();
}
