package com.luciola.funTools

import scala.reflect.runtime.{universe => ru}
import scala.collection.mutable

class Pool[T <: Creatable] {

  private val availableResources = mutable.ListBuffer[T]()

  def recycle(resToRecycle: T) {
    resToRecycle +=: availableResources
  }

  def getResource[Y: ru.TypeTag](): T = {
    if (availableResources.isEmpty) {
      val m = ru.runtimeMirror(getClass.getClassLoader)
      val classOfT = ru.typeOf[Y].typeSymbol.asClass
      val cm = m.reflectClass(classOfT)
      val ctor = ru.typeOf[Y].declaration(ru.nme.CONSTRUCTOR).asMethod
      val ctorm = cm.reflectConstructor(ctor)
      val value = ctorm()
      value.asInstanceOf[T]
    } else {
      availableResources.remove(0)
    }
  }

}

trait Creatable {
  def create(): Creatable
}
