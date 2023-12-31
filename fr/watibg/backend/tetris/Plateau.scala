package backend.tetris

import Block._

class Plateau {
  private val table: Array[Array[Boolean]] = Array.ofDim[Int](20, 10)

  sealed trait Direction
  case object Droite extends Direction
  case object Gauche extends Direction
  case object Bas extends Direction

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

  def tablePleine: Unit => Boolean = {
    for i <- 0 until 20
    j <- 0 until 10
    if (!table(i)(j))
    yield return false
    true
  }

  def estPerdue : Unit => Boolean = {
    table(0)(1) || table(0)(2) || table(0)(3) || table(0)(4) || table(0)(5) || table(0)(6) || table(0)(7) || table(0)(8) || table(0)(9) || table(1)(4) || table(1)(5)
  }

  def addBlock : (Int, Int) => Block => Unit = (x,y) => b => {
    b.forme match {
      case L => {
        addCase(x)(y)
        addCase(x+1)(y)
        addCase(x+1)(y+1)
        b.positionHG = (x,y)
      }
      case LigneV => {
        addCase(x)(y)
        addCase(x)(y+1)
        addCase(x)(y+2)
        b.positionHG = (x,y)
      }
      case LigneH => {
        addCase(x)(y)
        addCase(x+1)(y)
        addCase(x+2)(y)
        b.positionHG = (x,y)
      }
      case Carre => {
        addCase(x)(y)
        addCase(x)(y+1)
        addCase(x+1)(y)
        addCase(x+1)(y+1)
        b.positionHG = (x,y)
      }
    }
  }

