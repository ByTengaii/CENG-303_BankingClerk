package Modules;
import java.time.LocalTime;


public class TimeCheck {
    public static void computeTime(){
        LocalTime startTime = LocalTime.of(8, 0, 0);
        int serviceTime = 5;
        LocalTime endTime = startTime.plusMinutes(serviceTime);
        System.out.println(endTime);
    }    
}
