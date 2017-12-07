#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/fibonacci-modified/problem
object FabonacciModified {
	def main(args:Array[String]) {
		val Array(t1,t2,n)=scala.io.StdIn.readLine.split(" ").map(_.toInt)
		var j:BigInt = t1
		var jl:BigInt = t2
		(2 until n).foreach {i=>
			val ti:BigInt = j+jl*jl
			j = jl
			jl = ti
		}
		println(jl)
	}
}
FabonacciModified.main(args)