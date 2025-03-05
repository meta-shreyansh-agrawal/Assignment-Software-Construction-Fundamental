import java.util.ArrayList;
public class Cart{
    ArrayList<CartItem> items; 

    Cart(){
        items = new ArrayList<CartItem>();  
    }

    public void addToCart(Item item,int quantity){
         if (quantity<0){
            System.out.println("Enter valid Quantity for item");
            System.exit(0); 
        }
        for(int i = 0; i<items.size(); i++){
             if(items.get(i).item.id == item.id){
                items.get(i).quantity += quantity;  
            }
        }
        CartItem newItem = new CartItem(item,quantity);
        items.add(newItem); 
    }

    public int displayQty(Item item){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).item.id == item.id){
                return items.get(i).quantity; 
            }
        }
        return 0; 
    }

    public void updateQty(Item item, Integer quantity){
        if(quantity<0){
            System.out.println("Enter valid Quantity for item");
            System.exit(0); 
        }
         for(int i = 0; i<items.size(); i++){
            if(items.get(i).item.id == item.id){
                items.get(i).quantity = quantity; 
                return; 
            }
        }
        System.out.println("Item now Found"); 
    }

    public void deleteItem(Item item){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).item.id == item.id){
                items.remove(i); 
                return;    
            }
        }
        System.out.println("Item now Found"); 
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