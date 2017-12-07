#!/bin/bash
exec scala $0 $@
!#
import scala.collection.mutable
object Pangram {
	def main(args:Array[String]) {
		val s = scala.io.StdIn.readLine
		val letters = mutable.Map[Char,Int](('a' to 'z').map(_->0):_*)
		s.map(_.toLower).foreach{c=>
			if(letters.contains(c)) letters.put(c,1)
		}
		if(letters.values.sum<26) println("pangram")
		else println("not pangram")
	}
}

Pangram.main(args)