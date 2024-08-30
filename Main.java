/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoes;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
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
        do{
            System.out.println("Welcome to Customer Login");
            System.out.print("Enter your Email > ");
            email = sc.nextLine();
            System.out.print("Enter your Password > ");
            password = sc.nextLine();
            customer = customerManager.CheckLoginValid(email, password);
        }while(customer == null);
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
            }while(!(conPassword.equals(password)));
            customer = customerManager.registerCustomer(name, email, phone, address, password);
        }while(customer == null);
        System.out.println(customerManager.customerSize());
    }
    
    public static void vendor(Scanner sc){
        
    }
}
