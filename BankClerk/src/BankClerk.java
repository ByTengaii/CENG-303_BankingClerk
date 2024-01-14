import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Modules.*;
import controllers.Calculation;// For random number generation
// ... potentially more libraries for optimization algorithms


public class BankClerk {
	static int randomHour;
	public static void main(String[] args) {
	
		int[] unitServiceTime = {25,7,9};
		
		
		//Creating Shifts
		ArrayList<WorkShift> shiftList= new ArrayList<>();
		shiftList.add(WorkShift.toParse("morning",LocalTime.of(8, 0), LocalTime.of(13, 0)));
		shiftList.add(WorkShift.toParse("afternoon",LocalTime.of(13, 0), LocalTime.of(18, 0)));
		shiftList.add(WorkShift.toParse("evening",LocalTime.of(18, 0), LocalTime.of(23, 0)));

		//TimeCheck.computeTime();

		Scanner scanner = new Scanner(System.in);

		/*
		 * When generating a random arrival time, 
		 * it gives incorrect results in cases 
		 * where the shift time is not the exact time. This should be fixed
		 */
		Random random = new Random();
		int morningStart = shiftList.get(0).getStartTime().getHour();
		int morningEnd = shiftList.get(0).getEndTime().getHour();
		int afternoonStart = shiftList.get(1).getStartTime().getHour();
		int afternoonEnd = shiftList.get(1).getEndTime().getHour();
		int eveningStart = shiftList.get(2).getStartTime().getHour();
		int eveningEnd = shiftList.get(2).getEndTime().getHour();
		


		//for(int i = 0; i < shiftList.size() ; i++)
		for(int i = 0; i < shiftList.size() ; i++)
		{
			int tempIntReader;
			ArrayList<Unit> unitList = new ArrayList<>();
			
			//Getting Units & Max Waiting Time
			System.out.print("Enter Max waiting time of Commercials for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("commercial",tempIntReader, unitServiceTime[0]));

			System.out.print("Enter Max waiting time for Loans for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("loan",tempIntReader, unitServiceTime[1]));

			System.out.print("Enter Max waiting time for Casuals for "+ shiftList.get(i).getName()+" shift:\n");
			tempIntReader = scanner.nextInt();
			unitList.add(Unit.toParse("casual",tempIntReader, unitServiceTime[2]));
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
					if(i==0){
						randomHour = random.nextInt(morningEnd-morningStart)+morningStart;
					}
					else if(i ==1){
						randomHour = random.nextInt(afternoonEnd - afternoonStart)+afternoonStart;
					}
					else if(i == 2){
						randomHour = random.nextInt(eveningEnd - eveningStart)+eveningStart;
					}
					
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

		Calculation.calculateClerk(shiftList);
		
	}
}
