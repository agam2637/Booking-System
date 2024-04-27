import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.Random;

public class BookingSystemWithAlgorithms {
	
	static Scanner input = new Scanner(System.in);
	static Random random = new Random();
	static BufferedWriter writeFile;
	static BufferedReader readFile;
	
	
	public static void main(String[] args) throws IOException {
		//state the arrays that are to be used
		String [] names = new String [12];
		String [] times = new String [12];
		
		
		times[0]="6:00-6:10";
		times[1]="6:10-6:20";
		times[2]="6:20-6:30";
		times[3]="6:30-6:40";
		times[4]="6:40-6:50";
		times[5]="6:50-7:00";
		times[6]="7:00-7:10";
		times[7]="7:10-7:20";
		times[8]="7:20-7:30";
		times[9]="7:30-7:40";
		times[10]="7:40-7:50";
		times[11]="7:50-8:00";
		
		//ask the teacher number and what they want to do
		System.out.println("What Teacher # are you?");
		int teacherNum = input.nextInt();
		
		//validate the number and ask what to do with the name list
		validateTeacherNum(names,teacherNum);
		askInputType(names);
		
	
		//output the list 
		output(names,times);
			
		//write the full schedule to file
		if(teacherNum==1) {
			writeToFileOne(names,times);
		}
		else if (teacherNum==2) {
			writeToFileTwo(names,times);
		}
		else if (teacherNum==3) {
			writeToFileThree(names,times);
		}
		else if (teacherNum==4) {
			writeToFileFour(names,times);
		}
		
	
		//ask if the user wants to search for specific name 
		
		System.out.println("Would you like to search for a name? ");
		String response = input.next();
		
		if (response.equalsIgnoreCase("Yes")) {
			searchForName(names);
		}
		else if (response.equalsIgnoreCase("No")) {
			System.out.println("Thanks For Using");
			System.exit(0);
		}
		else {
			System.out.println("Invalid response. Please Repeat Process");
			System.exit(0);
		}
	
	}//main
	
	public static void validateTeacherNum (String [] names,int teacherNum) throws IOException {
				//validate input and call appropriate method
		
		
				if(teacherNum==1) {
					readFileOne(names);
				}//if
				else if (teacherNum==2) {
					readFileTwo(names);
				}//else if
				else if (teacherNum==3) {
					readFileThree(names);
				}//else if
				else if (teacherNum==4) {
					readFileFour(names);
				}//else if
				else {
					System.out.println("Not Valid Teacher Num");
					System.exit(0);
				}//else
				
					}//validateTeacherNum
	
	public static void askInputType (String [] names) {
		//Asks the user what they would like to do to the data that is read
		
		System.out.println("Would you like to shuffle or sort the names");
		String answer = input.next();
		
		if (answer.equalsIgnoreCase("Shuffle")) {
			shuffleNames(names);
		}//if
		else if (answer.equalsIgnoreCase("Sort")) {
			sortNames(names);
		}//else if
		else {
			System.out.println("Not Valid response");
			System.exit(0);
		}//else
	}//askInputType
	
