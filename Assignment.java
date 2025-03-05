public class Assignment{
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
