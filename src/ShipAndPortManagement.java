import java.util.ArrayList;
import java.util.Scanner;

public class ShipAndPortManagement {
	static ArrayList<Container> containersList = new ArrayList<Container>();
	static ArrayList<Port> portList = new ArrayList<Port>();
	static ArrayList<Ship> shipList = new ArrayList<Ship>();
	
	void createContainer() {
		
		System.out.println("Create Container Menu");
		System.out.println("---------------------");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Port ID where container is located: ");
		int portId = sc.nextInt();
		System.out.println("Enter weight: ");
		int weight = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter container type(B/R/L): ");
		String cType = sc.nextLine();
		StringBuffer type= new StringBuffer(cType);
		
		Container obj = new Container(portId, weight, type);
		containersList.add(obj);
		
		System.out.println("Container Created!");
	}

	void viewContainerList() {
		for(Container c : containersList) {
			System.out.println("ID: "+c.getId()+" Port ID: "+c.getPortId() + " Weight: "+c.getWeight()+ " Type: "+ c.getType());
		}
	}
	

	void createShip(){
		System.out.println("Create Ship Menu");
		System.out.println("-----------------");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter port Id where ship is located: ");
		int portId = sc.nextInt();
		System.out.println("Enter Max Weight : ");
		int maxWt = sc.nextInt();
		
		System.out.println("Enter Max Containers: ");
		int maxContainer = sc.nextInt();
		System.out.println("Enter Max Heavy Container: ");
		int hc  = sc.nextInt();
		System.out.println("Enter nos of Refrigerated Containers: ");
		int rContainer = sc.nextInt();
		System.out.println("Enter nos of Liquid Containers: ");
		int lContainer = sc.nextInt();
		System.out.println("Enter fuel consumption: ");
		double fc = sc.nextDouble();
		
		Ship shipObj = new Ship(portId, maxWt, maxContainer, hc, rContainer, lContainer, fc );
		shipList.add(shipObj);
		
	}
	
	void loadingContainer() {
		int shipId, containerId;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Ship Id: ");//shipList Index
		shipId = sc.nextInt();
		System.out.println("Enter Container Id: ");
		containerId = sc.nextInt();
		
		if(shipList.size() < shipId && (shipList.get(shipId).getPortId() == containerList.get(containerId-1) )) {
			
		}
		
	}
	
	
	void createPort() {
		System.out.println("Create Port");
		System.out.println("-----------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x coordinate: ");
		int x = sc.nextInt();
		System.out.println("Enter y coordinate: ");
		int y = sc.nextInt();
		
		Port portObj = new Port(x, y);
		portList.add(portObj);
	}

	
	
}
