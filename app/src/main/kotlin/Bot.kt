import kotlin.random.Random

// static guess
val Board.botSpot : Int
    get() = when {

        board[0] == GameCharacterScope.GameCharacter.Undetermined && board[1] == player && board[2] == player -> 0
        board[0] == player && board[1] == GameCharacterScope.GameCharacter.Undetermined && board[2] == player -> 1
        board[0] == player && board[1] == player && board[2] == GameCharacterScope.GameCharacter.Undetermined -> 2

        board[3] == GameCharacterScope.GameCharacter.Undetermined && board[4] == player && board[5] == player -> 3
        board[3] == player && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[5] == player -> 4
        board[3] == player && board[4] == player && board[5] == GameCharacterScope.GameCharacter.Undetermined -> 5

        board[6] == GameCharacterScope.GameCharacter.Undetermined && board[7] == player && board[8] == player -> 6
        board[6] == player && board[7] == GameCharacterScope.GameCharacter.Undetermined && board[8] == player -> 7
        board[6] == player && board[7] == player && board[8] == GameCharacterScope.GameCharacter.Undetermined -> 8

        board[0] == GameCharacterScope.GameCharacter.Undetermined && board[3] == player && board[6] == player -> 0
        board[0] == player && board[3] == GameCharacterScope.GameCharacter.Undetermined && board[6] == player -> 3
        board[0] == player && board[3] == player && board[6] == GameCharacterScope.GameCharacter.Undetermined -> 6

        board[1] == GameCharacterScope.GameCharacter.Undetermined && board[4] == player && board[7] == player -> 1
        board[1] == player && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[7] == player -> 4
        board[1] == player && board[4] == player && board[7] == GameCharacterScope.GameCharacter.Undetermined -> 7

        board[2] == GameCharacterScope.GameCharacter.Undetermined && board[5] == player && board[8] == player -> 2
        board[2] == player && board[5] == GameCharacterScope.GameCharacter.Undetermined && board[8] == player -> 5
        board[2] == player && board[5] == player && board[8] == GameCharacterScope.GameCharacter.Undetermined -> 8

        board[0] == GameCharacterScope.GameCharacter.Undetermined && board[4] == player && board[8] == player -> 0
        board[0] == player && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[8] == player -> 4
        board[0] == player && board[4] == player && board[8] == GameCharacterScope.GameCharacter.Undetermined -> 8

        board[2] == GameCharacterScope.GameCharacter.Undetermined && board[4] == player && board[6] == player -> 2
        board[2] == player && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[6] == player -> 4
        board[2] == player && board[4] == player && board[6] == GameCharacterScope.GameCharacter.Undetermined -> 6

        board[0] == GameCharacterScope.GameCharacter.Undetermined && board[1] == bot && board[2] == bot -> 0
        board[0] == bot && board[1] == GameCharacterScope.GameCharacter.Undetermined && board[2] == bot -> 1
        board[0] == bot && board[1] == bot && board[2] == GameCharacterScope.GameCharacter.Undetermined -> 2

        board[3] == GameCharacterScope.GameCharacter.Undetermined && board[4] == bot && board[5] == bot -> 3
        board[3] == bot && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[5] == bot -> 4
        board[3] == bot && board[4] == bot && board[5] == GameCharacterScope.GameCharacter.Undetermined -> 5

        board[6] == GameCharacterScope.GameCharacter.Undetermined && board[7] == bot && board[8] == bot -> 6
        board[6] == bot && board[7] == GameCharacterScope.GameCharacter.Undetermined && board[8] == bot -> 7
        board[6] == bot && board[7] == bot && board[8] == GameCharacterScope.GameCharacter.Undetermined -> 8

        board[0] == GameCharacterScope.GameCharacter.Undetermined && board[3] == bot && board[6] == bot -> 0
        board[0] == bot && board[3] == GameCharacterScope.GameCharacter.Undetermined && board[6] == bot -> 3
        board[0] == bot && board[3] == bot && board[6] == GameCharacterScope.GameCharacter.Undetermined -> 6

        board[1] == GameCharacterScope.GameCharacter.Undetermined && board[4] == bot && board[7] == bot -> 1
        board[1] == bot && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[7] == bot -> 4
        board[1] == bot && board[4] == bot && board[7] == GameCharacterScope.GameCharacter.Undetermined -> 7

        board[2] == GameCharacterScope.GameCharacter.Undetermined && board[5] == bot && board[8] == bot -> 2
        board[2] == bot && board[5] == GameCharacterScope.GameCharacter.Undetermined && board[8] == bot -> 5
        board[2] == bot && board[5] == bot && board[8] == GameCharacterScope.GameCharacter.Undetermined -> 8

        board[0] == GameCharacterScope.GameCharacter.Undetermined && board[4] == bot && board[8] == bot -> 0
        board[0] == bot && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[8] == bot -> 4
        board[0] == bot && board[4] == bot && board[8] == GameCharacterScope.GameCharacter.Undetermined -> 8

        board[2] == GameCharacterScope.GameCharacter.Undetermined && board[4] == bot && board[6] == bot -> 2
        board[2] == bot && board[4] == GameCharacterScope.GameCharacter.Undetermined && board[6] == bot -> 4
        board[2] == bot && board[4] == bot && board[6] == GameCharacterScope.GameCharacter.Undetermined -> 6

        else -> Random.nextInt( 9 )

    } + 1