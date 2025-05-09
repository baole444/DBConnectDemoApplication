package dbConnect;

import com.google.gson.Gson;
import org.bson.types.ObjectId;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Some potentially useful utility methods.
 */
public class Utility {
    /**
     * Enums for time formatting, support digit time display with separator of length 1.
     * <div>
     * Supported time string formats:
     * <li>{@link #DD_MM_YYYY}</li>
     * <li>{@link #MM_DD_YYYY}</li>
     * <li>{@link #YYYY_MM_DD}</li>
     * </div>
     */
    public enum TimeFormat {
        DD_MM_YYYY("(\\d{2})\\D+(\\d{2})\\D+(\\d{4})"),
        MM_DD_YYYY("(\\d{2})\\D+(\\d{2})\\D+(\\d{4})"),
        YYYY_MM_DD("(\\d{4})\\D+(\\d{2})\\D+(\\d{2})");

        private final Pattern regex;

        TimeFormat(String regex) {
            this.regex = Pattern.compile(regex);
        }

        public Pattern getRegex() {
            return regex;
        }
    }

    /**
     * Safe method to convert {@link java.sql.Date} to {@link java.util.Date}
     * @param date the {@code Date} object to convert.
     * @return Java Date object.
     */
    public static java.sql.Date dateCast(java.util.Date date) {
        long millisecond = date.getTime();

        return new java.sql.Date(millisecond);
    }

    /**
     * Safe method to convert {@link java.util.Date} to {@link java.sql.Date}
     * @param date the {@code Date} object to convert.
     * @return SQL Date object.
     */
    public static java.util.Date dateCast(java.sql.Date date) {
        long millisecond = date.getTime();

        return new java.sql.Date(millisecond);
    }

    /**
     * Convert date String that matched {@link TimeFormat} to {@code Date} Object.
     * @param dateString A string of date consists of day, month and year.
     * @param timeFormat The date order of the string following {@link TimeFormat} supported enums.
     * @return {@link java.util.Date} Object from the given date string.
     */
    public static java.util.Date parseDate(String dateString, TimeFormat timeFormat) {
        Pattern pattern = timeFormat.getRegex();
        Matcher matcher = pattern.matcher(dateString);

        if (matcher.matches()) {
            int year, month, day;

            switch (timeFormat) {
                case DD_MM_YYYY -> {
                    day = Integer.parseInt(matcher.group(1));
                    month = Integer.parseInt(matcher.group(2)) - 1;
                    year = Integer.parseInt(matcher.group(3));
                }
                case MM_DD_YYYY -> {
                    month = Integer.parseInt(matcher.group(1)) -1;
                    day = Integer.parseInt(matcher.group(2));
                    year = Integer.parseInt(matcher.group(3));
                }
                case YYYY_MM_DD -> {
                    year = Integer.parseInt(matcher.group(1));
                    month = Integer.parseInt(matcher.group(2)) - 1;
                    day = Integer.parseInt(matcher.group(3));
                }
                default -> throw new IllegalArgumentException("Unknown date format");
            }

            Calendar calendar = Calendar.getInstance();
            calendar.clear();

            calendar.set(year, month, day);

            return new Date(calendar.getTimeInMillis());
        } else {
            throw new RuntimeException("Invalid date string format: "  + dateString);
        }
    }

    /**
     * Convert {@code Date} object to String presentation.
     * @param date the date object of convert.
     * @param separator the string use for separation between date field.
     * @param timeFormat the date order of the string following {@link TimeFormat} supported enums.
     * @return A string presentation of the date object.
     * @throws IllegalArgumentException Invalid enum of {@link TimeFormat}.
     */
    public static String parseDate(java.util.Date date, String separator, TimeFormat timeFormat) throws IllegalArgumentException {
        String parsedDate;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String month = Integer.toString(calendar.get(Calendar.MONTH));
        String year = Integer.toString(calendar.get(Calendar.YEAR));

        switch (timeFormat) {
            case DD_MM_YYYY -> parsedDate = day + separator + month + separator + year;
            case MM_DD_YYYY -> parsedDate = month + separator + day + separator + year;
            case YYYY_MM_DD -> parsedDate = year + separator + month + separator + day;
            default -> throw new IllegalArgumentException("Unknown enum for TimeFormat");
        }

        return parsedDate;
    }

    // Internal parsing method.
    public static String appendPlaceholderValue(String filter, Object[] params, int argCount) {
        if (filter.isEmpty()) {
            filter = "{}";
        } else {
            if (!filter.startsWith("{")) {
                filter = "{" + filter;
            }

            if (!filter.endsWith("}")) {
                filter = filter + "}";
            }
        }

        for (int i = 0; i < argCount; i++) {
            Object param = params[i];

            String appending;

            if (param instanceof ObjectId) {
                appending = "ObjectId(\"" + param + "\")";
            } else if (param instanceof String strParam) {
                if (strParam.startsWith("/") && strParam.endsWith("/")) {
                    appending = strParam;
                } else {
                    appending = "\"" + strParam + "\"";
                }
            } else if (param instanceof Number || param instanceof Boolean) {
                appending = param.toString();
            } else {
                appending = new Gson().toJson(params);
            }

            filter = filter.replaceFirst("\\?", appending);
        }

        return filter;
    }

    // Internal params counter.
    public static int countFilterParams(String filter) {
        Matcher matcher = Pattern.compile("\\?").matcher(filter);
        int count = 0;

        while (matcher.find()){
            count++;
        }

        return count;
    }
}
