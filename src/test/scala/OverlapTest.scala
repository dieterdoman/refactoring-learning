import org.scalatest.{BeforeAndAfterAll, FunSuite}

import scala.io.Source

class OverlapTest extends FunSuite with BeforeAndAfterAll {
  test("Overlap.performOverlapCheck") {
    val testTxtSource = Source.fromFile("inputOverlapTest.txt")
    val inputOverlap = testTxtSource.getLines().toList
    val overlapSum = Overlap.performOverlapCheck(inputOverlap)
    assert(overlapSum === 4)
    testTxtSource.close()
  }
}

