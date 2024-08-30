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
public class Cart {
    
    private String cartId;
    private Customer customer;
    private ArrayList<Product> products;
    private int quantity;
    private Date addedDate;
    
    //default value
    public Cart(String cartId,Customer customer,int quantity,Date addedDate){
        this.cartId = cartId;
        this.customer = customer;
        this.quantity = quantity;
        this.addedDate = addedDate;
        this.products = new ArrayList<Product>();
    }
    
    
}
