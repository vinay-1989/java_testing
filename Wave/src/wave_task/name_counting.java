package wave_task;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class name_counting {

	public static void main(String[] args) {
		String name, orgvalue;
		char c = 0 ,alphabet= 0;
		int count_upper=65;
		int count_lower=97;
		String[] uppercase=new String[26];
		String[] lowercase=new String[26];
		
		for(int i=0; i<uppercase.length;i++) {	
			alphabet= (char)count_upper;
			String s=Character.toString(alphabet);
			uppercase[i]=s;
			count_upper++;			
		}
		for(int i=0; i<lowercase.length;i++) {	
			alphabet= (char)count_lower;
			String s=Character.toString(alphabet);
			lowercase[i]=s;	
			count_lower++;
		}

		Scanner scan=new Scanner(System.in);
		System.out.println("please enter your name");
		name=scan.next();
		Integer []ir=new Integer[name.length()];	
		for(int z=0; z<name.length();z++) {
			c=name.charAt(z);
			orgvalue=Character.toString(c);
			if(Character.isUpperCase(c)) {
				// Convert String Array to List
				List<String> list = Arrays.asList(uppercase);			
				ir[z]= list.indexOf(orgvalue);
				int x=ir[z]+1;
				System.out.println(orgvalue+ "="+x);
			}
			
			else {
				List<String> list = Arrays.asList(lowercase);			
				ir[z]= list.indexOf(orgvalue);
				int x=ir[z]+1;
				System.out.println(orgvalue+ "="+x);
			}
		}
	}
}
