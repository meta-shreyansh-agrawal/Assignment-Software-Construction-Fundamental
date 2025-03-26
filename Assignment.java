import java.util.Scanner; 

public class Assignment{
    public static void main(String[] args){
        Cart cart = new Cart(); 
        Item[] items = Items.items; 
        Scanner sc = new Scanner(System.in); 
        int choice = 1; 
        int number = 0; 
        int quantity = 0; 
        while(choice != 0){
            System.out.println("\nWelcome to shopping\nEnter your choice\n1)List Items\n2)List Cart\n3)Add Item to Cart\n4)Display Item Quantity\n5)Update Item Quantity\n6)Remove Item from Cart\n7)Get Total Bill\n0)Exit Program"); 
            choice = Util.inputNumberInRange(sc,0,7); 
            System.out.println("Your Choice is :"+choice); 
            switch (choice) {
                case 1: 
                    // List of all Items 
                    if (items.length<=0){
                        System.out.println("No Items Avaliable"); 
                        break; 
                    }
                    for(int i = 0; i<items.length;i++){
                        Item item = items[i]; 
                        System.out.println((i+1)+")"+item.name+"\n  id: "+item.id+"\n  price: "+item.price+"\n  description: "+item.description); 
                    }
                    break;
                case 2: 
                    // List of Items in Cart
                    if (cart.items.isEmpty()){
                        System.out.println("Cart is Empty"); 
                        break; 
                    }
                    for(int i = 0; i<cart.items.size();i++){
                        CartItem cartItem = cart.items.get(i); 
                        System.out.println((i+1)+")"+cartItem.item.name+"\n  id: "+cartItem.item.id+"\n  price: "+cartItem.item.price+"\n  quantity: "+cartItem.quantity+"\n  description: "+cartItem.item.description);
                    }
                    break;
                case 3: 
                    // Add Item to Cart
                    System.out.print("Enter Item ID :"); 
                    number = Util.inputNumberInRange(sc,1,items.length);
                    while(true){
                        try{
                            System.out.print("Enter Quantity :"); 
                            quantity = Util.inputNaturalNumber(sc); 
                            cart.addToCart(number,quantity); 
                            break; 
                        }catch(Exception e){
                            System.out.println();
                        }
                    }
                    break; 
                case 4: 
                    System.out.print("Enter Item id from cart :"); 
                    number = Util.inputNumberInRange(sc,1,items.length);
                    System.out.println("Quantity is: "+cart.displayQty(number));
                    break; 
                case 5: 
                    System.out.print("Enter Item id from cart: "); 
                    number = Util.inputNumberInRange(sc,1,items.length);
                    System.out.print("Enter new Quantity :"); 
                    quantity = Util.inputNaturalNumber(sc); 
                    cart.updateQty(number,quantity); 
                    System.out.println("Quantity updated Sucessfully"); 
                    break; 
                case 6: 
                    System.out.print("Enter Item ID from cart: "); 
                    number = Util.inputNumberInRange(sc,1,items.length);
                    cart.deleteItem(number); 
                    System.out.println("Item deleted Successfully"); 
                    break; 
                case 7: 
                    System.out.println("Total Bill is: "+cart.displayBill()); 
                    break; 
                    case 0:
                    System.exit(0); 
            }

        }

        sc.close(); 

    }
}
