/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class CustomerManager {
    
    private ArrayList<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<Customer>();
    }

    public Customer registerCustomer(String name, String email, String phone, String address,String password) {
        Customer newCustomer = new Customer(name, email, phone, address, this, password);
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
    
    public Customer CheckLoginValid(String email,String password){
        
        for(Customer customer : customers){
            if(email.equals(customer.getEmail()) && password.equals(customer.getPassword())){
                return customer;
            }
        }
        return null;
    }
    
    public int customerSize(){
        return this.customers.size();
    }
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
    
    public boolean checkNameisValid(String name){
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(name);
        
        if(name.length() < 50 && matcher.matches()){
            return true;
        } else if (name.length() > 50){
            System.out.println("Name cannot be more than 50 character");
            return false;
        } else{
            System.out.println("Name cannot have special character and punctuation mark");
            return false;
        }
    }
    
    public boolean checkEmailisValid(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.matches()){
            return true;
        }
        System.out.println("Email must be written as email format");
        return false;
    }
    
    public boolean checkPhoneisValid(String phone){
        Pattern pattern = Pattern.compile("^01\\d{8,9}$");
        Matcher matcher = pattern.matcher(phone);
        
        if(matcher.matches()){
            return true;
        }
        System.out.println("Phone number must be in the format like 01XXXXXXXXX");
        return false;
    }
    
    public boolean checkAddressisValid(String address){
        
        if(address.length() < 300 && !(address.isBlank())){
            return true;
        }else if(address.isBlank()){
            System.out.println("Address can not be blank.");
            return false;
        }else{
            System.out.println("Address can not be written more than 300 character");
            return false;
        }
    }
    
    public boolean checkPasswordisValid(String password){
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$");
        Matcher matcher = pattern.matcher(password);
        
        if(matcher.matches()){
            return true;
        }
        
        System.out.println("Password must have at least 8 character, an uppercase letter and a special character");
        return false;
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
                    System.out.print("Enter the Name > ");
                    name = sc.nextLine();
                    customer.setName(name);
                }
                break;
                case 2: {
                    System.out.print("Enter the Email > ");
                    email = sc.nextLine();
                    customer.setEmail(email);
                }
                break;
                case 3: {
                    System.out.print("Enter the Phone Number > ");
                    phone = sc.nextLine();
                    customer.setPhone(phone);
                }
                break;
                case 4: {
                    System.out.print("Enter the Address > ");
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
        
        System.out.print("Enter the Customer ID > ");
        customerId = sc.nextLine();
        
        for(Customer customer : this.customers){
            if(customerId.compareTo(customer.getCustomerId())== 0){
                return customer;
            }
        }
        
        return null;
    }
    
    public String getCustomerDetails(Customer customer,Scanner sc){ 
        return String.format("\nCustomer Name : %s\nCustomer Email : %s\nCustomer Phone Number : %s\nCustomer Addresss : %s\n",
                customer.getName(),customer.getEmail(),customer.getPhone(),customer.getAddress());
    }
    
    public boolean confirmAction(String message, Scanner sc){
        char sure;
        do{
            System.out.println(message);
            sure = sc.next().charAt(0);
            sure = Character.toLowerCase(sure);
        }while(sure != 'y' && sure != 'n');
        
        if(sure != 'y' && sure != 'n'){
            System.out.println("Please enter y(yes) or n(no) for confirmation.");
        }
        return sure == 'y';
    }
    
    public void deleteCustomer(Customer customer,boolean valid){
        
        if(valid){
            this.customers.remove(customer);
        }
    }
    
    public void applyLoyaltyPoints(Customer customer,int loyaltyPoints){
        customer.setLoyaltyPoints(loyaltyPoints);
    }
    
    public void updateOrderStatus(){
        
    }
}
