package backend.tetris

class Plateau {
  private val table: Array[Array[Boolean]] = Array.ofDim[Int](20, 10)

  def initPlateau: Unit => Unit = {
    for i <- 0 until 20
    j <- 0 until 10
    yield table(i)(j) = false
  }

  def addCase: Int => Int => Unit = x =>
    y => {
      table(x)(y) = true
    }

  def removeCase: Int => Int => Unit = x =>
    y => {
      table(x)(y) = false
    }

  def ligneComplete: Int => Boolean = x => {
    for y <- 0 until 10
    if (table(x)(y) != true)
    yield return false
    true

  }

}
