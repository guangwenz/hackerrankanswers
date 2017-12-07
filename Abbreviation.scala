#!/bin/bash
exec scala $0 $@
!#
object Abbreviation {
	def abbreviation(a: String, b: String): String =  {
        // Complete this function
        var bstart = -1
        var boffset = 0
        var i=0
        var matched = false
        while(i< a.length && !matched){
        	val c = a(i).toUpper
        	if(bstart == -1 && c == b.head) {
        		bstart = i
        		boffset = 1
        	}
        	else if(bstart > -1) {
        		if(c == b(boffset)) {
        			if(boffset+1 == b.length) matched=true
        			else boffset += 1
        		}
        		else {
        			bstart = -1
        			boffset = 0
        		}
        	}
        	i+=1
        }
        if(matched) "YES" else "NO"
    }

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var q = sc.nextInt();
        var a0 = 0;
        while(a0 < q){
            var a = sc.next();
            var b = sc.next();
            val result = abbreviation(a, b);
            println(result)
            a0+=1;
        }
    }
}
Abbreviation.main(args)