  def moveBlock : Direction => Block => Int = d => b => {
    d match {
      case Droite => {
        b.forme match {
          case L => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2+2)
            addCase(b.positionHG._1+2)(b.positionHG._2+2)
            b.positionHG = (b.positionHG._1,b.positionHG._2+1)
            1
          }
          case LigneV => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1)(b.positionHG._2+1)
            removeCase(b.positionHG._1)(b.positionHG._2+2)
            addCase(b.positionHG._1+1)(b.positionHG._2)
            addCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2+2)
            b.positionHG = (b.positionHG._1+1,b.positionHG._2)
            1
          }
          case LigneH => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+2)(b.positionHG._2)
            addCase(b.positionHG._1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1+2)(b.positionHG._2+1)
            b.positionHG = (b.positionHG._1,b.positionHG._2+1)
            1
          }
          case Carre => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1)(b.positionHG._2+1)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1)(b.positionHG._2+2)
            addCase(b.positionHG._1+1)(b.positionHG._2+2)
            b.positionHG = (b.positionHG._1,b.positionHG._2+1)
            1
          }
        }
      }
      case Gauche => {
        b.forme match {
          case L => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1)(b.positionHG._2-1)
            addCase(b.positionHG._1+1)(b.positionHG._2-1)
            addCase(b.positionHG._1+2)(b.positionHG._2-1)
            b.positionHG = (b.positionHG._1,b.positionHG._2-1)
            1
          }
          case LigneV => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1)(b.positionHG._2+1)
            removeCase(b.positionHG._1)(b.positionHG._2+2)
            addCase(b.positionHG._1+1)(b.positionHG._2-1)
            addCase(b.positionHG._1+1)(b.positionHG._2)
            addCase(b.positionHG._1+1)(b.positionHG._2+1)
            b.positionHG = (b.positionHG._1+1,b.positionHG._2-1)
            1
          }
          case LigneH => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+2)(b.positionHG._2)
            addCase(b.positionHG._1)(b.positionHG._2-1)
            addCase(b.positionHG._1+1)(b.positionHG._2-1)
            addCase(b.positionHG._1+2)(b.positionHG._2-1)
            b.positionHG = (b.positionHG._1,b.positionHG._2-1)
            1
          }
          case Carre => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1)(b.positionHG._2+1)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1)(b.positionHG._2-1)
            addCase(b.positionHG._1+1)(b.positionHG._2-1)
            b.positionHG = (b.positionHG._1,b.positionHG._2-1)
            1
      }
    }
  }
      case Bas => {
        b.forme match {
          case L => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2)
            addCase(b.positionHG._1+2)(b.positionHG._2)
            addCase(b.positionHG._1+2)(b.positionHG._2+1)
            b.positionHG = (b.positionHG._1+1,b.positionHG._2)
            1
          }
          case LigneV => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1)(b.positionHG._2+1)
            removeCase(b.positionHG._1)(b.positionHG._2+2)
            addCase(b.positionHG._1+1)(b.positionHG._2)
            addCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2+2)
            b.positionHG = (b.positionHG._1+1,b.positionHG._2)
            1
          }
          case LigneH => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+2)(b.positionHG._2)
            addCase(b.positionHG._1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1+2)(b.positionHG._2+1)
            b.positionHG = (b.positionHG._1+1,b.positionHG._2)
            1
          }
          case Carre => {
            removeCase(b.positionHG._1)(b.positionHG._2)
            removeCase(b.positionHG._1)(b.positionHG._2+1)
            removeCase(b.positionHG._1+1)(b.positionHG._2)
            removeCase(b.positionHG._1+1)(b.positionHG._2+1)
            addCase(b.positionHG._1+1)(b.positionHG._2)
            addCase(b.positionHG._1+1)(b.positionHG._2+1)
            b.positionHG = (b.positionHG._1+1,b.positionHG._2)
            1
          }
        }
      }
    } 
    0
  }

  def cantMove : Block => Direction => Boolean = b => d =>{
    d match{
      case Bas => b.forme match{
        case L => if(b.positionHG._1 == 19 || table(b.positionHG._1+2)(b.positionHG._2) || table(b.positionHG._1+2)(b.positionHG._2+1)) true else false
        case LigneV => if(b.positionHG._1 == 19 || table(b.positionHG._1+2)(b.positionHG._2) || table(b.positionHG._1+2)(b.positionHG._2+1) || table(b.positionHG._1+2)(b.positionHG._2+2)) true else false
        case LigneH => if(b.positionHG._1 == 19 || table(b.positionHG._1+3)(b.positionHG._2)) true else false
        case Carre => if(b.positionHG._1 == 19 || table(b.positionHG._1+2)(b.positionHG._2) || table(b.positionHG._1+2)(b.positionHG._2+1)) true else false
      }
      case Droite => {
        b.forme match{
          case L => if(b.positionHG._2 == 9 || table(b.positionHG._1)(b.positionHG._2+2) || table(b.positionHG._1+1)(b.positionHG._2+2)) true else false
          case LigneV => if(b.positionHG._2 == 9 || table(b.positionHG._1)(b.positionHG._2+1) || table(b.positionHG._1+1)(b.positionHG._2+1) || table(b.positionHG._1+2)(b.positionHG._2+1)) true else false
          case LigneH => if(b.positionHG._2 == 9 || table(b.positionHG._1)(b.positionHG._2+3)) true else false
          case Carre => if(b.positionHG._2 == 9 || table(b.positionHG._1)(b.positionHG._2+2) || table(b.positionHG._1+1)(b.positionHG._2+2)) true else false
        }
      }
      case Gauche => {
        b.forme match{
          case L => if(b.positionHG._2 == 0 || table(b.positionHG._1)(b.positionHG._2-1) || table(b.positionHG._1+1)(b.positionHG._2-1)) true else false
          case LigneV => if(b.positionHG._2 == 0 || table(b.positionHG._1)(b.positionHG._2-1) || table(b.positionHG._1+1)(b.positionHG._2-1) || table(b.positionHG._1+2)(b.positionHG._2-1)) true else false
          case LigneH => if(b.positionHG._2 == 0 || table(b.positionHG._1)(b.positionHG._2-1)) true else false
          case Carre => if(b.positionHG._2 == 0 || table(b.positionHG._1)(b.positionHG._2-1) || table(b.positionHG._1+1)(b.positionHG._2-1)) true else false
        }
      }
    }
    
  }
    
  }





