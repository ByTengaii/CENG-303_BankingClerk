package controllers;

import java.util.ArrayList;
import Modules.*;
public class Calculation {
	
	// TO-DO: Integrate service time calculation.
	public static void calculateClerksHeuristic(ArrayList<WorkShift> shiftList) {
	    for (WorkShift shift : shiftList) {
	        for (Unit unit : shift.getUnitList()) {
		            int clerksForUnit = (int) Math.ceil(shift.getWorkMinuteTime()/ (unit.getTotalServiceTime()));
		            unit.setClerk(clerksForUnit);
	        }
	    }
	}

}
