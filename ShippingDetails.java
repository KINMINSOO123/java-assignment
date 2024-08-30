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
public class ShippingDetails {
    
    private String shippingId;
    private ArrayList<Order> orders;
    private String shippingAddress;
    private Date deliveryDate;
    private int trackingNum;
    
    public ShippingDetails(String shippingId,String shippingAddress,Date deliveryDate,int trackingNum){
        this.shippingId = shippingId;
        this.shippingAddress = shippingAddress;
        this.deliveryDate = deliveryDate;
        this.trackingNum = trackingNum;
        this.orders = new ArrayList<Order>();
    }
    
    
}
