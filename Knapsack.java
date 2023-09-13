import java.util.Scanner;
import java.util.Random;

public class Knapsack {

    public static void k(int n, int p[], int w[], int m) {
        double x[] = new double[n];
        double profit = 0;
        int i;
        for (i = 0; i < n; i++) {
            x[i] = 0;
            if (w[i] > m) {
                break;
            }
            x[i] = 1;
            profit = profit + (x[i] * p[i]);
            m = m - w[i];
        }
        if (i < n) {
            x[i] = (double) m / w[i]; 
            profit = profit + (x[i] * p[i]);
        }
        System.out.println("The selected items are");
        for (i = 0; i < n; i++) {
            System.out.println(x[i]);
        }
        System.out.println("profit:" + profit);
    }

    public static void main(String[] args) {
        int i, j, temp, m, n;
        double temp_r;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no items");
        n = sc.nextInt();
        System.out.println("Enter the max value");
        m = sc.nextInt();
        int p[] = new int[n];
        int w[] = new int[n];
        double ratio[] = new double[n];
        Random r = new Random();
        System.out.println("Enter the weights");
        for (i = 0; i < n; i++) {
            w[i] = r.nextInt(100) + 1;
            System.out.println(w[i] + "");
        }
        System.out.println("Enter the profits");
        for (i = 0; i < n; i++) {
            p[i] = r.nextInt(100) + 1;
            System.out.println(p[i] + "");
        }
        System.out.println("The ratio before sorting");
        for (i = 0; i < n; i++) {
            ratio[i] = (double) p[i] / w[i]; 
            System.out.println(ratio[i] + " ");
        }

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    temp_r = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = temp_r;

                    temp = p[j];
                    p[j] = p[i];
                    p[i] = temp;

                    temp = w[j];
                    w[j] = w[i];
                    w[i] = temp;
                }
            }
        }

        System.out.println("The ratio after sorting");
        for (i = 0; i < n; i++) {
            System.out.println(ratio[i] + "");
        }
        k(n, p, w, m);
    }
}
