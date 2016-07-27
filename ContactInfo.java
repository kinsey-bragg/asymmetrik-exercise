import java.util.*;
import java.lang.String;

public class ContactInfo {
	
	/*This function finds the email on the business card through 
	 * finding the @*/
	public static String getEmail(ArrayList<String> card) {
		
		String email = new String("N/A");
		
		for(int i= 0; i< card.size(); i++) {
		
			if(card.get(i).contains("@")) {
				email = card.get(i);
			}
		}
		return email;
	}
	
	/* This function finds the phone on the business card
	 * through finding exactly 9 or 10 digits in the string */
	public static String getPhone(ArrayList<String> card) {
		
		String phone = new String("N/A");
		
		for(int i= 0; i< card.size(); i++) {
			
			//Removing all but numbers
			String tmp = card.get(i).replaceAll("\\D+", "");
			
			if((tmp.matches("\\d{9}") || tmp.matches("\\d{10}")) 
					&& !card.get(i).contains("Fax")){
				phone = tmp;
			}
			
		}
		return phone;
	}

	/*This function finds the name on the business card by 
	 * looking at the email and seeing if the name string is related*/
	public static String getName(ArrayList<String> card) {
		
		String name = new String("N/A");
		String phone = getPhone(card);
		String email = getEmail(card);
		//Making sure the company name doesn't match in the email
		email = email.substring(0, email.indexOf("@"));
		System.out.println(email);
		
		//Iterating through the ArrayList
		for(int i= 0; i< card.size(); i++) {
			
			//Splitting the names in half - if there is no spaces, this will be ignored
			String[] tmp = card.get(i).split(" ");
			
			//Making sure this isn't the email or phone, and has two words
			if(card.get(i) != email && card.get(i) != phone && tmp.length >= 2) {
				
				for(int i1= 0; i1 < tmp.length; i1++) {
					
					//If the email has part of the name
					if(email.toLowerCase().contains(tmp[i1].toLowerCase())) {
						name = card.get(i);
						break;
					}
				}
			}
		}
		return name;
	}
}
