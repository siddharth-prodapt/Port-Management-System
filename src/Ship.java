
public class Ship {
	static int pk = 100;
	private int shipId;
	private int portId; //where the ship initially is
	private int maxWeight; //max wt of containers
	private int maxContainers; // max containers in that ship
	private int countHeavyContainer;
	private int countRefrigeratedContainers = 0;
	private int countLiquidContainers = 0;
	private double fuelConsumption;
	private int countBasicContainer;
	private int countOfContainersLoaded = 0;
	
	public Ship(int portId, int maxWeight, int maxContainers, int maxHeavyContainer, int countRefrigeratedContainers,
			int countLiquidContainers, double fuelConsumption) {
		this.shipId = ++pk;
		this.portId = portId;
		this.maxWeight = maxWeight;
		this.maxContainers = maxContainers;
		this.countHeavyContainer = maxHeavyContainer;
		this.countRefrigeratedContainers = countRefrigeratedContainers;
		this.countLiquidContainers = countLiquidContainers;
		this.fuelConsumption = fuelConsumption;
		this.setCountBasicContainer(this.maxContainers - this.countHeavyContainer);
	}
	
	public int getPortId() {
		return portId;
	}
	public void setPortId(int portId) {
		this.portId = portId;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getMaxContainers() {
		return maxContainers;
	}
	public void setMaxContainers(int maxContainers) {
		this.maxContainers = maxContainers;
	}
	public int getMaxHeavyContainer() {
		return countHeavyContainer;
	}
	public void setMaxHeavyContainer(int countHeavyContainer) {
		this.countHeavyContainer = countHeavyContainer;
	}
	public int getCountRefrigeratedContainers() {
		return countRefrigeratedContainers;
	}
	public void setCountRefrigeratedContainers(int countRefrigeratedContainers) {
		this.countRefrigeratedContainers = countRefrigeratedContainers;
	}
	public int getCountLiquidContainers() {
		return countLiquidContainers;
	}
	public void setCountLiquidContainers(int countLiquidContainers) {
		this.countLiquidContainers = countLiquidContainers;
	}
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public int getCountBasicContainer() {
		return countBasicContainer;
	}

	public void setCountBasicContainer(int countBasicContainer) {
		this.countBasicContainer = countBasicContainer;
	}

	public int getCountOfContainersLoaded() {
		return countOfContainersLoaded;
	}

	public void setCountOfContainersLoaded(int countOfContainersLoaded) {
		this.countOfContainersLoaded = countOfContainersLoaded;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	
	
	
}
