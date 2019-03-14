/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacw2;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author ashmit.khadka
 */
public class test {

    
    public static int ex1t1(int[] a){
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            int cnt = 0;
            for(int j = 0; j < n; j++)
            {
                if(a[i]==a[j])
                {
                    cnt++;
                }
            }
            if (cnt > n/2){
                return a[i];
            }
        }
        return -1;
    }
    
    public static void pa(int[] a){
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println("");
    }
    
    public static int ex1t2(int[] a)
    {
        pa(a);
        int n = a.length;        
        if (n == 2)
        {
            if (a[0] == a[1])
            {
                return a[0];
            }
            else
            {
                return -1;                
            }
        }
        else if (n == 1)
        {
            return a[0];
        }
        
        
        //System.out.println("n/2 is: " + n/2);
        //System.out.println("n/2 + 1 is: " + ((n/2) + 1));
        System.out.println("looking left..");
        int nl = ex1t2(Arrays.copyOfRange(a,0,(n/2)));
        System.out.println("found "+ nl);
        System.out.println("looking right..");
        int nr = ex1t2(Arrays.copyOfRange(a, (n/2), n)); 
        System.out.println("found "+ nr);

        
        if(nl == -1 && nr >= 0){
            return nr;
        }
        else if (nr == -1 && nl >=0 ){
            return nl;
        }
        
        if (nl == nr){
            return nr;
        }
        else{
            return -1;
        }
    }
    
    public static int ex1t3(int[] a)
    {
        int n = a.length;
        HashMap<Integer, Integer> freq_tally = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++)
        {
            if (!freq_tally.containsKey(a[i]))
            {
                freq_tally.put(a[i], 1);
            }
            else
            {
                int tally = freq_tally.get(a[i])+1; 
                if (tally > n/2)
                {
                    return a[i];
                }  
                freq_tally.put(a[i], tally);
            }
        }
        return -1;
        
    }
 
    public static int[] mergeSort(int[] a, int n) 
    {
        if (n < 2) {
            return a;
        }
        int mid = n/2;        
        int[] l = Arrays.copyOfRange(a, 0, mid); //i=0 to i<mid
        int[] r = Arrays.copyOfRange(a, mid, n); //i=mid to i<n   
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
        return a;
    }
    
    
    public static void merge(int[] a, int[] l, int[] r, int left, int right)
    {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right)
        {
            if (l[i] <= r[j])
            {
                a[k++] = l[i++];
            }
            else
            {
                a[k++] = r[j++];
            }
        }
        while (i < left)
        {
            a[k++] = l[i++];
        }
        while (j < right)
        {
            a[k++] = r[j++];
        }
    }
    
    
    public static int test(int[] a)
    {        
        int n = a.length; 
        a = mergeSort(a, n);        //O(nlong(n))
        int cnt = 0;
        int median = a[n/2];
        
        pa(a);
        System.out.println("median: "+median);
        
        for (int i = 0; i < n; i++) //O(n)
        {
            if (a[i] == median)
            {
                if (++cnt>n/2){
                    return median;
                }
            }
        }
        
        return -1;
 
    }
    
    public static void show_result(int r)
    {
        if (r < 0) 
        {
            System.out.println("SVD not found!");
        }
        else
        {
            System.out.printf("SVD is %d\n", r);
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1,1,3,3,1,3};
        //show_result(ex1t1(a));
        //show_result(ex1t2(a));
        //show_result(ex1t3(a));
        show_result(test(a));
    }
    
}
