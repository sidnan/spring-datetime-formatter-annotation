This is an example Spring boot project, to create custom annotation to parse-format-convert request parameter from String to Date.


MyDateTimeZoneFormat.java => Is the Custom Annotation with target restricted to just parameter, because in this case, it is used against request param only

MyDateTimeZoneFormatter.java => Holds the logic to do the convert from String to Date

MyDateTimeZoneFormatterFactory.java => To bind the annotation by implementing AnnotationFormatterFactory

MyAnnotationConfiguration => to register the AnnotationFormatterFactory, so that @MyDateTimeZoneFormat is recognized during http request initial processing


Example ways to use the annotation:
1. @MyDateTimeZoneFormat => defaults to pattern "yyyy-MM-dd HH:mm:ss"
2. @MyDateTimeZoneFormat(pattern="dd-MMM-yyyy HH:mm")  => for different pattern "dd-MMM-yyyy HH:mm"


Success case Examples:
1. localhost:8080/example1/orders?from=2016-11-11%2022:00:00&to=2016-11-11%2023:30:00
2. localhost:8080/example2/orders?from=11-NOV-2016%2022:00&to=11-NOV-2016%2023:30

Failure case Examples:
1. If you try to input date in different format, other than "dd-MMM-yyyy HH:mm", say "yyyy-MM-dd HH:mm:ss", it will throw exception
	localhost:8080/example2/orders?from=2016-11-11%2022:00:00&to=2016-11-11%2023:30:00