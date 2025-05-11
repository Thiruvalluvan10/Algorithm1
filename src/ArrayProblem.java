import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayProblem {

    public static void setZeroes(int arr[][])
    {
        int n=arr.length;
        int m=arr[0].length;
        int col=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==0)
                {
                    arr[i][0]=0;

                    if(j!=0) arr[0][j]=0;
                    else col=0;
                }
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(arr[0][j]==0 || arr[i][0]==0)
                {
                    arr[i][j]=0;
                }
            }
        }
        if(arr[0][0]==0)
        {
            for(int i=0;i<m;i++)
            {
                arr[0][i]=0;
            }
        }
        if(col==0)
        {
            for(int i=0;i<n;i++)
            {
                arr[i][0]=0;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> generate(int n) {
        List <List<Integer>> ll=new ArrayList<>();
        ll.add(new ArrayList<>(Arrays.asList(1)));
        if(n==1)
            return ll;
        ll.add(new ArrayList<>(Arrays.asList(1,1)));
        if(n==2)
            return ll;
        for(int i=2;i<n;i++)
        {
            int m=(i+1);
            m=m/2;
            m=(i+1)%2==0?m:m+1;
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                if(j==0)
                {
                    l.add(1);
                }
                else if(j==1)
                {
                    l.add(1+(ll.get(i-1).get(1)));
                }
                else
                {
                    l.add(ll.get(i-1).get(j)+ll.get(i-1).get(j-1));
                }
            }
            int s=l.size();
            if((i)%2==0)
            {
                s--;
            }
            for(int j=s-1;j>=0;j--)
            {
                l.add(l.get(j));
            }

            ll.add(l);
        }
        return ll;
    }





    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        setZeroes(arr);
    }
}

