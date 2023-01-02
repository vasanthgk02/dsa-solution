//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    public ArrayList<Integer> printF(ArrayList<Integer> arr1, int N, ArrayList<Integer> arr2, ArrayList<Integer> res, int ind){
        if(ind == N){
            int sum = 0;
            for(int i : arr2) sum += i;
            res.add(sum);
            return res;
        };
        arr2.add(arr1.get(ind));
        printF(arr1, N, arr2, res, ind + 1);
        arr2.remove(Integer.valueOf(arr1.get(ind)));
        printF(arr1, N, arr2, res, ind + 1);
        return res;
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        return printF(arr, N, new ArrayList<Integer>(), new ArrayList<Integer>(),  0);
    }
}