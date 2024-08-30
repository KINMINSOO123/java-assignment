/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public class DressShoe extends Product{
    private String material;
    private String heelType;

    public DressShoe(String productId,String productName,String brand,char size,String color,double price,String description, String material, String heelType) {
        super(productId,productName,brand,size,color,price,description);
        this.material = material;
        this.heelType = heelType;
    }

    // Getters and setters...

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getHeelType() {
        return heelType;
    }

    public void setHeelType(String heelType) {
        this.heelType = heelType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s|%-10s|\n",this.material,this.heelType);
    }

}
