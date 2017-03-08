#Program used to find the median of two sorted arrays of integer numbers
#Implements a sort of binary search to the two arrays to find the two median numbers
#(as we see, the merged array has an even number of elements

import math

array_int1 = input("Enter 1st array of integer numbers: ");
array_int2 = input("Enter 2nd array of integer numbers: ");

def Median_arr(arr1, arr2):
    #initial sizes of the arrays- adjusted to match with indicies

    size1 = float(len(arr1)-1);
    size2 = float(len(arr2)-1);

    #need an initializer
    dumb = 1; #doesn't matter how we splice the initial two arrays into two halves
    prev_arr1 = arr1 ;
    prev_arr2 = arr2 ;

    while (size1 > 1) | (size2 > 1):
        if dumb == 1:
            dumb = 0; #only one time
            a = 0;
            b = 1;
        
        #the current median indices of each array at each iteration
        temp_med1 = a*math.ceil(size1 /2) + b*math.floor(size1 /2);
        temp_med2 = b*math.ceil(size2 /2) + a*math.floor(size2 /2);


        #truth/false flags
        a = 0;
        if prev_arr1[int(temp_med1)] > prev_arr2[int(temp_med2)]:
            a = 1;
        b = 1 - a;

        #update arrays
        new_arr1 = prev_arr1[b*int(temp_med1):(int(temp_med1)*a + int(size1)*b + 1)];
        new_arr2 = prev_arr2[a*int(temp_med2):(int(temp_med2)*b + int(size1)*a + 1)];


        #update sizes
        size1 = float(len(new_arr1)-1);
        size2 = float(len(new_arr2)-1);

        #reset for next possible iteration
        prev_arr1 = new_arr1;
        prev_arr2 = new_arr2;


    median1 = max(new_arr1[0], new_arr2[0]);
    median2 = min(new_arr1[1], new_arr2[1]);

    print "The median numbers are: ", median1, ",", median2 


Median_arr(array_int1, array_int2) 

    
