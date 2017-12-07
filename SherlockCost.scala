#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/sherlock-and-cost/problem
object SherlockCost {
	def sum(in:Array[Int]):Int = {
		var lastLow = 0
		var lastHigh = 0

		var i = 1
		while(i < in.length) {
			val hh = Math.abs(in(i) - in(i-1))
			val lh = Math.abs(1 - in(i))
			val hl = Math.abs(in(i-1) -1 )

			val l = Math.max(lastLow, lastHigh+hl)
			val h = Math.max(lastHigh + hh, lastLow+lh)
			i +=1

			lastLow = l
			lastHigh = h
		}
		Math.max(lastLow, lastHigh)
	}
	def main(args:Array[String]) {
		val q = scala.io.StdIn.readInt
		(0 until q).foreach{_=>
			val n = scala.io.StdIn.readInt
			val in = scala.io.StdIn.readLine.split(" ").map(_.toInt)
			println(sum(in))
		}
	}
}
SherlockCost.main(args)