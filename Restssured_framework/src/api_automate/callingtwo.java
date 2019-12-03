package api_automate;

import java.io.IOException;

public class callingtwo {

	public static void main(String[] args)throws IOException {
		Ganna_wave gw1=new Ganna_wave();
		Ganna_wave gw2=new Ganna_wave();
		gw2.filenames("stfolder/vinayinput2.txt");
		Thread t2=new Thread(gw2);
		t2.start();
	}

}
