import java.util.UUID; 
public class Item{
    UUID id; 
    String name; 
    String description; 
    int price; 

    Item(String name, String description, int price){
        this.id = UUID.randomUUID(); 
        this.name = name; 
        this.description = description; 
        this.price = price;  
    }
}