/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class CustomerManager {
    
    private ArrayList<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<Customer>();
    }

    public Customer registerCustomer(String name, String email, String phone, String address) {
        
        Customer newCustomer = new Customer(name, email, phone, address,this);
        customers.add(newCustomer);
        return newCustomer;
        
    }

    public String generateCustomerId(){
        
        String customerId = "CUS";
        int[] num = new int[4];
        boolean nonUnique;
        do{
            for(int i = 0; i < num.length; i++){
                
                num[i] = (int)(Math.random() * 10);
                customerId += num[i];
            }
            
            nonUnique = false;
            
            for(Customer customer: this.customers){
                if(customerId.compareTo(customer.getCustomerId())==0){
                    nonUnique = true;
                    break;
                }
            }
        }while(nonUnique);
        
        return customerId;
    }
    
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
    
    public void updateCustomerDetails(Customer customer,Scanner sc){
        
        String name;
        String email;
        String phone;
        String address;
        int option;
                
        do{
            System.out.println("Here is the modification of " + customer.getName() + "information");
            System.out.println("1. Name");
            System.out.println("2. Email");
            System.out.println("3. Phone Number");
            System.out.println("4. Address");
            System.out.println("0. Exit");
            System.out.print("Enter your choice > ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1: {
                    System.out.print("Enter the name > ");
                    name = sc.nextLine();
                    customer.setName(name);
                }
                break;
                case 2: {
                    System.out.print("Enter the email > ");
                    email = sc.nextLine();
                    customer.setEmail(email);
                }
                break;
                case 3: {
                    System.out.print("Enter the phone number > ");
                    phone = sc.nextLine();
                    customer.setPhone(phone);
                }
                break;
                case 4: {
                    System.out.print("Enter the address > ");
                    address = sc.nextLine();
                    customer.setAddress(address);
                }
                break;
                case 0: {
                    System.out.println("Exit");
                }
                break;
                default: {
                    System.out.println("Invalid choice. Please try again...");
                }         
            }
        }while(option != 0);
    }
    
    public Customer findCustomer(Scanner sc){
        String customerId;
        
        System.out.print("Enter the customer ID > ");
        customerId = sc.nextLine();
        
        for(Customer customer : this.customers){
            if(customerId.compareTo(customer.getCustomerId())== 0){
                return customer;
            }
        }
        
        return null;
    }
    
    public void getCustomerDetails(Customer customer,Scanner sc){
        
        System.out.println("Customer Name : " + customer.getName());
        System.out.println("Customer Email : " + customer.getEmail());
        System.out.println("Customer Phone Number : " + customer.getPhone());
        System.out.println("Customer Addresss : " + customer.getAddress());
        
    }
    
    public void deleteCustomer(Customer customer,Scanner sc){
        
        char sure;
        do{
            System.out.println("Are you sure you want to delete " + customer.getName() + "'s record, yes(y) or no(n) > ");
            sure = sc.next().charAt(0);
            sure = Character.toLowerCase(sure);
        }while(sure != 'y' && sure != 'n');
        
        if(sure == 'y'){
            this.customers.remove(customer);
        }
    }
    
    public void applyLoyaltyPoints(Customer customer,int loyaltyPoints){
        customer.setLoyaltyPoints(loyaltyPoints);
    }
}
