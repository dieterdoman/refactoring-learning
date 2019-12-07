object Overlap {
  def performOverlapCheck(lines: List[String]): Int = {
    val spaceLines = lines.map(_.replace(" ", ""))
    val claimInfos = spaceLines.map(element => element.split('@')(1))
    val foobar = claimInfos.map(element => element.split(":"))
    val claimBlocks = foobar.map(element => (element(0).split(","),  element(1).split("x")))
    val size = 1000
    val MehMatrix = Array.ofDim[Int](size,size)
    claimBlocks.foreach(element => {
      val left = element._1(0).toInt
      val top = element._1(1).toInt
      val width = element._2(0).toInt
      val height = element._2(1).toInt
      for(col <- left until (left + width))
      {
        for(row <- top until (top + height))
          {
            MehMatrix(col)(row) = MehMatrix(col)(row) + 1
          }
      }
    })
    // matrix to int
    var finalcountdown_dededewdo = 0
    for(col <- 0 until size){
      for(row <- 0 until size){
        if(MehMatrix(col)(row) > 1)
          finalcountdown_dededewdo = finalcountdown_dededewdo + 1
      }
    }
    finalcountdown_dededewdo
  }
}