	public static String [] readFileOne (String [] names) throws IOException{
		//read teacher one class names
		
		
readFile = new BufferedReader(new FileReader("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 1 Appointment Times.txt"));
	
		for(int index = 0;index<names.length;index++) {
			names[index] = readFile.readLine();
		}//for
		
		readFile.close();//end of the reading
		return names;
		
		
	}//readFileOne
	
public static String [] readFileTwo (String [] names) throws IOException{
	//read teacher two class names
		
		
readFile = new BufferedReader(new FileReader("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 2 Schedule .txt"));
	
		for(int index = 0;index<names.length;index++) {
			names[index] = readFile.readLine();
		}//for
		
		readFile.close();//end of the reading
		return names;
		
		
	}//readFileTwo

public static String [] readFileThree (String [] names) throws IOException{
	//read teacher three class names
	
	
readFile = new BufferedReader(new FileReader("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 3 Scehdule .txt"));

	for(int index = 0;index<names.length;index++) {
		names[index] = readFile.readLine();
	}//for
	
	readFile.close();//end of the reading
	return names;
	
	
}//readFileThree

public static String [] readFileFour (String [] names) throws IOException{
	//read teacher four class names
	
	
readFile = new BufferedReader(new FileReader("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 4 Schedule .txt"));

	for(int index = 0;index<names.length;index++) {
		names[index] = readFile.readLine();
	}//for
	
	readFile.close();//end of the reading
	return names;

}//readFileFour
	
	
	public static String [] sortNames (String [] names) {
		//Sort the names in alphabetical order using insertion sort for strings 
		
		        //insertion sort for strings
		       
		    	 for (int index = 1 ; index < names.length ; index++)
		         {
		             String item = names [index];
		             int toPlace = index;
		             while (toPlace > 0 && item.compareTo(names [toPlace - 1])<0)
		             {
		                 names [toPlace] = names [toPlace - 1];
		                 toPlace--;
		             }//while
		             names [toPlace] = item;
		          }//for index
		    
		    	
		   return names;
		
	}//sortNames
	
	public static String [] shuffleNames (String [] names) {
		//shuffle names randomly using the shuffle algorithm
		
		int lengthString = names.length;
		
		for(int i=0;i<names.length;i++) {
			int indexOne=i;
			int indexTwo = random.nextInt(lengthString);
			
			String indexHolder = names[indexOne];
			
			names[indexOne]=names[indexTwo];
			names[indexTwo]=indexHolder;
		}
		return names;
	}//shuffleNames
    
	public static void output (String [] names,String [] times) {
		//output names and times 
		for(int index = 0;index<names.length;index++) {
			System.out.println(names[index] + ":"+times[index]);
		}//for
		
		
		
	}//output
	
	public static void writeToFileOne (String [] names,String [] times) throws IOException {
		//write to the file of teacher one
		
		writeFile = new BufferedWriter(new FileWriter("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 1 Appointment Times.txt"));
		
	
		for(int index = 0;index<names.length;index++) {
			writeFile.write(names[index]+ ":" + times[index]);
			writeFile.newLine();
		}//for
		
		writeFile.close();
	}//writeToFileOne
	
	public static void writeToFileTwo (String [] names,String [] times) throws IOException {
		//write to the file of teacher two 
		
		writeFile = new BufferedWriter(new FileWriter("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 2 Schedule.txt"));
		
		
		for(int index = 0;index<names.length;index++) {
			writeFile.write(names[index]+ ":" + times[index]);
			writeFile.newLine();
		}//for
		
		writeFile.close();
	}//writeToFileTwo

	public static void writeToFileThree (String [] names, String [] times) throws IOException {
		//write to the file of teacher three 
		
writeFile = new BufferedWriter(new FileWriter("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 3 Scehdule.txt"));
		
		
		for(int index = 0;index<names.length;index++) {
			writeFile.write(names[index]+ ":" + times[index]);
			writeFile.newLine();
		}//for
		
		writeFile.close();
}//writeToFileThree

	public static void writeToFileFour (String [] names, String [] times) throws IOException {
		//write to the file of teacher four 
		
		
writeFile = new BufferedWriter(new FileWriter("/Users/AgamjotNijjar/eclipse-workspace/Grade 12 Porgramming/src/Teacher 4 Schedule.txt"));
		
		
		for(int index = 0;index<names.length;index++) {
			writeFile.write(names[index]+ ":" + times[index]);
			writeFile.newLine();
		}//for
		
		writeFile.close();
}//writeToFileFour
	
	 public static void searchForName (String [] names) {
	    // the user can search for any name that they like and the program will them which line
		 
		 System.out.println("What Name Would You Like Searched?");
		 String searchName = input.next();
		 
		 
	    	String searchValue = searchName;
	    
	    		int place = -1; 
	    		for (int i = 0; i < names.length; i++) {
	    		if (names[i].equalsIgnoreCase(searchValue)) {
	    			place = i; 
	    		}
	    		}
	    		
	    		System.out.println(place+1);
	    	
	    }//searchForName
 
}//BookingSystemWithAlgorithms