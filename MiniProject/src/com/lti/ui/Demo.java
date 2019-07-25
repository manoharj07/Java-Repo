
package com.lti.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Minister;
import com.lti.service.MinisterService;
import com.lti.service.MinisterServiceImp;

public class Demo {
	public static void main(String[] args) {
		MinisterService s = new MinisterServiceImp();
		boolean exit_flag=true;
		while(exit_flag) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("SELECT OPTION : ");
			System.out.println("------------------------------------------------------");
			System.out.println("1. Insert new chief minister details");
			System.out.println("2. Display all chief minister details");
			System.out.println("3. Display chief minister details whose name starts with K");
			System.out.println("4. Update chief minister end date");
			System.out.println("5. Delete records");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------------------");
			
			int ch = sc.nextInt();
			switch(ch) {
				case 1://a. Insert Minister
					System.out.println("Insert ID : ");
					int id = sc.nextInt();
					System.out.println("Insert Name : ");
					String name = sc.next();
					System.out.println("Insert State : ");
					String state = sc.next();
					System.out.println("Insert Qualification : ");
					String qual = sc.next();
					System.out.println("Insert Date (dd mm yy) : ");
					int dd = sc.nextInt();
					int mm = sc.nextInt();
					int yy = sc.nextInt();
					LocalDate d = LocalDate.of(yy, mm, dd);
					System.out.println("Insert Party : ");
					String party = sc.next();
					
					Minister m = new Minister(id,name,state,qual,d,party);
					s.addMinister(m);
					break;
				case 2://display all
					List<Minister> mlist = s.displayAll();
					for(Minister i:mlist) System.out.println(i);
					break;
				case 3://display all with k
					List<Minister> mklist = s.displayWithK();
					for(Minister i:mklist) System.out.println(i);
					break;
				case 4://update end date by aid
					System.out.println("Insert ID : ");
					int idd = sc.nextInt();
					System.out.println("Insert Date (dd mm yy) : ");
					int ddd = sc.nextInt();
					int mmm = sc.nextInt();
					int yyy = sc.nextInt();
					LocalDate dddd = LocalDate.of(yyy, mmm, ddd);
					s.update(idd,dddd);
				
					break;
				case 5://delete by state
					System.out.println("Insert State : ");
					String statee = sc.next();
					s.delete(statee);
					break;
				case 6:
					exit_flag=false;
					break;
			}
		}
	}

}
 