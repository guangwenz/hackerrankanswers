#!/bin/bash
exec scala $0 $@
!#
object CamelCaseWordCount {
	def main(args:Array[String]) {
		val sc = new java.util.Scanner (System.in);
        var s = sc.next();
        val ret = s.foldLeft(0){(acc,c)=>
        	if(c.isUpper || acc==0) acc+1
        	else acc
        }
        println(ret)
	}
}

CamelCaseWordCount.main(args)