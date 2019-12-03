package api_automate;

import java.io.IOException;

public class callingfour {

	public static void main(String[] args)throws IOException {
		Ganna_wave gw1=new Ganna_wave();
		Ganna_wave gw4=new Ganna_wave();
		gw4.filenames("stfolder/vinayinput4.txt");
		Thread t4=new Thread(gw4);
		t4.start();
	}
}
