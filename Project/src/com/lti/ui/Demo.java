package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import com.lti.bean.College;
import com.lti.service.CollegeService;
import com.lti.service.CollegeServiceImp;

public class Demo {

	public static void main(String[] args) {

		CollegeService s = new CollegeServiceImp();
		boolean exit_flag=true;
		while(exit_flag) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("SELECT OPTION : ");
			System.out.println("------------------------------------------------------");
			System.out.println("1. Insert new college details");
			System.out.println("2. Display colleges in Mumbai who teach Engg");
			System.out.println("3. Display all colleges");
			System.out.println("4. Update college fees");
			System.out.println("5. Delete college");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------------------");
			
			int ch = sc.nextInt();
			switch(ch) {
				case 1:
					//a - insert all details
					System.out.println("Insert College ID : ");
					int id = sc.nextInt();
					System.out.println("Insert College Name : ");
					String name = sc.next();
					System.out.println("Insert College Type : ");
					String course = sc.next();
					System.out.println("Insert City : ");
					String city = sc.next();
					System.out.println("Insert Fees : ");
					double fees = sc.nextInt();
					System.out.println("Insert Pincode : ");
					int pincode = sc.nextInt();
					
					College c = new College(id,name,course,city,fees,pincode);
					s.addCollege(c);
					break;
				case 2:
					//b - display colleges in mumbai who teach engg
					List<College> clist = s.collegesInMumbaiEngg();
					for(College i:clist) System.out.println(i);
					break;
				case 3:
					//c - display all colleges
					List<College> cklist = s.displayAllColleges();
					for(College i:cklist) System.out.println(i);
					break;
				case 4:
					//d - update course fees by name
					System.out.println("Insert Name : ");
					String name_2 = sc.next();
					System.out.println("Insert New Fees : ");
					double new_fees = sc.nextDouble();
					s.changeCollegeFees(name_2,new_fees);		
					break;
				case 5:
					//e- delete college by id
					System.out.println("Insert College ID : ");
					int id_2 = sc.nextInt();
					s.removeCollege(id_2);
					break;
				case 6:
					exit_flag=false;
					break;
			}
		}
	}

}
