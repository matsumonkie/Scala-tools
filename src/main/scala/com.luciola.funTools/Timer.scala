package foo.luciola.funTools

import System.{ currentTimeMillis => now }

/**
 * evaluate for how long a function run
 *
 * ex:
 * Timer("myFunction") {
 *   println("hello world")
 * }
 * will print "myFunction took [1ms]"
 *
 * Timer {
 *   println("hello world")
 * }
 * will print "function took [1ms]"
 */
object Timer {

  def apply[T](f: => T) : Long = {
    apply("function")(f)
  }

  def apply[T](functionName: String)(f: => T) : Long = {
    val timeBeforeFunctionExecution = now()
    f
    val duration = now() - timeBeforeFunctionExecution
    println(s"$functionName took [ $duration ] ms")
    duration
  }

}
