#!/bin/bash
exec scala $0 $@
!#
import scala.collection.mutable
// https://www.hackerrank.com/challenges/gem-stones/problem
object Gemstones {
	def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var arr = new Array[String](n);
        var letters = List.empty[Set[Char]]
        for(arr_i <- 0 to n-1) {
           arr(arr_i) = sc.next();
           letters = arr(arr_i).toSet +: letters
        }
        val ret  = letters.reduce(_ intersect _)
        println(ret.size)
    }
}

Gemstones.main(args)