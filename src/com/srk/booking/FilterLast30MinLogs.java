package com.srk.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 	<DD-MM-YYYY HH:MM:SS:sss> <LogStatement>
		02-01-2014 10:02:01:001 abcd
		(\d{2})-(\d{2})-(\d{4}) (\d{2}):(\d{2}):(\d{2}):(\d{3}) (.*)
 */

class LogData{
	public String str;
	public Long ts;
	public String log;
	
	public LogData(String tsStr, String log) {
		this.str = tsStr;
		this.log = log;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogData [str=").append(str).append(", ts=").append(ts).append(", log=").append(log).append("]");
		return builder.toString();
	}
	
}

public class FilterLast30MinLogs {
	
	private static ThreadLocal<SimpleDateFormat> dateFormatSup = new ThreadLocal<SimpleDateFormat>() {
		@Override
		public SimpleDateFormat get() {
			return new SimpleDateFormat("DD-MM-YYYY HH:MM:SS:sss");
		}
	};
  private static Pattern pattern = Pattern.compile("(\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}:\\d{3}) (.*)");
  
  private static List<String> getLast30MinLogs(List<String> data) throws ParseException {
  	
  	List<LogData> logs= new ArrayList<>();
  	
  	Long max = Long.MIN_VALUE;
  	
  	for(int i = 0; i<data.size(); i++) {
  		Matcher matcher = pattern.matcher(data.get(i));
  		if(matcher.matches()) {
  			LogData logData = new LogData(matcher.group(1), matcher.group(2));
  			Date date = dateFormatSup.get().parse(logData.str);
  			logData.ts = date.getTime();
  			max = Math.max(max, logData.ts);
  			System.out.println(logData);
  			logs.add(logData);
  		}
  	}
  	
  	System.out.println(max);
  	long start = max - (3*60*60*1000);
  	System.out.println(start);
  	
  	List<LogData> last3Hrs = logs.stream().filter(logData -> logData.ts >= start).collect(Collectors.toList());
  	System.out.println(last3Hrs.size());
  		
  	return null;
  }
  
  public static void main(String[] args) throws ParseException {
		Matcher matcher = pattern.matcher("02-01-2014 10:02:01:001 abcd");
		System.out.println(matcher.matches());
		for(int i = 1; i<=matcher.groupCount(); i++) {
			System.out.println(matcher.group(i));
		}
		
		getLast30MinLogs(Arrays.asList(
				"02-01-2014 10:02:01:001 abcd1",
				"02-01-2014 11:02:01:001 abcd2",
				"02-01-2014 12:02:01:001 abcd3",
				"02-01-2014 13:02:01:001 abcd4",
				"02-01-2014 13:02:01:001 abcd5",
				"02-01-2014 13:09:01:001 abcd6",
				"02-01-2014 14:02:01:001 abcd7",
				"02-01-2014 14:02:01:001 abcd8",
				"02-01-2014 14:02:01:001 abcd9",
				"02-01-2014 15:02:01:001 abcd10",
				"02-01-2014 15:02:01:001 abcd11",
				"02-01-2014 15:02:01:001 abcd12",
				"02-01-2014 15:02:01:001 abcd13",
				"02-01-2014 14:02:01:001 abcd14",
				"02-01-2014 14:02:01:001 abcd15",
				"02-01-2014 14:02:01:001 abcd16",
				"02-01-2014 10:02:01:001 abcd17",
				"02-01-2014 11:02:01:001 abcd18"
				));
	}

}
