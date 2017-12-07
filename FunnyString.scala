#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/funny-string/problem
object FunnyString {
	def main(args:Array[String]) {
		val sc = new java.util.Scanner (System.in);
        var q = sc.nextInt();
        var a0 = 0;
        while(a0 < q){
            var s = sc.next()
            val len = s.length
            var reverse = s.reverse
            var funny = true
            var i = 1
            while(funny && i < len - 1) {
                funny = Math.abs(s(i) - s(i-1)) == Math.abs(reverse(i) - reverse(i - 1))
                i = i + 1                
            }
            val ret = if(funny) "Funny" else "Not Funny"
            println(ret)
            a0+=1;
        }
	}
}

FunnyString.main(args)