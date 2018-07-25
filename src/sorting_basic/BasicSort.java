package sorting_basic;

import Module.Student;
import Tools.SortTestHelper;

public class BasicSort {
    // 我们的算法类不允许产生任何实例
    private BasicSort(){}

    /*
    * ============================选择排序======================================
    * */
    public static void Selection_sort1(Comparable[] arr){
        int len = arr.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if(arr[j].compareTo(arr[i]) < 0){ //< or <= is all right
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = (Comparable)temp;
                }
            }
        }
    }
    //改进版的选择排序
    public static void Selection_sort2(Comparable[] arr){
        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ ){
                if( arr[j].compareTo(arr[minIndex]) < 0 )
                    minIndex = j;
            }
            swap( arr , i , minIndex);
        }
    }
    //==============================================================================
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

//        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
//        BasicSort.Selection_sort1(arr);
//        for( int i = 0 ; i < arr.length ; i ++ ){
//            System.out.print(arr[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        Student[] tt = new Student[3];
//        tt[0] = new Student("lihao",100);
//        tt[1] = new Student("lijie",99);
//        tt[2] = new Student("lisheng",100);
//        BasicSort.Selection_sort1(tt);
//        for( int i = 0 ; i < tt.length ; i ++ ){
//            System.out.println(tt[i]);
//        }

        Integer[] ty = SortTestHelper.generateRandomArray(20000,0,20000);
        SortTestHelper.testSort("sorting_basic.BasicSort","Selection_sort1",ty);
        SortTestHelper.testSort("sorting_basic.BasicSort","Selection_sort2",ty);

    }
}
