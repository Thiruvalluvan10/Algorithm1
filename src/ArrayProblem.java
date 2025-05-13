import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayProblem {

    public int maxSubArray(int[] nums) {
        int m=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=nums[i]+nums[i-1]<nums[i]?nums[i]:nums[i]+nums[i-1];
            if(nums[i]<0)
            {
                m=Math.max(m,nums[i]);
                nums[i]=0;
            }
            else m=Math.max(m,nums[i]);
        }
        return m;
    }

    public static void change(int i,int j,int arr[])
    {
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

    }///this code is along with the problem => 31. Next Permutation
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind1=-1;
        int ind2=-1;
        int min=10;
        for(int i=n-1;i>=0;i--)
        {
            if(i!=n-1 && nums[i]<nums[i+1])
            {
                ind1=i;
                break;
            }
        }
        if(ind1==-1)
        {

            change(0,n-1,nums);
            return;
        }
        for(int i=n-1;i>ind1;i--)
        {
            if(nums[i]>nums[ind1])
            {
                min=nums[i];
                ind2=i;
                break;
            }
        }
        nums[ind2]=nums[ind1];
        nums[ind1]=min;
        change(ind1+1,n-1,nums);
    }

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

