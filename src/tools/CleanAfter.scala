package tools

/**
 * Loan/Disposable pattern
 *
 */
object CloseAfter {

  def apply[A <: Closable](c: A)(f : (A) => Unit ) =
    try { f(c) } finally { c.close() }
}

trait Closable {

  abstract def close()

}

