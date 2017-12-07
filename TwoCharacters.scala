#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/two-characters/problem
import scala.collection.mutable.Map
object TwoCharacters{
	def max(s:String, memo:Map[String, Int]):Int = {
		var max = 0
		var i=0
		while(i < s.length){
			var j=0
			while(j < s.length) {
				if(s(j)!=s(i)) {
					val key = if(s(i)>s(j)) s"${s(j).toString}-${s(i).toString}" else s"${s(i).toString}-${s(j).toString}"                                        
					if(!memo.contains(key)) {
						val selected = s.filter(c=>c==s(i) || c==s(j))
						var last = selected.head
						var x = 1
						var valid = true
						while(x < selected.length && valid) {
							if(selected(x) == last) valid=false
							else last = selected(x)
							x+=1
						}
						val length = if(valid) selected.length else 0
						if(length > max) max = length
						memo.put(key, length)
					}
				}
				j+=1
			}
			i+=1
		}
		max
	}
	def main(args:Array[String]) {
		val sc = new java.util.Scanner (System.in);
		var len = sc.nextInt();
		var s = sc.next();

		println(max(s, Map.empty[String, Int]))
	}
}

TwoCharacters.main(args)