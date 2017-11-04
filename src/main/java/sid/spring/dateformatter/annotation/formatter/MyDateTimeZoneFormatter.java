/**
 * 
 */
package sid.spring.dateformatter.annotation.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.format.Formatter;

/**
 * @author sidnan
 *
 */
public class MyDateTimeZoneFormatter implements Formatter<Date> {
	
	Logger LOG = Logger.getLogger(MyDateTimeZoneFormatter.class);

	private String timezone;
	private String pattern;

	public void setTimezone (String timezone) {
		LOG.info("Setting timezone = " + timezone);
		this.timezone = timezone;
	}

	public void setPattern (String pattern) {
		LOG.info("Setting pattern = " + pattern);
		this.pattern = pattern;
	}

	@Override
	public Date parse (String dateTimeString, Locale locale) throws ParseException {
		LOG.info("Given date-time string = "+dateTimeString);
		LOG.info("Given pattern using which the date string must be parsed = "+pattern);
		LOG.info("Given timezone using which the date string must be parsed = "+timezone);
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		Date dateTime = sdf.parse(dateTimeString);
		
		LOG.info("Formatted java date object = "+dateTime);

		return dateTime;
	}

	@Override
	public String print(Date date, Locale locale) {
		LOG.info("I'm here in print method. Date-time = "+date);
		return date.toString();
	}
}
