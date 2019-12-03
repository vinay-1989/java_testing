package wave_task;

import org.testng.annotations.Test;

public class testngDemo {
	@Test
	public void insert() {
		System.out.println("inserting demo data");
	}
	
	@Test (dependsOnMethods="insert")
	public void select() {
		System.out.println("selecting demo data");
	}
	
	@Test
	public void update() {
		System.out.println("updating demo data");
	}
	
	@Test
	public void delete() {
		System.out.println("deleting demo data");
	}

}
