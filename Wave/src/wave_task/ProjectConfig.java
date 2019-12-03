package wave_task;
import org.aeonbits.owner.Config;
public interface ProjectConfig extends Config {
	 String imagesDirectory();
	 String videosDirectory();
	 int maxIcons();
	 String adminMail();
}
