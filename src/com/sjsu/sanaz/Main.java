package com.sjsu.sanaz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {


    public static void main(String args[]) {
       /* ZipCodeRange[] zipCodesArray = new ZipCodeRange[3];
        zipCodesArray[0]=new ZipCodeRange(94133,94133);
        zipCodesArray[1]=new ZipCodeRange(94200,94299);
        zipCodesArray[2]=new ZipCodeRange(94226,94399);
        */

        ZipCodeRange[] zipCodesArray = new ZipCodeRange[]{ new ZipCodeRange(94133,94133),
                                                           new ZipCodeRange(94226,94399),
                                                           new ZipCodeRange(94200,94299)};

        mergeZipCodeIntervals(zipCodesArray);
    }



    public static void mergeZipCodeIntervals(ZipCodeRange[] zipCodesArray)
    {
        if (zipCodesArray.length == 0 || zipCodesArray == null){
            return;
        }

        sortZipCodeIntervals(zipCodesArray);
        // Create an empty stack of zip code intervals
        Stack<ZipCodeRange> zipCodeRangeStack = new Stack<>();
        // Push the first zip code interval to the zipCodeRangeStack
        zipCodeRangeStack.push(zipCodesArray[0]);
        for (int i = 1 ; i < zipCodesArray.length; i++)
        {
            ZipCodeRange topZipCode = zipCodeRangeStack.peek();
            if (topZipCode.end < zipCodesArray[i].start){
                zipCodeRangeStack.push(zipCodesArray[i]);
            }
            else if (topZipCode.end < zipCodesArray[i].end)
            {
                topZipCode.end = zipCodesArray[i].end;
                zipCodeRangeStack.pop();
                zipCodeRangeStack.push(topZipCode);
            }
        }

        // Print contents of zipCodeRangeStack
        while (!zipCodeRangeStack.isEmpty())
        {
            ZipCodeRange current = zipCodeRangeStack.pop();
            System.out.print("["+current.start+","+current.end+"] ");
        }
    }

    // Sort the intervals based on starting element in increasing order
    private static void sortZipCodeIntervals(ZipCodeRange[] zipCodesArray) {
        Arrays.sort(zipCodesArray, new Comparator<ZipCodeRange>() {
            @Override
            public int compare(ZipCodeRange o1, ZipCodeRange o2) {
                if(o1.start > o2.start){
                    return 1;
                }
                if(o1.start < o2.start){
                    return -1;
                }
                return 0;
            }
        });
    }


}




