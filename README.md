## Backend
### Chess Game class
In ``Chess Game`` class there is a constructor which takes in as argument ``GameMode``(Enum of GameModes).
The constructor calls a private method ``createChessBoard()`` which return a 2D array of ``Piece`` and another private method
``updateGameMode()`` this sets the moving strategies of each Piece according to GameMode.
#### Update ChessBoard method
```java
public void updateGameMode(GameMode gameMode) {
        switch (gameMode) {
            case NORMAL -> {
                pawnStrategy = new NormalPawnStrategy();
                bishopStrategy = new NormalBishopStrategy();
                knightStrategy = new NormalKnightStrategy();
                rookStrategy = new NormalRookStrategy();
                queenStrategy = new NormalQueenStrategy();
                kingStrategy = new NormalKingStrategy();
            }
        }
    }
```

The class has some private fields - each pieceMoveStrategy, the GameMode, the color which turn it is (Type ``PieceColor``) and the chess board (2D array of ``Piece``)

The ChessGame class also has a method ``printChessBoard()`` which prints the ChessBoard to the console.

It has some getters ``getChessBoard()``, ``getTurn()``. It also has a way to change the turn of player with method ``nextTurn()``.

ChessBoard has a method for moving pieces ``move()`` which takes as argument the position (row,col) of piece you want to move and position where the piece wants to move.
In the ``move()`` it calls a method of Piece class ``move()``.

It should also be noted that only one instance of ChessGame is ever created at the moment.


### GameMode enum.
This contains all of the possible game modes. At the moment there are only two ``GameMode.NORMAL`` and ``GameMode.ATOMIC``.

Atomic game mode has not been implemented yet.

### Piece class
The constructor takes in as arguments. 

#### Consturctor of Piece
```java
 public Piece(Strategy strategy, PieceColor pieceColor, int row, int col, ChessBoard chessBoard) {
        this.pieceColor = pieceColor;
        this.strategy = strategy;
        this.row = row;
        this.col = col;
        this.chessBoard = chessBoard;
    }
```
It takes in ``Strategy``, ``PieceColor``, row, col, ``ChessBoard``.

It has two abstract methods ``getAllPossibleMoves()`` and ``getLetter()``.

It has a few getters ``getRow()``, ``getCol()`` and ``getPieceColor``.

It also has some setters ``setRow()``, ``setCol()``

