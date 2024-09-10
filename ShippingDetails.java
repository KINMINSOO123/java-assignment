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
    
    public ShippingDetails(){
        
    }
    
    public ShippingDetails(String shippingId,String shippingAddress,Date deliveryDate,int trackingNum){
        this.shippingId = shippingId;
        this.shippingAddress = shippingAddress;
        this.deliveryDate = deliveryDate;
        this.trackingNum = trackingNum;
        this.orders = new ArrayList<Order>();
    }
    
    public String getShippingAddress(){
        return this.shippingAddress;
    }
    
    public int getTrackingNum(){
        return this.trackingNum;
    }
    
    public void setShippingAddress(String shippingAddress){
        this.shippingAddress = shippingAddress;
    }
    
    public ArrayList<Order> getOrders(){
        return orders;
    }
    
    public String trackShipment(int trackingNum) {
        StringBuilder trackingInfo = new StringBuilder();

        if(this.trackingNum == trackingNum){
            trackingInfo.append("Tracking Number: ").append(trackingNum).append("\n")
                    .append("Shipping ID: ").append(shippingId).append("\n")
                    .append("Shipping Address: ").append(shippingAddress).append("\n")
                    .append("Delivery Date: ").append(deliveryDate).append("\n");
            
            for (Order order : orders) {
                trackingInfo.append("Order ID | Current Status | Total Amount(RM) | Order Date \n")
                            .append(order.getOrderId()).append(" |   ").append(order.getStatus()).append("   |     ").append(order.getTotalAmount())
                            .append("     |").append(order.getOrderDate()).append("|");
            }
        } else {
            trackingInfo.append("Tracking Number is not available.");
        }

        return trackingInfo.toString();
    }
    
    public Date getEstimatedDeliveryDate() {
        return this.deliveryDate;
    }
}
