package com.luciola.funTools

import scala.collection.mutable

/**
 * count how many time a class have been instanciated
 *
 * ex :
 * val bird = new Bird()
 * val bird2 = new Bird()
 * bird.getNbOfInstances will return 2
 * val car = new Car()
 * car.getNbOfInstances will return 1
 */

trait InstanceCounter {

  private val className: String = getClass().getSimpleName
  InstanceCounter.incInstances(className)

  def getNbOfInstances: Int = InstanceCounter.getNbOfInstances(className)
}

object InstanceCounter {

  private val nbOfClassesInstances = mutable.Map[String, Int]()

  private def getNbOfInstances(className: String) : Int = nbOfClassesInstances.get(className).get

  private def incInstances(className: String) = {
    val nbOfInst: Option[Int] = nbOfClassesInstances.get(className)
    nbOfClassesInstances(className) = nbOfInst.getOrElse(0) + 1
  }
}
