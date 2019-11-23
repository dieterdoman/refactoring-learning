object CheckSum {
  val END_LINE_CHAR = sys.props("line.separator")

  def performCheckSum(boxIds: List[String]): Int = {
    val distinctCharInBoxIds = calculateDistinctCharacters(boxIds)
    val doubleTripleListPerBoxId = filterDoubleTriples(distinctCharInBoxIds)
    var doubleString = ""
    var tripleString = ""
    doubleTripleListPerBoxId.foreach(_.foreach(charCount =>
      if (charCount._2 == 2)
        doubleString = doubleString.concat(charCount._1.toString)
      else
        tripleString = tripleString.concat(charCount._1.toString)
      )
    )
    val uniqueDoubleCount = doubleString.toSeq.distinct.unwrap.length
    val uniqueTripleCount = tripleString.toSeq.distinct.unwrap.length
    uniqueDoubleCount * uniqueTripleCount
  }

  def calculateDistinctCharacters(boxIds: List[String]): List[List[(Char, Int)]] = {
    boxIds.map(boxId =>
      boxId.toSeq.distinct.unwrap.toList.map(char =>
        (char, boxId.count(_ == char))
      )
    )
  }

  def filterDoubleTriples(distinctCharInBoxIds: List[List[(Char, Int)]]): List[List[(Char, Int)]] = {
    distinctCharInBoxIds.map(_.filter(charCount => charCount._2 == 2 || charCount._2 == 3))
  }
}
