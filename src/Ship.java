
public class Ship {
	private int portId; //where the ship initially is
	private int maxWeight; //max wt of containers
	private int maxContainers; // max containers in that ship
	private int maxHeavyContainer = 0;
	private int countRefrigeratedContainers = 0;
	private int countLiquidContainers = 0;
	private double fuelConsumption;
	
	public Ship(int portId, int maxWeight, int maxContainers, int maxHeavyContainer, int countRefrigeratedContainers,
			int countLiquidContainers, double fuelConsumption) {
		
		this.portId = portId;
		this.maxWeight = maxWeight;
		this.maxContainers = maxContainers;
		this.maxHeavyContainer = maxHeavyContainer;
		this.countRefrigeratedContainers = countRefrigeratedContainers;
		this.countLiquidContainers = countLiquidContainers;
		this.fuelConsumption = fuelConsumption;
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
		return maxHeavyContainer;
	}
	public void setMaxHeavyContainer(int maxHeavyContainer) {
		this.maxHeavyContainer = maxHeavyContainer;
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
	
	
	
}
