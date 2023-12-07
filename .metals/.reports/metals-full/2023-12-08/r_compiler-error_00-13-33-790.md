file://<WORKSPACE>/fr/watibg/backend/tetris/Plateau.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

action parameters:
offset: 886
uri: file://<WORKSPACE>/fr/watibg/backend/tetris/Plateau.scala
text:
```scala
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
    if(table(1)(@@))
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






```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0