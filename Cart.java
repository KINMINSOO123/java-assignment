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
    private ArrayList<CartItem> cartItems;
    private Date addedDate;
    
    //default value
    public Cart(String cartId,Customer customer,Date addedDate){
        this.cartId = cartId;
        this.customer = customer;
        this.addedDate = addedDate;
        this.cartItems = new ArrayList<CartItem>();
    }
    
    public String getCartId(){
        return this.cartId;
    }
    
    public int getCartItemsSize(){
        return cartItems.size();
    }
    
    public String getAddedDate(){
        return this.addedDate.toString();
    }
    
    public void addProduct(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Updated quantity of " + product.getProductName() + " to " + item.getQuantity());
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
        System.out.println("Added " + quantity + " of " + product.getProductName() + " to cart " + this.getCartId() + ".");
    }
    
    public void updateItemQuantity(Product product, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(newQuantity);
                System.out.println("Updated " + product.getProductName() + " quantity to " + newQuantity);
                return;
            }
        }
        System.out.println("Product " + product.getProductName() + " not found in the cart " + this.getCartId() + ".");
    }
    
    public void clearCart() {
        this.cartItems.clear();
        System.out.println("Cart has been cleared.");
    }
    
    public void removeProduct(Product product){
        CartItem itemToRemove = null;
        
        for(CartItem item : cartItems){
            if(item.getProduct().equals(product)){
                itemToRemove = item;
                break;
            }
        }
        
        if(itemToRemove != null){
            cartItems.remove(itemToRemove);
            System.out.println("Product " + product.getProductName() + " removed from cart " + this.getCartId() + ".");
        }
    }
    
    public void viewCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (CartItem item : cartItems) {
                System.out.println(item.getProduct().getProductName() + " - Quantity: " + item.getQuantity() + " - Total Price: RM" + item.getQuantity() * item.getProduct().getPrice());
            }
            System.out.println("Total Price of All Item : " + calculateTotalPriceofAllItem());
        }
    }
    
    public double calculateTotalPriceofAllItem(){
        double totalPrice = 0;
        for(CartItem item : cartItems){
            totalPrice += item.getQuantity() * item.getProduct().getPrice();
        }
        return totalPrice;
    }
}
