package sid.spring.dateformatter;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDatetimeFormatterAnnotationApplication {

	public static void main(String[] args) {
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		SpringApplication.run(SpringDatetimeFormatterAnnotationApplication.class, args);
	}
}
