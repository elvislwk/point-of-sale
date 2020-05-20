import eCart.Product;
import eCart.CartItem;
import java.util.*; // used for Scanner and ArrayList

public class pointOfSale
{
    // main method
    public static void main(String[] args) 
    {
    	// declare constants and variables
		ArrayList productList  = new ArrayList(); // list of products
		ArrayList shoppingCart = new ArrayList(); // list of cart items
		
		
		initProductList(productList);					// store the products (objects) in productList
		 
		int option = 1;
		
		Scanner input = new Scanner(System.in);
		
		while (option != 0)
		{
			displayMenu(); 				// display main menu
			
			option = input.nextInt();	// get option selected by user

			switch (option)				// process option selected by user
			{
				case 1 : listProducts(productList);				// list products and prices
							break;
		
				case 2 : addItem(productList, shoppingCart);	// add item to cart
							break;
		
				case 3 : removeItem(shoppingCart);				// remove item from cart
							break;

				case 4 : viewCartItems(shoppingCart);			// show cart items
							break;

				case 5 : shoppingCart.clear();					// clear cart items
							break;

				case 6 : checkOut(shoppingCart);					// check out
							break;

				case 0 : System.out.println("Bye.");			// exit
							break;

				default:System.out.print("Sorry. Invalid option.");
			}
		}
                
    } 

	// method to display main menu
	public static void displayMenu() 
	{
		System.out.println();
		System.out.println("------------------- M E N U -------------------");
		System.out.println("[1] List products and prices");
		System.out.println("[2] Add item to cart");
		System.out.println("[3] Remove item from cart");
		System.out.println("[4] View cart items");
		System.out.println("[5] Clear cart items");
		System.out.println("[6] Checkout");
		System.out.println("[0] Exit");		
		System.out.println("-----------------------------------------------");
		System.out.print("Enter your option : ");		
	}

	
    // method to store the products to the productList
    public static void initProductList(ArrayList productList)
    {		 
	      Product p = null;
			p = new Product(1001, "Apple iPhone", 1088.00);
         productList.add(p);
			
			p = new Product(1005, "HTC Sensation", 888.00);
         productList.add(p);
			
			p = new Product(1013, "LG Optimus", 788.00);
         productList.add(p);
			
			p = new Product(1022, "Motorola Atrix", 958.00);
         productList.add(p);

			p = new Product(1027, "Samsung Galaxy", 988.00);
         productList.add(p);
 	 }
	
  	 // method to display all products and prices
    public static void listProducts(ArrayList productList)
    {
       if (productList.size() > 0)
       {
          System.out.println("No \tCode \tName \t\tPrice");
         
          for (int i=0; i<productList.size(); i++)
          {
             Product p = (Product) productList.get(i);
             System.out.println((i+1) + "\t" + p.getCode()+ "\t" + p.getName() + "\t" + p.getPrice());
          }
       }
       else
          System.out.println("No product found.");
    }  

    // method to add an item to the cart
    public static void addItem(ArrayList productList, ArrayList shoppingCart)
    {     
		  Scanner input = new Scanner(System.in);
	 	  
	     if (productList.size() > 0)
		  {
				listProducts(productList);
  		  		System.out.print("Enter item number : ");
		  		int itemNo = input.nextInt();	// no validation
		  		Product p = (Product) productList.get(itemNo-1);
				int code = p.getCode();
		  		String name = p.getName();
		  		double price = p.getPrice();
		  		System.out.print("Enter item qty    : ");
		  		int qty = input.nextInt();		// no validation
		  
		  		CartItem item = new CartItem(code, name, price, qty);
		  		shoppingCart.add(item);
			}
			else
			 	System.out.println("No product found.");
    }
     
    // method to remove an item from the cart
    public static void removeItem(ArrayList shoppingCart)
    {
	 		Scanner input = new Scanner(System.in);
 
        	if ( shoppingCart.size() > 0 )
			{
	    		viewCartItems(shoppingCart); // display the items in the cart
				System.out.print("Enter item number to delete : ");
		   	int itemNo = input.nextInt();		// no validation
			
				shoppingCart.remove(itemNo-1);	// no validation
			}
			else
			 	System.out.println("The cart is empty.");

    }
     
    // method to show all cart items
    public static void viewCartItems(ArrayList shoppingCart)
    {
			double total = 0.0;
        	if ( shoppingCart.size() > 0 )
			{
				System.out.println("No	Name		Price	Qty	Amount");
				System.out.println("-----------------------------------------------");
       		for (int i=0; i<shoppingCart.size(); i++)
				{
			   	CartItem item = (CartItem) shoppingCart.get(i);
           		System.out.println ((i+1) + "\t" + item.getName() + "\t" + item.getPrice() + "\t" 
					                     + item.getQty() + "\t" + item.calculateTotalAmount());
					total = total + item.calculateTotalAmount();
         	}
				System.out.println("-----------------------------------------------");
				System.out.println("Total Amount ($) : " + total);
				System.out.println("-----------------------------------------------");
			}
			else
			 	System.out.println("The cart is empty.");
	 } 

    // method to clear all cart items
    public static void clearCartItems(ArrayList shoppingCart)
    {
        	if ( shoppingCart.size() > 0 )
			{
			   shoppingCart.clear();
			 	System.out.println("The cart is cleared.");
			}
			else
			 	System.out.println("The cart is empty.");
	 } 
	 
    // method to check out
    public static void checkOut(ArrayList shoppingCart)
    {
	     	if ( shoppingCart.size() > 0 )
			{
			   System.out.println("Transaction done on " + getDate() + " at " + getTime());
				viewCartItems(shoppingCart);
 				shoppingCart.clear();
			}
			else
			 	System.out.println("The cart is empty.");
	 } 
	 
	 // method to get current date
	 public static String getDate()
	 {
  		// create a calendar object
 		Calendar today = new GregorianCalendar();
 	
 		// retrieve the date 
		int yr  = today.get(Calendar.YEAR);
		int mth = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DATE);
    	String date = day + "/" + mth + "/" + yr;
		
	   return date;	 
	 }
	 
	 // method to get current time
	 public static String getTime()
	 {
  		// create a calendar object
 		Calendar today = new GregorianCalendar();
 			
		// retrieve the time
		int hr  = today.get(Calendar.HOUR);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		String time = hr + ":" + min + ":" + sec;	 
		
		return time;
	}
}