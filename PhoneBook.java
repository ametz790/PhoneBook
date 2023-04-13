import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
		static Scanner scanner = new Scanner (System.in);
		static File file = new File ("C:\\Users\\peach\\Desktop\\PhoneBook.txt");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char p;
		do {
			Scanner i = new Scanner (System.in);
			System.out.println("What would you like to do? (Enter task number)\n 1- Save Contact \n 2- Search Phone Number \n 3- Delete Contact");
		int choice = i.nextInt();
		i.nextLine();
		
		switch(choice) {
		case 1: Saving();
			break;
		case 2: Searching();
			break;
		case 3: Deleting();
			break;
		default: System.out.println("Please enter correct numerical input.\n 1- Save Contact \n 2- Search for phone numbers \n 3- Delete phone numbers");
		
		
		}
		
		
		System.out.println("Would you like to continue to the main menu? (y/n)");
		p=i.next().charAt(0);
		i.nextLine();
		}
		while (p=='y');}
		
		
		
		
	
	public static void Saving() {
		System.out.println("What is the full name of the person you would like to save? (first name and last name) ");
		String name = scanner.nextLine();
		System.out.println("What is the phone number of the person you are saving? ");
		String phonenum = scanner.nextLine();
		try {
			file.createNewFile();
			Scanner scanner1 = new Scanner (file);
			PrintWriter pwriter = new PrintWriter(new FileWriter(file,true));
			pwriter.println(name+" : "+phonenum);
			pwriter.close();}

		catch(Exception IOException) {
			IOException.printStackTrace();}
		
		System.out.println("Contact of "+name+": "+phonenum+" is saved.");}
		
	public static void Searching() {
		System.out.println("What is the full name of the person you would like to search? (First name and last name) ");
		String name = scanner.nextLine();
		boolean numberfound=false;
		String l;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((l=br.readLine())!=null) {
				String [] words=l.split(" : ");
				if (words[0].equalsIgnoreCase(name)){
						System.out.println("The phone number for the person you have searched is: "+words[1]+".");
						numberfound=true;}
				}
			}
		catch (IOException e) {
				e.printStackTrace();}
			if (numberfound==false) {
				System.out.println("The name you entered is not available.");}
			}
			
	public static void Deleting() {
	    System.out.println("What is the name of the person whose number you would like to delete? (First name and last name) ");
	    String name = scanner.nextLine();
	    boolean numberfound = false;
	    String l;
	    try {
	        BufferedReader bf = new BufferedReader(new FileReader(file));
	        ArrayList<String> ar = new ArrayList<String>();
	        while ((l = bf.readLine()) != null) {
	            ar.add(l);
	        }
	        PrintWriter pw = new PrintWriter(file);
	        String[] words;
	        for (int i = 0; i < ar.size(); i++) {
	            words = ar.get(i).split(" : ");
	            if (words[0].equalsIgnoreCase(name)) {
	                System.out.println("The contact you are deleting is: " + words[0] + ".");
	                numberfound = true;
	                System.out.println("...");
	                System.out.println("Contact Deleted.");
	                continue;
	            } else {
	                pw.println(ar.get(i));
	            }
	        }
	        pw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    if (numberfound == false) {
	        System.out.println("The name you entered is not available.");
	    }
	}
}
