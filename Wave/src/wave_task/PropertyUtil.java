package wave_task;

import org.aeonbits.owner.ConfigFactory;

public class PropertyUtil {
	public static void main(String args[]) throws Exception {
		  ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);
		
		//  System.out.println(cfg);

		  System.out.println(cfg.adminMail());
		  System.out.println(cfg.imagesDirectory());
		  System.out.println(cfg.maxIcons());
		  System.out.println(cfg.videosDirectory());
	}

}
