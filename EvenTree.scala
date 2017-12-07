#!/bin/bash
exec scala $0 $@
!#
object EvenTree {
	def main(args:Array[String]): Unit = {
		val input = new java.util.Scanner(System.in)
		val Array(n,m) = input.nextLine().split(" ").map(_.toInt)
		(0 until m).foreach{ i=>
			val Array(u,v) = input.nextLine().split(" ").map(_.toInt)			
		}
	}
}
EvenTree.main(args)