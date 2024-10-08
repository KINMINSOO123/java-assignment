/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public class RunningShoe extends Product{
    
    private double weight;
    private String soleType;

    public RunningShoe(String productId,String productName,String brand,char size,String color,double price,String description, double weight, String soleType) {
        super(productId,productName,brand,size,color,price,description);
        this.weight = weight;
        this.soleType = soleType;
    }

    // Getters and setters...

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSoleType() {
        return soleType;
    }

    public void setSoleType(String soleType) {
        this.soleType = soleType;
    }
    
    public String productHeader(){
        return String.format("|%-15s|%-20s|%-15s|%-10s|%-10s|%-10s|%-45s|%-15s|%-20s|\n=========================================================================================================================================================================="
                ,"PRODUCT ID","PRODUCT NAME","BRAND","SIZE","COLOR","PRICE(RM)","DESCRIPTION","WEIGHT","SOLE TYPE");
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("%-15f|%-20s|",weight,soleType);
    }
}
