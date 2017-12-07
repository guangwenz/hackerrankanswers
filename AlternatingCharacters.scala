#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/alternating-characters/problem
object AlternatingCharacters {
	def count(s:String):Int = {
		var deleted = 0
		var lastPos = 0
		var i=0
		(1 until s.length).foreach {i=>
			if(s(i) == s(i-1)) {
				deleted += 1
			} else {
				lastPos = i-1
			}
		}
		deleted
	}
	def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var q = sc.nextInt();
        var a0 = 0;
        while(a0 < q){
            var s = sc.next();
            println(count(s))
            a0+=1;
        }
    }
}
AlternatingCharacters.main(args)