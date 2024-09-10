/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Payment {
    
    private String paymentId;
    private ArrayList<Order> orders;
    private Date paymentDate;
    private String paymentMethod;
    private String status;
    private Transaction transaction;
    public static final String STATUS_PENDING = "Pending";
    public static final String STATUS_COMPLETED = "Completed";
    public static final String STATUS_REFUND = "Refund";
    
    public Payment(){
        
    }
    public Payment(String paymentId,ArrayList<Order> orders,String paymentMethod,String status){
        this.paymentId = paymentId;
        this.orders = orders;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
    public String getPaymentMethod(){
        return this.paymentMethod;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public Transaction getTransaction(){
        return this.transaction;
    }
    
    public void setTransaction(Transaction transaction){
        this.transaction = transaction;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    public boolean processPayment(){
        if(this.status.equals(STATUS_PENDING)){
            this.status = STATUS_COMPLETED;
            this.paymentDate = new Date();
            System.out.println("Payment processed. Payment ID: " + this.paymentId);
            return true;
        }
        System.out.println("Payment could not be processed.");
        return false;
    }
    
    public boolean refundPayment(){
        if(this.status.equals(STATUS_COMPLETED)){
            this.status = STATUS_REFUND;
            System.out.println("Payment refunded. Payment ID: " + this.paymentId);
            return true;
        }
        System.out.println("Refund failed. Only completed payments can be refunded.");
        return false;
    }
    
    public String getPaymentDetails() {
        return "Payment ID: " + paymentId + "\nMethod: " + paymentMethod + "\nAmount: " + calcTotalAmount() + "\nStatus: " + status + 
                (paymentDate != null ? "\nPayment Date : " + paymentDate : "");
    }
    
    public double calcTotalAmount(){
        double totalAmount = 0;
        for(Order order : this.orders){
            totalAmount += order.getTotalAmount();
        }
        return totalAmount;
    }
    
}
