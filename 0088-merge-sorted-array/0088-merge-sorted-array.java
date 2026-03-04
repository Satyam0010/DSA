class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int originalLength = m + n; 

        int[] third = new int[m + n];
        int j = 0;
        int k = 0;

        for (int i = 0; i < originalLength; i++) {

            if (j < m && k < n) {
                if (nums1[j] < nums2[k]) {
                    third[i] = nums1[j];
                    j++;
                } else {
                    third[i] = nums2[k];
                    k++;
                }
            }
            else if (j < m) {
                third[i] = nums1[j];
                j++;
            }
            else {
                third[i] = nums2[k];
                k++;
            }
        }

        for (int i = 0; i < originalLength; i++) {
            nums1[i] = third[i];
        }

        quickSort(nums1, 0, originalLength - 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}