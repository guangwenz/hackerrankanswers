#!/bin/bash
exec scala $0 $@
!#
// https://www.hackerrank.com/challenges/weighted-uniform-string/problem
object WeightedUniformString {

    def time[T](timerName: String, convert: Long => (Long, String) = { time => (time / 1000 / 1000, "ms") })(block: => T):T = {
        val t0 = System.nanoTime()
        val result = block
        val t1 = System.nanoTime()
        val ret = convert(t1 - t0)
        // println(s"$timerName took ${ret._1} ${ret._2}")
        result
    }
	def main(args:Array[String]) {

		val sc = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        var s = time("read input"){sc.readLine()}
        var n = sc.readLine().toInt;
        var a0 = 0;


        val w = ('a' to 'z').zipWithIndex.map(l=>l._1->(l._2 + 1)).toMap        
        var counts = Set.empty[Int]
        var i=0
        var lastC:Char = '0'
        var cont = 1
        time("counting"){
            s.foreach{c=>
            	if(c == lastC) {
            		cont = cont + 1
            		counts += w(c)*cont
            	} else {
            		cont = 1
            		counts += w(c)
            	}
            	lastC=c
            }
        }
        time("checking"){
            val output = new StringBuilder
            while(a0 < n){
                var x = sc.readLine.toInt;
                // your code goes here
                if(counts.contains(x)) output.append("Yes\n")
                else output.append("No\n")
                a0 += 1
            }
            println(output.toString)
        }
	}
}

WeightedUniformString.main(args)