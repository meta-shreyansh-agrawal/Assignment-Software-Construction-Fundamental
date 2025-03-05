import java.util.UUID; 
public class Item{
    UUID id; 
    String name; 
    String description; 
    int price; 

    Item(String name, String description, int price){
        this.id = UUID.randomUUID(); 
        if(name.isEmpty() || description.isEmpty()){
            System.out.println("Enter valid name and description of Item");
            System.exit(0); 
        }
        if(price<0){
            System.out.println("Enter valid price of Item");
            System.exit(0); 
        }
        this.name = name; 
        this.description = description; 
        this.price = price;  
    }
}