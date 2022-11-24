package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;



import com.example.demo.entity.Payment;
import com.example.demo.exception.PaymentException;

import com.example.demo.repository.PaymentRepository;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;






import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;





//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
    @Mock
    PaymentRepository repo;
    
    @Mock
    PaymentService service;
    
   
    Date date = StringToDate( "2022-11-04 05:30:00");
    private Date StringToDate(String string) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Test
    public void testaddPayment() {
        Payment payment=new Payment(5,date,15000);
        repo.save(payment);
        assertThat(payment.getTransactionId()).isEqualTo(5);
    }
    @Test
    public void testgetAllTransactions() throws PaymentException {    
        
        List<Payment> list = new ArrayList<Payment>();
        Payment payment = new Payment(4,date,15000);
        list.add(payment);
        when(service.getAllTransactions()).thenReturn(list);
        List<Payment> paymentList = service.getAllTransactions();



       assertEquals(1, paymentList.size());
        verify(service, times(1)).getAllTransactions();
    }
    @Test
    public void testgetTransactionById() throws  PaymentException{



       when(service.getTransactionById(4)).thenReturn(new Payment(4,date,15000));
        Payment payment = service.getTransactionById(4);
        assertEquals(date, payment.getTransactionDate());



   }
    
    
//    @Test
//    public void testUpdateEvent() {
//
//        Event event = repo.findById(13).get();       
//        event.setCapacity(200);       
//        Event updatedevent = repo.save(event);  
//        assertThat(updatedevent.getEventCost()).isEqualTo(200);
//    }
    
    
    @Test
    public void testdeleteTransaction() {
        repo.deleteById(14);
        assertThat(repo.existsById(14)).isFalse();
    }
//    
//    

//    @Test
//    public void testdeleteTransaction() {
//        repo.deleteTrasanctionById(14);
//        assertThat(repo.existsdeleteTrasanctionById(14)).isFalse();
//    }


}