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
public class Inventory {
    
    private String inventoryId;
    private ArrayList<Product> products;
    private int quantityAvailable;
    private Warehouse warehouseLocation;
    private String reorderLevel;
    private Date lastUpdated;
    
    public Inventory(String inventoryId,int quantityAvailable, Warehouse warehouse, String reorderLevel, Date lastUpdated){
        this.inventoryId = inventoryId;
        this.quantityAvailable = quantityAvailable;
        this.reorderLevel = reorderLevel;
        this.lastUpdated = lastUpdated;
    }
    
    public void addProduct(Product product){
        this.products.add(product);
        System.out.println("Product " + product.getProductName() + " added to inventory.");
        this.lastUpdated = new Date();
    }
}
