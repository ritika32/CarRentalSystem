# CarRentalSystem
CAR RENTAL SYSTEM:
Requirements of the Car Rental System:
1.	User should be able to book a car using startDate and endDate
2.	Users should be able to book a car using startDate and the number of days
3.	Multiple users cannot book the same car  for the same dates
4.	User can cancel a booking
5.	Receptionist can add new cars to inventory
6.	Customers cannot add new cars to the inventory
7.	Both receptionist and customers can book cars
8.	Car has car types(used as enum) and it limits the number of types of car
Use Case Diagram:
There are 4 main actors:
Receptionist: Receptionist can book a car as well as add new cars to the carInventory list
Members: Users can book a car and add it to reservations list but they cannot add new cars in the carInventory list
System: Responsible for sending notifications of successfully booking and no cars available and booking is canceled
Use cases:
1.	Add/Update cars, whenever a new car is added or a car is out for servicing 
2.	Search for a car based start and end date
3.	Search for a car based start date and number of days for booking
4.	Confirm a car and book it
5.	Cancel existing reservation
6.	Return an error if booking does not exist


UML Diagram:
 
UML added as pdf

Steps to run the program:
1.	Download the file
2.	Unzip file
3.	Open project in Intellij
4.	Go to -> Project Structure
5.	In Project Settings go to project structure
6.	Click on “+” sign to add new jar file
7.	Go to the project in folder carreservaionsystemCRDapp\libs\joda-time-2.10.1.jar
8.	Click on apply and wait for the maven project to build 
9.	Run the test folder tests to see the output

