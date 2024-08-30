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
public class InventoryAudit {
    
    private String auditId;
    private Inventory inventory;
    private Date auditDate;
    private String auditorName;
    private String discrepancies;
    
    public InventoryAudit(String auditId,Inventory inventory, Date auditDate, String auditorName, String discrepancies){
        
        this.auditId = auditId;
        this.inventory = inventory;
        this.auditDate = auditDate;
        this.auditorName = auditorName;
        this.discrepancies = discrepancies;
    }
}
