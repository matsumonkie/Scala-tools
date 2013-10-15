package com.luciola.funTools

import scala.reflect.runtime.universe._
import java.lang.reflect.Constructor

/**
 * dynamically instantiate a class from its name e.g:
 *
 * class Bird extends Instantiable
 *
 * class BirdFactory extends Factory[Bird]
 *
 * val myBird: Bird = new BirdFactory().create("my.package.com.Bird")
 *
 */

trait Instantiable

trait Factory[T <: Instantiable] {

  private var ctorMethods = Map[String, MethodMirror]()


  def create(classToInstantiate: String): Option[T] = {
    var res: Option[T] = None

    getSavedCtorMethod(classToInstantiate) match {
      case Some(x) => res = Some(x.apply().asInstanceOf[T])
      case None => {
        getCtorMethod(classToInstantiate) match {
          case Some(ctorMethod) => {
            saveCtorMethod(classToInstantiate, ctorMethod)
            res = Some(ctorMethod.apply().asInstanceOf[T])
          }
          case None => res = None
        }
      }
    }

    res
  }


  /**
   * return the constructor of class to instantiate as a method
   */
  private def getCtorMethod(classToInstantiate: String): Option[MethodMirror] = {
    val mirror = runtimeMirror(getClass.getClassLoader)
    val classSymbol = mirror.staticClass(classToInstantiate)
    val thisType = classSymbol.selfType

    if (isInstantiable(thisType)) {
      val classMirror = mirror.reflectClass(classSymbol)
      val ctor = classSymbol.toType.declaration(nme.CONSTRUCTOR).asMethod
      Some(mirror.reflectClass(classSymbol).reflectConstructor(ctor))
    } else {
      None
    }
  }


  private def isInstantiable[T: TypeTag](thisType: Type) = {
    thisType <:< typeOf[Instantiable]
  }


  private def saveCtorMethod(className: String, ctorMethod: MethodMirror) {
    ctorMethods += (className -> ctorMethod)
  }


  private def getSavedCtorMethod(className: String): Option[MethodMirror] = {
    ctorMethods.get(className)
  }
}
