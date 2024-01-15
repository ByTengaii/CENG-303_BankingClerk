# CENG-303_BankingClerk
## Taha Yasin Kuvan - 20050111048 - ysnkvn
## Çağrı Çal - 21050161005 - cagrical
## Mehmet Duman - 20050111005 - Axsens
## Gürkan AĞIR - 20050111073
---------------------------
HOW DOES IT WORK
---------------------------

To run this code, the java version must be 21 for the jar file to work. The project also works with previous versions, but if it does not work, it is recommended to update the java version. To run the project, the command "java -jar TermProject.jar". First of all, the program takes the maximum waiting time for each unit from the user as a parameter. Then, for each shift, it gets how many customers will come to each unit as input. Customers are given random arrival times for workshift hours suitable for each customer. Here, when customers' arrival time at the bank is randomly assigned, the end time of the shift is taken into account. Therefore, the total of service time and max waiting time should not be more than 1 hour. (For example, if 20 minutes of service time is assigned, a maximum of 39 minutes should be given as max waiting time input.) The program initially finds the minimum number of clerks according to the service times and maximum waiting times of the given units and gives it as output for each unit. Please note that the parameters are given for each unit as follows.
---------------------------

Example of output
----------------------

Enter max waiting times of Commercial - Loan - Casual
10 12 13
------- For morning ---------
Enter number of customer for Commercial - Loan - Casual
10 12 13
------- For afternoon ---------
Enter number of customer for Commercial - Loan - Casual
10 14 15
------- For evening ---------
Enter number of customer for Commercial - Loan - Casual
10 22 45

----------------------------
workshift: morning
----------------------------

Unit Name: commercial
Number of customer for this unit: 10
Max Waiting time for this unit: 10
Service time for this unit: 10
Arrival time of customers:
08:25 09:11 09:33 09:58 10:22 11:07 11:30 11:31 12:04 12:19 

.
.
.


-----------------
For morning Shift
-----------------

For commercial:
Number of customer arrived the unit: 10
Minimum clerk for unit: 1

For loan:
Number of customer arrived the unit: 12
Minimum clerk for unit: 3

For casual:
Number of customer arrived the unit: 13
Minimum clerk for unit: 4
-----------------

-----------------------------------
Taha Yasin Kuvan - 20050111048
Çağrı Çal - 21050161005
Mehmet Duman - 20050111005
Gürkan Ağır - 20050111073
