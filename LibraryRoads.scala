#!/bin/bash
exec scala $0 $@
!#
import scala.collection.mutable
class Graph(v:Int) {
	val graph = mutable.Map.empty[Int, List[Int]]
	(1 to v).foreach {i=>
		graph(i)=List.empty[Int]
	}

	def addEdge(u:Int, v:Int, directed:Boolean=false):Unit = {
		graph(u) = graph(u) :+ v
		if(!directed) graph(v) = graph(v) :+ u
	}	

	def output(input: Map[Int,Option[Int]], empty:String=""):String = {
		input.map{case (k,v)=>s"$k -> ${v.getOrElse(empty)}"}.mkString(",")
	}

	def DFS:Unit = {
		var time:Int = 0
		val color = mutable.Map.empty[Int,Int] //color: 1 white(not visited), 2 gray(visiting), 3 black(visited)
		val d = mutable.Map.empty[Int,Option[Int]]
		val f = mutable.Map.empty[Int,Option[Int]]
		val p = mutable.Map.empty[Int, Option[Int]]

		graph.foreach{
			case (k,v)=>
				color(k) = 1
				p(k)=None
				d(k)=None
				f(k)=None
		}
		graph.keys.toList.sorted.foreach{k=>
			if(color(k)==1) {
				println(s"visiting $k")
				visit(k)
			}
		}
		def visit(u:Int):Unit = {
			color(u)=2
			time = time + 1
			d(u)=Some(time)
			graph(u).foreach{v=>
				if(color(v)==1) {
					p(v)=Some(u)
					visit(v)
				}
			}
			color(u)=3
			time=time+1
			f(u) = Some(time)
		}
		println(s"start: ${output(d.toMap,"inf")}")
		println(s"finish: ${output(f.toMap,"inf")}")
		println(s"parent: ${output(p.toMap,"no parent")}")
	}

	/**
	* BFS traversal of the tree.
	*/
	def BFS(s:Int):(Map[Int,Option[Int]],Map[Int,Option[Int]]) = {
		val color = mutable.Map.empty[Int,Int] //color: 1 white(not visited), 2 gray(visiting), 3 black(visited)
		val d = mutable.Map.empty[Int,Option[Int]]
		val p = mutable.Map.empty[Int, Option[Int]]
		val queue = new mutable.Queue[Int]

		// Initialize with empty values 
		graph.foreach{
			case (k,v)=>
				color(k) = 1
				d(k)=None
				p(k)=None

		}
		color(s) = 2
		d(s)=Some(1)
		p(s)=None
		queue.enqueue(s)
		while(queue.nonEmpty) {
			val u=queue.dequeue
			graph(u).foreach{v=>
				if(color(v)==1) {
					color(v) = 2
					p(v)=Some(u)
					d(v)=d(u).map(_+1)
					queue.enqueue(v)
				}
			}
			color(u)=3
		}
		(d.toMap,p.toMap)
	}
}

object LibraryRoads {
	def main(args:Array[String]): Unit = {
		val sc = new java.util.Scanner (System.in);
        var q = sc.nextInt();
        var a0 = 0;
        while(a0 < q){
            var n = sc.nextInt();
            var m = sc.nextInt();
            var x = sc.nextLong();
            var y = sc.nextLong();
			val graph = new Graph(n)

            var a1 = 0;
            while(a1 < m){
                var city_1 = sc.nextInt();
                var city_2 = sc.nextInt();
                graph.addEdge(city_1, city_2, true)
                a1+=1;
            }
            graph.DFS
   //          println("-----BFS-----")
   //          val (d,p)=graph.BFS(1)
   //          println(s"distances: ${graph.output(d,"infinity")}")
			// println(s"parents:${graph.output(p,"no parent")}")
            a0+=1;
        }
	}
}

LibraryRoads.main(args)