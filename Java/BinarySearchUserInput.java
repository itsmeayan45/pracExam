import java.util.Scanner;
import java.util.Arrays;

public class BinarySearchUserInput {

    public static int binarySearch(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;

            else if (key < arr[mid])
                high = mid - 1;

            else
                low = mid + 1;
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort array (Binary search requires sorted array)
        Arrays.sort(arr);

        // Input element to search
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // Perform binary search
        int result = binarySearch(arr, key);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);

        sc.close();
    }
}
