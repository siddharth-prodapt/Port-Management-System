
public interface IShip {
	void createShip();
	Ship searchShip(int shipId);
	void displayShipDetails();
	boolean isShipAvailable(int shipNo);
	Ship findShip(int shipNo);
	void shipSailsToAnotherPort();
	
}
