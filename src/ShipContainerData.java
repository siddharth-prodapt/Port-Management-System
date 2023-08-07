import java.util.ArrayList;

public class ShipContainerData {
	private int shipNo;
	private ArrayList<Integer> loadedContainersInShip = new ArrayList<Integer>();
	
	
	public int getShipNo() {
		return shipNo;
	}
	public void setShipNo(int shipNo) {
		this.shipNo = shipNo;
	}
	public ArrayList<Integer> getLoadedContainerList() {
		return loadedContainersInShip;
	}
	public void setLoadedContainerList(ArrayList<Integer> loadedContainerList) {
		this.loadedContainersInShip = loadedContainerList;
	}
	public void appendValuesInContainersList(int val) {
		this.loadedContainersInShip.add(val);
	}
	
}
