package espionage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SecretAgentView {
 	
	// Displays output for Secret Agent
	public void show(Integer ID, Agency agency) throws IOException {
        System.out.println("Welcome I-" + ID);
        Integer targetID = Target(ID, agency);
        System.out.println("Your target is agent U-" + targetID);
        
        Integer target_number = Game(); 
        for(int i = 0; i <= 3; i++)
        {
        	if(i == 3) {
        		System.out.println("You have failed to kill agent U-" + targetID);
        		System.out.println("$250 has been reducted from your balance");
        		agency.reductBalance(ID, 250);
        		System.out.println("Your total balance is now " + agency.getBalance(ID)); 
        		System.out.println("The correct target number was " + target_number); 
        		System.out.println(); 
        		break;
        	}
        	System.out.println("Choose a number between 0 and 10");
        	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        	String ans = reader.readLine();
        	Integer answer = Integer.decode(ans); 
        	if(check(answer, target_number) == true) {
        		System.out.println("You have successfully killed agent U-" + targetID);
        		System.out.println("$500 has been added to your balance.");
        		agency.addBalance(ID, 500); 
        		System.out.println("Your total balance is now " + agency.getBalance(ID));
        		agency.addKillCount(ID);
        		System.out.println("Your total kill count is now " + agency.getKillCount(ID)); 
        		System.out.println();
        		break;
        	}
        }
        
        Integer a = agency.getBalance(ID).compareTo(0);
        if(a < 0) {
        	agency.deleteAgent(ID);
        	System.out.println("Agent I-" + ID + " has been terminated from the agency hereafter for having a balance less than 0."); 
        }
        
        System.out.println("Shutting Down Secret Agent View... Returning Back to Main Menu\n");
    }
	
	// returns the ID of the agent's next target 
	public Integer Target(Integer ID, Agency agency) {
		Random rand = new Random();
		Integer targetID = rand.nextInt(1000);
		agency.addTarget(ID, targetID); 
		return targetID;
	}
	
	// Creates a target value which the agent must guess correct to kill their target 
	public Integer Game() {
		Random rand = new Random();
		Integer target = rand.nextInt(10);
		return target; 
	}
	
	// Checks whether agent's guess matches the target number 
	public boolean check(Integer answer, Integer target) {
		if(answer.equals(target)) {
			return true;
		}
		return false; 
	}
}