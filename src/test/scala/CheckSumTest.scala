import org.scalatest.{BeforeAndAfterAll, FunSuite}
import scala.io.Source

class CheckSumTest extends FunSuite with BeforeAndAfterAll {
    test("CheckSum.performCheckSum") {
      val testTxtSource = Source.fromFile("inputCheckSumTest.txt")
      val inputCheckSum = testTxtSource.getLines().mkString
      val checkSum = CheckSum.performCheckSum(inputCheckSum)
      assert(checkSum === 12)
      testTxtSource.close()
    }
}
