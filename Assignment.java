import java.util.Scanner; 
import java.util.ArrayList; 

public class Assignment{
    public static void main(String[] args){
        Cart cart = new Cart(); 
        Item[] items = new Item[10]; 
        items[0] = new Item("bottle","used to store water",20);
        items[1] = new Item("pen","used to write",10);
        items[2] = new Item("book","used to write upon",50);
        items[3] = new Item("pencil","used to write and can be erased",5);
        items[4] = new Item("sketch book","used to draw upon",100);
        items[5] = new Item("mouse","used to navigate in pc",250);
        items[6] = new Item("keyboard","used to type on pc",500);
        items[7] = new Item("bag","used to carry items",400);
        items[8] = new Item("headphones","used to listen through pc",800);
        items[9] = new Item("charger","used to charge pc",600);

        Scanner sc = new Scanner(System.in); 
        int choice = 1; 
        int number = 0; 
        int quantity = 0; 
        while(choice != 0){
            System.out.println("\nWelcome to shopping\nEnter your choice\n1)List Items\n2)List Cart\n3)Add Item to Cart\n4)Display Item Quantity\n5)Update Item Quantity\n6)Remove Item from Cart\n7)Get Total Bill\n0)Exit Program"); 
            choice = sc.nextInt(); 
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
                    System.out.println((i+1)+")"+item.name+"\n  price: "+item.price+"\n  description: "+item.description); 
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
                    System.out.println((i+1)+")"+cartItem.item.name+"\n  price: "+cartItem.item.price+"\n  quantity: "+cartItem.quantity+"\n  description: "+cartItem.item.description);
                }
                break;
                case 3: 
                // Add Item to Cart
                System.out.print("Enter Item Number :"); 
                number = sc.nextInt(); 
                if (number <=0 || number>=items.length){
                    System.out.println("Item does not exist"); 
                    break; 
                }
                System.out.print("Enter Quantity :"); 
                quantity = sc.nextInt(); 
                if(quantity<=0){
                    System.out.println("Enter valid Quantity"); 
                    break; 
                }
                cart.addToCart(items[number-1],quantity); 
                break; 
                case 4: 
                System.out.print("Enter Item Number from cart :"); 
                number = sc.nextInt(); 
                if (number <=0 || number>=cart.items.size()){
                    System.out.println("Item does not exist"); 
                    break; 
                }
                System.out.println("Quantity is: "+cart.displayQty(cart.items.get(number-1).item));
                break; 
                case 5: 
                System.out.print("Enter Item Number from cart: "); 
                number = sc.nextInt(); 
                if (number <=0 || number>=cart.items.size()){
                    System.out.println("Item does not exist"); 
                    break; 
                }
                System.out.print("Enter new Quantity :"); 
                quantity = sc.nextInt();
                if(quantity<=0){
                    System.out.println("Enter valid Quantity"); 
                    break; 
                }
                cart.updateQty(cart.items.get(number-1).item,quantity); 
                System.out.println("Quantity updated Sucessfully"); 
                break; 
                case 6: 
                System.out.print("Enter Item Number from cart: "); 
                number = sc.nextInt(); 
                if (number <=0 || number>=cart.items.size()){
                    System.out.println("Item does not exist"); 
                    break; 
                }
                cart.deleteItem(cart.items.get(number-1).item); 
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
