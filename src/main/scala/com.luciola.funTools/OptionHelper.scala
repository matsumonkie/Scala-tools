package com.luciola.funTools

/**
 * helper class dealing with Option
 *
 * ex:
 *
 * val a = Some(1)
 * val b = None
 * a.ifEmpty(println("oops empty"))
 * a.ifDefined(_ + 5)
 */
object OptionHelper {

  class OptionOps[T](x: Option[T]) {

    def ifEmpty (f: => Any) = { if (x.isEmpty) f }

    def ifDefined (f: T => Unit) = { if (x.isDefined) f(x.get) }
  }

  implicit def OptionOps[T](o: Option[T]): OptionOps[T] = new OptionOps(o)
}
