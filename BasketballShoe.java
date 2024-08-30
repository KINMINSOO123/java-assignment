/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public class BasketballShoe extends Product{
    private String ankleSupport;
    private boolean isHighTop;

    public BasketballShoe(String productId,String productName,String brand,char size,String color,double price,String description, String ankleSupport, boolean isHighTop) {
        super(productId,productName,brand,size,color,price,description);
        this.ankleSupport = ankleSupport;
        this.isHighTop = isHighTop;
    }

    // Getters and setters...

    public String getAnkleSupport() {
        return ankleSupport;
    }

    public void setAnkleSupport(String ankleSupport) {
        this.ankleSupport = ankleSupport;
    }

    public boolean isHighTop() {
        return isHighTop;
    }

    public void setHighTop(boolean highTop) {
        isHighTop = highTop;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-15s|%-15s|\n",ankleSupport,isHighTop ? "Yes" : "No");
    }
}