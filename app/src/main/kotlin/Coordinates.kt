class Coordinates {

    lateinit var row : ScopedSpot
    val rowInitialised : Boolean
        get() = ::row.isInitialized

    lateinit var column : ScopedSpot
    val columnInitialised : Boolean
        get() = ::column.isInitialized

    val first : ScopedSpot = ScopedSpot.First
    val second : ScopedSpot = ScopedSpot.Second
    val third : ScopedSpot = ScopedSpot.Third
    val Int.scopedSpot : ScopedSpot
        get() = when ( this ) {
            1 -> first
            2 -> second
            3 -> third
            else -> throw IllegalArgumentException( "Range 1 - 3 Received $this" )
        }

    enum class ScopedSpot( val `val` : Int ) {
        First( 1 ) ,
        Second( 2 ) ,
        Third( 3 ) ;

        override fun toString(): String {
            return `val`.toString() ;
        }

        companion object {
            fun fetchSpot(`val`: Int): ScopedSpot {
                return when (`val`) {
                    1 -> First
                    2 -> Second
                    3 -> Third
                    else -> throw IndexOutOfBoundsException("Range 1 to 3\nGiven $`val`")
                }
            }
        }

    }

}