#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/candies/problem
object Candies {
	def candies(n: Int, arr: Array[Int]): Long =  {
        // Complete this function
        val candies = Array((0 until n).map(_=>1):_*)
        var i=1
        while (i < n) {
        	if(arr(i) > arr(i-1)){
        		candies(i)=candies(i-1)+1
        	}
        	i+=1
        }
        i=n-2
        while(i>=0) {
        	if(arr(i) > arr(i+1)) {
        		candies(i) = Math.max(candies(i), candies(i+1)+1)
        	}
        	i-=1
        }
        var sum:Long = 0
        i=0
        while(i< n){
        	sum+=candies(i)
        	i+=1
        }
        sum
    }

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var arr = new Array[Int](n);
        for(arr_i <- 0 to n-1) {
           arr(arr_i) = sc.nextInt();
        }
        val result = candies(n, arr);
        println(result)
    }
}

Candies.main(args)