import java.util.Scanner;

public class Kruskal {
    int parent[] = new int[10];

    int find(int m) {
        int p = m;
        while (parent[p] != 0)
            p = parent[p];
        return p;
    }

    void union(int i, int j) {
        if (i < j)
            parent[i] = j;
        else
            parent[j] = i;
    }

    void kruskal(int[][] a, int n) {

        int u = 0, v = 0, min, k = 0, i, j, sum = 0;
        while (k < n - 1) {
            min = 99;
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (a[i][j] < min && i != j) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            i = find(u);
            j = find(v);
            if (i != j) {
                union(i, j);
                System.out.println("(" + u + "," + v + ")" + "=" + a[u][v]);
                sum = sum + a[u][v];
                k++;
            }
            a[u][v] = a[v][u] = 99;
        }
        System.out.println("The cost of the minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        int i, j;
        System.out.println("Enter the number of vertices of the graph");
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int a[][] = new int[n + 1][n + 1]; // Increased array size to accommodate 1-based indexing
        System.out.println("Enter the weighted matrix");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        Kruskal k = new Kruskal();
        k.kruskal(a, n);
    }
}
/*0 1 2 3
1 0 1 99
2 1 0 5
3 99 5 0*/