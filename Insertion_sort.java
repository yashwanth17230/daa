import java.util.Scanner;
import java.util.Random;
public class Insertion_sort{
    public static void main(String[] args){
        int i,j,k,n,temp;
        int arr[]=new int[1000];
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no fo elements");
        n=sc.nextInt();
        long Start=System.CurrentTimeMillis();
        if(n<1){
            System.out.println("inavlid");
        }
        Random rand = new Random();
        System.out.println("enter the array Elements");
        for(i=0;i<n;i++){
            arr[i]=rand.nextInt(500);
        }
        System.out.println("Elements before sorting");
        for(i=0;i<n;i++){
             System.out.println(arr[i]+"");
        }
 
        for(i=0;i<n-1;i++){
            j=i;
            for(k=i+1;k<n;k++){
                if(arr[k]<arr[j]){
                    j=k;
                }
            }
            temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
        System.out.println("Elements after sorting");
        for(i=0;i<n;i++){
             System.out.println(arr[i]+"");
        }
         System.out.println(" ");
        long End=System.CurrentTimeMillis();
        System.out.println("Time requried for completion:"+(End-Start)+"milliseconds");
    }
}