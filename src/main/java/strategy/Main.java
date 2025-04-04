package strategy;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        int smallArr[]= new int[30];
        Timestamp start;
        Timestamp end;
        for (int i=0; i < 30; i++) {
            smallArr[i] = (int) (Math.random() * 100);
        }
         start = new Timestamp(System.currentTimeMillis());
        SortContext context = new SortContext(new InsertionSort());
        context.executeSort(smallArr);
         end = new Timestamp(System.currentTimeMillis());
        System.out.println("InsertionSort Time: " + (end.getTime() - start.getTime()) + "ms");

        context.setSortStrategy(new BubbleSort());
        start = new Timestamp(System.currentTimeMillis());
        context.executeSort(smallArr);
        end = new Timestamp(System.currentTimeMillis());
        System.out.println("BubbleSort Time: " + (end.getTime() - start.getTime()) + "ms");

        context.setSortStrategy(new QuickSort());
        start = new Timestamp(System.currentTimeMillis());
        context.executeSort(smallArr);
        end = new Timestamp(System.currentTimeMillis());
        System.out.println("QuickSort Time: " + (end.getTime() - start.getTime()) + "ms");

        int largeArr[]= new int[100000];
        for (int i=0; i < 100000; i++) {
            largeArr[i] = (int) (Math.random() * 100);
        }
        start = new Timestamp(System.currentTimeMillis());
        context.setSortStrategy(new InsertionSort());
        context.executeSort(largeArr);
        end = new Timestamp(System.currentTimeMillis());
        System.out.println("InsertionSort Time: " + (end.getTime() - start.getTime()) + "ms");
        context.setSortStrategy(new BubbleSort());
        start = new Timestamp(System.currentTimeMillis());
        context.executeSort(largeArr);
        end = new Timestamp(System.currentTimeMillis());
        System.out.println("BubbleSort Time: " + (end.getTime() - start.getTime()) + "ms");
        context.setSortStrategy(new QuickSort());
        start = new Timestamp(System.currentTimeMillis());
        context.executeSort(largeArr);
        end = new Timestamp(System.currentTimeMillis());
        System.out.println("QuickSort Time: " + (end.getTime() - start.getTime()) + "ms");
    }
}
