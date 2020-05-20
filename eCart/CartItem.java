// CartItem class derived from Product class
package eCart;

public class CartItem extends Product
{
  	// Attributes
  	private int qty;
  
  	// Behaviors
  
  	// constructors
  	public CartItem() { }										// default constructor
 	 
  	public CartItem( int c, String n, double p, int q) // parameterised constructor
  	{ 
     	super(c,n,p); 
	  	qty = q;
  	}
  
  	// set and get methods
  	public void setQty(int q) { qty = q; }
  	public int  getQty() { return qty; }
  	
	// toString method
  	public String toString() { return super.toString() + "\tQty:" + qty; }
  
  	// other methods
  	public double calculateTotalAmount() { return qty * getPrice(); }
}