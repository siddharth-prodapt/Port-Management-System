
public interface IContainer {
	void createContainer();
	void viewContainerList();
	void loadingContainer();
	void unloadingContainers();
	int findIndexOfContainerOnShip(Ship s, int containerNo);
	Container findContainerOnShip(Ship s, int containerNo);
}
