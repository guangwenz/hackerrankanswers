#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/sam-and-substrings/problem
object SamSubstring {
	def sum(s:String):Long = {
		val mod = (1e9 + 7).toLong
		val nums = s.split("").map(_.toInt)
		var sum:Long = nums.head
		var output:Long = nums.head
		var i = 1
		while(i < nums.length) {
			sum = 10*sum + (i+1)*nums(i)
			sum = sum % mod
			output = (output + sum) % mod
			i += 1
		}
		output
	}
	def main(args:Array[String]){
		val s = scala.io.StdIn.readLine
		println(sum(s))
	}
}

SamSubstring.main(args)