//Where the scanner comes from
import java.util.*;

//Beginning of program
public class Calculator {
	
	//Main method
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.run();
	}
	
	//Constructor
	public Calculator() {
		
	}
	
	//Top-level methods
	public void run() {
		describeProgram();
		getNumberOne();
		getOperator();
		getNumberTwo();
		compute();
		displayOutput();
		storeMemory();
	}
	
	public void run2() {
		getNumberOne();
		getOperator();
		getNumberTwo();
		compute();
		displayOutput();
		storeMemory();
	}
		
	public void operatorError() {
		getOperator();
		getNumberTwo();
		compute();
		displayOutput();
		storeMemory();
	}

	public void run3() {
		getNumberTwo();
		compute();
		displayOutput();
		storeMemory();
	}
	
	public void run4() {
		storeMemory();
	}
	
		//Describes the program to user
		private void describeProgram() {
			System.out.println("Welcome to Java Calculator 1.0000                                                                     ");
			System.out.println("This is a simple four function calculator with basic memory functions.                                  ");
			System.out.println("Enter a number up to 8 digits long                                                       ");
			System.out.println("followed by one of four operators (+, -, *, /).                                                                ");
			System.out.println("Then enter one more number (again up to 8 digits)                                                              ");
			System.out.println("And the result will be displayed.                                                                              ");
			System.out.println("You can then select whether or not you wish to store your result in memory.                                    ");
			System.out.println("I know what you're thinking, 'this is exciting!'. So let's get started.                                        ");
			System.out.println("                                                                                                               ");
		}
		
		//Declare and initiate variables and scanner
		//Keyboard
		Scanner scanner = new Scanner(System.in);
		//First number input
		Number numberOne = new Number();
		//Second number input
		Number numberTwo = new Number();
		//Result of the calculation
		Number result = new Number();
		//y or n string selecting whether or not to restart the program
		String again = new String();
		//y or n string selecting whether or not to store in memory
		String mem = new String();
		//y or n string selecting whether or not to erase memory
		String erase = new String();
		//y or n string selecting whether or not to erase memory
		String recall = new String();
		//Operator string
		Operation operationOne = new Operation();
		//Memory storage variable
		Memory memoryOne = new Memory();
		
		
		//Receives the user inputs
		//First number selection
		
		private void getNumberOne() {
			try {
			if (memoryOne.memory != 0.0) {
				System.out.println("Would you like to recall memory for your first number? (y=yes, n=no):");
				recall = scanner.next();
			
					if (recall.equalsIgnoreCase("y")) {
						numberOne.number = memoryOne.memory;
						numberOne.numberInt = memoryOne.memoryInt;
				
							if (numberOne.numberInt == numberOne.number) {
								System.out.println(numberOne.numberInt);
							}
					
							else {
								System.out.println(numberOne.number);
							}
					}
					else if (recall.equalsIgnoreCase("n")) {
						System.out.println("Please enter your first number (8 digits or less):");			
						numberOne.number = scanner.nextDouble();
						numberOne.numberInt = (int) numberOne.number;
					}
					
					else {
						System.out.println(recall +" is not a valid input, try again");
						run2();
					}
			}
			
			else {System.out.println("Please enter your first number (8 digits or less):");
				
				numberOne.number = scanner.nextDouble();
				numberOne.numberInt = (int) numberOne.number;
			}
			
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, retry.");
				scanner.next();
				run2();
			}
		}
		
		//Operator selection
		private void getOperator() {
			System.out.println("Please enter operation (+, -, *, /):");
			operationOne.operator = scanner.next();
			
			if (!(operationOne.operator.equals("+")  
				|| operationOne.operator.equals("-")
				|| operationOne.operator.equals("*")
				|| operationOne.operator.equals("/"))) {
				System.out.println("Invalid operator.");
				System.out.println("Seriously....not that hard....oh well...have another go at it");
				operatorError();
			}
		}
		
		//Second number selection
		private void getNumberTwo() {
			try {
			if (memoryOne.memory != 0.0) {
				System.out.println("Would you like to recall memory for your second number? (y=yes, n=no):");
				recall = scanner.next();
				
					if (recall.equalsIgnoreCase("y")) {
						numberTwo.number = memoryOne.memory;
						numberTwo.numberInt = memoryOne.memoryInt;
					
							if (numberTwo.numberInt == numberTwo.number) {
								System.out.println(numberTwo.numberInt);
							}
						
							else {
								System.out.println(numberTwo.number);
							}
					}
					
					else if (recall.equalsIgnoreCase("n")) {
						System.out.println("Please enter your second number (8 digits or less):");			
						numberTwo.number = scanner.nextDouble();
						numberTwo.numberInt = (int) numberTwo.number;
					}
					
					else {
						System.out.println(recall +" is not a valid input, try again");
						run3();
					}
				}
				
			else {System.out.println("Please enter your second number (8 digits or less):");			
				numberTwo.number = scanner.nextDouble();
				numberTwo.numberInt = (int) numberTwo.number;
			}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, retry.");
				scanner.next();
				run3();
			}
		}
		
		//Performs the computation
		private void compute() {
			
			if (operationOne.operator.equals("+")) {
				result.number = numberOne.number+numberTwo.number;
				result.numberInt = (int) result.number;
			}
			
			else if (operationOne.operator.equals ("-")) {
				result.number = numberOne.number-numberTwo.number;
				result.numberInt = (int) result.number;
			}
			
			else if (operationOne.operator.equals ("*")) {
				result.number = numberOne.number*numberTwo.number;
				result.numberInt = (int) result.number;
			}
			
			else if (operationOne.operator.equals ("/")) {
				result.number = numberOne.number/numberTwo.number;
				result.numberInt = (int) result.number;
			}
		}
		
		//Displays output
		private void displayOutput() {
			if ((numberOne.number == numberOne.numberInt)
				&& (numberTwo.number == numberTwo.numberInt)) {
				System.out.print(numberOne.numberInt + " " + operationOne.operator + " " + numberTwo.numberInt + " = ");
			}
			
			else if ((numberOne.number != numberOne.numberInt)
				&& (numberTwo.number == numberTwo.numberInt)) {
				System.out.print(numberOne.number + " " + operationOne.operator + " " + numberTwo.numberInt + " = ");
			}
			
			else if ((numberOne.number == numberOne.numberInt)
					&& (numberTwo.number != numberTwo.numberInt)) {
					System.out.print(numberOne.numberInt + " " + operationOne.operator + " " + numberTwo.number + " = ");
			}
			
			else {
					System.out.print(numberOne.number + " " + operationOne.operator + " " + numberTwo.number + " = ");
			}
			
			if (result.number == result.numberInt) {
			System.out.println(result.numberInt);
			}
			
			else {
			System.out.println(result.number);
			}
		}
		
		//Stores result in memory
		private void storeMemory() {
			//Choice to store results
			if (result.number != 0.0) {
			if (result.number == result.numberInt) {
				System.out.println("Would you like to save " + result.numberInt + " to memory? (y=yes, n=no):");
			}
			
			else {
				System.out.println("Would you like to save " + result.number + " to memory? (y=yes, n=no):");
			}
			
			mem = scanner.next();
			
			if (mem.equalsIgnoreCase("y")) {
				memoryOne.memory = result.number;
				memoryOne.memoryInt = result.numberInt;
				
					if (memoryOne.memoryInt == memoryOne.memory) {
						System.out.println(memoryOne.memoryInt + " is saved to memory.");
					}
				
					else {
						System.out.println(memoryOne.memory + " is saved to memory.");
					}
				restart();
			}

			else if (mem.equalsIgnoreCase("n")) {
				
				if (result.numberInt == result.number) {
					System.out.println(result.numberInt + " not saved to memory.");
				}
			
				else {
					System.out.println(result.number + " not saved to memory.");
				}
				eraseMemory();
			}
			
			else {
				System.out.println(mem +" is not a valid input, try again.");
				run4();
			}
			}
			
			else {
				System.out.println("0 can not be stored to memory");
				restart();
			}
		}
		//Gives the option to erase the memory by setting it to 0.0
		private void eraseMemory() {
			if (memoryOne.memory != 0.0) {
				System.out.println("Erase old memory? (y=yes, n=no):");
				erase = scanner.next();
					
					if (erase.equalsIgnoreCase("y")) {
						memoryOne.eraseMemory(0);
						memoryOne.memoryInt = (int) memoryOne.memory;
						System.out.println("Memory erased and set to " + memoryOne.memory);
						restart();
					}
					
					else if (erase.equalsIgnoreCase("n")) {
						restart();
					}
					
					else {
						System.out.println(erase + " is not a valid input, try again.");
						eraseMemory();
					}
				}
			
			else {
			restart();
			}
		}
		//Gives program restart options and sends user back to inputs
		private void restart() {
			System.out.println("Another computation? (y=yes, n=no):");
			again = scanner.next();
			
			if (again.equalsIgnoreCase("y")) {
				run2();
			}
			
			else if (again.equalsIgnoreCase("n")) {
				System.out.println("Well I guess this is it then.");
				System.out.println("Farewell.");
			}
			
			else {
				System.out.println(again + " is not a valid input, try again.");
				restart();
			}
		}
		
			
	//The classes
	/*
	 * Number class stores the entered double as well as the int value of that double
	 * for comparison for proper output. Methods input and output values of the two numbers
	 */
	public class Number {
		public double number;
		public int numberInt;
		
		private Number() {
			number = 0.0;
			numberInt = 0;
		}
		
		public double getNumber() {	
			return number;
		}
		
		public int getNumberInt() {
			return numberInt;
		}
		
		public void setNumber(double num) {
			 number = num;
		}
		public void setNumberInt(int num) {
			numberInt = num;
		}
	}
	//Operation class stores the operator string and intially sets it to unknown
	public class Operation {
		private String operator;
		
		public Operation() {
			operator = "Unknown";
		}
		
		public String getOperation() {
			return operator;
		}
		
		public void setOperation(String oper) {
			operator = oper;
		}

	}
	/*
	 * Memory class conducts memory functions and stores a double and the int value of that double
	 * There is also functionality for erasing memory and reset it to 0.0 value
	 */
	public class Memory {
		private double memory;
		private int memoryInt;
		
		public Memory() {
			memory = 0.0;
		}
		
		public double getMemory() {
			return memory;
		}
		
		public int getMemoryInt() {
			return memoryInt;
		}
		
		public void setMemory(double mem) {
			memory = mem;
		}
		
		public void setMemoryInt(int num) {
			memoryInt = num;
		}
		
		public void eraseMemory(double mem) {
			memory = 0;
		}
	}
}