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
public class StockAdjustment extends Inventory{
    private String adjustmentId;
    private int quantityAdjusted;
    private String reason;
    private Date adjustmentDate;
    
    public StockAdjustment(String inventoryId,int quantityAvailable, Warehouse warehouse, String reorderLevel, Date lastUpdated, String adjustmentId, int quantityAdjusted, String reason, Date adjustmentDate){
        super(inventoryId,quantityAvailable,warehouse,reorderLevel,lastUpdated);
        this.adjustmentId = adjustmentId;
        this.quantityAdjusted = quantityAdjusted;
        this.reason = reason;
        this.adjustmentDate = adjustmentDate;
    }
}


