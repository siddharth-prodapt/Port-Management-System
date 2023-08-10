import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShipAndPortManagement implements IPort, IContainer, IShip{
	static ArrayList<Container> containersList = new ArrayList<Container>();
	static ArrayList<Port> portList = new ArrayList<Port>();
	static ArrayList<Ship> shipList = new ArrayList<Ship>();
 //	static HashMap<Integer,ArrayList<Integer>> loadedContainersMap = new HashMap<Integer, ArrayList<Integer>>();
//	static ArrayList<ShipContainerData> loadedContainersList = new ArrayList<ShipContainerData>();

	
	public void createContainer() {
		System.out.println("\n--------------------");
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
		
		
		if(isPortAvailable(portId)) {
			Container newContainer = new Container(portId, weight, type);
			containersList.add(newContainer);
			
			portList.get(portId -1).inventoryContainersList.add(newContainer.getId());
			
			System.out.println("Container Created!");
			
		}else {
			System.out.println("Port is not available. Register it!");
		}
	}

	public void viewContainerList() {
		for(Container c : containersList) {
			System.out.println("ID: "+c.getId()+" Port ID: "+c.getPortId() + " Weight: "+c.getWeight()+ " Type: "+ c.getType());
		}
	}
	

	public void createShip(){
//		ship Id start from 101
		
		System.out.println("\n----------------");
		System.out.println("Create Ship Menu");
		System.out.println("-----------------");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter port Id where ship is located: ");
		int portId = sc.nextInt();
		
		if(!isPortAvailable(portId)) {
			System.out.println("Port Not Available!");
			return;
		}
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
		
		System.out.println("\t\t\t\t\t\tTo Reach a port we must Sail! ");
		System.out.println("\t\t\t\t\t\tShip "+shipList.get(shipList.size()-1).getShipId() + " is registered.");
				
	}
	
	public Ship searchShip(int shipId) {
		for(Ship ele : shipList) {
			if(ele.getShipId() == shipId) {
				return ele;
			}	
		}
		return null;
	}
	
	public void displayShipDetails() {
		System.out.println("\n-------------------");
		System.out.println("Display Ship Details");
		System.out.println("-------------------");
		for(Ship ele: shipList) {
			System.out.println("ShipID: "+ ele.getShipId()+" Available at Port: "+ele.getPortId() + " MaxContainers : "+ ele.getMaxContainers() + " HC: "+ ele.getMaxHeavyContainer());
			System.out.println("Max wt.: "+ ele.getMaxWeight() + " RCon: "+ ele.getCountRefrigeratedContainers() + " LCon: "+ ele.getCountLiquidContainers());
			System.out.println("Loaded Containers No: "+(ele.loadedContainersList) );
			System.out.println();
		}
		
	}
	
	
//	public  void displayDetails() {
//		System.out.println("\n---------------");
//		System.out.println("Port DEtails");
//		System.out.println("---------------");
//		for(Port ele: portList) {
//			System.out.println("");
//		}
//		
//	}
	
	public void loadingContainer() {
		System.out.println("\n-----------------");
		System.out.println("Loading Container");
		System.out.println("-----------------");
		int shipId, containerId;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Ship Id: ");//shipList Index
		shipId = sc.nextInt();
		System.out.println("Enter Container Id: ");
		containerId = sc.nextInt();
		
		if(containersList.size() == 0 || shipList.size()==0 || (!isContainerAvailable(containerId))) {
			System.out.println("Either container or ship is not present! ");
			return;
		}
		
		
		if(searchShip(shipId) != null) {
			
			Ship shipInfo = searchShip(shipId);
			Container containerInfo = containersList.get(containerId-1);
			
			if(shipInfo.getPortId() == containerInfo.getPortId()) {
//				true then available in same port
				
				System.out.println("\t\t\t\t\t\tShip: "+shipInfo.getShipId()+ " can feel the weight");
//				System.out.println("Container's PortID: "+ containerInfo.getPortId());
				
				if((shipInfo.getCountOfContainersLoaded() < shipInfo.getMaxContainers()) && (containerInfo.getWeight() <= shipInfo.getMaxWeight() )) {
		
//					ShipContainerData tempOb = new ShipContainerData();
//					tempOb.appendValuesInContainersList(containerInfo.getId());
					
					
					if(shipInfo.addLoadedContainerId(containerInfo.getId())) {
//						if container is added to loaded container list
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
						System.out.println("\t\t\t\t\tContainer is Loaded in the Ship");
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
	

	
	public void createPort() {
		
		System.out.println("\n----------");
		System.out.println("Create Port");
		System.out.println("-----------");
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter x coordinate: ");
			int x = sc.nextInt();
			System.out.println("Enter y coordinate: ");
			int y = sc.nextInt();
			
			Port portObj = new Port(x, y);
			portList.add(portObj);
			
			System.out.println("\t\t\t\t\t\tHurray! Port Created");
			System.out.println("\t\t\t\t\t\tPORT "+ portList.get(portList.size()-1).getPortId()+" is waiting for Ships...." );
		
	}
	
	
	
	public boolean isShipAvailable(int shipNo) {
		if(shipNo<= shipList.size())
			for(Ship s: shipList) {
				if(s.getShipId() == shipNo) {
					return true;
				}
			}
		return false;
	}
	
	public boolean isPortAvailable(int portId ){
		if(portId <= portList.size())
			for(Port p: portList) {
				if(p.getPortId() == portId) {
					return true;
				}
			}
		return false;	
	}
	
	public boolean isContainerAvailable(int containerId) {
		if( containersList.size() != 0 ) {
			for(Container c: containersList) {
				if(c.getId() == containerId) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Ship findShip(int shipNo) {
		for(Ship s: shipList)
			if(s.getShipId() == shipNo)
				return s;
		return null;
	}

//	calc distance between two ports
	public double calcDistance(Port source, Port destination) {
//		distance between two coordinates
		float distance;
		
		double x1 =  source.getX(), y1 = source.getY();
		double x2 =  destination.getX(), y2 = destination.getY();
		
		double calcDist = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
		return calcDist;
	}
	
	
	public void shipSailsToAnotherPort() {
		Scanner sc = new Scanner(System.in);
		int shipNo, dportNo;
		
		System.out.println("\n------------------------");
		System.out.println("Journey is going to Begin");
		System.out.println("-------------------------");
		System.out.println("Enter available Ship No: ");
		shipNo = sc.nextInt();
		System.out.println("Enter destination Port No: ");
		dportNo = sc.nextInt();
		
//		check if ship and port available 
/*			chk if ship is empty or not
 * 				if not empty
 * 					calcDistance to another port
 * 						if fuel available() then move to other port
 * 							Start moving thread.sleep() then reached port
 * 								change ship port no.
 *	
 * 
 * */
//		System.out.println("Is ship Available: "+isShipAvailable(shipNo) +"Is port: "+isPortAvailable(dportNo));
		if(isShipAvailable(shipNo) && isPortAvailable(dportNo)) {
			Ship curShip = findShip(shipNo);
				
					if(curShip.loadedContainersList.size() != 0) {
						double distance = calcDistance(portList.get(curShip.getPortId()-1), portList.get(dportNo-1));
						
						System.out.printf("Distance to Sail: %.2f"+ distance);
						System.out.println("Sailing");
						
						for(int i = 0; i<10; i++) {
							System.out.print(".");
							try {
								Thread.sleep(500);
							}
							catch(Exception e) {
								System.out.println(e);
							}
							
						}
//						Since ship reached the destination
//						ship port Id will change to destination ID
						curShip.setPortId(dportNo);
						System.out.println("Hurray Ship Reached to Port.. "+ dportNo);
						
					}else {
						System.out.println("Ship is Empty! Load Containers to start sailing");
					}
		}else {
			System.out.println("Either ship or port is not available.\nTry Again after registering ship and port");
		}
	}
	
/*
 * for unloading the containers on destination port
 * container nos. 
 * if available on the ship 
 * 	Drop it... (remove from ships loaded containers list) && isDelivered = true
 * 	add to ports inventory
 * 
 */
	
	public void unloadingContainers() {
		System.out.println("\n-----------------");
		System.out.println("Unload Containers");
		System.out.println("-----------------");
		
		Scanner sc = new Scanner(System.in);
		int containerNo, shipNo;
		
		System.out.println("Enter Container to UNload: ");
		containerNo = sc.nextInt();
		System.out.println("Enter Ship No: ");
		shipNo = sc.nextInt();
		
		if(isShipAvailable(shipNo)) {
			Ship currShip = findShip(shipNo);
			Container c = findContainerOnShip(currShip,containerNo);
			if(c != null) {
//				current container is now shipped to another port
				c.setPortId(currShip.getPortId());
//				get port where ship reached.addContainerData to port's inventory container list
				portList.get(currShip.getPortId() - 1).inventoryContainersList.add(c.getId());
				int containerIndex = findIndexOfContainerOnShip(currShip, containerNo);
				currShip.loadedContainersList.remove(containerIndex);
				
				currShip.setMaxWeight(currShip.getMaxWeight()+c.getWeight());
				currShip.setMaxContainers(currShip.getMaxContainers()+1);
				
				if(c.getType().toString().equals("B")) {
//					basic container
				}
				else {
//					Heavy container
					currShip.setMaxHeavyContainer(currShip.getMaxHeavyContainer()+1);
					if(c.getType().toString().equals("R")) {
						currShip.setCountRefrigeratedContainers(currShip.getCountRefrigeratedContainers() + 1);
					}
					else {
						currShip.setCountLiquidContainers(currShip.getCountLiquidContainers() + 1);
					}
				}
				currShip.setCountOfContainersLoaded(currShip.loadedContainersList.size());
				System.out.println("\t\t\t\t\t\tMission Successful");
				System.out.println("\t\t\t\t\t\tContainer: "+containerNo+" unloaded!");
				
			}
		}
	}
	
	public int findIndexOfContainerOnShip(Ship s, int containerNo) {
		for(int index = 0; index<s.loadedContainersList.size(); index++)
			if(s.loadedContainersList.get(index) == containerNo) {
				return index;
			}
			return -1;
	}
	public Container findContainerOnShip(Ship s, int containerNo){
		for(int loadedContNo: s.loadedContainersList) {
			if(containerNo == loadedContNo) {
				Container c = containersList.get(containerNo - 1);
				return c;
			}
		}
		return null;
	}
	
	public void viewContainerDetails() {
		System.out.println("\n-----------------");
		System.out.println("Container Details");
		System.out.println("-----------------");
		for(Container c: containersList) {
			System.out.println("ID: "+c.getId()+" Port ID: "+ c.getPortId()+" Weight: "+c.getWeight()+" Type: "+ c.getType());
			System.out.println();
		}
	}
	public void viewPortDetails() {
		System.out.println("-------------");
		System.out.println("Port Details");
		System.out.println("------------");
		for(Port p: portList) {
			System.out.println(" Port ID: "+ p.getPortId()+" Coordinates(x,y): "+"("+p.getX()+","+p.getY()+")");
			System.out.println(" Containers In Inventory:(ContainerID) "+ p.inventoryContainersList);
			System.out.println("------------------------------\n");
		}
		
	}
	
	
}
