package tools

import System.{ currentTimeMillis => now }

/**
 * evaluate for how long a function run
 *
 * ex:
 * Timer({
 *   println("hello world")
 * }, "myFunction")
 *
 * will print "myFunction took [1ms]"
 */
object Timer {

  def apply[T](f: => T, functionName: String = "function") {
    val t = new Timer
    f
    println(functionName + " took [" + (now() - t.startTime) + "] ms")
  }

}

class Timer(private val startTime: Long = now()) {}