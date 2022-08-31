package rs.edu.code.ProjectForComtradeVersion3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class ProjectForComtradeVersion3Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectForComtradeVersion3Application.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		print("Starting Spring Application");
	}






	private static void print(String text) {
		System.out.println(text);
	}
}
