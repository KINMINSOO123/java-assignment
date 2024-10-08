/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public abstract class Product {
    
    private String productId;
    private String productName;
    private String brand;
    private char size;
    private String color;
    private double price;
    private String description;
    
    public Product(String productId,String productName,String brand,char size,String color,double price,String description){
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.price = price;
        this.description = description;
    }
    
    public String getProductID(){
        return this.productId;
    }
    
    public String getProductName(){
        return this.productName;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public abstract String productHeader();
            
    public String toString(){
        return String.format("|%-15s|%-20s|%-15s|%-10c|%-10s|%-10.2f|%-45s|",
                this.productId,this.productName,this.brand,this.size,this.color,this.price,this.description);
    }
    
}
