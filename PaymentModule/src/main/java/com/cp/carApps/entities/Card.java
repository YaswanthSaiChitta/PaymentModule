package com.cp.carApps.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	@Id
	private Long id;
	@Column(name = "card_name")
	private String cardName;
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "card_expiry")
	private LocalDate cardExpiry;
	/*
	 * @Column(name = "bank_name") private String bankName;
	 */
	@Column(name = "cvv")
	private int cvv;

	public Card() {
		super();
	}

	public Card(Long id, String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate=" + cardExpiry
				+ ", cvv=" + cvv + "]";
	}

}
