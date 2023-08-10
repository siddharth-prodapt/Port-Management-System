
public interface IPort {
	void createPort();
	boolean isPortAvailable(int portId);
	double calcDistance(Port source, Port destination);
	
}
