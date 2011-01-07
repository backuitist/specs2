package org.specs2
package examples
import mutable._
import specification._
import execute.Success

/**
 * This specification shows how to use the mutable.Specification trait to create a specs-like Specification
 * where the fragments are built using a mutate variable
 */
class MutableSpec extends SpecificationWithJUnit {
  // arguments are simply declared at the beginning of the specification if needed
  args(xonly=true)
  // an action to execute before the specification must be declared before any example
  action {
    // setup database here
    success
  }

  "'Hello world'" should {
    "contain 11 characters" in {
      "Hello world" must have size(11)
    }
    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }
    /**
     * a failing example will stop right away, without having to "chain" expectations
     */
    "with 'world'" in {
      // uncommenting this line will stop the execution right away with a Failure
      // "Hello world" must startWith("Hi")
      "Hello world" must endWith("world")
    }
  }
  /**
   * There's no "context management", so you need case classes to manage setup and variables
   */
  "'Hey you'" should {
    // this one uses a "before" method
    "contain 7 characters" in context {
      "Hey you" must have size(7)
    }
    // System is a Success result. If the expectations fail when building the object, the example will fail
    "contain 7 characters" in new system {
      string must have size(7)
    }
    // otherwise a case class can be used but the example body will be further down the file
    "contain 7 characters" in system2().e1
  }
  // you can add links to other specifications with `link`
  link("how" ~ ("to do hello world", new HelloWorldSpec))
  // you can include other specifications with `include`
  include(new HelloWorldSpec)

  // an action to execute after the specification must be declared after all examples
  action {
    // close the database here
    success
  }


  object context extends Before {
    def before = () // do something to setup the context
  }
  trait system extends Success {
    val string = "Hey you"
  }
  case class system2() {
    val string = "Hey you"
    def e1 = string must have size(7)
  }
}
}
