package api_automate;

import java.io.IOException;

public class callingthree {

	public static void main(String[] args)throws IOException {
		Ganna_wave gw1=new Ganna_wave();
		Ganna_wave gw3=new Ganna_wave();
		gw3.filenames("stfolder/vinayinput3.txt");
		Thread t3=new Thread(gw3);
		t3.start();
	}

}
