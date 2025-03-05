public class CartItem{
    Item item; 
    int quantity; 

    CartItem(Item item, int quantity){
        if (quantity<0){
            System.out.println("Enter valid Quantity for item");
            System.exit(0); 
        }
        this.item = item; 
        this.quantity = quantity; 
    }
}