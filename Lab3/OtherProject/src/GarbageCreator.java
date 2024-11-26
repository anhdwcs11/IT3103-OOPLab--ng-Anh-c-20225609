import java.nio.file.Files;
import java.nio.file.Paths;
public class GarbageCreator {
public static void main(String[] args) {
	
	String filename = "test.txt";
	byte[] inputBytes = {0};
	long startTime , endTime;
// kiem tra su ton tai cua tep
	if(!Files.exists(Paths.get(filename)))
	{
		System.out.println("Error File:"+filename);
		return;
	}
	try {
		inputBytes = Files.readAllBytes(Paths.get(filename));
		
	}
	catch (Exception e){
		e.printStackTrace();
	}
	startTime = System.currentTimeMillis();
	String outputString = "";
	for(byte b : inputBytes)
	{
		outputString += (char) b;
	}
	endTime = System.currentTimeMillis();
	System.out.println(endTime - startTime);
	System.out.println("The string read from the file:");
	System.out.println(outputString.toString());
}
<<<<<<< HEAD
}
=======
}
>>>>>>> dc228a8771c615f4725a54702676cfdb619533b3
