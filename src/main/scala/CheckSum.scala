object CheckSum {
  val END_LINE_CHAR = sys.props("line.separator")

  def performCheckSum(boxIds: List[String]): Int = {
    val distinctCharInBoxIds = calculateDistinctCharacters(boxIds)
    val doubleTripleListPerBoxId = filterDoubleTriples(distinctCharInBoxIds)
    val dtTuple = concatDoubleTripleString(doubleTripleListPerBoxId)
    val uniqueDoubleCount = distinctCharInString(dtTuple.doubleString).length
    val uniqueTripleCount = distinctCharInString(dtTuple.tripleString).length
    uniqueDoubleCount * uniqueTripleCount
  }

  def calculateDistinctCharacters(boxIds: List[String]): List[List[(Char, Int)]] = {
    boxIds.map(boxId =>
      distinctCharInString(boxId).toList.map(char =>
        (char, boxId.count(_ == char))
      )
    )
  }

  def filterDoubleTriples(distinctCharInBoxIds: List[List[(Char, Int)]]): List[List[(Char, Int)]] = {
    distinctCharInBoxIds.map(_.filter(charCount => charCount._2 == 2 || charCount._2 == 3))
  }

  def concatDoubleTripleString(doubleTripleListPerBoxId: List[List[(Char, Int)]]): DistinctMultipliers = {
    var doubleString = ""
    var tripleString = ""
    doubleTripleListPerBoxId.foreach(_.foreach(charCount =>
      if (charCount._2 == 2)
        doubleString = doubleString.concat(charCount._1.toString)
      else
        tripleString = tripleString.concat(charCount._1.toString)
    )
    )
    DistinctMultipliers(doubleString, tripleString)
  }

  def distinctCharInString(input: String): String = {
    input.toSeq.distinct.unwrap
  }

}

case class DistinctMultipliers(doubleString: String, tripleString: String)
