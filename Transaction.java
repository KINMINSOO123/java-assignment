/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Transaction {
    
    private String transactionId;
    private Payment payment;
    private Date transactionDate;
    private String transactionType;
    private String status;
    
    public Transaction(String transactionId,Payment payment,Date transactionDate,String transactionType,String status){
        this.transactionId = transactionId;
        this.payment = payment;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.status = status;
    }
}
