import java.util.ArrayList;

public class Port {
	static private int pk=0;
	private double x;
	private double y;
	int portId;
	ArrayList<Integer> inventoryContainersList = new ArrayList<Integer>();
	
	Port(double x, double y){
		this.portId = ++pk;
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public int getPortId() {
		return portId;
	}
}
