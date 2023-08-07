import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
//		input and output to the file
		
//		File file = new File("C:\\Users\\siddharth.sp\\Desktop\\Prodapt-Training\\Ship&PortManagement\\src\\test.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		
//		String str;
//		
//		while((str = br.readLine()) != null) {
//			System.out.println(str);
//		}
		
		Scanner sc = new Scanner(System.in);
		
		int option = -1;
		do {
			System.out.println("1. Create Container\n2. Create Ship\n3. Create Port\n4. Loading a container \n5. Unloading the container"
					+ "\n6. Ship sails to another port\n7. Ship is refueled\n8. Exit\n9. View Ship Details");
			
			System.out.print("Select Option: ");
			option = sc.nextInt();
			
			ShipAndPortManagement spm = new ShipAndPortManagement();
			
			switch(option) {
			case 1: spm.createContainer();
			break;
			case 2: spm.createShip();
			break;
			case 3: spm.createPort();
			break;
			case 4: spm.loadingContainer();
			break;
			case 9: spm.displayShipDetails();
			default:
				System.out.println("Try Again with correct input");
			}
			
		}while(option != 8);
		System.out.println("Exit....");
	}

}
