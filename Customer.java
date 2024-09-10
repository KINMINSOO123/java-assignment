/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


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
    private Payment payment;
            
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
    
    public ArrayList<Order> getOrders(){
        return this.orders;
    }
    
    public Payment getPayment(){
        return this.payment;
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
    
    public void setPayment(Payment payment){
        this.payment = payment;
    }
    public Order createOrder(Customer customer,Date orderDate,String status,ShippingDetails shippingDetails){
        Order newOrder = new Order(customer,orderDate,status,shippingDetails);
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
    
    public Cart findOrCreateCart(int option){
        if(option != 0){
            return this.carts.get(option - 1);
        }else{
            Cart newCart = new Cart(generateCartId(),this,new Date());
            this.carts.add(newCart);
            return newCart;
        }
    }
    
    public void removeCart(Cart cart){
        this.carts.remove(cart);
    }
    
    public String generateCartId(){
        String cartId = "Cart";
        int len = 3;
        boolean nonUnique;
        
        do{
            for(int i = 0; i < len; i++){
                cartId += (int)(Math.random() * 10);
            }
            
            nonUnique = false;
            
            for(Cart cart : carts){
                if(cartId.equals(cart.getCartId())){
                    nonUnique = true;
                }
            }
        }while(nonUnique);
        
        return cartId;
    }
    
    public ArrayList<Cart> getCarts(){
        return carts;
    }
    
    public int displayCart(){
        if (this.getCarts().isEmpty()) {
            System.out.println("You don't have any carts. Create a cart first.");
            return 0;
        }

        System.out.println("Select a cart number to perform :");
        for (int i = 0; i < this.getCarts().size(); i++) {
            System.out.println((i + 1) + ". Cart ID: " + this.getCarts().get(i).getCartId() + " |Cart AddedDate: " + this.getCarts().get(i).getAddedDate());
        }
        return this.getCarts().size();
    }
}
