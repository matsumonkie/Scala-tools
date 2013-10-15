package com.luciola.funTools

import scala.util.Success

/**
 * execute a function that might rises an exception
 * if it does, return a default value
 *
 * ex:
 * TryOr(1) { "1".toInt } will return 1
 * TryOr(2) { "1qsd".toInt } will return 2
 *
 */
object TryOr {

  def apply[T](fallback: T)(f: => T): T = scala.util.Try(f) getOrElse fallback
}

/**
 * same as TryOr except that it wraps the return value in an Optional and there is
 * default value here
 *
 * e.g:
 *
 * TryOpt { 1 / 0 } match {
 *   case Some(x) => doSomething(x)
 *   case None => doSomethingElse()
 * }
 *
 */
object TryOpt {

  def apply[T](f: => T): Option[T] = {
    scala.util.Try(f) match {
      case Success(x) => Some(x)
      case _ => None
    }
  }
}
