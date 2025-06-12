package pixel.academy.FireBaseCRUDApplication;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;



// https://console.firebase.google.com/project/fir-crudapplication-3c2d8/overview - firebase console project
@SpringBootApplication
public class FireBaseCrudApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = FireBaseCrudApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount =
				new FileInputStream("C:\\Users\\svascan\\Desktop\\New folder\\NewSpringBootFirebaseCRUDApplication\\src\\main\\resources\\serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://default.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);



		SpringApplication.run(FireBaseCrudApplication.class, args);

	}

} 
