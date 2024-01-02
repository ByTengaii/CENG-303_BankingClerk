import java.util.ArrayList;
import java.util.Scanner;

import Modules.*;
import controllers.Calculation;// For random number generation
// ... potentially more libraries for optimization algorithms


public class BankClerk {
	public static void main(String[] args) {
		
		//Creating Shifts
		ArrayList<WorkShift> shiftList= new ArrayList<>();
		shiftList.add(WorkShift.toParse("morning",8, 13));
		//shiftList.add(WorkShift.toParse("afternoon",13, 18));
		//shiftList.add(WorkShift.toParse("evening",18, 23));

		TimeCheck.computeTime();

		Scanner scanner = new Scanner(System.in);
		//for(int i = 0; i < shiftList.size() ; i++)
		for(int i = 0; i < 1 ; i++)
		{
			int tempIntReader;
			ArrayList<Unit> unitList = new ArrayList<>();
			
			//Getting Units & Max Waiting Time
			System.out.print("Enter Max waiting time of Commercials for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("commercial",tempIntReader, tempIntReader));
			/*System.out.print("Enter Max waiting time for Loans for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("loan",tempIntReader, tempIntReader));
			System.out.print("Enter Max waiting time for Casuals for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("casual",tempIntReader, tempIntReader));*/
			//Getting customers of Unit
			//for(int j = 0; j < unitList.size(); j++)
			for(int j = 0; j < 1; j++)
			{
				System.out.print("Enter number of customers for "+ unitList.get(j).getName()+" shift:\n");
				int numberOfCustomers = scanner.nextInt();
				System.out.print("Enter service time of customers for "+ unitList.get(j).getName()+" shift:\n");
				int serviceTime = scanner.nextInt();
				System.out.println("Enter arrive time (Hour:Minute) of customers for " + unitList.get(j).getName() + " shift:");
				String arrivedTime = scanner.next();
				unitList.get(j).setCustomers(Customer.createCustomers(unitList.get(j).getName(), numberOfCustomers, serviceTime, arrivedTime));
			}
			// Adding UnitList to WorkShift
			shiftList.get(i).setUnitList(unitList);	
			unitList = null;
		}
		scanner.close();

		for(int i = 0; i < shiftList.size(); i++){
			System.out.println("workshift: " + shiftList.get(i).getName());
			System.out.println("----------------------------");
			for(int j = 0; j < shiftList.get(i).getUnitList().size(); j++){
				System.out.println("unit name: " + shiftList.get(i).getUnitList().get(j).getName());
				System.out.println("bu unit icin: " + shiftList.get(i).getUnitList().get(j).getCustomers().size() + " tane musteri vardir."
				+ "musterilerin bekleme suresi: " + shiftList.get(i).getUnitList().get(j).getCustomers().get(0).getServiceTime());
				System.out.println("musterilerin varis zamani: " + shiftList.get(i).getUnitList().get(j).getCustomers().get(0).getArrivedTime() );
			}
			System.out.println();
		}

		Calculation.calculateClerksHeuristic(shiftList);
		
		//Example reaching
		//shiftList.get(0).getUnitList().get(2).getClerk(); // Taking number of morning clerks for casuals
		
		// TO-DO: Output Schema

	}
}
