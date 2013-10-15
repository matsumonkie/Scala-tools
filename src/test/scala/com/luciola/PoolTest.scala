package com.luciola

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import com.luciola.funTools.{Cleanable, Echo, Recyclable}

class PoolTest extends FlatSpec with ShouldMatchers {

  class Animal extends Cleanable {

    override def clean() {
      Echo("cleaning animal...")
    }

  }

  class Animals extends Pool[Animal]

  val animalsPool = new Animals
  val animal = animalsPool.reserve
  animalsPool.clean(animal)

  "" should "" in {

  }

}
