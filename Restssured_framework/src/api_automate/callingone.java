package api_automate;

import java.io.IOException;


public class callingone  {
	public static void main(String[] args)throws IOException {
		Ganna_wave gw1=new Ganna_wave();
		gw1.filenames("stfolder/vinayinput1.txt");
		Thread t1=new Thread(gw1);
		t1.start();
	
		
	
 	}
}