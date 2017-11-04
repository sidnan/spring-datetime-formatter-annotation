/**
 * 
 */
package sid.spring.dateformatter.annotation.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import sid.spring.dateformatter.annotation.factory.MyDateTimeZoneFormatterFactory;

/**
 * @author sidnan
 *
 */
@EnableWebMvc
@Configuration
public class MyAnnotationConfiguration extends WebMvcConfigurerAdapter {
	
	Logger LOG = Logger.getLogger(MyAnnotationConfiguration.class);
	
    @Override
    public void addFormatters (FormatterRegistry registry) {
    	LOG.info("I'm in configuration to register Formatter - MyDateTimeZoneFormatter");
    	
    	MyDateTimeZoneFormatterFactory factory = new MyDateTimeZoneFormatterFactory();

        registry.addFormatterForFieldAnnotation(factory);
    }
}
