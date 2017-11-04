/**
 * 
 */
package sid.spring.dateformatter.annotation.factory;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import sid.spring.dateformatter.annotation.MyDateTimeZoneFormat;
import sid.spring.dateformatter.annotation.formatter.MyDateTimeZoneFormatter;

/**
 * @author sidnan
 *
 */
public class MyDateTimeZoneFormatterFactory implements AnnotationFormatterFactory<MyDateTimeZoneFormat> {
	
	Logger LOG = Logger.getLogger(MyDateTimeZoneFormatterFactory.class);

	@Override
	public Set<Class<?>> getFieldTypes() {
		LOG.info(" I'm in getFieldTypes ");
		return new HashSet<>(Arrays.asList(Date.class));
	}

	@Override
	public Parser<?> getParser(MyDateTimeZoneFormat annotation, Class<?> fieldType) {
		
		LOG.info(" I' in getParser ");
		
		return getMyDateTimeZoneFormatter(annotation, fieldType);
	}

	@Override
	public Printer<?> getPrinter(MyDateTimeZoneFormat annotation, Class<?> fieldType) {
		LOG.info(" I' in getPrinter ");
		return getMyDateTimeZoneFormatter(annotation, fieldType);
	}

	private MyDateTimeZoneFormatter getMyDateTimeZoneFormatter(MyDateTimeZoneFormat annotation,
			Class<?> fieldType) {
		LOG.info(" I' in getMyDateTimeZoneFormatter  fieldType="+fieldType+"; annotation="+annotation);
		
		MyDateTimeZoneFormatter formatter = new MyDateTimeZoneFormatter();
		formatter.setPattern(annotation.pattern());
		formatter.setTimezone(annotation.timezone());
		
		return formatter;
	}

}