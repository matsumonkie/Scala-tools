package com.luciola.funTools

import foo.luciola.funTools.Timer
import scala.Function
import foo.luciola.funTools.Test._

object Main extends App {

  println("Hello, Worleeiid!")

  /*
  // simple print
  Echo("foo")
  Echo("myVar", "foo")
  Echo("A", "B", "C")

  // function timer

  Timer("sleeping for 500ms should") {
    Thread.sleep(500)
  }

  Timer {
    Thread.sleep(500)
  }

  // instances count
  class Car extends InstanceCounter {}
  class Bird extends InstanceCounter {}


  val car = new Car()
  val bird = new Bird()
  val bird2 = new Bird()

  Echo("Bird", bird.getNbOfInstances)
  Echo("Bird", bird2.getNbOfInstances)
  Echo("Car", car.getNbOfInstances)



  // exception operations

  def divideByZero = 0/0
  def divideByOne = 1/1
  val res1 = TryOr(-1) { divideByZero }
  val res2 = TryOr(-1) { divideByOne }

  Echo(res1)
  Echo(res2)

  TryOpt { divideByOne } match {
    case Some(x) => Echo(s"yeah $x")
    case _ => Echo("noooo...")
  }

  TryOpt { divideByZero } match {
    case Some(x) => Echo(s"yeah $x")
    case _ => Echo("noooo...")
  }



  class ClosableImpl extends Closable {

    System.out.println("-- Constructing")

    def doSomething {
      System.out.println("-- Doing something")
    }

    def close() {
      System.out.println("-- Closing")
    }
  }


  // loan pattern
  CloseAfter(new ClosableImpl())({ _.doSomething })

  Echo("coucouss")
  val test = Factory("tools.Submarine")
  if (test.isDefined) {
    test.get.asInstanceOf[Submarine].sayHello
  }


  //class AnimalCreator extends Factory(Animal) {

  //}

  class AnimalFactory extends Factory[Animal]

  val myFactory = new AnimalFactory()
  Timer("first time") {
    myFactory.create("com.luciola.funTools.Bird")
  }
  //if (foo.isDefined) {
    //foo.get.whoami
  //}

  Timer("modified") {
    for(i <- 0 to 100000) {
      myFactory.create("com.luciola.funTools.Bird")
    }
  }

  Timer("modified") {
    for(i <- 0 to 100000) {
      new com.luciola.funTools.Bird
    }
  }
*/
/*  import LateVal._

  Echo("new LateVal")
  val foo = new LateVal[Int]
  Echo("assign 3")
  foo.assign(3)
  Echo(foo.get)
  Echo(Some(foo) )
  Echo("+2")
  Echo(foo + 2)
*/
/*
  val node = Node(1) (
    Node(2),
    Node(3) (
      Node(4),
      Node(5),
      Node(6)
    )
  )*/
  import foo.luciola.funTools.Conv._
  val node2 = Node(1) {
    Node(2) :: Node(3) { Node(4) }
  }
  val node3 = Node(1) (
    Node(2) :: Node(3) ( Node(4) )
  )



//  println(Node(4) :: Node(3))
//  4.head


  println(node2)
    println(node3)

}
