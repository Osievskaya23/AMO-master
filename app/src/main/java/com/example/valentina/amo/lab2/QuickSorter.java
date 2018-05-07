package com.example.valentina.amo.lab2;

/**
 * Created by Valentina on 27.03.2018.
 */

public class QuickSorter {

    private int array[];
    private int length;

    void sort(int[] inputArr) {

        //закінчуємо сортування, якщо масив пустий
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    int[] quickSort(int low, int high){

        // розділяемо на підмасиви що більше та менше опорного елемента
        int i = low, j = high;
        int pivot = array[low+(high-low)/2];
        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                // заміна елементів місцями
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        // виклик рекурсії
        if (low < j) {
            quickSort(low, j);
        }
        if (high > i) {
            quickSort(i, high);
        }
        return array;
    }

}
