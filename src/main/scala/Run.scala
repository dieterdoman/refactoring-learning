import scala.io.Source

object Run {
  def main(args: Array[String]): Unit = {
    val testTxtSource = Source.fromFile("inputOverlapFullInput.txt")
    val inputOverlap = testTxtSource.getLines().toList
    val overlapCount = Overlap.performOverlapCheck(inputOverlap)
    println(overlapCount)
    testTxtSource.close()
  }
}
