#!/bin/bash
exec scala $0 $@
!#
object SuperReduceString {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var s = sc.next();

    def split(input: String): String = {
      val ret = input.foldLeft(new StringBuilder) { (acc, c) =>
        if (acc.nonEmpty) {
          if (acc.last == c) acc.dropRight(1)
          else acc.append(c)
        } else acc.append(c)
      }
      ret.toString
    }

    val ret = split(s)
    val display = if (ret.isEmpty) "Empty String" else ret
    print(display)
  }
}

SuperReduceString.main(args)