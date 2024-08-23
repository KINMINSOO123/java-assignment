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
                    Main.inventoryManager();
                    break;
                case 2: 
                    Main.customer();
                    break;
                case 3:
                    Main.vendor();
                    break;
                case 0:
                    System.out.println("Exiting the program. Bye Bye");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again...");
            }
        }while(option != 0);
    }
}
