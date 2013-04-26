package tools

/**
 * execute a function that might rises an exception
 * if it does, return default
 *
 * ex:
 * Try({ "1".toInt }, 1) will return 1
 * Try({ "1qsd".toInt }, 2) will return 2
 */
object Try {

  def apply[T](f: => T, defaultValue: T) : T =
    try { f } catch { case _ : Throwable => defaultValue }

}
