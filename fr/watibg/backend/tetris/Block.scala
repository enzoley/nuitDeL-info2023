package fr.watibg.backend.tetris

sealed trait Forme
    case object L extends Forme
    case object LigneH extends Forme
    case object LigneV extends Forme
    case object Carre extends Forme


class Block(f : Forme) {

    private val forme: Forme
    private val positionHG : (Int,Int)

    def initBlock : Unit => Block = {
        forme = f
        positionHG = (0,4)
    }

    def goDown : Unit => Unit = {
        if(positionHG._1 < 19){
            positionHG._1 += 1
        }
    }

    def goRight : Unit => Unit = {
        if(positionHG._2 < 9){
            positionHG._2 += 1
        }
    }

    def goLeft : Unit => Unit = {
        if(positionHG._2 > 0){
            positionHG._2 -= 1
        }
    }

    



    
}
