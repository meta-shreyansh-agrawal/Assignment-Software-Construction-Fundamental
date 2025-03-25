public class Item{
    
    static int idCount = 1; 
    
    int id; 
    String name; 
    String description; 
    int price; 
    
    Item(String name, String description, int price){
        this.id = idCount; 
        this.name = name; 
        this.description = description; 
        this.price = price;  
        idCount++; 
    }
}