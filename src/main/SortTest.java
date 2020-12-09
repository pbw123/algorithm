package main;

import java.text.DecimalFormat;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        Random random = new Random(700);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.println();
//        SortDemo.quick_sort(arr,0,arr.length-1);
//        SortDemo.sort_m(arr);
//        SortDemo.SelectionSort(arr);
        SortDemo.sort_insert2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
//        System.out.println("3/2=" + (3 >> 1));
//        System.out.println("5/2=" + 5 % 2);
//        DecimalFormat format = new DecimalFormat("0.0");
//        String str = format.format((float) 5 / 2);
//
//        float mid = 5 >> 1;
////        System.out.println(mid instanceof );
//        System.out.println();
//
//        int[] s = new int[10];
//
//        for (int i = 0; i < s.length; i++) {
//            s[i] = (int) (Math.random() * 10);
//        }
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(s[i] + "_>_");
//        }
//        System.out.println();
//        SortDemo.merge_sort(s);
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(s[i] + "_>_");
//        }
//
//        Comparable tem = 3;
//        int compareTo = tem.compareTo(2);
//        System.out.println(compareTo);
//
//        int a = 1, b = 2;
//        a = a+b;
//        b=a-b;
//        a=a-b;
//        System.out.println("a=="+a+",b=="+b);
        
    }
}
