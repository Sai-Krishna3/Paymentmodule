package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.exception.PaymentException;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins= {"http://localhost:8080", "http://localhost:4200"},allowedHeaders="*")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<String> addPayment(@RequestBody @Valid Payment payment){
		paymentService.addPayment(payment);
		return new ResponseEntity<String>("Details added Successfully",HttpStatus.OK);
	}
	@GetMapping("/allpayments")
	public ResponseEntity<List<Payment>> getAllTransactions()throws PaymentException{
		List<Payment> allPayments =paymentService.getAllTransactions();
		return new ResponseEntity<List<Payment>>(allPayments,HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentbyid/{transactionId}")
	public ResponseEntity<Payment> getTransactionById(@PathVariable ("transactionId") int transactionId)throws PaymentException{
		Payment retrievedPayment =paymentService.getTransactionById(transactionId);
		return new ResponseEntity<Payment>(retrievedPayment,HttpStatus.OK);
	}
	@DeleteMapping("/deletepayment/{transactionId}")
	public ResponseEntity<String> deleteTransaction(@PathVariable ("transactionId") int transactionId)throws PaymentException{
		paymentService.deleteTransaction(transactionId);
		return new ResponseEntity<String>("Payment deleted successfully with given id",HttpStatus.OK) ;
	}	
	
}
