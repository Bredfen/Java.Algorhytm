import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.currentThread;

public class Main {
    private static double MIN = 1;
    private static double MAX = 6;
    public static final int INTERUPTER = -282;
    public static void main(String[] args) {
        int[] array = new int[1000000];
        array = init(array);
        System.out.println(find(array, 4));
        int[] deleteFromArrayEl = deleteFromArray(array, 2);
        int[] addElToArray = addToArray(array, 2,8);



        int[] sortArr =  bubbleSort(array);
        int[] insertionSortArr =  insertionSort(array);
        int[] selectionSortArr = selectionSort(array);
        long timeMillis = System.currentTimeMillis();
        int[] mergeSortArr = mergeSort(array);
        long timeMillis2 = System.currentTimeMillis();
        long answer = timeMillis2 - timeMillis;
        System.out.println("Runtime of mergeSortArr is "+answer);
        timeMillis = System.currentTimeMillis();
        int[] mergeSortArr2 = mergeSortResult(array, 0, array.length-1);
        System.out.println("Runtime of mergeSortArr2 is "+(System.currentTimeMillis() - timeMillis));



    }
    private static int[] init(int [] array){
        for (int i = 0; i < array.length; i++) array[i] = (int)((Math.random() * (MAX-MIN)) + MIN);
        return array;
    }
    private static int[] deleteFromArray(int [] array, int index){
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        array[array.length-1] = INTERUPTER;
        return array;
    }
    private static boolean isFull(int[] array) { return (array[array.length-1] != INTERUPTER)?true:false; }
    private static int[] addToArray(int[] array, int index, int val){
        if (isFull(array)) return null;
        int i = 0;
        while (array[i] != INTERUPTER) i++;
        System.arraycopy(array, index, array,index+1, i-index);
        array[index] = val;
        return array;
    }
    private static int find(int[] array, int arg){
        int i = 0;
        while (i<array.length-1){
            if (array[i] == arg) break;
            i++;
        }
        return i;
    }
    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    }




    //сортировка




    private static int[] mergeSortResult(int[] array, int left, int right) {
        if(array!=null) {
            if (right <= left) return array;
            int mid = (left + right) / 2;
            mergeSortResult(array, left, mid);
            mergeSortResult(array, mid + 1, right);
            return merge(array, left, mid, right);
        }
        return null;
    }

    private static int[] merge(int[] array, int left, int mid, int right) {
        int lenghtLeft = mid - left +1;
        int lenghtRight = right - mid;

        int[] leftArray = new int [lenghtLeft];
        int[] rightArray = new int [lenghtRight];

        for(int i = 0; i <lenghtLeft; i++){
            leftArray[i] = array[left+i];
        }
        for(int i = 0; i <lenghtRight; i++){
            rightArray[i] = array[mid+i+1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for(int i = left; i<right + 1; i++){
            if(leftIndex<lenghtLeft&&rightIndex<lenghtRight){
                if(leftArray[leftIndex]<rightArray[rightIndex]){
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else{
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if(leftIndex<lenghtLeft){
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if(rightIndex<lenghtRight){
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        return array;
    }


    private static int[] mergeSort(int[] array) {
        if(array == null){
            return null;
        }

        if(array.length<2){
            return array;
        }

        int[] arrayB = new int[array.length/2];
        System.arraycopy(array, 0, arrayB, 0, array.length/2);
        int[] arrayC = new int[array.length - array.length/2];
        System.arraycopy(array, array.length/2, arrayC, 0, array.length - array.length/2);

        arrayB = mergeSort(arrayB);
        arrayC = mergeSort(arrayC);

        return array;// итоговый выриант
    }


    private static int[] selectionSort(int[] array) {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        System.out.println("Runtime of insertionSort is "+(System.currentTimeMillis()-timeMillis));
        return array;
    }



    private static int[] insertionSort(int[] array) {
        long timeMillis = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        System.out.println("Runtime of insertionSort is "+(System.currentTimeMillis()-timeMillis));
        return array;
    }



    private static int[] bubbleSort(int[] array) {
        long timeMillis = System.currentTimeMillis();
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Runtime of bubbleSort is "+(System.currentTimeMillis()-timeMillis));
        return array;
    }
}
