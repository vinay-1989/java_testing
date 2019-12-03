package wave_proj;

import java.io.IOException;



public class wavecalling {
	public static void main(String[] args) throws IOException {
		String[] key=new String[2];
		key[0]="BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72";
		String waveapi="http://192.168.100.21/Localization1.3/MoxApi.ashx";
		String inputfilepath="D:\\Wave_Automation\\tagging data\\demo.txt";
		String outputfilepath="D:\\Wave_Automation\\tagging data\\outputdemo.txt";	
		Wave_InputOutput.main(key,waveapi,inputfilepath,outputfilepath);
		
}
}
