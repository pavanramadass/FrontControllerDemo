package espionage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrontController {
	private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher(); 
    }

    private boolean isAuthenticUser(Agency agency) throws IOException {
    	System.out.println("Enter Passcode");
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String input = reader.readLine(); 
    	Integer passcode = Integer.decode(input);
    	if(agency.containsAgent(passcode)) {
    		System.out.println("User is authenticated successfully.\n");
            return true;
    	}
    	return false; 
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request, Agency agency) throws IOException {
    	System.out.println("Enter ID");
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String input = reader.readLine(); 
    	Integer ID = Integer.decode(input);
    	
        // log each request
        trackRequest(request);

        // authenticate the user
        if(isAuthenticUser(agency)) {
            dispatcher.dispatch(request, agency, ID);
        }
        else {
        	System.out.println("Incorrect Passcode\n");
        }
    }
}
