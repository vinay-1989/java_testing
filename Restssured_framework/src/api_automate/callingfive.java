package api_automate;

import java.io.IOException;

public class callingfive {

	public static void main(String[] args)throws IOException {
		Ganna_wave gw1=new Ganna_wave();
		Ganna_wave gw5=new Ganna_wave();
		gw5.filenames("stfolder/vinayinput5.txt");
		Thread t5=new Thread(gw5);
		t5.start();

	}

}
