package tools

object Main extends App {
	println("Hello, World!")


  // simple print
  Echo("foo")
  Echo("myVar", "foo")
  Echo("A", "B", "C")


  // function timer
	Timer({
    Thread.sleep(500)
	}, "sleeping for 500ms should")


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
  def divideByOne = 0/1
  Echo(Try(divideByZero, "You cannot divide by zero..."))
  Echo(Try(divideByOne, "You cannot divide by zero..."))


  class ClosableImpl extends Closable {

    System.out.println("-- Constructed")

    def doSomething {
      System.out.println("-- Doing something")
    }

    def close() {
      System.out.println("-- Closing")
    }
  }


  // loan pattern
  CloseAfter(new ClosableImpl())({ x => x.doSomething })

}