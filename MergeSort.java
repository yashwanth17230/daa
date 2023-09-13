import java.util.Scanner;
import java.util.Random;
public class MergeSort{
    void Merge(int a[],int low,int mid,int high){
          int i=low,j=mid+1,k=low;
          int result[]=new int[high+1];
          while(i<=mid && j<=high){
            if(a[i]<a[j]){
                result[k]=a[i];
                i++;
                k++;
            }
            else{
                result[k]=a[j];
                j++;
                k++;
            }
          }
          while(i<=mid){
            result[k]=a[i];
            i++;
            k++;
          }
          while(j<=high){
            result[k]=a[j];
            j++;
            k++;
          }
          for(int m=low;m<=high;m++){
            a[m]=result[m];
          }
    }
    void Merge_sort(int a[],int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            Merge_sort(a,low,mid);
            Merge_sort(a,mid+1,high);
            Merge(a,low,mid,high);
        }
    }
    public static void main(String[] args){

        int a[]=new int[100];
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no fo elements");
        int n=sc.nextInt();
        if(n<1){
            System.out.println("invalid");
        }
        Random rand = new Random();
        System.out.println("enter the array Elements");
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(1000);
        }
        System.out.println("Elements before sorting");
        for(int i=0;i<n;i++){
             System.out.println(a[i]+"");
        }
        MergeSort m =new MergeSort();
        m.Merge_sort(a,0,n-1);

        System.out.println("Elements after sorting");
        for(int i=0;i<n;i++){
             System.out.println(a[i]+"");
        }
         System.out.println(" ");
    }
}