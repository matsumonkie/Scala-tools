package tools

import scala.reflect.runtime.universe._


object Factory {

  type classInstanciable = Boat
  /*
  def apply(className: String): Option[classInstanciable] = {
    try {
      val classToInstanciate: Class[_] = Class.forName(className)
      Echo(classToInstanciate.getSimpleName)
    } catch


    val newInstance: Option[classInstanciable] = tools.Try({
      Some(classToInstanciate.newInstance().asInstanceOf[classInstanciable])
    }, None)

    if (newInstance.isEmpty) {
      Echo("Factory could no instanciate class", className)
    }

    newInstance
  }
*/
  def apply2() = {
    /*
    val classTypeTag = getTypeTag(fish)


    if (classTypeTag.tpe <:< typeTag[Boat].tpe) {
      Echo("Yes subtype !")
    } else {
      Echo("Not a subtype !")
      Echo(classTypeTag.tpe, typeTag[Boat].tpe)
    }
     */
  }

  private def getTypeTag[T: TypeTag](unusedVal: T) : TypeTag[T] = {
   val foo = typeTag[T]
    Echo(foo.tpe)
    foo
  }

}


trait Boat {

  def create()

}

class Submarine extends Boat {

  override def create() = {

  }

  def sayHello = Echo("coucou")

}