#!/bin/bash
exec scala $0 $@
!#
object AngaryChildren {
	def main(args:Array[String]) {
		val input = new java.util.Scanner(System.in)
		val packets = input.nextInt
		val children = input.nextInt
		var candies = new Array[Int](packets)
		var i = 0
		(0 until packets).foreach{ i =>
			candies(i) = input.nextInt
		}
		println("result")
		println(candies.mkString("\n"))
	}
}
AngaryChildren.main(args)
