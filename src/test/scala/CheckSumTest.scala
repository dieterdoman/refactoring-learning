import org.scalatest.{BeforeAndAfterAll, FunSuite}

class CheckSumTest extends FunSuite with BeforeAndAfterAll {
    test("CheckSum.performCheckSum") {
      val testTxtSource = scala.io.Source.fromFile("inputCheckSumTest.txt")
      val inputCheckSum = testTxtSource.getLines().mkString
      val checkSum = CheckSum.performCheckSum(inputCheckSum)
      assert(checkSum === 12)
      testTxtSource.close()
    }
}
