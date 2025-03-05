import java.util.UUID; 
import java.util.ArrayList; 


public class Temp{
    public static void main(String[] args){
        Cart cart = new Cart(); 
        Item i1 = new Item("bottle","used to store water",20);
        Item i2 = new Item("pen","used to write",10);
        Item i3 = new Item("book","used to write upon",50);

        cart.addToCart(i1,3); 
        cart.addToCart(i3,2); 

        System.out.println("Quantity of books:"+cart.displayQty(i3)); 

        cart.updateQty(i3,4); 

        System.out.println("Updated Quantity of books:"+cart.displayQty(i3)); 

        cart.deleteItem(i3); 

        System.out.println("Total bill of cart:" + cart.displayBill()); 

    }
}

class Item{
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

class CartItem{
    Item item; 
    int quantity; 

    CartItem(Item item, int quantity){
        this.item = item; 
        this.quantity = quantity; 
    }
}

class Cart{
    ArrayList<CartItem> items; 

    Cart(){
        items = new ArrayList<CartItem>();  
    }

    public void addToCart(Item item,int quantity){
        CartItem newItem = new CartItem(item,quantity);
        items.add(newItem); 
    }

    public int displayQty(Item item){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).item.id == item.id){
                return items.get(i).quantity; 
            }
        }
        return -1; 
    }

    public void updateQty(Item item, Integer quantity){
         for(int i = 0; i<items.size(); i++){
            if(items.get(i).item.id == item.id){
                items.get(i).quantity = quantity; 
            }
        }
    }

    public void deleteItem(Item item){
         for(int i = 0; i<items.size(); i++){
            if(items.get(i).item.id == item.id){
                items.remove(i);    
            }
        }
    }

    public double displayBill(){
        int billAmount = 0; 
        for(int i = 0; i<items.size(); i++){
            int itemAmount = items.get(i).item.price*items.get(i).quantity; 
            billAmount += itemAmount; 
        }
        return billAmount;
    }
}


// Pending 
// 1) Validations
// 2) Item addition and uniqueness