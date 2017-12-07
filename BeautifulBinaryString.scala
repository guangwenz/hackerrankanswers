#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/beautiful-binary-string/problem
object BeautifulBinaryString {
	def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var B = sc.next();

        var i = 0
        var steps = 0
        while(i < B.length - 2) {
        	if(B(i).toString + B(i+1).toString + B(i+2).toString == "010") {        		
        		steps += 1
        		if((i+3) < B.length) {
        			B = B.substring(0, i+1) + B(i+3) + B.substring(i+3)
        		}
        	}
        	i += 1
        }
        println(steps)
    }
}
BeautifulBinaryString.main(args)