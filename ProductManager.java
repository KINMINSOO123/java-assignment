/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
        // Initialize products
        addInitialProducts();
    }

    private void addInitialProducts() {
        products.add(new Sandal("S001", "Beach Sandal", "Havaianas", 'M', "Blue", 25.99, "Perfect for beach trips", "Rubber", true));
        products.add(new Sandal("S002", "Leather Sandal", "Birkenstock", 'L', "Brown", 85.50, "Comfortable leather sandals", "Leather", false));
        products.add(new Sandal("S003", "Flip-Flop", "Old Navy", 'M', "Black", 15.00, "Basic flip-flops for everyday wear", "Synthetic", true));
        products.add(new Sandal("S004", "Sport Sandal", "Nike", 'L', "Grey", 45.00, "Sporty sandals for hiking", "Mesh", true));
        products.add(new Sandal("S005", "Casual Sandal", "Adidas", 'M', "White", 35.99, "Stylish and comfortable", "Foam", false));
        products.add(new RunningShoe("RS001", "Air Zoom", "Nike", 'L', "Red", 120.00, "Lightweight running shoes", 250.5, "Rubber"));
        products.add(new RunningShoe("RS002", "Ultraboost", "Adidas", 'M', "White", 140.00, "Maximum comfort for long runs", 280.0, "Foam"));
        products.add(new RunningShoe("RS003", "Speedform", "Under Armour", 'M', "Black", 110.00, "Designed for speed", 220.3, "Synthetic"));
        products.add(new RunningShoe("RS004", "Gel Nimbus", "Asics", 'L', "Blue", 130.00, "Gel cushioning for comfort", 275.8, "Rubber"));
        products.add(new RunningShoe("RS005", "Kinvara", "Saucony", 'M', "Green", 100.00, "Lightweight for long-distance running", 230.7, "EVA Foam"));
        products.add(new DressShoe("DS001", "Oxford Shoe", "Clarks", 'L', "Black", 150.00, "Classic formal shoes", "Leather", "Flat"));
        products.add(new DressShoe("DS002", "Derby Shoe", "Hugo Boss", 'M', "Brown", 180.00, "Stylish business wear", "Suede", "Flat"));
        products.add(new DressShoe("DS003", "Loafer", "Gucci", 'L', "Navy", 300.00, "Luxury slip-on shoes", "Leather", "Block"));
        products.add(new DressShoe("DS004", "Monk Strap", "Allen Edmonds", 'M', "Tan", 210.00, "Elegant dress shoes", "Leather", "Flat"));
        products.add(new DressShoe("DS005", "Wingtip Brogue", "Cole Haan", 'M', "Brown", 160.00, "Classic wingtip style", "Leather", "Flat"));
        products.add(new BasketballShoe("BS001", "Air Jordan", "Nike", 'L', "Black", 220.00, "High-performance basketball shoes", "Strong support", true));
        products.add(new BasketballShoe("BS002", "LeBron Soldier", "Nike", 'M', "White", 180.00, "Durable with ankle support", "Medium support", true));
        products.add(new BasketballShoe("BS003", "Harden Vol 4", "Adidas", 'M', "Blue", 160.00, "Lightweight and comfortable", "Basic support", false));
        products.add(new BasketballShoe("BS004", "Curry 8", "Under Armour", 'L', "Yellow", 190.00, "Enhanced grip and support", "Flexible support", true));
        products.add(new BasketballShoe("BS005", "Zoom Freak", "Nike", 'M', "Green", 140.00, "Great traction on court", "Strong support", false));
        products.add(new CasualShoe("CS001", "Slip-On Sneaker", "Vans", 'L', "Black", 60.00, "Classic slip-on casual shoes", "Everyday wear", true));
        products.add(new CasualShoe("CS002", "Low-Top Sneaker", "Converse", 'M', "White", 55.00, "Iconic low-top sneakers", "Casual wear", false));
        products.add(new CasualShoe("CS003", "Espadrille", "Toms", 'L', "Blue", 45.00, "Light and breezy for summer", "Beach", true));
        products.add(new CasualShoe("CS004", "Boat Shoe", "Sperry", 'M', "Brown", 75.00, "Stylish and comfortable for outings", "Boating", false));
        products.add(new CasualShoe("CS005", "Moccasin", "UGG", 'L', "Tan", 90.00, "Comfortable and cozy", "Indoor wear", true));
    }

    public Product findProductById(String productId) {
        for (Product product : products) {
            if (product.getProductID().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null; // Return null if product not found
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public void displayProducts() {
        // Display all products, sorted by category
       boolean headerPrinted = false;
        System.out.println("\n==============================================================================SANDAL==============================================================================");
        for(Product p : products){
            if(p instanceof Sandal){
                if(!headerPrinted){
                    System.out.println(p.productHeader());
                    headerPrinted = true;
                }
                System.out.println(p);
            }
        }
        System.out.println("==================================================================================================================================================================");
        
        headerPrinted = false;
        System.out.println("\n================================================================================RUNNING SHOE==============================================================================");
        for(Product p : products){
            if(p instanceof RunningShoe){
                if(!headerPrinted){
                    System.out.println(p.productHeader());
                    headerPrinted = true;
                }
                System.out.println(p);
            }
        }
        System.out.println("==========================================================================================================================================================================");
        
        headerPrinted = false;
        System.out.println("\n============================================================================DRESS SHOE============================================================================");
        for(Product p : products){
            if(p instanceof DressShoe){
                if(!headerPrinted){
                    System.out.println(p.productHeader());
                    headerPrinted = true;
                }
                System.out.println(p);
            }
        }
        System.out.println("==================================================================================================================================================================");
        
        headerPrinted = false;
        System.out.println("\n==============================================================================BASKETBALL SHOE=============================================================================");
        for(Product p : products){
            if(p instanceof BasketballShoe){
                if(!headerPrinted){
                    System.out.println(p.productHeader());
                    headerPrinted = true;
                }
                System.out.println(p);
            }
        }
        System.out.println("==========================================================================================================================================================================");
        
        headerPrinted = false;
        System.out.println("\n=============================================================================CASUAL SHOE=============================================================================");
        for(Product p : products){
            if(p instanceof CasualShoe){
                if(!headerPrinted){
                    System.out.println(p.productHeader());
                    headerPrinted = true;
                }
                System.out.println(p);
            }
        }
        System.out.println("=====================================================================================================================================================================");  
    }
}