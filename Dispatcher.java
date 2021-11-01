package espionage;

import java.io.IOException;

public class Dispatcher {
	private SecretAgentView secretAgentView;
    private ManagerView managerView;

    public Dispatcher() {
        secretAgentView = new SecretAgentView();
        managerView = new ManagerView();
    }
    
    // Dispatches received requests 
    public void dispatch(String request, Agency agency, Integer ID) throws IOException {
        if(request.equalsIgnoreCase("AGENT")){
            secretAgentView.show(ID, agency);
        }
        else if(request.equalsIgnoreCase("BOSS")){
            managerView.show(agency);
        }
        else{
            System.out.println("Incorrect request. Request must be 'AGENT' or 'BOSS'");
        }
    }
}
