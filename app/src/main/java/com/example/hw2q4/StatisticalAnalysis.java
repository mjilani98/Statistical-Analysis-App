package com.example.hw2q4;

import java.util.Arrays;

public class StatisticalAnalysis {

    //The string that will be passed by the controller
    private String strNumbers;

    //Array to store the numbers
    private double[]  numArray;

    public StatisticalAnalysis(String strNumbers)
    {
        //splitting the space
        String[] strNum = strNumbers.split(" ");

        numArray = new double[strNum.length];

        for(int x = 0 ; x < strNum.length; x++)
        {
            numArray[x] = Double.parseDouble(strNum[x]);
        }
    }

    //get the sum
    public double getSum()
    {
        double sum =0;

        for(int x = 0 ; x < numArray.length; x++)
        {
            sum+= numArray[x];
        }
        return sum;
    }

    //get the mean
    public double getMean()
    {
        double mean = getSum()/numArray.length;

        return mean;
    }

    //get the median
    public double getMedian()
    {
        int index =0 ;
        int length = numArray.length;
        double median =0;

        //if the length of array is odd
        if(length%2 != 0)
        {
            index = length /2;
            median = numArray[index];
        }
        //if the length of array is even
        else
        {
            //variables for the middle numbers
            double mid1;
            double mid2;

            mid1 = numArray[length/2];
            mid2 = numArray[(length/2) +1];



            median = (mid1 + mid2)/2;
        }


        return median;
    }
    //get the standard deviation
    public double getStandardDeviation()
    {
        double mean =  getMean();
        int length = numArray.length;

        double squaredDiffSum = 0.0;
        for(int x = 0 ; x < numArray.length ; x++)
        {
            squaredDiffSum += Math.pow(numArray[x] - mean,2);
        }

        double variance = squaredDiffSum / length;

        return Math.sqrt(variance);
    }

    //get the minimum
    public double getMinimum()
    {
        double minimum = Double.MAX_VALUE;

        for(int x = 0 ; x < numArray.length; x++)
        {
            if(numArray[x] < minimum)
            {
                minimum = numArray[x];
            }
        }

        return minimum;
    }


    //get the maximum
    public double getMaximum()
    {
        double maximum = 0;

        for(int x = 0 ; x < numArray.length; x++)
        {
            if(numArray[x] > maximum)
            {
                maximum = numArray[x];
            }
        }

        return maximum;
    }


}
