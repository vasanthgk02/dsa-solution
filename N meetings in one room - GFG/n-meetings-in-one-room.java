//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    
    public static void merge(int start[], int end[], int s, int m, int e){
        int arr1[] = new int[e - s + 1];
        int arr2[] = new int[e - s + 1];
        int k = 0;
        int i = s, j = m + 1;
        while(i <= m && j <= e){
            if(end[i] <= end[j]){
                arr1[k] = start[i];
                arr2[k] = end[i];
                i++;
            }else{
                arr1[k] = start[j];
                arr2[k] = end[j];
                j++;
            }
            k++;
        }
        while(i <= m){
            arr1[k] = start[i];
            arr2[k] = end[i];
            i++;
            k++;
        }
        while(j <= e){
            arr1[k] = start[j];
            arr2[k] = end[j];
            j++;
            k++;
        }
        i = s; k = 0;
        while(i <= e){
            start[i] = arr1[k];
            end[i] = arr2[k];
            i++; k++;
        }
    }
    
    public static void mergeSort(int start[], int end[], int ind1, int ind2){
        if(ind1 == ind2) return;
        int mid = (ind1 + ind2) / 2;
        mergeSort(start, end, ind1, mid);
        mergeSort(start, end, mid + 1, ind2);
        merge(start, end, ind1, mid , ind2);
    }
    
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        mergeSort(start, end, 0, n - 1);
        // System.out.println(Arrays.toString(start) + "\n" + Arrays.toString(end));
        int ans = 1, e = end[0];
        for(int i =  1; i < n; i++){
            if(start[i] > e){
                ans++;
                e = end[i];
            }
        }
        return ans;
    }
}
