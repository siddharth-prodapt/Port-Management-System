import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShipAndPortManagement {
	static ArrayList<Container> containersList = new ArrayList<Container>();
	static ArrayList<Port> portList = new ArrayList<Port>();
	static ArrayList<Ship> shipList = new ArrayList<Ship>();
//	static HashMap<Integer,ArrayList<Integer>> loadedContainersMap = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<ShipContainerData> loadedContainersList = new ArrayList<ShipContainerData>();

	
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
//		ship Id start from 101
		
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
	
	Ship searchShip(int shipId) {
		for(Ship ele : shipList) {
			if(ele.getShipId() == shipId) {
				return ele;
			}	
		}
		return null;
	}
	
	void displayShipDetails() {
		System.out.println("Display Ship Details");
		for(Ship ele: shipList) {
			System.out.println("ShipID: "+ ele.getShipId() + "MaxContainers : "+ ele.getMaxContainers() + "HC: "+ ele.getMaxHeavyContainer());
			System.out.println("Max wt.: "+ ele.getMaxWeight() + "RCon: "+ ele.getCountRefrigeratedContainers() + "LCon: "+ ele.getCountLiquidContainers());
		}
		
	}
	void loadingContainer() {
		int shipId, containerId;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Ship Id: ");//shipList Index
		shipId = sc.nextInt();
		System.out.println("Enter Container Id: ");
		containerId = sc.nextInt();
		
		
		if(searchShip(shipId) != null) {
			
			Ship shipInfo = searchShip(shipId);
			Container containerInfo = containersList.get(containerId-1);
			
			if(shipInfo.getPortId() == containerInfo.getPortId()) {
//				true then available in same port
				
				System.out.println("Ship's PortID : "+ shipInfo.getPortId());
				System.out.println("Container's PortID: "+ containerInfo.getPortId());
				
				if((shipInfo.getCountOfContainersLoaded() < shipInfo.getMaxContainers()) && (containerInfo.getWeight() <= shipInfo.getMaxWeight() )) {
		
					ShipContainerData tempOb = new ShipContainerData();
					tempOb.appendValuesInContainersList(containerInfo.getId());
					
					if(loadedContainersList.add(tempOb)) {
						shipInfo.setCountOfContainersLoaded(shipInfo.getCountOfContainersLoaded() + 1);
						shipInfo.setMaxWeight( shipInfo.getMaxWeight() - containerInfo.getWeight());
						shipInfo.setMaxContainers(shipInfo.getMaxContainers() - 1);
						
						/*
						 * if container is basic
						 * then basic count will be subtracted
						 * 
						 * else{
						 * heavy then
						 * 	heavyCount - 1;
						 * if Refrigerated Then 
						 * 		count Refrigerated -1;
						 * elseIf(LIquid)
						 * then 
						 * 		countLiquid -1;
						 * */
						if(containerInfo.getType().toString().equals("B")) {
							shipInfo.setCountBasicContainer(shipInfo.getCountBasicContainer() - 1);
						}
						else {
//							Then its heavy container
							shipInfo.setMaxHeavyContainer(shipInfo.getMaxHeavyContainer() -1);
							if(containerInfo.getType().toString().equals("R")) {
								shipInfo.setCountRefrigeratedContainers(shipInfo.getCountRefrigeratedContainers() - 1);
							}else {
								shipInfo.setCountLiquidContainers(shipInfo.getCountLiquidContainers() - 1);
							}
						}
						System.out.println("Container Loaded To Ship");
					}
				}
				else {
					System.out.println("Required weight or space is NOT available");
				}	
			}
			else {
				System.out.println("Either container or ship is not in the same port");
			}
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
