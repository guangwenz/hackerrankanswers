#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/equal/problem
object Equal {

	// def foo(people:Int, operationCount:Int, chocolates:Array[Int]):Int = {		
	// 	var ret = operationCount
	// 	val options = Array(1,2,5)
	// 	// val groups = for(p <- people) yield chocolates.zipWithIndex.filter(_._2 != p).map(_._1)
	// 	for(p <- (0 until people)){
	// 		//skip pth people for update
	// 		var solved=false
	// 		val newChanges = for(o <- options) yield {
	// 			val changed = chocolates.zipWithIndex.map(i=> if(i._2 == p) i._1 else i._1 + o)
	// 			if(changed.toSet.size == 1) {
	// 				println("problem solved !")
	// 				solved=true
	// 				ret = ret + 1
	// 			}
	// 			changed
	// 		}
	// 		if(!solved) {
	// 			println(s"solving ${newChanges.map(_.mkString(",")).mkString("|")}")
	// 			newChanges.foreach(c=> foo(people, ret, c))
	// 		} 
	// 	}
	// 	ret
	// }
	def main(args:Array[String]) {
		val q = scala.io.StdIn.readInt
		for(i <- (0 until q)){
			val colleagues = scala.io.StdIn.readInt
			val chocolates = scala.io.StdIn.readLine.split(" ").map(_.toInt)
			// println(chocolates)
		}
	}
}

Equal.main(args)