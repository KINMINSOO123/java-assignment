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
public class Order {
    
    private String orderId;
    private Customer customer;
    private Date orderDate;
    private String status;
    private double totalAmount;
    private ShippingDetails shippingDetails;
    private Invoice invoice;
    
    public static final String STATUS_PENDING = "Pending";
    public static final String STATUS_SHIPPED = "Shipped";
    public static final String STATUS_DELIVERED = "Delivered";
    public static final String STATUS_CANCELLED = "Cancelled";
    
    public Order(Customer customer,Date orderDate,String status,ShippingDetails shippingDetails){
        //add this to prevent the compiler confuse whether it is local or class data
        if(orderId == null || orderId.isEmpty()){
            orderId = customer.generateOrderId();
        }else{
            orderId = "";
        }
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingDetails = shippingDetails;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public String getOrderId(){
        return this.orderId;
    }
    
    public String getOrderDate(){
        return this.orderDate.toString();
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public double getTotalAmount(){
        return this.totalAmount;
    }
    
    public ShippingDetails getShippingDetails(){
        return this.shippingDetails;
    }
    
    public Invoice getInvoice(){
        return this.invoice;
    }
    
    public void setOrderDate(Date orderDate){
        this.orderDate = orderDate;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }
    
    public void setShippingDetails(ShippingDetails shippingDetails){
        this.shippingDetails = shippingDetails;
    }
    
    public void setInvoice(Invoice invoice){
        this.invoice = invoice;
    }
    public void updateOrderStatus(String newStatus) {
        // Example validation: An order can only be marked as "Delivered" if it's currently "Shipped"
        if (newStatus.equals(STATUS_DELIVERED) && !this.status.equals(STATUS_SHIPPED)) {
            System.out.println("Order " + orderId + " cannot be marked as 'Delivered' unless it is 'Shipped'.");
            return;
        }

        // Update the status
        this.status = newStatus;
        System.out.println("Order " + orderId + " status has been updated to: " + this.status);
    }
    
    public void getTotalAmountByCart(Cart cart){
        this.totalAmount = cart.calculateTotalPriceofAllItem();
    }
}
