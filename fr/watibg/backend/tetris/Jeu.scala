package backend.tetris

import Plateau._
import java.awt.event._

class Jeu {

    val directions : List[Direction] = List(Droite, Gauche, Bas)

    private val plateau : Plateau
    private val score : Int

    def startGame : Unit => Jeu = {
        plateau = new Plateau()
        plateau.initPlateau
        score = 0
        partie
    }

    def randomForme : Unit => Forme = {
        val r = scala.util.Random
        r.nextInt(4) match {
            case 0 => L
            case 1 => LigneH
            case 2 => LigneV
            case 3 => Carre
        }
    }

    def partie : Unit => Unit = {
        boolean estPerdu = false
        while(!estPerdu){
            var block = new Block(randomForme)
            boolean cantMove = false
            while(!cantMove){
                if(plateau.ligneComplete(block.positionHG._1)){
                plateau.removeLine(block.positionHG._1)
                score += 100
            }
            }
        }
    }



    
  
}
