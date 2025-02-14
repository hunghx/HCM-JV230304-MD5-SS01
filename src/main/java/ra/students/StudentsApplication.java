package ra.students;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}
	@Bean
	public Storage storage() throws IOException {
		InputStream inputStream = new ClassPathResource("firebase-config.json").getInputStream();
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("firebase-config.json");
		return StorageOptions.newBuilder()
				.setCredentials(GoogleCredentials.fromStream(inputStream))
				.build()
				.getService();
	}
}
