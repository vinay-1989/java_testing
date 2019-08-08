package testing_enviroment;

public class thread_fun extends Thread {
	String tname;
public thread_fun(String i) {
		tname=i;
	}
public void run() {
	
	//System.out.println(tname);
	if(tname=="thread1") {
		System.out.println("t1");
	}
	
//for(int i=0;i<=5;i++) {
//	try{
//		Thread.sleep(2000);
//		System.out.println(tname);
//	}catch(Exception e) {
//		System.out.println(e);
//	}
//	System.out.println(i);
//}
//
}
	public static void main(String[] args) {
		thread_fun tf =new thread_fun("thread1");
		thread_fun tf1 =new thread_fun("Thread2");
		thread_fun tf2 =new thread_fun("thread3");
		
		tf2.start();
		tf.start();
        tf1.start();
        
	}

}
