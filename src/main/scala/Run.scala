import scala.io.Source

object Run {
  def main(args: Array[String]): Unit = {
    val testTxtSource = Source.fromFile("inputCheckSum.txt")
    val inputCheckSum = testTxtSource.getLines().mkString
    val checkSum = CheckSum.performCheckSum(inputCheckSum)
    println(checkSum)
    testTxtSource.close()
  }
}
