import java.util.Scanner;
import java.util.Random;

public class QuickSort {

    int partition(int a[], int low, int high) {
        int p, j, i, temp;
        p = a[low];
        i = low;
        j = high;
        while (i < j) {
            while (a[i] <= p && i <= high)
                i++;
            while (a[j] > p)
                j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
    }

    void Quick_sort(int a[], int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            Quick_sort(a, low, s - 1);
            Quick_sort(a, s + 1, high);
        }
    }

    public static void main(String args[]) {

        int a[] = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Invalid input");
        } else {
            Random rand = new Random();
            System.out.println("Enter the array elements");
            for (int i = 0; i < n; i++) {
                a[i] = rand.nextInt(1000);
            }
            System.out.println("Elements before sorting");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();

            QuickSort q = new QuickSort();
            q.Quick_sort(a, 0, n - 1);

            System.out.println("Elements after sorting");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
