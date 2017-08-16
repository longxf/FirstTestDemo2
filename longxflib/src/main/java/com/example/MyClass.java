package com.example;


public class MyClass {
    public static void main(String[] args) {
        System.out.println("hello1");
        System.out.println("hello2");
        System.out.println("hello3");

    }


    /**
     *
     排序法   最差时间分析	 平均时间复杂度	稳定度	空间复杂度
     选择排序	O(n2)	     O(n2)	        稳定		O(1)
     插入排序	O(n2)	     O(n2)	     	稳定		O(1)
     冒泡排序	O(n2)	     O(n2)	     	稳定		O(1)
     快速排序	O(n2)	     O(n*log2n) 	不稳定	O(log2n)~O(n)
     归并排序	O(n^2)	     O(n*logn)		稳定		不一定
     希尔排序	O(n*(logn)2) O(n*(logn)2)	不稳定	O(1)
     堆排序	    O(n*log2n)   O(n*log2n)		不稳定	O(1)
     基数排序	O(kn)	     O(nlog(r)m)	稳定		O(kn)
     */

    /**
     * 冒泡排序
     * 比较相邻的元素，如果第二个比第一个大，就交换他们
     * 对每一对相邻的元素做同样的工作，从开始到最后
     * 针对所有的元素重复以上操作，除了最后一个
     */

    public static void bubbleSort(int[] numbers) {
        int temp;  // 临时变量
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[j] = numbers[i];
                    numbers[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 在未排序的数据中找到最小的元素，放到起始位置
     * 剩下的继续这样找
     */
    public static void selectSort(int[] numbers) {
        int size = numbers.length, temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[i]) {
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    /**
     * 插入排序
     * 第一个元素认为已经排序
     * 取出下一个元素，在已经排序的序列从后向前扫描
     * 如果该元素大于新元素，则换位置
     */

    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for (int i = 1; i < size; i++) {
            temp = numbers[i];
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }


}
