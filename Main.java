/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoes;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
  
    public static void main(String[] args) {
        
        int option;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Shoes Inventory system");
            System.out.println("1. Shoes Inventory Manager");
            System.out.println("2. Customer ");
            System.out.println("3. Vendor");
            System.out.println("0. Exit");
            System.out.print("Enter the option > ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: 
                    Main.inventoryManager(sc);
                    break;
                case 2: 
                    Main.customer(sc);
                    break;
                case 3:
                    Main.vendor(sc);
                    break;
                case 0:
                    System.out.println("Exiting the program. Bye Bye");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        }while(option != 0);
    }
    
    public static void inventoryManager(Scanner sc){
        Warehouse w = new Warehouse("333","rere",32,"dfifd","kfdj");
        System.out.println(w.getWarehouseDetails());
    }
    
    public static void customer(Scanner sc){
        int option;
        CustomerManager customerManager = new CustomerManager();
        do{
            System.out.println("Welcome to the Boo Shoes Shop");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("0.Exit");
            System.out.print("Enter your choice > ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: Main.customerLogin(sc,customerManager);
                    break;
                case 2: Main.customerRegister(sc,customerManager);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid number. Please try again...");
            }
        }while(option != 0);
        
    }
    
    public static void customerLogin(Scanner sc,CustomerManager customerManager){
        String email;
        String password;
        Customer customer;
        final int maxAttempts = 5;
        int attempt = 0;
        do{
            System.out.println("Welcome to Customer Login");
            System.out.print("Enter your Email > ");
            email = sc.nextLine();
            System.out.print("Enter your Password > ");
            password = sc.nextLine();
            customer = customerManager.CheckLoginValid(email, password);
            
            if(customer != null){
                Main.customerDisplayMenu(sc,customer,customerManager);
                return;
            }else{
                attempt++;
                System.out.println("Invalid email or password. Attempt " + attempt + " of " + maxAttempts);
            }
        }while(attempt < maxAttempts);
        
        
        
        // If maximum attempts are reached, jump to register function
        System.out.println("Maximum login attempts reached. Please register.");
        Main.customerRegister(sc, customerManager);  // Jump to the registration function
    }
    
    public static void customerRegister(Scanner sc,CustomerManager customerManager){
        Customer customer;
        String name;
        String email;
        String phone;
        String address;
        String password;
        String conPassword;
        boolean valid;
        do{
            System.out.println("Welcome to Customer Register");
            System.out.println("Please enter the following information");
            do{
                System.out.print("Enter your Name > ");
                name = sc.nextLine();
                valid = customerManager.checkNameisValid(name);
            }while(!valid);
            do{
                System.out.print("Enter your Email > ");
                email = sc.nextLine();
                valid = customerManager.checkEmailisValid(email);
            }while(!valid);
            do{
                System.out.print("Enter your Phone Number > ");
                phone = sc.nextLine();
                valid = customerManager.checkPhoneisValid(phone);
            }while(!valid);
            do{
                System.out.print("Enter your Address > ");
                address = sc.nextLine();
                valid = customerManager.checkAddressisValid(address);
            }while(!valid);
            do{
                System.out.print("Enter your Password > ");
                password = sc.nextLine();
                valid = customerManager.checkPasswordisValid(password);
            }while(!valid);
            do{
            System.out.print("Enter your Confirm Password > ");
            conPassword = sc.nextLine();
                if(!(conPassword.equals(password))){
                    System.out.println("Confirm Password didn't match to the Password...");
                }
            }while(!(conPassword.equals(password)));
            customer = customerManager.registerCustomer(name, email, phone, address, password);
        }while(customer == null);
        
        Main.customerDisplayMenu(sc,customer,customerManager);
    }
    
    public static void customerDisplayMenu(Scanner sc,Customer customer,CustomerManager customerManager){
        int option;
        
        do{
            System.out.println("Welcome " + customer.getName() + "to Boo's Shoes Shop");
            System.out.println("1. Shoes Shopping");
            System.out.println("2. Customer personal details");
            System.out.println("3. Payment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice > ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: Main.shoesShopping(sc,customer,customerManager);
                break;
                case 2: Main.customerPersonalInformation();
                break;
                case 3: Main.payment(sc,customer);
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please Try again...");
                    break;
            }
        }while(option != 0);   
    }
    
    public static void shoesShopping(Scanner sc, Customer customer, CustomerManager customerManager){
        
        ProductManager productManager = new ProductManager();
        System.out.println("Welcome to shoes shopping!");
        System.out.println("Here are our products details");
        
        int option;
        do{
            productManager.displayProducts();
            System.out.println("1.View Cart");
            System.out.println("2.Add New Cart");
            System.out.println("3.Remove a Cart");
            System.out.println("4.Add Item into a Cart");
            System.out.println("5.Modify Item From a Cart");
            System.out.println("6.Remove Item From a Cart");
            System.out.println("7.Place Order");
            System.out.println("8.Track Order");
            System.out.println("0.Exit");
            System.out.print("Enter your choice > ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: Main.viewCart(sc,customer);
                break;
                case 2: Main.addNewCart(sc,customer);
                break;
                case 3: Main.removeCart(sc,customer);
                break;
                case 4: Main.addItemtoCart(sc,customer,productManager);
                break;
                case 5: Main.modifyItemFromCart(sc,customer,productManager);
                break;
                case 6: Main.removeItemFromCart(sc,customer,productManager);
                break;
                case 7: Main.placeOrder(sc, customer);
                break;
                case 8: Main.trackOrders(sc,customer);
                break;
                default: System.out.println("Invalid choice. Please try again...");
            }
        }while(option!=0);
    }
    
    public static void viewCart(Scanner sc, Customer customer){
        for (Order order : customer.getOrders()) {
            ShippingDetails shippingDetails = order.getShippingDetails();
            if(shippingDetails.getTrackingNum() > 0){
                System.out.println("Tracking Number : " + shippingDetails.getTrackingNum());
            }
        }
        int cartSize = customer.displayCart();
        int cartOption;
        if(cartSize != 0){
            do{
                System.out.print("Enter your choice > ");
                cartOption = sc.nextInt();
                sc.nextLine(); // clear the buffer
                if(cartOption < 1 || cartOption > cartSize){
                    System.out.println("Invalid option. Please try again...");
                }
            }while(cartOption < 1 || cartOption > cartSize);
            Cart selectedCart = customer.getCarts().get(cartOption - 1);
            selectedCart.viewCartItems();
        }
    }
         
    public static void addNewCart(Scanner sc,Customer customer){      
        char sure;
        do{//We should create or choose cart first then add item into cart...
            System.out.print("Do you want to create a new cart? yes(y) or no(n)> ");
            sure = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
            if(sure != 'y' && sure != 'n'){
                System.out.println("Please try again. Invalid input...");
            }
        }while(sure != 'y' && sure != 'n');
        
        switch(sure){
            case 'y': Cart newCart = customer.findOrCreateCart(0);
                System.out.println("New cart created with Cart ID: " + newCart.getCartId());
                break;
            case 'n': System.out.println("You chose not to create a cart.");
                break;
        }
    }
    
    public static void removeCart(Scanner sc, Customer customer){
        
        int cartSize = customer.displayCart();
        int cartOption;
        if(cartSize != 0){
            do{
                System.out.print("Enter your choice > ");
                cartOption = sc.nextInt();
                sc.nextLine(); // clear the buffer
                if(cartOption < 1 || cartOption > cartSize){
                    System.out.println("Invalid option. Please try again...");
                }
            }while(cartOption < 1 || cartOption > cartSize);
            Cart selectedCart = customer.getCarts().get(cartOption - 1);
            char sure;
            do{//We should create or choose cart first then add item into cart...
                System.out.print("Do you want to remove cart " + selectedCart.getCartId() + "? yes(y) or no(n)> ");
                sure = sc.next().toLowerCase().charAt(0);
                sc.nextLine();
                if(sure != 'y' && sure != 'n'){
                    System.out.println("Please try again. Invalid input...");
                }
            }while(sure != 'y' && sure != 'n');
        
            switch(sure){
                case 'y': System.out.println("Cart removed with Cart ID: " + selectedCart.getCartId());
                    customer.removeCart(selectedCart);                  
                    break;
                case 'n': System.out.println("You chose not to remove a cart.");
                    break;
            }
        }      
    }
    
    public static void addItemtoCart(Scanner sc, Customer customer,ProductManager productManager){
        
        int cartSize = customer.displayCart();
        int cartOption;
        if(cartSize != 0){
            do{
                System.out.print("Enter your choice > ");
                cartOption = sc.nextInt();
                sc.nextLine(); // clear the buffer
                if(cartOption < 1 || cartOption > cartSize){
                    System.out.println("Invalid option. Please try again...");
                }
            }while(cartOption < 1 || cartOption > cartSize);
            Cart selectedCart = customer.getCarts().get(cartOption - 1);
            selectedCart.viewCartItems();
            // Prompt user to add product to this cart
            System.out.print("Enter Product ID to add > ");
            String productId = sc.nextLine();

            Product product = productManager.findProductById(productId);
            if (product != null) {
                System.out.print("Enter quantity > ");
                int quantity = sc.nextInt();
                sc.nextLine(); // clear the buffer

                selectedCart.addProduct(product, quantity);
            } else {
                System.out.println("Product not found.");
            }
        }
    }
    
    public static void modifyItemFromCart(Scanner sc, Customer customer, ProductManager productManager){
        
        int cartSize = customer.displayCart();
        int cartOption;
        if(cartSize != 0){
            do{
                System.out.print("Enter your choice > ");
                cartOption = sc.nextInt();
                sc.nextLine(); // clear the buffer
                if(cartOption < 1 || cartOption > cartSize){
                    System.out.println("Invalid option. Please try again...");
                }
            }while(cartOption < 1 || cartOption > cartSize);
            
            Cart selectedCart = customer.getCarts().get(cartOption - 1);
            selectedCart.viewCartItems();
            
            if(selectedCart.getCartItemsSize() != 0){
                // Prompt user to add product to this cart
                System.out.print("Enter Product ID to modify > ");
                String productId = sc.nextLine();

                Product product = productManager.findProductById(productId);
                if (product != null) {
                    System.out.print("Enter new quantity > ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine(); // clear the buffer

                    selectedCart.updateItemQuantity(product, newQuantity);
                }else{
                    System.out.println("Product not found in the cart " + selectedCart.getCartId() + ".");
                }
            }
        }
    }
    
    public static void removeItemFromCart(Scanner sc, Customer customer, ProductManager productManager){
        
        int cartSize = customer.displayCart();
        int cartOption;
        if(cartSize != 0){
            do{
                System.out.print("Enter your choice > ");
                cartOption = sc.nextInt();
                sc.nextLine(); // clear the buffer
                if(cartOption < 1 || cartOption > cartSize){
                    System.out.println("Invalid option. Please try again...");
                }
            }while(cartOption < 1 || cartOption > cartSize);
            
            Cart selectedCart = customer.getCarts().get(cartOption - 1);
            selectedCart.viewCartItems();

            if(selectedCart.getCartItemsSize() != 0){
                // Prompt user to add product to this cart
                System.out.print("Enter Product ID to remove > ");
                String productId = sc.nextLine();

                Product product = productManager.findProductById(productId);
                if (product != null) {
                    char sure;
                    do{//We should create or choose cart first then add item into cart...
                        System.out.print("Do you want to remove product " + product.getProductID() + " from cart " + selectedCart.getCartId() + "? yes(y) or no(n)> ");
                        sure = sc.next().toLowerCase().charAt(0);
                        sc.nextLine();
                        if(sure != 'y' && sure != 'n'){
                            System.out.println("Please try again. Invalid input...");
                        }
                    }while(sure != 'y' && sure != 'n');

                    switch(sure){
                        case 'y': selectedCart.removeProduct(product);
                            break;
                        case 'n': System.out.println("You chose not to remove an item from a cart.");
                            break;
                    }
                }else{
                    System.out.println("Product not found in the cart " + selectedCart.getCartId() + ".");
                }
            }
        }
    }
    
    public static void placeOrder(Scanner sc,Customer customer){
        int cartSize = customer.displayCart();
        int cartOption;
        if(cartSize != 0){
            do{
                System.out.print("Enter your choice > ");
                cartOption = sc.nextInt();
                sc.nextLine(); // clear the buffer
                if(cartOption < 1 || cartOption > cartSize){
                    System.out.println("Invalid option. Please try again...");
                }
            }while(cartOption < 1 || cartOption > cartSize);
            
            Cart selectedCart = customer.getCarts().get(cartOption - 1);
            selectedCart.viewCartItems();

            if(selectedCart.getCartItemsSize() != 0){
                // Get Shipping Details
                System.out.print("Enter the shipping address > ");
                String shippingAddress = sc.nextLine();

                // Generate tracking number (for simplicity, using random number here)
                int trackingNum = (int) (Math.random() * 100000);

                // Create a new ShippingDetails object
                ShippingDetails shippingDetails = new ShippingDetails(
                    "SH" + System.currentTimeMillis(), // unique shipping ID
                    shippingAddress,
                    new Date(), // setting current date as the delivery date for simplicity
                    trackingNum
                );

                // Create the order
                Order newOrder = customer.createOrder(customer, new Date(), Order.STATUS_PENDING, shippingDetails);
                shippingDetails.getOrders().add(newOrder);
                // Calculate total amount for the order
                newOrder.getTotalAmountByCart(selectedCart);

                Invoice invoice = new Invoice("INV" + System.currentTimeMillis(), newOrder, new Date(), newOrder.getTotalAmount());

                // Display order details and confirmation
                System.out.println("Order placed successfully!");
                System.out.println("Order ID: " + newOrder.getOrderId());
                System.out.println("Shipping Address: " + shippingDetails.getShippingAddress());
                System.out.println("Total Amount: RM" + newOrder.getTotalAmount());
                System.out.println("Tracking Num: " + shippingDetails.getTrackingNum());
                System.out.println(invoice.getInvoiceDetails());
                newOrder.setInvoice(invoice);
                invoice.sendInvoiceToCustomer(customer);
                // Optionally, you can clear the cart after placing the order
                selectedCart.clearCart();
            }
        }
    }
    
    public static void trackOrders(Scanner sc,Customer customer){
        int trackingNum;
        System.out.print("Enter your Tracking Number > ");
        trackingNum = sc.nextInt();
        sc.nextLine();
        ShippingDetails shippingDetails = new ShippingDetails();
        for (Order order : customer.getOrders()) {
            shippingDetails = order.getShippingDetails();
        }
        if(shippingDetails != null){
            System.out.println(shippingDetails.trackShipment(trackingNum));
        }
    }
    
    public static void payment(Scanner sc,Customer customer){
        
        int option;
        do{
            System.out.println("Here is customer payment models");     
            System.out.println("1.View payment details");
            System.out.println("2.Process payment");
            System.out.println("3.Refund payment");
            System.out.println("4.View Invoice");
            System.out.println("5.View Transaction");
            System.out.println("0.Exit");
            System.out.print("Enter your choice > ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: Main.viewPaymentDetails(sc,customer);
                break;
                case 2: Main.processPayment(sc,customer);
                break;
                case 3: Main.refundPayment(sc,customer);
                break;
                case 4: Main.viewInvoice(sc,customer);
                break;
                case 5: Main.viewTransaction(sc,customer);
                break;
                default: System.out.println("Invalid choice. Please try again...");
            }
        }while(option != 0);
        
    }
    
    public static boolean viewPaymentDetails(Scanner sc, Customer customer){
        
        if(customer.getOrders().isEmpty()){
            System.out.println("No orders available. Hence, no payment details.");
            return false;
        } else{
            Payment payment = customer.getPayment();
            if(payment == null){
                System.out.print("Enter Payment Method (Credit Card / PayPal) > ");
                String paymentMethod = sc.nextLine();                
                payment = new Payment("P" + System.currentTimeMillis(),customer.getOrders(),paymentMethod,Payment.STATUS_PENDING);
                System.out.println(payment.getPaymentDetails());
                customer.setPayment(payment);
                
                return true;
            }
            else{
                System.out.println(payment.getPaymentDetails());
                return true;
            }
        }
    }
    
    public static void processPayment(Scanner sc,Customer customer){
        boolean processPayment = viewPaymentDetails(sc,customer);  
        if(processPayment){
            char sure;
        
            do{//We should create or choose cart first then add item into cart...
                System.out.print("Do you sure to make a payment? yes(y) or no(n)> ");
                sure = sc.next().toLowerCase().charAt(0);
                sc.nextLine();
                if(sure != 'y' && sure != 'n'){
                    System.out.println("Please try again. Invalid input...");
                }
            }while(sure != 'y' && sure != 'n');

            switch(sure){
                case 'y': 
                    if(customer.getPayment().processPayment()){
                        Invoice invoice = new Invoice();
                        for(Order order : customer.getOrders()){
                            invoice = new Invoice("INV" + System.currentTimeMillis(), order, new Date(), customer.getPayment().calcTotalAmount());
                            System.out.println(invoice.generateInvoice());
                            order.setInvoice(invoice);
                        }
                        // Send invoice to customer
                        invoice.sendInvoiceToCustomer(customer);

                        // Mark invoice as paid
                        invoice.markInvoiceAsPaid();
                        System.out.println("Invoice marked as paid.");

                        // Record transaction
                        Transaction transaction = new Transaction("TXN" + System.currentTimeMillis(), customer.getPayment(), new Date(), "Payment", "Completed");
                        transaction.recordTransaction();
                        customer.getPayment().setTransaction(transaction);
                    }
                    break;
                case 'n': System.out.println("You chose not to process a payment");
                    break;
            }
        }
    }
    
    public static void refundPayment(Scanner sc,Customer customer){
        boolean processPayment = viewPaymentDetails(sc,customer);  
        if(processPayment){
            char sure;
        
            do{//We should create or choose cart first then add item into cart...
                System.out.print("Do you sure to make a refund? yes(y) or no(n)> ");
                sure = sc.next().toLowerCase().charAt(0);
                sc.nextLine();
                if(sure != 'y' && sure != 'n'){
                    System.out.println("Please try again. Invalid input...");
                }
            }while(sure != 'y' && sure != 'n');

            switch(sure){
                case 'y': 
                    if(customer.getPayment().refundPayment()){
                        System.out.println("Payment refunded successfully.");
                        // Record refund transaction
                        Transaction transaction = customer.getPayment().getTransaction();
                        transaction.updateTransactionStatusNType("Refunded", "Refund");
                        transaction.recordTransaction();
                        customer.getPayment().setTransaction(transaction);
                    }
                    break;
                case 'n': System.out.println("You chose not to process a payment");
                    break;
            }
        }
    }
    
    public static void viewInvoice(Scanner sc,Customer customer) {
        // Loop through each order (assuming multiple orders)
        if(!customer.getOrders().isEmpty())
        for (Order order : customer.getOrders()) {
            if(order.getInvoice() != null){
                Invoice invoice = order.getInvoice();
                System.out.println(invoice.getInvoiceDetails());
            }
        }else{
            System.out.println("There is no an order. Hence, there is no an invoice...");
        }
        
    }
    
    public static void viewTransaction(Scanner sc,Customer customer) {
        // Check if the customer has a payment
        if (customer.getPayment().getTransaction() != null) {
            Payment payment = customer.getPayment();
            // For simplicity, assuming there's only one transaction per payment
            // You could maintain a list of transactions if needed
            System.out.println(payment.getTransaction().getTransactionDetails());
        } else {
            System.out.println("No transactions available for this customer.");
        }
    }
    
    public static void customerPersonalInformation(){
        
        
    }
    
    public static void vendor(Scanner sc){
        
    }
}
