package com.example.demo.entity;
import java.sql.Date;
import java.util.function.IntPredicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int transactionId;
	@Column(name = "Trans_date")
	@JsonFormat(pattern ="yyyy-MM-DD")
	@NotNull(message="Invalid Date")
	private Date transactionDate;
	@Min(0) 
	private double amountPaid;
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Payment (int transactionId,
			Date transactionDate,
			 double amountPaid) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.amountPaid = amountPaid;
	}



	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public double getAmountPaid() {
		return amountPaid;
	}



	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
	
}
