/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;


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
    private int loyaltyPoints;
    
    public Customer(){
        this("","","","",null);      
    }
    
    public Customer(String name,String email,String phone,String address,CustomerManager customerManager){
        
        if(this.customerId != null){
            this.customerId = customerManager.generateCustomerId();
        }else{
            this.customerId = "";
        }
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.loyaltyPoints = 0;
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
}
