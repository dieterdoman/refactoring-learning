object CheckSum {
  val END_LINE_CHAR = sys.props("line.separator")

  def performCheckSum(boxIds: List[String]): Int = {
    val distinctCharInBoxIds = boxIds.map(boxId =>
      boxId.toSeq.distinct.unwrap.toList.map(char =>
        (char, boxId.count(_ == char))
      )
    )
    val doubleTripleListPerBoxId = distinctCharInBoxIds.map(_.filter(charCount => charCount._2 == 2 || charCount._2 == 3))
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
}
