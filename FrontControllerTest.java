package espionage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class FrontControllerTest {
	
	@Test
	void Manager_addSecretAgentTest() throws IOException {
		Agency agency = new Agency(); 
		ManagerView managerView = new ManagerView();
		
		Integer ID = 1;
		
		boolean result = managerView.addSecretAgent(ID, agency);
		assertEquals(true, result);
	}
	
	@Test
	void Manager_terminateSecretAgentTest() {
		Agency agency = new Agency(); 
		ManagerView managerView = new ManagerView();
		Integer ID = 1;
		
		managerView.addSecretAgent(ID, agency);
		
		boolean result = managerView.terminateSecretAgent(ID, agency);
		assertEquals(true, result);
	}	
}
