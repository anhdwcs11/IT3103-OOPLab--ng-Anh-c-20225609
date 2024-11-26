
public class Cart {
  public static final int MAX_NUMBERS_ORDERED = 20;
  private DigitalVideoDisc itemOrdered[]=
		  new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered;
  public void addDigitalVideoDisc( DigitalVideoDisc d)
  {
	  if(qtyOrdered < MAX_NUMBERS_ORDERED ) {
		  itemOrdered[ qtyOrdered] = d;
		  qtyOrdered++;
		  System.out.println(d.getTitle() + " Has been added!");
		  
			  
	  }
	  else
	  {
		  System.out.println("Cannot add more DVDs! The cart is almost full .");
		  
	  }
		  
		  
	
  }
  public void removeDigitalVideoDisc(DigitalVideoDisc d)
  {
	  if(itemOrdered[0]== null) {
		  System.out.println("[ERROR] Your cart is empty!");
		  return;
	  }
	  for(int i=0;i<qtyOrdered;i++)
	  {
		 if(itemOrdered[i].equals(d))
		 {
			 for(int j=i;j<qtyOrdered -1;j++)
			 {
				 itemOrdered[j] = itemOrdered[j+1];
			 }
			 itemOrdered[qtyOrdered -1] = null;
			 qtyOrdered --;
			 System.out.println(d.getTitle() + "has been removed!");
			 return ;
		 }
		 
	  }
	  System.out.println("[ERROR] No such DVD exists!");
	  
	  }
  
  public float totalCost()
  {
	  float total = 0.0f;
	  for(int i=0; i < qtyOrdered ;i++)
	  {
		  total+=itemOrdered[i].getCost();
	  }
	  return total;
  }
  public String toString()
  {
	  String s = "";
	  for(int i=0 ;i < qtyOrdered ; i++)
	  {
		  s+=itemOrdered[i].toString();
		  s+="\n";
	  }
	  return s;
  }
  
  public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
  {
	
	  // add to cart
	for(DigitalVideoDisc disc : dvdList)
	{   if(qtyOrdered>20) {
		System.out.println("The cart is full ");
		 return ;
	}
	else {
		itemOrdered[qtyOrdered]=disc;
		qtyOrdered++;
		System.out.println(disc.getTitle()+" has been added!");	  
	}
	}
	  }
  
	  
  public void addDigitalVideoDisc( DigitalVideoDisc dvd1 , DigitalVideoDisc dvd2 )
  {
	  if(qtyOrdered>20)
	  {
		  System.out.println("The cart is full");
		  return ;
	  }
	  
	  qtyOrdered+=2;
	  itemOrdered[qtyOrdered-2]=dvd1;
	  itemOrdered[qtyOrdered-1]=dvd2;
	  System.out.println("The list has been adder 2dvd!");
  }
  public int getQtyOrdered()
  {
	  return qtyOrdered;
  }
  
 public void printCART()
 {
	 System.out.println("*************CART*************");
	 System.out.println("Ordered Items:");
	 System.out.println(toString());
	 System.out.println("Total cost: $"+totalCost());
	 System.out.println("******************************");
 }
public void searchCart(int id)
{
 boolean search  = false;
 for(int i=0;i<qtyOrdered;i++)
 {
	 if(itemOrdered[i].isMatch(id-1))
	 {
		 search = true;
		 System.out.println("Found item with ID: "+id);
		 System.out.println(itemOrdered[i].toString());
         break;
	 }
	
 }
 if(search==false) {
	 System.out.println("Not found!");
	 }
}
public void searchCart(String title)
{
 boolean search = false;
 for(int i=0;i<qtyOrdered;i++)
 {
	 if(itemOrdered[i].isMatch(title))
	 {
		 search = true;
		 System.out.println("Found item with title included : "+title);
		 System.out.println(itemOrdered[i].toString());
		break;
	 }
	
 }
 if(search==false)
	 System.out.println("Not found!");
}
}
  