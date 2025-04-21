package adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface{
    private Calendar calendar=Calendar.getInstance();

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH,day);
    }

    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH,month);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR,year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH,days);
    }
}
