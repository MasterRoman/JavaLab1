package com.company;

import java.io.Console;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        System.out.println(firstTask(1,1));
        System.out.println(coordInArea(2,4));
        thirdTask(1.0,5.0,0.2);

        var array = new int[] {3,1,7,12,2,5,6};
        fourthTask(array);

        System.out.println(fifthTask(array.length,array));

        fifthTask(array.length,array);

        array = new int[] {1,2,3,4,5,6,7};
        sixthTask(array.length,array);

        array = new int[] {3,1,7,12,2,5,6};
        seventhTask(array.length,array);

        var array1 = new int[] {2,4,6,7};
        var array2 = new int[] {1,3,4,5,8,9};
        eighthTask(array1,array2);
    }

    private static double firstTask(double x,double y) { //1 task

        double numerator = 1 + Math.pow(Math.sin(x + y),2);
        double denominator = 2 + Math.abs(x - 2 * x / (1 + Math.pow(x,2) * Math.pow(y,2)));
        double result = numerator / denominator + x;

        return result;
    }

    private static boolean coordInArea(double x,double y) { //2 task
        if (y > 0){
            if (x >= -4 && x <= 4){
                return true;
            }
        } else {
            if (x >= -6 && x <= 6){
                return true;
            }
        }

        return false;
    }

    private static void thirdTask(double a,double b,double h){
        double x = a;
        while ((int)((b-x) * 1000) >= 0){
            try {
                double y = Math.tan(x);
                System.out.printf("x:%.2f y:%.2f \n",x,y);
            } catch (Exception e) {
                x += h;
            }
            x += h;
        }
    }

    private static void fourthTask(int[] array){
        for (int i = 0;i < array.length;++i){
            int maxDivider = (int)Math.sqrt(array[i]);
            if (array[i] % 2 == 0) {
                continue;
            }
            int curDivider = 3;
            boolean isPrime = true;
            while (curDivider <= maxDivider){
                if (array[i] % curDivider == 0) {
                    isPrime = false;
                    break;
                }
                curDivider += 2;
            }

            if (isPrime){
                System.out.printf("index: %d \n",i);
            }

        }

    }

    private static int fifthTask(int lenght,int[] array) {
        var maxSequence = new int[lenght];
        for (int i = 0; i < lenght; ++i) {
            maxSequence[i] = 1;
            for (int j=0; j<i; ++j)
                if (array[j] < array[i]) {
                    maxSequence[i] = Math.max(maxSequence[i], 1 + maxSequence[j]);
                }
        }

        int ans = maxSequence[0];
        for (int i=0; i<lenght; ++i) {
            ans = Math.max(ans, maxSequence[i]);
        }

        return lenght - ans;
    }

    private static void sixthTask(int lenght,int[] array) {
        var matrix = new int[lenght][lenght];
        for (int i = 0; i < lenght; ++i) {
            var index = i;
            for (int j = 0; j < lenght; ++j) {
                matrix[i][j] = array[index];
                index = (index + 1) % (lenght);
            }
        }

        for (int i = 0; i < lenght; ++i) {;
            for (int j = 0; j < lenght; ++j) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }

    }

    private static void seventhTask(int lenght,int[] a) {
        int i = 0;
        while (i < lenght - 1) {
            if (a[i] < a[i+1]){
                i++;
            } else {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                i = i > 0 ? --i : 0;
            }
        }

        for (i = 0; i < lenght; ++i) {
            System.out.printf("%d \n",a[i]);
        }

    }

    private static void eighthTask(int[] a,int[] b) {

        var posToInsert = 0;
        var countOfInserted = 0;

        for (int i = 0; i < b.length; ++i) {
            boolean isInserted = false;
            var start =  countOfInserted > 0 ? countOfInserted - 1 : 0;
            for (int j = start; j < a.length; ++j) {
                if (b[i] <= a[j]) {
                    System.out.printf("pos: %d \n", posToInsert++ + j);
                    countOfInserted++;
                    isInserted = true;
                    break;
                }
            }
            if (!isInserted) {
                System.out.printf("pos: %d \n", posToInsert++ + a.length);
            }
        }
    }
}
