
import java.util.Scanner;
public class DIJKSTRA {
	
	int d[]=new int[10];
	int p[]=new int[10];
	int visited[]=new int[10];
	
	public void dijk(int[][]a,int s,int n) {
		int u=-1,v,i,j,min;
		for(v=0;v<n;v++) {
			d[v]=99;
			p[v]=-1;
		}
		d[s]=0;
		for(i=0;i<n;i++) {
			min=99;
			for(j=0;j<n;j++) {
				if(visited[j]==0&&d[j]<min) {
					min=d[j];
					u=j;
				}
			}
			visited[u]=1;
		for(v=0;v<n;v++) {
			if(visited[v]==0&&(d[u]+a[u][v]<d[v])){
				d[v]=d[u]+a[u][v];
				p[v]=u;
			}
		}
	}
}
	
	void path(int v,int s){
		if(p[v]!=-1) {
			path(p[v],s);
		}
		if(v!=s) {
			System.out.println("->"+v+" ");
		}
	}
	
	void display(int s ,int n) {
		int i;
		for(i=0;i<n;i++) {
			if(i!=s) {
				System.out.println(s+" ");
				path(i,s);
				System.out.println(""+d[i]+"");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][]a=new int[10][10];
		int i,j,n,s;
		System.out.println("enter the number of vertices:");
		n=sc.nextInt();
		System.out.println("enter the weighted matrix");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("enter the source vertex:");
		s=sc.nextInt();
		DIJKSTRA tr =new DIJKSTRA();
		tr.dijk(a,s,n);
		System.out.println("the shortest path between source "+s+" for remaining vertices are");
		tr.display(s,n);

		
		
	}

}

/*0 3 1 99
3 0 1 1
1 1 0 5
99 1 5 0*/
