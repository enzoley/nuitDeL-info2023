package backend.tetris

sealed trait Forme
case object L extends Forme
case object LigneH extends Forme
case object LigneV extends Forme
case object Carre extends Forme
