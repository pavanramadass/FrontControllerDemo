package espionage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManagerView {
	// Displays output for the Manager 
	public void show(Agency agency) throws IOException {
        System.out.println("Welcome Manager"); 
        System.out.println("How may I be of service to you?");
        printMenu();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        
        while(!request.equals("3"))
        {
        	if(request.equals("1")) {
            	System.out.println("Secret Agent's ID");
            	request = reader.readLine();
            	Integer ID = Integer.decode(request);
            	addSecretAgent(ID, agency); 
            }
            else if(request.equals("2")) {
            	System.out.println("Secret Agent's ID");
            	request = reader.readLine();
            	Integer ID = Integer.decode(request);
            	terminateSecretAgent(ID, agency); 
            }
            else if(request.equals("3"))
            	break;
            else
            	System.out.println("I did not understand your request.");
        	printMenu();
        	request = reader.readLine(); 
        }
        System.out.println("Shutting Down Manager View... Returning Back to Main Menu\\n");
    }
	
	// Let's manager add a secret agent
	public void addSecretAgent(Integer ID, Agency agency) {
		agency.addAgent(ID); 
	}
	
	// Let's manager remove a secret agent 
	public void terminateSecretAgent(Integer ID, Agency agency) {
		agency.deleteAgent(ID); 
	}
	
	// Prints menu option for manager 
	public void printMenu() {
		System.out.println("Press the following number:");
		System.out.println("1: Add a Secret Agent");
		System.out.println("2: Terminate a Secret Agent");
		System.out.println("3: Quit");
	}
}
