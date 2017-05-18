//Anatoly Brevnov
//October 4, 2015
//Quick Sort

import java.util.*;
import java.lang.Math;



public class QuickSort {
    
    
    public static void main(String[] args){
        
        int[] randomNumbers=new int[9]; //Creates array
        Random ran = new Random();
        
        for(int i = 0; i < randomNumbers.length;i++){
            randomNumbers[i]=ran.nextInt(10); //Populates array with random integers
        }
        for(int i = 0; i < randomNumbers.length;i++){
            System.out.print(randomNumbers[i]);
        }
        System.out.println("");
        
        
        //sorts
        randomNumbers=QuickSort(randomNumbers);
        
        
        //prints out sorted array
        
        for(int i = 0; i < randomNumbers.length;i++){
            System.out.print(randomNumbers[i]);
        }
        System.out.println("");
        
        
        
        
    }
    private static int[] QuickSort(int[] a){
        //base case if there is only one element in the array
        if (a.length<=1){
            return a;
        }
        
        //create my three arrays that are greater, less than, or equal to the pivot
        int[] greater = new int[a.length-1];
        int[] less = new int[a.length];
        int[] equal = new int[a.length];
       
        int gcount=0;
        int lcount=0;
        int ecount=0;
        //set the pivot to the first element
        int p=a[0];
        
        //sort array a into the greater, less, equal to arrays
        for (int i=0; i<a.length; i++){
            if (a[i]<p){
                less[lcount]=a[i];
                lcount++;
            }
            else if (p!=a[i]){
                greater[gcount]=a[i];
                gcount++;
            }
            
            else {
                equal[ecount]=a[i];
                ecount++;
                
            }
            
        }
        //since I chose to use arrays over arraylists for efficiency reasons, I need to deal with arrays that are too long because i defined them as being larger than they are; to do this, i need to make new arrays and populate them as I do below
        int[] finalArray=new int[gcount+lcount+ecount];
        int[] finalGreat=new int[gcount];
        int[] finalLess=new int[lcount];
        
        for (int i=0;i<gcount;i++){
            finalGreat[i]=greater[i];
        }
        
        for (int i=0;i<lcount;i++){
            finalLess[i]=less[i];
        }
        
        //recursively sort greater and less arrays
        
        finalLess=QuickSort(finalLess);
        //equal=QuickSort(equal);
        finalGreat=QuickSort(finalGreat);
        
        
        //combine less, equal to, and greater than arrrays in one, final array
        
        for (int i=0;i<finalLess.length;i++){
            finalArray[i]=finalLess[i];
        }
        
        for (int i=0;i<ecount;i++){
            
            finalArray[i+finalLess.length]=equal[i];
        }
        
        for (int i=0;i<finalGreat.length;i++){
            finalArray[i+finalLess.length+ecount]=finalGreat[i];
        }
        
        //return the final Array
        return finalArray;
        // int[] greaterf = new int[a.length-1];
        //int[] lessf = new int[a.length-1];
        //int[] equalf = new int[a.length];
        /* int l=lp;
         int r=rp;
         int p=a[lp];
         
         
         if (r-l>1){
         while (r>l){
         while (a[l]<p && l<a.length-1){
         l++;
         }
         while (a[r]>p && r>0){
         r--;
         }
         if (r>l){
         int al=a[l];
         a[l]=a[r];
         a[r]=al;
         
         }
         else{
         QuickSort(a, lp, r);
         QuickSort(a, l, rp);
         }
         }
         
         }*/
        
        
    }
}

