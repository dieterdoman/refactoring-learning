object CheckSum {
  val END_LINE_CHAR = sys.props("line.separator")

  def performCheckSum(boxIds: List[String]): Int = {
    val distinctCharInBoxIds = calculateDistinctCharacters(boxIds)
    val doubleTripleListPerBoxId = filterDoubleTriples(distinctCharInBoxIds)
    val dtTouple = concatDoubleTrippleString(doubleTripleListPerBoxId)
    val doubleString = dtTouple._1
    val tripleString = dtTouple._2
    val uniqueDoubleCount = distinctCharInString(doubleString).length
    val uniqueTripleCount = distinctCharInString(tripleString).length
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

  def concatDoubleTrippleString(doubleTripleListPerBoxId: List[List[(Char, Int)]]): (String, String) = {
    var doubleString = ""
    var tripleString = ""
    doubleTripleListPerBoxId.foreach(_.foreach(charCount =>
      if (charCount._2 == 2)
        doubleString = doubleString.concat(charCount._1.toString)
      else
        tripleString = tripleString.concat(charCount._1.toString)
    )
    )
    (doubleString, tripleString)
  }

  def distinctCharInString(input: String): String = {
    input.toSeq.distinct.unwrap
  }

}
