class GameCharacterScope {

    enum class GameCharacter(val `val` : Int ) {
        Undetermined(-1) ,
        Draw( 0 ) ,
        X( 1 ) ,
        O( 2 )
    }

    val X : GameCharacter
        get() = GameCharacter.X

    val O : GameCharacter
        get() = GameCharacter.O

    companion object {

        fun gameCharacter( playerScope : GameCharacterScope.() -> Unit ) : Unit = playerScope.invoke( GameCharacterScope() )

        // static check
        fun Board.gameStatus() : GameCharacter = when {
            // wining lines
            board[0] == board[1] && board[1] == board[2] -> board[0]
            board[3] == board[4] && board[4] == board[5] -> board[3]
            board[6] == board[7] && board[7] == board[8] -> board[6]
            board[0] == board[3] && board[3] == board[6] -> board[0]
            board[1] == board[4] && board[4] == board[7] -> board[1]
            board[2] == board[5] && board[5] == board[8] -> board[2]
            board[0] == board[4] && board[4] == board[8] -> board[0]
            board[2] == board[4] && board[4] == board[6] -> board[2]
            // spots available
            board[0] == GameCharacter.Undetermined || board[1] == GameCharacter.Undetermined
                    || board[2] == GameCharacter.Undetermined || board[3] == GameCharacter.Undetermined
                    || board[4] == GameCharacter.Undetermined || board[5] == GameCharacter.Undetermined
                    || board[6] == GameCharacter.Undetermined || board[7] == GameCharacter.Undetermined ||
                    board[8] == GameCharacter.Undetermined -> GameCharacter.Undetermined
            // draw
            else -> GameCharacter.Draw
        }

        // dynamic checks
//        fun Board.gameStatus(character : GameCharacter? = null , row : Int = -1 , column : Int = -1 ) : GameCharacter {
//            character?.let { _ ->
//                if ( row > 2 || column > 2 ) return GameCharacter.Draw
//                val absoluteIndex = ( column * 3 ) + row
//                if ( board[absoluteIndex] != character ) return GameCharacter.Undetermined
//                val recurse = gameStatus( character , row+1 , column )
//                val recurse1 = gameStatus( character , row , column+1 )
//                val recurse2 = gameStatus( character , row+1 , column+1 )
//                return when {
//                    recurse == character || recurse1 == character || recurse2 == character -> character
//                    recurse == GameCharacter.Undetermined || recurse1 == GameCharacter.Undetermined || recurse2 == GameCharacter.Undetermined -> GameCharacter.Undetermined
//                    else -> GameCharacter.Draw
//                }
//            } ?: run {
//                val recurseX = gameStatus( GameCharacter.X , row+1 , column+1 )
//                val recurseO = gameStatus( GameCharacter.O , row+1, column+1 )
//                return when {
//                    recurseX == GameCharacter.X -> GameCharacter.X
//                    recurseO == GameCharacter.O -> GameCharacter.O
//                    recurseO == GameCharacter.Undetermined || recurseX == GameCharacter.Undetermined -> GameCharacter.Undetermined
//                    else -> GameCharacter.Draw
//                }
//            }
//        }

        val Board.isPlaying : Boolean
            get() = gameStatus() == GameCharacter.Undetermined

        infix fun Board.playing(loopScope : Board.( GameCharacter ) -> Unit ) {
            var turn : GameCharacter = GameCharacter.X
            while ( isPlaying ) {
                loopScope(turn)
                turn = if ( turn == GameCharacter.O ) GameCharacter.X else GameCharacter.O
            }
        }

        val Board.showResult : String
            get() = result.let {
                print( it )
                it
            }

        val Board.result : String
            get() = when ( gameStatus() ) {
                GameCharacter.Draw -> "It's A Draw"
                GameCharacter.O -> "${if (bot == GameCharacter.O) "Bot" else "Player"} Won The Game"
                GameCharacter.X -> "${if (bot == GameCharacter.X) "Bot" else "Player"} Won The Game"
                GameCharacter.Undetermined -> "Game Still Playable"
            }

    }

}