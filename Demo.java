package espionage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo { 
	
	public static void main(String[] args) throws IOException {
		//agency = new Agency(); 
        FrontController frontController = new FrontController();
        Agency agency = new Agency(); 
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Welcome to ASGR");
        printMenu(); 
        
        String request = reader.readLine(); 
        
        while(!request.equalsIgnoreCase("Q")) {
        	if(request.equalsIgnoreCase("M")) {
        		printMenu(); 
        	}
        	else {
        		frontController.dispatchRequest(request, agency);
        	}
        	printMenu(); 
        	request = reader.readLine();
        }
    }
	
	public static void printMenu() {
		System.out.println("Type 'Q' to quit the program");
        System.out.println("Type 'Boss' to access the Manager's portal");
        System.out.println("Type 'Agent' to access the Secret Agent's portal");
        System.out.println("Type 'M' to access the main menu");
	}
}
