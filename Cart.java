import java.util.ArrayList;
public class Cart{
    ArrayList<CartItem> items; 

    Cart(){
        items = new ArrayList<CartItem>();  
    }

    public void addToCart(int id,int quantity)throws Exception{
         if (quantity<0){
            System.out.println("Enter valid Quantity for item");
            return; 
        }

        for(int i = 0; i<items.size(); i++){
             if(items.get(i).item.id == id){
                items.get(i).quantity += quantity;  
                return; 
            }
        }
        Item toAdd = null; 
        boolean found = false; 
        for(Item i: Items.items){
            if(i.id == id){
                toAdd = i;
                found = true;
            } 
        }
        if(!found)throw new Exception("Item with such ID does not Exist"); 
        CartItem newItem = new CartItem(toAdd,quantity);
        items.add(newItem);
    }

    public int displayQty(int id){
        for(CartItem c : items){
            if(id == c.item.id)return c.quantity; 
        }
        return 0;  
    }

    public void updateQty(int id, Integer quantity){
        if(quantity<0){
            System.out.println("Enter valid Quantity for item");
            return; 
        }
        for(CartItem c : items){
            if(id == c.item.id){
                c.quantity = quantity; 
                return; 
            } 
        }
        System.out.println("Item now Found"); 
    }
    
    public void deleteItem(int id){
        for(CartItem c : items){
            if(id == c.item.id){
                items.remove(c);  
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