import java.util.ArrayList;
public class Cart{
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