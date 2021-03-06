package com.luciola.funTools

/**
 * print variables with a simple format
 *
 * ex: Echo("woodpecker", woodpecker.name)
 * will print "woodpecker [woody]"
 */
object Echo {

  private def formatStr (value: Any) : String = s"[$value]"

  def apply (varNames: Any*) {
    if (varNames.length == 2) {
      println(varNames(0) + " " + formatStr(varNames(1)))
    } else {
      varNames.foreach(x => print(formatStr(x)))
      println
    }
  }
}
