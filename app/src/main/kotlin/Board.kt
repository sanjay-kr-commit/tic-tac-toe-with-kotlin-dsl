import GameCharacterScope.GameCharacter
import Coordinates.ScopedSpot.Companion.fetchSpot

class Board {

    var board : Array<GameCharacter> = Array( 9 ) { GameCharacter.Undetermined }

    var bot : GameCharacter? = null
        set(value) {
            if ( player == value ) throw Exception( "Bot Tried To Register $value But Player Already Registered This Character" )
            field = value
        }

    var player : GameCharacter? = null
        set(value) {
            if ( bot == value ) throw Exception( "Player Tried To Register $value But Bot Already Registered This Character" )
            field = value
        }

    var priority : GameCharacter = GameCharacter.X

    val showBoard : String
        get() {
            print( this )
            return this.toString()
        }

    fun reset() {
        board = Array( 9 ) { GameCharacter.Undetermined }
    }

    override fun toString(): String {
        val elements = hashMapOf( GameCharacter.Undetermined to '-' , GameCharacter.X to 'X' , GameCharacter.O to 'O' )
        return "| ${elements[board[0]]} | ${elements[board[1]]} | ${elements[board[2]]} |\n"+
                "| ${elements[board[3]]} | ${elements[board[4]]} | ${elements[board[5]]} |\n" +
                "| ${elements[board[6]]} | ${elements[board[7]]} | ${elements[board[8]]} |"
    }

    infix fun GameCharacter.mark(coordinateScope: Coordinates.() -> Unit ) : Unit = Coordinates().also(coordinateScope).run {
        if ( !rowInitialised || !columnInitialised ) throw InvalidSpotException( "Please Define coordinates in Coordinate Scope\ni.e row and column" )
        val absoluteIndex = ( ( column.`val` -1 )*3 ) + row.`val` - 1
        if ( board[ absoluteIndex ] > GameCharacter.Draw ) throw SpotAlreadyOccupiedException( "row : ${row}\ncolumn : ${column}\nCharacter : ${board[absoluteIndex]}" )
        board[absoluteIndex] = this@mark
    }

    infix fun GameCharacter.mark(absoluteIndex : Int ) : Unit = mark {
        row = fetchSpot(
            ( absoluteIndex - (( absoluteIndex / 3 )*3) )
                .let {
                    return@let if ( it == 0 ) 3 else it
                }
        )
        column = fetchSpot( ((absoluteIndex-1) / 3) + 1 )
    }

    companion object {
        fun board( boardScope : Board.() -> Unit ) : Unit = boardScope.invoke( Board() )
        infix fun Int.column( column : Int ) : Pair<Int,Int> = Pair( this , column )
    }

}