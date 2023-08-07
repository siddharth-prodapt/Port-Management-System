
class Container {
	static private int pk = 0;
	private int id ;
	private int portId;
	private int weight;
	private StringBuffer type;
	
	
	
	Container(int portId, int weight, StringBuffer type){
		this.id = ++pk;
		this.portId = portId;
		this.weight = weight;
		this.type   = type;
	}
	
	
	void setContainerType() {
		if(this.weight <= 3000) {
			this.setType(new StringBuffer("B"));
		}
		else {
			this.setType(new StringBuffer("H"));
		}
	}

	public int getPortId() {
		return portId;
	}

	public void setPortId(int portId) {
		this.portId = portId;

	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public StringBuffer getType() {
		return type;
	}

	public void setType(StringBuffer type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
}
