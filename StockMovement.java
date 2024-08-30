/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class StockMovement extends Inventory{
    private String movementId;
    private String fromWarehouseId;
    private String toWarehouseId;
    private int quantityMoved;
    private Date movementDate;
    
    public StockMovement(String inventoryId,int quantityAvailable, Warehouse warehouse, String reorderLevel, Date lastUpdated, String movementId, String fromWarehouseId, String toWarehouseId, int quantityMoved, Date movementDate){
        super(inventoryId,quantityAvailable,warehouse,reorderLevel,lastUpdated);
        this.movementId = movementId;
        this.fromWarehouseId = fromWarehouseId;
        this.toWarehouseId = toWarehouseId;
        this.quantityMoved = quantityMoved;
        this.movementDate = movementDate;
    }
}
