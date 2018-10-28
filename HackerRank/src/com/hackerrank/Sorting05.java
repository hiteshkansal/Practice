package com.hackerrank;

/*
 * In an array, arr, the elements at indices i and j (where i<j) form an inversion if arr[i]>arr[j]. 
 * In other words, inverted elements arr[i] and arr[j] are considered to be "out of order". 
 * To correct an inversion, we can swap adjacent elements. Min swap to sort dataset
 */
public class Sorting05 {

	private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }

    private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        long count = 0;
        count += countInversions(aux, lo, mid, arr);
        count += countInversions(aux, mid + 1, hi, arr);
        count += merge(arr, lo, mid, hi, aux);

        return count;
    }

    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }

        return count;
    }

	public static void main(String[] args) {
		int[] arr = {7, 3, 2, 1};
		//int[] arr = { 2, 1, 3, 1, 2 };
		System.out.println(countInversions(arr));
		for (int i : arr)
			System.out.print(i);

	}
}
