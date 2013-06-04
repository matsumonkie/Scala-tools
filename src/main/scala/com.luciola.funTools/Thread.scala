package com.luciola.funTools


/**
 * Class that simplifies the syntax for creating/running thread.
 * e.g:
 * val myThread = Thread(println("hello"))
 * myThread.run()
 *
 * or
 *
 * Thread {
 *   println("Hello")
 *   println("world")
 * }.run()
 *
 */
object Thread {

  def apply(f: => Unit) : Runnable = new Runnable() { def run = f }

}
