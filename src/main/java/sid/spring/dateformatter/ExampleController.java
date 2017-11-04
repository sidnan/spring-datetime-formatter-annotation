/**
 * 
 */
package sid.spring.dateformatter;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sid.spring.dateformatter.annotation.MyDateTimeZoneFormat;

/**
 * @author sidnan
 *
 */
@RestController
public class ExampleController {
	
	Logger LOG = Logger.getLogger(ExampleController.class);

	@RequestMapping("/example1/orders")
	public Object getOrdersByDateRange_Example1(@RequestParam(value = "from") @MyDateTimeZoneFormat Date from, 
			@RequestParam(value = "to") @MyDateTimeZoneFormat Date to) {
		
		LOG.info("getOrdersByDateRange_Example1 ===> @MyDateTimeZoneFormat converted the date, from string type to util.Date type. from=" + from + "; to=" + to);
		
		String strJson="{\"OrdersExample1\":[{\"id\":\"101\",\"name\":\"pen\",\"price\":\"2\",\"date\":\"12-12-2016 12:00:00\"},{\"id\":\"102\",\"name\":\"pencil\",\"price\":\"1\",\"date\":\"12-12-2016 12:00:00\"},{\"id\":\"103\",\"name\":\"book\",\"price\":\"3\",\"date\":\"12-12-2016 12:00:00\"}]}";
		return new ResponseEntity<>(strJson, HttpStatus.OK);
	}
	
	@RequestMapping("/example2/orders")
	public Object getOrdersByDateRange_Example2(@RequestParam(value = "from") @MyDateTimeZoneFormat(pattern="dd-MMM-yyyy HH:mm", timezone="PTC") Date from, 
			@RequestParam(value = "to") @MyDateTimeZoneFormat(pattern="dd-MMM-yyyy HH:mm", timezone="PTC") Date to) {
		
		LOG.info("getOrdersByDateRange_Example2 ===> @MyDateTimeZoneFormat converted the date, from string type to util.Date type. from=" + from + "; to=" + to);
		
		String strJson="{\"OrdersExample2\":[{\"id\":\"101\",\"name\":\"pen\",\"price\":\"2\",\"date\":\"12-12-2016 12:00:00\"},{\"id\":\"102\",\"name\":\"pencil\",\"price\":\"1\",\"date\":\"12-12-2016 12:00:00\"},{\"id\":\"103\",\"name\":\"book\",\"price\":\"3\",\"date\":\"12-12-2016 12:00:00\"}]}";
		return new ResponseEntity<>(strJson, HttpStatus.OK);
	}
}
