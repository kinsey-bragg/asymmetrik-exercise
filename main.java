/*
 * This class opens the text file and reads it. 
 * It then calls upon the ContactInfo class, which parses the information, 
 * and prints out the result. 
 * */
import java.util.*;
import java.io.*;

class BusinessCardParser {
	public static void main (String[] args) throws FileNotFoundException { 
		
		File f = new File ("BusinessCard.txt");
		
		ArrayList<String> card = new ArrayList<String>();
	    
		Scanner sc = new Scanner(f);
	    
		//Creating the ArrayList card to work with
		while (sc.hasNextLine()) {
	      String line = sc.nextLine();
	      card.add(line);
	    }
		
	    sc.close();
	    
	    System.out.println("Name: " + ContactInfo.getName(card));
	    System.out.println("Phone: " + ContactInfo.getPhone(card));
	    System.out.println("Email: " + ContactInfo.getEmail(card));
	
	}
}
