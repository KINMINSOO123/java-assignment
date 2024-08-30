/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
public class Warehouse {
    
    private String warehouseId;
    private String location;
    private int capacity;
    private String managerName;
    private String contactDetails;
    
    public Warehouse(String warehouseId,String location,int capacity,String managerName,String contactDetails){
        this.warehouseId = warehouseId;
        this.location = location;
        this.capacity = capacity;
        this.managerName = managerName;
        this.contactDetails = contactDetails;
    }
    
    public String getWarehouseDetails(){
        
        return String.format("\nWarehouse Details\n%-15s|%-30s|%-10s|%-20s|%-10s\n"
                + "%-15s|%-30s|%-10d|%-20s|%-10s","Warehouse ID","Location","Capacity","Manager Name","Contact Details",
                this.warehouseId,this.location,this.capacity,this.managerName,this.contactDetails);
    }
}
