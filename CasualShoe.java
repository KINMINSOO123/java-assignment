/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public class CasualShoe extends Product {
    private String occasion;
    private boolean isSlipOn;

    public CasualShoe(String productId,String productName,String brand,char size,String color,double price,String description, String occasion, boolean isSlipOn) {
        super(productId,productName,brand,size,color,price,description);
        this.occasion = occasion;
        this.isSlipOn = isSlipOn;
    }

    // Getters and setters...

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public boolean isSlipOn() {
        return isSlipOn;
    }

    public void setSlipOn(boolean slipOn) {
        isSlipOn = slipOn;
    }

    public String productHeader(){
        return String.format("|%-15s|%-20s|%-15s|%-10s|%-10s|%-10s|%-45s|%-20s|%-10s|\n====================================================================================================================================================================="
                ,"PRODUCT ID","PRODUCT NAME","BRAND","SIZE","COLOR","PRICE(RM)","DESCRIPTION","OCCASION","SLIP ON?");
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("%-20s|%-10s|",occasion,isSlipOn ? "Yes" : "No");       
    }
}
