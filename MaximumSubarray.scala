#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/maxsubarray/problem
import scala.collection.mutable.Map
object MaximumSubarray {
	def time[T](name:String)(block: => T) = {
		val start = System.nanoTime
		val ret = block
		val end = System.nanoTime
		println(s"$name took ${end - start} nanoseconds")
		ret
	}
	def sum(in:Array[Int], start:Int, end:Int, memo:Map[String,Int]):Int = {
		val key = s"$start-$end"
		if(memo.contains(key)) memo(key)
		else {
			val ret = in(end) + sum(in, start, end -1, memo);
			memo.put(key, ret)
			ret
		}
	}
	def max(in:Array[Int], start:Int):Int={
		if(start >= in.length) return 0
		val len = in.length
		var largest = in(start)
		var sum = in(start)
		var i = start + 1
		while(i < len) {
			sum += in(i)
			if(sum > largest) largest = sum
			i += 1
		}
		largest	
	}
	def max2(in:Array[Int]):Unit = {
		var sum = 0
		var c_sum = Int.MinValue
		var non_i = 0
		in.foreach{e =>
			sum += e
			if(e > 0) non_i += e
			if(sum > c_sum) c_sum = sum
			if(sum < 0) sum=0
		}
		if(non_i == 0) non_i = in.max
		
		println(s"$c_sum, $non_i")
	}
	def main(args:Array[String]) {
		val sc = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
		val q = sc.readLine.toInt
		for(i <- (0 until q)) {
			val n = sc.readLine.toInt
			val c = sc.readLine.split(" ").map(_.toInt)
			
			max2(c)
			// if(c.filter(_ > 0).length==0) {
			// 	println(s"${c.max} ${c.max}")
			// } else {
			// 	val incon=c.filter(_ > 0).sum
			// 	var lastMax=0
			// 	for(i <- (0 until n)) {
			// 		if(c(i)>0) {
			// 			val ret = max(c,i)
			// 			if(ret>lastMax) lastMax=ret
			// 		}
			// 	}
			// 	println(s"$lastMax $incon")					
			// }
		}
	}
}

MaximumSubarray.main(args)