#!/bin/bash
exec scala $0 $@
!#

// https://www.hackerrank.com/challenges/separate-the-numbers/problem
object SeparateNumbers{
	def checkBeautiful(s:String, source:String):Boolean = {
		if (source.isEmpty) false
		else if(source.length == 1) BigInt(source) - BigInt(s) == 1
		else {
			val start = BigInt(s)
			val next = BigInt(source.take(s.length))
			val nextD = BigInt(source.take(s.length+1))
			if((next - start)==1 && source.take(s.length) == next.toString) {
				val left = source.drop(s.length)
				if(left.nonEmpty) checkBeautiful(next.toString, left)
				else true
			} else if((nextD - start)==1 && source.take(s.length+1) == nextD.toString){
				val left = source.drop(s.length+1)
				if(left.nonEmpty) checkBeautiful(nextD.toString, left)
				else true
			} else false
		}
	}
	def main(args:Array[String]) {
		val sc = new java.util.Scanner (System.in);
        var q = sc.nextInt();
        var a0 = 0;
        while(a0 < q){
            var s = sc.next();
            // your code goes here
            var i=1
            var start = s.head.toString
            var body = s.tail
            var isBeautiful = false
            while(!isBeautiful && body.nonEmpty) {
            	i = i+1
            	isBeautiful = checkBeautiful(start, body)
            	start = s.take(i)
            	body = s.drop(i)            	
            }
            if(isBeautiful) println(s"YES ${start.dropRight(1)}")
            else println("NO")

            a0+=1;
        }
	}
}

SeparateNumbers.main(args)