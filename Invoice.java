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
public class Invoice {
    
    private String invoiceId;
    private Order order;
    private Date invoiceDate;
    private double totalAmount;
    private Date dueDate;
    private boolean isPaid;

    public Invoice(){
        
    }
    public Invoice(String invoiceId, Order order, Date invoiceDate, double totalAmount) {
        this.invoiceId = invoiceId;
        this.order = order;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.isPaid = false;
    }

    // Generate an invoice for an order
    public String generateInvoice() {
        return "Invoice ID: " + invoiceId + "\nOrder ID: " + order.getOrderId() + "\nAmount: " + totalAmount;
    }

    // Retrieve details of a specific invoice
    public String getInvoiceDetails() {
        return "Invoice ID: " + invoiceId + "\nOrder ID: " + order.getOrderId() + "\nAmount: " + totalAmount + "\nPaid: " + (isPaid ? "Yes" : "No") + "\nInvoice Date: " + invoiceDate;
    }

    // Send the invoice to the customer
    public void sendInvoiceToCustomer(Customer customer) {
        // Logic to send the invoice (e.g., email or print)
        System.out.println("Invoice sent to: " + customer.getEmail());
    }

    // Mark the invoice as paid
    public void markInvoiceAsPaid() {
        this.isPaid = true;
    }

}
