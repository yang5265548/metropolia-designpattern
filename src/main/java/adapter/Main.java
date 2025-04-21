package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date=new CalendarToNewDateAdapter();
        System.out.println("Current date: "+date.getDay()+"/"+date.getMonth()+"/"+date.getYear());

        date.setYear(2026);
        date.setMonth(10);
        date.setDay(10);

        System.out.println("Updated date: "+date.getDay()+"/"+date.getMonth()+"/"+date.getYear());

        date.advanceDays(5);
        System.out.println("Date after advancing 5 days: "+date.getDay()+"/"+date.getMonth()+"/"+date.getYear());


    }
}
