package sorting_1_basic;

import Tools.SortTestHelper;

import java.util.Arrays;

public class BasicSort {
    // 我们的算法类不允许产生任何实例
    private BasicSort(){}

    /*
    * ============================选择排序======================================
    * */
    public static void Selection_sort_basic(Comparable[] arr){
        int len = arr.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if(arr[j].compareTo(arr[i]) < 0){ //< or <= is all right
                    swap(arr,j,i);
                }
            }
        }
    }
    //改进版的选择排序
    public static void Selection_sort_optimize(Comparable[] arr){
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

    /*
    * =================================插入排序=====================================
    * */
    public static void Insertion_sort_basic(Comparable[] arr){
        int len = arr.length;
        for (int i = 0;i < len;i++){
            for (int j = i;j > 0;j--){
                if (arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }
    /*
    * ==============================改进后的Insertion_sort====================
    * 注意：判断要加break，不然要出现边界问题
    * */
    public static void Insertion_sort_optimize(Comparable[] arr){
        int len = arr.length;
        for (int i = 0;i < len;i++){
            Comparable temp = arr[i];
            int j = i;
            for (;j > 0;j--){
                if (temp.compareTo(arr[j-1]) < 0){
                    arr[j] = arr[j-1];
                }else {
                    break;
                }
            }
            arr[j] = temp;
//            Comparable e = arr[i];
//            int j = i;
//            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
//                arr[j] = arr[j-1];
//            arr[j] = e;
        }
    }
    //==============================================================================

    /*
    * ================================冒泡排序======================================
    * */
    public static void Bubble_sort_basic(Comparable[] arr){
        int len  = arr.length;
        for (int i = 0;i < len;i++){
            for (int j = 1;j < len-i;j++){
                if (arr[j-1].compareTo(arr[j]) > 0){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    public static void Bubble_sort_optimize1(Comparable[] arr){
        int len = arr.length;
        int mask =len;
        int mk = mask;
        //这种优化只是把内部循环缩小了，但是对于外部的循环还是len
        //因此会出现排序已完毕，但是外部循环还未执行完，这里len是定死了的，没必要
        //灵活处理循环次数，可以看到，外部的循环条件len并没有与内部的循环有任何关系，
        //只是保证了len循环次数，这种称为“静态循环”，下面的优化3针对这点进行优化
        for (int i = 0;i < len;i++){
//            System.out.println("============:"+i);
            for (int j=1;j < mk;j++){
                if (arr[j-1].compareTo(arr[j]) > 0){
                    swap(arr,j-1,j);
                    mask = j;
//                    System.out.println("==:"+mask);
                }
            }
            mk = mask;
//            System.out.println("====:"+mk);
        }
    }


    //相对于上面的优化，只是控制了外部循环的次数，并未对内部循环进行控制
    public static void Bubble_sort_optimize2(Comparable[] arr){
        int n = arr.length;
        boolean swapped = false;
        do{
            swapped = false;
            for( int i = 1 ; i < n ; i ++ )
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    swap( arr , i-1 , i );
                    swapped = true;
                }
            n --;
        }while(swapped);
    }

//    public static void Bubble_sort_optimize4(Comparable[] arr){
//        int n = arr.length;
//        do{
//            for( int i = 1 ; i < n ; i ++ )
//                if( arr[i-1].compareTo(arr[i]) > 0 ){
//                    swap( arr , i-1 , i );
//                }
//            n --;
//        }while(n>0);
//    }

    public static void Bubble_sort_optimize3(Comparable[] arr){
        int len = arr.length;
        int newn;
        do {
            newn = 0;
            for (int i = 1;i < len;i++){
                if (arr[i-1].compareTo(arr[i]) > 0){
                    swap(arr,i-1,i);
                    newn = i;
                }
            }
            len = newn;
        }while(newn > 0);
    }

    //==============================================================================
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    //==============================================================================
    public static void main(String[] args) {

//        Integer[] arr = {3,5,4,3,1,1,1,8,6,10};
//        BasicSort.Bubble_sort_optimize1(arr);
//        for( int i = 0 ; i < arr.length ; i ++ ){
//            System.out.print(arr[i]);
//            System.out.print(' ');
//        }
//        boolean mask = SortTestHelper.isSorted(arr);
//        System.out.println(mask);
//        System.out.println();

        Integer[] ty1 = SortTestHelper.generateRandomArray(50000,0,20000);
        Integer[] ty2 = Arrays.copyOf(ty1,ty1.length);
        Integer[] ty3 = Arrays.copyOf(ty1,ty1.length);
        Integer[] ty4 = Arrays.copyOf(ty1,ty1.length);
        Integer[] ty5 = Arrays.copyOf(ty1,ty1.length);
        Integer[] ty6 = Arrays.copyOf(ty1,ty1.length);
        Integer[] ty7 = Arrays.copyOf(ty1,ty1.length);
        Integer[] ty8 = Arrays.copyOf(ty1,ty1.length);
//        SortTestHelper.testSort("sorting_basic.BasicSort","Selection_sort_basic",ty1);
//        System.out.println(SortTestHelper.isSorted(ty1));
//        SortTestHelper.testSort("sorting_basic.BasicSort","Selection_sort_optimize",ty2);
//        System.out.println(SortTestHelper.isSorted(ty2));
//        SortTestHelper.testSort("sorting_basic.BasicSort","Insertion_sort_basic",ty3);
//        System.out.println(SortTestHelper.isSorted(ty3));
        SortTestHelper.testSort("sorting_basic.BasicSort","Insertion_sort_optimize",ty4);
        System.out.println(SortTestHelper.isSorted(ty4));
//        SortTestHelper.testSort("sorting_basic.BasicSort","Bubble_sort_basic",ty5);
//        System.out.println(SortTestHelper.isSorted(ty5));
//        SortTestHelper.testSort("sorting_basic.BasicSort","Bubble_sort_optimize1",ty6);
//        System.out.println(SortTestHelper.isSorted(ty6));
//        SortTestHelper.testSort("sorting_basic.BasicSort","Bubble_sort_optimize2",ty7);
//        System.out.println(SortTestHelper.isSorted(ty7));
//        SortTestHelper.testSort("sorting_basic.BasicSort","Bubble_sort_optimize3",ty8);
//        System.out.println(SortTestHelper.isSorted(ty8));

    }
}
