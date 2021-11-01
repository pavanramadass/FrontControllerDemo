package espionage;
import java.util.*;

public class Agency {
	Map<Integer, ArrayList<Integer>> agency;
	
	// Agency constructor
	// Creates the Manager
	public Agency() {
		agency = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		list.add(0);
		list.add(0);
		agency.put(0, list);
	}
	
	// adds an agent to the agency 
	public void addAgent(Integer ID) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-1); 
		list.add(0); 
		list.add(5000);
		agency.put(ID, list); 
	}
	
	// terminates an agent from the agency 
	public void deleteAgent(Integer ID) {
		agency.remove(ID); 
	}
	
	// adds a target for an agent 
	public void addTarget(Integer ID, Integer Target) {
		ArrayList<Integer> list = agency.get(ID); 
		list.set(0, Target);  
	}
	
	// increments kill count 
	public void addKillCount(Integer ID) {
		ArrayList<Integer> list = agency.get(ID);
		Integer killCount = list.get(1);
		killCount = killCount + 1; 
		list.set(1, killCount);
	}
	
	// checks to see if passcode matches agent's id 
	public boolean containsAgent(Integer ID) {
		if(agency.containsKey(ID))
			return true;
		return false; 
	}
	
	// returns balance of agent 
	public Integer getBalance(Integer ID) {
		ArrayList<Integer> list = agency.get(ID);
		return list.get(2);
	}
	
	// returns kill count of agent 
	public Integer getKillCount(Integer ID) {
		ArrayList<Integer> list = agency.get(ID);
		return list.get(1); 
	}
	
	public void addBalance(Integer ID, Integer Amount) {
		ArrayList<Integer> list = agency.get(ID);
		Integer Balance = list.get(2) + Amount;
		list.set(2, Balance); 
	}
	
	public void reductBalance(Integer ID, Integer Amount) {
		ArrayList<Integer> list = agency.get(ID);
		Integer Balance = list.get(2) - Amount;
		list.set(2, Balance); 
	}
}
