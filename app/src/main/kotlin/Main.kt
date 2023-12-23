import Board.Companion.board
import GameCharacterScope.Companion.gameCharacter
import GameCharacterScope.Companion.playing
import GameCharacterScope.Companion.result

fun main() : Unit = board {

    gameCharacter {

        player = X
        bot = O
        priority = X

        playing { turn ->

            print( "\r${this@board}\n" )

            if ( turn == bot ) {
                turn mark botSpot.also { absoluteIndex ->
                    val row =
                        ( absoluteIndex - (( absoluteIndex / 3 )*3) )
                            .let {
                                return@let if ( it == 0 ) 3 else it
                            }
                    val column = ((absoluteIndex-1) / 3) + 1
                    print( "\nBot Choose Row $row Column $column" )
                }
            }
            else turn mark {
                print( "Enter Row : " )
                while ( true ) {
                    try {
                        row = readln().toInt().scopedSpot
                        break
                    } catch ( _ : Exception ) {
                        print( "\rEnter Row in Range of 1 - 3 : " )
                    }
                }
                print( "Enter Column : " )
                while ( true ) {
                    try {
                        column = readln().toInt().scopedSpot
                        break
                    } catch ( _ : Exception ) {
                        print( "\rEnter Column in Range of 1 - 3 : " )
                    }
                }
            }

        }

        println( "\n\n$result" )
        showBoard
        println()
        println( "Game Ended" )

    }
}