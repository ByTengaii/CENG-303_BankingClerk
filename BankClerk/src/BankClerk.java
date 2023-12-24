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
		shiftList.add(WorkShift.toParse("afternoon",13, 18));
		shiftList.add(WorkShift.toParse("evening",18, 23));

		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < shiftList.size() ; i++)
		{
			int tempIntReader;
			ArrayList<Unit> unitList = new ArrayList<>();
			
			//Getting Units & Max Waiting Time
			System.out.print("Enter Max waiting time of Commercials for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("commercial",tempIntReader, tempIntReader));
			System.out.print("Enter Max waiting time for Loans for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("loan",tempIntReader, tempIntReader));
			System.out.print("Enter Max waiting time for Casuals for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("casual",tempIntReader, tempIntReader));
			
			//Getting customers of Unit
			for(int j = 0; j < unitList.size(); i++)
			{
				System.out.print("Enter number of customers for "+ unitList.get(i).getName()+" shift:\n");
				int numberOfCustomers = scanner.nextInt();
				System.out.print("Enter avg service time of customers for "+ unitList.get(i).getName()+" shift:\n");
				int serviceTime = scanner.nextInt();
				unitList.get(i).setCustomers(Customer.createCustomers(unitList.get(i).getName(), numberOfCustomers, serviceTime));
			}
			
			// Adding UnitList to WorkShift
			shiftList.get(i).setUnitList(unitList);	
			unitList = null;
		}
		scanner.close();

		Calculation.calculateClerksHeuristic(shiftList);
		
		//Example reaching
		shiftList.get(0).getUnitList().get(2).getClerk(); // Taking number of morning clerks for casuals
		
		// TO-DO: Output Schema

	}
}
