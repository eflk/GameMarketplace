package concrete;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import abstracts.IEntity;

public class Helper {
	static SimpleDateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static <T extends IEntity<?>> void dumpEntities(List<T> entities) {
		for (T entity : entities) {
			System.out.println(".");
			dumpEntity(entity);
		}
	}
	public static <T extends IEntity<?>> void dumpEntity(T entity) {
		for (Field field2 : entity.getClass().getDeclaredFields()) {
			Object val = null;
			try {
				val = field2.get(entity);
			} catch (IllegalArgumentException e) {
				if (Helper.PrintStactTraceAllowed())
					e.printStackTrace();
			} catch (IllegalAccessException e) {
				if (Helper.PrintStactTraceAllowed())
					e.printStackTrace();
			}
			System.out.printf("%-20s : %-100s\n", field2.getName().toUpperCase(), val);
		}
	}

	public static Date StringToDate(String date) {
		try {
			return _dateFormat.parse(date);
		} catch (ParseException e) {
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}
		return null;
	}

	public static String DateToString(Date date) {
		return _dateFormat.format(date);
	}

	public static String getStringSystemDateUTC() {
		return ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
	}

	public static ZonedDateTime getZDateTimeSystemDateUTC() {
		return ZonedDateTime.now(ZoneOffset.UTC);
	}

	public static Date getDateSystemDateUTC() {
		return Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());
	}

	public static boolean PrintStactTraceAllowed() {
		return false;
	}
}
