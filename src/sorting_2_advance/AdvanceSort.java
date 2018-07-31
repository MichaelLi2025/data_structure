package sorting_2_advance;

import Tools.SortTestHelper;
import sorting_1_basic.BasicSort;
import java.util.Arrays;

public class AdvanceSort {

    /*
    * ===========================shellsort=============================
    * */
    public static void ShellSort(Comparable[] arr){
        int len = arr.length;
        int h=1;
        //初始化间隔
        while (h < len/3) h=3*h+1;
        while (h >= 1){
            for (int i = h;i < len;i++){
                Comparable tmp = arr[i];
                int j = i;
                for (;j >= h && tmp.compareTo(arr[j-h]) < 0;j -=h){
                    arr[j] = arr[j-h];
                }
                arr[j] = tmp;
            }
            h=h/3;
        }
    }

    public static void main(String[] args){
        Integer[] tt = SortTestHelper.generateRandomArray(50000,0,20000);
        Integer[] ty = Arrays.copyOf(tt,tt.length);
        SortTestHelper.testSort("sorting_2_advance.AdvanceSort","ShellSort",tt);
        System.out.println(SortTestHelper.isSorted(tt));
        SortTestHelper.testSort("sorting_1_basic.BasicSort","Insertion_sort_optimize",ty);
        System.out.println(SortTestHelper.isSorted(ty));
    }
}
