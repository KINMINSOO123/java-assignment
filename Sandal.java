/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public class Sandal extends Product {
    private String strapMaterial;
    private boolean isWaterproof;

    public Sandal(String productId,String productName,String brand,char size,String color,double price,String description, String strapMaterial, boolean isWaterproof) {
        super(productId,productName,brand,size,color,price,description);
        this.strapMaterial = strapMaterial;
        this.isWaterproof = isWaterproof;
    }

    // Getters and setters...

    public String getStrapMaterial() {
        return strapMaterial;
    }

    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    public boolean isWaterproof() {
        return isWaterproof;
    }

    public void setWaterproof(boolean waterproof) {
        isWaterproof = waterproof;
    }

    public String productHeader(){
        return String.format("|%-15s|%-20s|%-15s|%-10s|%-10s|%-10s|%-45s|%-15s|%-12s|\n=================================================================================================================================================================="
                ,"PRODUCT ID","PRODUCT NAME","BRAND","SIZE","COLOR","PRICE(RM)","DESCRIPTION","STRAP MATERIAL","WATERPROOF?");
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("%-15s|%-12s|", strapMaterial,isWaterproof ? "Yes" : "No");
    }
}

