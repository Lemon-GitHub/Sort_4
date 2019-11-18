package Sort_4;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array){
        //1.创建堆
        createHeap(array);
        //2.循环取堆顶元素放在末尾已排序区间
        //[0, array.length - i)   待排序区间
        //[array.length - i, array.length)   已排序区间
        for(int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - i - 1);
            shiftDown(array, array.length - 1 - i, 0);
        }
    }

    public static void createHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2 ; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    public static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size) {
            //找左子树和右子树谁更大
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            //此时下标child的元素一定是左右子树最大的元素
            if(array[child] > array[parent]) {
                //不符合大堆的性质 交换
                swap(array, child, parent);
            }else{
                //符合大堆性质
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
