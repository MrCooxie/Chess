# Chess
## Backend
I have created a class ChessBoard in there I have a method called createChessBoard() this basically creates a 8x8 board and puts Pieces on it. 
Every piece on that board is of type Piece. There are many pieces that extend Piece for example: Pawn, Bishop, Knight, Rook, Queen, King. 
Each of these pieces have methods ``getAllPossibleMoves()`` and ``move()``. 

The Method getAllPossibleMoves returns all of the possible moves that piece can make, taking in surroundings and position. Each piece has its own way of moving 
and that also varies on different chess game modes. For that I have created a bunch of Strategies. At the moment I have only one Strategy called NormalStrategy. 
Then I have created all of the different strategies, how a piece can move.

Then the method move takes in the place to move. This first checks if the move is legal, if it is illegal, then it returns false and doesn't do anything. If the move is 
legal, needed changes get done in the chess board and true is returned. 

What you can do in test class is create a new instance 

```java
ChessBoard chessBoard = new ChessBoard(ChessMode.NORMAL);
```

This creates a new instance of chessBoard and tells that all of the move strategies are for normal chess game

then you can print the chessBoard using

```java
chessBoard.printChessBoard();
```

You can also get all of the possibleMoves of a piece doing something like this:

```java
chessBoard.getChessBoard()[row][col].getAllPossibleMoves();
```

This returns ``ArrayList<Move>``, where Move is a record containing row and col.

Then you can move a piece by specifying a piece to move and where to move.

```java
chessBoard.move(6,4,5,4);
```

This moves the piece up by one square on loc (6;4) 

And now if you print the board you get the updated board

If the move is illegal then no changes will be done to the board.
