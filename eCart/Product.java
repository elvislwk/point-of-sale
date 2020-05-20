// Product class
package eCart;

public class Product 
{
  // attributes
  private int code;
  private String name; 
  private double price; 
  
  // behaviors
  
  // constructors
  public Product()									// default constructor
  {
     // attributes will be initialized to their default values
  }

  public Product(int c, String n, double p)	// parameterised constructor
  {
	 code = c;
    name = n;
    price = p;
  }
  
  // set and get methods
  public void   setCode(int c) { code = c; }
  public int    getCode() { return code; }  
  public void   setName(String n) { name = n; }
  public String getName() { return name; }
  public void   setPrice(double p) { price = p; }
  public double getPrice(){ return price; }
  
  // toString method
  public String toString() { return "Code:" + code + "\tName:" + name + "\tPrice:" + price; }

}