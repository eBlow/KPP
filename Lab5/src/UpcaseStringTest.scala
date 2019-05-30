package lab5

import org.scalatest.FunSuite

class UpcaseStringTest extends FunSuite {
  val testString = "666 – the number of the Beast!"
  val expected = "666 – THE NUMBER OF THE BEAST!"

  test("testUpcaseStringTailrec") {
    assert(expected.equals(UpcaseString.upcaseStringTailRec(testString)))
  }

  test("testUpcaseString") {
    assert(expected.equals(UpcaseString.upcaseString(testString)))
  }
}