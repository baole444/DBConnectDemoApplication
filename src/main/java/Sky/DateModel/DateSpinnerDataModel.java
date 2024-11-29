package Sky.DateModel;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class DateSpinnerDataModel extends SpinnerDateModel{
    private boolean updating = false;

    public DateSpinnerDataModel() {
        super(new Date(), null, null, Calendar.DAY_OF_MONTH);
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Date) {
            Date noTime = stripTime((Date) value);

            if (!updating && !noTime.equals(super.getValue())) {
                updating = true;
                super.setValue(noTime);
                updating = false;
            }
        } else {
            throw new IllegalArgumentException("Value was not an instance of Date!");
        }
    }

    @Override
    public Object getNextValue() {
        return addDay((Date) getValue(), -1);
    }

    @Override
    public Object getPreviousValue() {
        return addDay((Date) getValue(), 1);
    }

    private Date stripTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stripTime(date));
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        return calendar.getTime();
    }
}
