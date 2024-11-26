public class Aims {
public static void main(String[] args) {
//	Cart anOrder = new Cart();
//	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King"
//			,"Animation","Roger Allers",87,19.95f);
//     anOrder.addDigitalVideoDisc(dvd1);
//DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
//		"Science Fiction","George Lucas",87,24.95f);
//	anOrder.addDigitalVideoDisc(dvd2);
//	DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
//			"Animation",18.99f);
//	anOrder.addDigitalVideoDisc(dvd3);
//	anOrder.removeDigitalVideoDisc(dvd3);
//	
//	
//	System.out.println("Total Cost is :" +anOrder.totalCost());
	
	 Cart anOrder = new Cart();
	  DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King"
			,"Animation","Roger Allers",87,19.95f);
	  DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas",87,24.95f);
	  DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
			"Animation",18.99f);

	  DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
	  dvdList[0]= new DigitalVideoDisc("The abc","Muc King",14.2f);
	  dvdList[1] = new DigitalVideoDisc("The def","Lee King",18.5f);
	  dvdList[2] = new DigitalVideoDisc("the xyz","Yasuo King",20.4f);
	  
	 anOrder.addDigitalVideoDisc(dvdList);
	 anOrder.addDigitalVideoDisc(dvd1,dvd2);

	 System.out.println(anOrder.toString());
	 
	 System.out.println("Total cost is: "+anOrder.totalCost());

	anOrder.addDigitalVideoDisc(dvd3);
//	anOrder.removeDigitalVideoDisc(dvd3);
	
	System.out.println("Total Cost is :" +anOrder.totalCost());
	 anOrder.printCART();
}
}