class Solution {
    public int nextGreaterElement(int num) {
        int n = (int) Math.log10(num) + 1;
        int[] arr = new int[n];
        int ptr = n - 1;
        int temp = num;
        while (temp > 0) {
            arr[ptr--] = temp % 10;
            temp = temp / 10;
        }
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i < 0)
            return -1;
        int j = n - 1;
        while (j > 0 && arr[j] <= arr[i])
            j--;
        swap(arr, i, j);
        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        long res = 0;
        for (i = 0; i < n; i++)
            res = res * 10 + arr[i];
        if (res > Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
