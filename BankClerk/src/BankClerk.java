import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Modules.*;
import controllers.Calculation;// For random number generation
// ... potentially more libraries for optimization algorithms


public class BankClerk {
	
	public static void main(String[] args) {
	
		int[] unitServiceTime = {25,7,9};
		
		//Creating Shifts
		ArrayList<WorkShift> shiftList= new ArrayList<>();
		shiftList.add(WorkShift.toParse("morning",LocalTime.of(8, 0), LocalTime.of(13, 0)));
		//shiftList.add(WorkShift.toParse("afternoon",13, 18));
		//shiftList.add(WorkShift.toParse("evening",18, 23));

		//TimeCheck.computeTime();

		Scanner scanner = new Scanner(System.in);

		//System.out.print("Enter number of customers for morning shift:");
		//int numOfCustomer = scanner.nextInt();

		/*
		 * When generating a random arrival time, 
		 * it gives incorrect results in cases 
		 * where the shift time is not the exact time. This should be fixed
		 */
		Random random = new Random();
		int morningStart = shiftList.get(0).getStartTime().getHour();
		int morningEnd = shiftList.get(0).getEndTime().getHour();
		


		//for(int i = 0; i < shiftList.size() ; i++)
		for(int i = 0; i < shiftList.size() ; i++)
		{
			int tempIntReader;
			ArrayList<Unit> unitList = new ArrayList<>();
			
			//Getting Units & Max Waiting Time
			System.out.print("Enter Max waiting time of Commercials for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("commercial",tempIntReader, unitServiceTime[0]));

			/*System.out.print("Enter Max waiting time for Loans for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("loan",tempIntReader, unitServiceTime[1]));

			System.out.print("Enter Max waiting time for Casuals for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("casual",tempIntReader, unitServiceTime[2]));*/
			//Getting customers of Unit
			//for(int j = 0; j < unitList.size(); j++)
			for(int j = 0; j < unitList.size(); j++)
			{
				System.out.print("Enter number of customers for "+ unitList.get(j).getName()+" shift:\n");
				int numberOfCustomers = scanner.nextInt();
				//System.out.print("Enter service time of customers for "+ unitList.get(j).getName()+" shift:\n");
				//int serviceTime = scanner.nextInt();
				ArrayList<Customer> tempCustomer = new ArrayList<>();
				for(int k = 0; k<numberOfCustomers; k++){
					int randomHour = random.nextInt(morningEnd-morningStart)+morningStart;
					int randomMinute = random.nextInt(59);
					String arrivedTime = Integer.toString(randomHour)+":"+Integer.toString(randomMinute); 
					//unitList.get(j).setCustomers(Customer.createCustomers(unitList.get(j).getName(), numberOfCustomers, unitServiceTime[0], arrivedTime));
					tempCustomer.add(Customer.toParse(unitList.get(j).getName(), arrivedTime));
					
				}
				
				unitList.get(j).setCustomers(tempCustomer);
				unitList.get(j).sortCustomer();
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
				+ "bu unit icin max bekleme suresi: " + shiftList.get(i).getUnitList().get(j).getMaxWaitingTime() + 
				" - bu unit icin servis suresi: " + shiftList.get(i).getUnitList().get(j).getserviceTime());
				for(int k = 0; k<shiftList.get(i).getUnitList().get(j).getCustomers().size(); k++)
					System.out.println("musterilerin varis zamani: " + shiftList.get(i).getUnitList().get(j).getCustomers().get(k).getArrivedTime() );
			}
			System.out.println();
		}

		//Calculation.calculateClerksHeuristic(shiftList);
		Calculation.calculateClerk(shiftList);
		/* 
		LocalTime time1 = LocalTime.of(11, 23);
		System.out.println("time1: "+time1);
		LocalTime addedTime = Calculation.increaseTime(time1);
		System.out.println("after added 1 minute: " + addedTime);
		LocalTime time2 = LocalTime.of(9, 50);
		System.out.println("time2: " + time2);
		LocalTime diffMinutesTwoTime = Calculation.diffTime(time1, time2);
		System.out.println("difference of time1: " + time1 +" and time2: " + time2 +" = " + diffMinutesTwoTime);
		*/

		//Example reaching
		//shiftList.get(0).getUnitList().get(2).getClerk(); // Taking number of morning clerks for casuals
		
		// TO-DO: Output Schema

	}
}
