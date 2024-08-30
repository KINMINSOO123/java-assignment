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
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private int loyaltyPoints;
    private ArrayList<Cart> carts;
    private ArrayList<Order> orders;
            
    public Customer(){
        this("","","","",null,"");      
    }
    
    public Customer(String name,String email,String phone,String address,CustomerManager customerManager,String password){
        
        if (this.customerId == null || this.customerId.isEmpty()) {
            this.customerId = customerManager.generateCustomerId();
        }else{
            this.customerId = "";
        }
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.loyaltyPoints = 0;
        this.password = password;
        this.carts = new ArrayList<Cart>();
        this.orders = new ArrayList<Order>();
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getCustomerId(){
        return this.customerId;
    }
    
    public int getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setLoyaltyPoints(int loyaltyPoints){
        this.loyaltyPoints = loyaltyPoints;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public Order createOrder(Customer customer,Date orderDate,String status,ShippingDetails shippingDetails){
        Order newOrder = new Order("",customer,orderDate,status,shippingDetails);
        this.orders.add(newOrder);
        return newOrder;
    }
    
    public String generateOrderId(){
        String orderId = "Ord";
        int len = 5;
        boolean nonUnique;
        
        do{
            for(int i = 0; i < len; i++){
                orderId += (int)(Math.random() * 10);
            }
                nonUnique = false;
            for(Order order : this.orders){
                if(order.getOrderId().equals(orderId)){
                    nonUnique = true;
                }
            }
        }while(nonUnique);
        return orderId;
    }
    
    public void cancelOrder(Order order,Boolean valid){
        if(valid){
            this.orders.remove(order);
        }
    }
    
    public String getOrderDetails(){
        String orderDetails = "";
        for(Order order : orders){
        orderDetails += String.format("\n-10%s|-10%s|-10%s|-8%d",order.getOrderId(),order.getOrderDate(),order.getStatus(),order.getTotalAmount());
        }
        
        return orderDetails;
    }
    
    //allow a customer to add many product into a cart
    public void addItemToCart(Product product){
        
    }
}
