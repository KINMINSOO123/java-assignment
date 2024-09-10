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
    
    public void recordTransaction() {
        // Logic to record the transaction (e.g., storing in a database)
        System.out.println("Transaction recorded: " + transactionId);
    }

    // Retrieve details of a specific transaction
    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId + "\nPayment ID: " + payment.getPaymentDetails() + "\nStatus: " + status + "\nTransaction Date: " + transactionDate;
    }

    // Update the transaction status
    public void updateTransactionStatusNType(String newStatus, String newTransactionType) {
        this.status = newStatus;
        this.transactionType = newTransactionType;
    }
    
}
