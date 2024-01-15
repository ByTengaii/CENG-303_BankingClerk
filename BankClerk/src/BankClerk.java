import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Modules.*;
import controllers.Calculation;


public class BankClerk {
	static int randomHour;
	static int randomMinute;
	public static void main(String[] args) {
	
		int[] unitServiceTime = {10, 15, 20};
		
		//Creating Shifts
		ArrayList<WorkShift> shiftList= new ArrayList<>();
		shiftList.add(WorkShift.toParse("morning",LocalTime.of(8, 0), LocalTime.of(13, 0)));
		shiftList.add(WorkShift.toParse("afternoon",LocalTime.of(13, 0), LocalTime.of(18, 0)));
		shiftList.add(WorkShift.toParse("evening",LocalTime.of(18, 0), LocalTime.of(23, 0)));

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
		
		int waitingTimes[] = new int[3];		
		System.out.println("Enter max waiting times of Commercial - Loan - Casual");
		waitingTimes[0] = scanner.nextInt();
		waitingTimes[1] = scanner.nextInt();
		waitingTimes[2] = scanner.nextInt();
		while(waitingTimes[0] >= waitingTimes[1] || waitingTimes[0] >= waitingTimes[2]){
			System.out.println("Select Commercial's max waiting time to be shorter than others!!");
			System.out.println("Enter max waiting times of Commercial - Loan - Casual");
			waitingTimes[0] = scanner.nextInt();
			waitingTimes[1] = scanner.nextInt();
			waitingTimes[2] = scanner.nextInt();
		}

		for(int i = 0; i < shiftList.size() ; i++)
		{
			ArrayList<Unit> unitList = new ArrayList<>();

			unitList.add(Unit.toParse("commercial",waitingTimes[0], unitServiceTime[0]));
			unitList.add(Unit.toParse("loan",waitingTimes[1], unitServiceTime[1]));
			unitList.add(Unit.toParse("casual",waitingTimes[2], unitServiceTime[2]));

			int numCustomer[] = new int[3];

			System.out.println("------- For " + shiftList.get(i).getName() + " ---------");
			System.out.println("Enter number of customer for Commercial - Loan - Casual");
			numCustomer[0] = scanner.nextInt();
			numCustomer[1] = scanner.nextInt();
			numCustomer[2] = scanner.nextInt();

			for(int j = 0; j < unitList.size(); j++)
			{
				int numberOfCustomers = numCustomer[j];
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
					int hourCheck = shiftList.get(i).getEndTime().getHour();
					if(randomHour == (hourCheck - 1)){
						randomMinute = random.nextInt(59 - (unitList.get(j).getserviceTime() + unitList.get(j).getMaxWaitingTime()));	
					}else{
						randomMinute = random.nextInt(59);
					}
						
					String arrivedTime = Integer.toString(randomHour)+":"+Integer.toString(randomMinute); 
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

		//shiftList.size()
		for(int i = 0; i < shiftList.size(); i++){
			System.out.println("\n----------------------------");
			System.out.println("workshift: " + shiftList.get(i).getName());
			System.out.println("----------------------------");
			for(int j = 0; j < shiftList.get(i).getUnitList().size(); j++){
				System.out.println("\nUnit Name: " + shiftList.get(i).getUnitList().get(j).getName());
				System.out.println("Number of customer for this unit: " + shiftList.get(i).getUnitList().get(j).getCustomers().size()
				+ "\nMax Waiting time for this unit: " + shiftList.get(i).getUnitList().get(j).getMaxWaitingTime() + 
				"\nService time for this unit: " + shiftList.get(i).getUnitList().get(j).getserviceTime());
				System.out.println("Arrival time of customers:");
				for(int k = 0; k<shiftList.get(i).getUnitList().get(j).getCustomers().size(); k++){
					System.out.print(shiftList.get(i).getUnitList().get(j).getCustomers().get(k).getArrivedTime() + " ");
				}
				System.out.println("\n");	
			}
		}

		Calculation.calculateClerk(shiftList);
		
	}
}
