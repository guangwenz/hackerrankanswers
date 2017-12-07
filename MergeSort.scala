#!/bin/bash
exec scala $0 $@
!#

object MergeSort {
	def mergeSort(in:Array[Int]):Array[Int] = {
		if(in.length == 1) in
		else {
			println(s"sorting ${in.mkString(",")}")
			val middle = in.length/2
			val middleValue = in(middle)
			var (left, right) = in.splitAt(middle)
			var idx = 0
			(0 until left.length).foreach
			while(idx < in.length) {
				if(left(idx) < middleValue) {
					in(idx)=left(idx)
				} else {
					in(middle+idx) = right(idx)
				}
				idx = idx+1
			}
			mergeSort(left) ++ mergeSort(right)
		}
	}
	def main(args:Array[String]) {
		val n = scala.io.StdIn.readInt
		val s = scala.io.StdIn.readLine
		println(mergeSort(s.split(" ").map(_.toInt)))
	}
}

MergeSort.main(args)