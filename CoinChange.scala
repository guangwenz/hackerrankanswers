#!/bin/bash
exec scala $0 $@
!#
import scala.collection.mutable.Map
// https://www.hackerrank.com/challenges/coin-change/problem
object CoinChange {

  /**
  recursive + memoization
  */
  def makeChange(money:Long, coinTypes:Int, changes:Array[Long], memo: Map[String, Long]):Long = {
    if(money == 0) return 1
    if(money < 0) return 0
    if(coinTypes<=0 && money>=1) return 0
    val key = s"$money-$coinTypes"
    if(memo.contains(key)) {
      memo(key)
    } else {
      val ret = makeChange(money, coinTypes-1, changes,memo) + makeChange(money - changes(coinTypes-1), coinTypes, changes,memo)
      memo.put(key, ret)
      ret
    }    
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var c = new Array[Long](m);
    for(c_i <- 0 to m-1) {
       c(c_i) = sc.nextLong();
    }
    // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
    println(makeChange(n,c.length,c,Map.empty[String,Long]))
  }
}

CoinChange.main(args)