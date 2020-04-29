package com.brilliant.fury;

import java.util.Arrays;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fury.
 * version 2020/4/20.
 */
public class SortDemo {

    private static final Logger log = LoggerFactory.getLogger(SortDemo.class);

    @Test
    public void cleanTest() throws Exception {
        Integer[] array = new Integer[]{12, 13, 24, 6, 3, 6, 90, 70};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        Integer[] array2 = new Integer[]{1, 6, 7, 5, 3};
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * 快排思想：
     * 1. 选中中间位置元素。
     * 2. 中间元素 左边选出所有大值，右边选出所有小值，依次交换
     * 3. 交换完成后，对子数组(low, j) (i, high)再次进行相同操作。
     * @param high
     */
    public void quickSort(Integer[] arr, int low, int high) {
        //check for empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot) {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    public  void swap(Integer array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
