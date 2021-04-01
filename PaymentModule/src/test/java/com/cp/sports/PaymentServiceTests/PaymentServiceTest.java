package com.cp.sports.PaymentServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.carApps.dao.PaymentRepository;
import com.cp.carApps.entities.Payment;
import com.cp.carApps.services.PaymentService;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	private PaymentService paymentService;
	static ArrayList<Payment> list = new ArrayList<>();

	@Test
	public void addPaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(3, "debit", "paid", 3, "harish", "124", expiryDate, 123);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

	}

	@Test
	public void removePaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(4, "debit", "paid", 4, "saran", "124", expiryDate, 132);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		assertEquals(payment1.toString(), paymentService.removePayment(4).toString());

	}

	@Test
	public void getPaymentDetailsTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(5, "debit", "paid", 5, "sairam", "124", expiryDate, 145);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

		assertEquals(payment1.toString(), paymentService.getPaymentDetails(5).toString());
	}

	@Test
	public void updatePaymentTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(6, "debit", "paid", 6, "dinesh", "124", expiryDate, 456);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		expiryDate = LocalDate.parse("2025-07-01");
		Payment payment2 = new Payment(6, "debit", "paid", 7, "pavan", "124", expiryDate, 678);
		list.add(payment2);
		assertEquals(payment2.toString(), paymentService.updatePayment(6, payment2).toString());
	}

	@Test
	void getAllPaymentDetailsTest() {
		LocalDate expiryDate = LocalDate.parse("2025-07-01");
		Payment payment1 = new Payment(8, "debit", "paid", 8, "raghu", "124", expiryDate, 987);
		assertEquals(payment1.toString(), paymentService.addPayment(payment1).toString());
		list.add(payment1);

		assertEquals(list.toString(), paymentService.getAllPaymentDetails().toString());
	}

}
