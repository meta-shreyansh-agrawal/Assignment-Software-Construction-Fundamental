import java.util.ArrayList;
public class Cart{
    ArrayList<CartItem> items; 

    Cart(){
        items = new ArrayList<CartItem>();  
    }

    public void addToCart(Item item,int quantity){
         if (quantity<0){
            System.out.println("Enter valid Quantity for item");
            return; 
        }
        for(int i = 0; i<items.size(); i++){
             if(items.get(i).item.id == item.id){
                items.get(i).quantity += quantity;  
                return; 
            }
        }
        CartItem newItem = new CartItem(item,quantity);
        items.add(newItem);
    }

    public int displayQty(int n){
        return items.get(n).quantity;  
    }

    public void updateQty(int no, Integer quantity){
        if(quantity<0){
            System.out.println("Enter valid Quantity for item");
            return; 
        }
        items.get(no).quantity = quantity; 
        System.out.println("Item now Found"); 
        return; 
    }

    public void deleteItem(int no){
        items.remove(no); 
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