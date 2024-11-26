<<<<<<< HEAD

public class Store {
private DigitalVideoDisc itemsInStore[];
private int numberOfItems;
public Store(int fullsize)
{
	itemsInStore = new DigitalVideoDisc[fullsize];
	numberOfItems=0;
	}
public void addDVD(DigitalVideoDisc dvd)
{
	 if(numberOfItems<itemsInStore.length) {
  itemsInStore[numberOfItems] = dvd;
  numberOfItems++;
  System.out.println("ADDED: "+dvd.getTitle());
  
	 }
	 else {
		 System.out.println("The DVDs Store is full!");
	 }
	 }
  public void removeDVD(DigitalVideoDisc dvd)
  {
	  boolean check = false;
	  for(int i=0;i<numberOfItems;i++)
	  {
		  if(itemsInStore[i].equals(dvd))
		  {
			  check = true;
			  for(int j=i;j<numberOfItems-1;j++)
			  {
				  itemsInStore[j]=itemsInStore[j+1];
			  }
			  numberOfItems--;
			  System.out.println("REMOVE: "+dvd.getTitle());
			  break;
		  }
	  }
	  if(check == false)
	  {
		  System.out.println("DVD not found: "+dvd.getTitle());
	  }
  }
 public void displayStore()
 {
	 System.out.println("*********Store************");
	 for(int i=0;i<numberOfItems;i++)
	 {
		 System.out.println(itemsInStore[i].toString());
	 }
	 System.out.println("**************************");
	 
 }
}


=======
public class Store {
    private DigitalVideoDisc itemsInStore[];
    private int numberOfItems;

    // Constructor
    public Store(int fullsize) {
        itemsInStore = new DigitalVideoDisc[fullsize];
        numberOfItems = 0;
    }

    // Add DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (numberOfItems < itemsInStore.length) {
            itemsInStore[numberOfItems] = dvd;
            numberOfItems++;
            System.out.println("ADDED: " + dvd.getTitle());
        } else {
            System.out.println("The DVDs Store is full!");
        }
    }

    // Remove DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean check = false;
        for (int i = 0; i < numberOfItems; i++) {
            if (itemsInStore[i].equals(dvd)) {
                check = true;
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                numberOfItems--;
                System.out.println("REMOVE: " + dvd.getTitle());
                break;
            }
        }
        if (check == false) {
            System.out.println("DVD not found: " + dvd.getTitle());
        }
    }

    // Display the DVDs in the store
    public void displayStore() {
        System.out.println("*********Store************");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println(itemsInStore[i].toString());
        }
        System.out.println("**************************");
    }
}

>>>>>>> dc228a8771c615f4725a54702676cfdb619533b3
