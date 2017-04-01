public class Pit {
    int numberOfPiece = 4;
    int x;
    int y;
    Piece [] pieceArr = {new Piece(1,x+40,y+40),new Piece(1,x+40,y+57),new Piece(1,x+57,y+40), new Piece(1,x+57,y+57),new Piece(3,x+50,y+22), new Piece(3,x+22,y+50),new Piece(3,x+75,y+50), new Piece(3,x+50,y+75), new Piece(3,x+70,y+70)
            , new Piece(3,x+27,y+70),new Piece(3,x+70,y+27),new Piece(3,x+27,y+27)};

    Pit(){

    }

    Pit(int x, int y){
        this.x=x;
        this.y=y;
        for(int i=0; i<12; i++){
            pieceArr[i].setX(x+pieceArr[i].getX());
            pieceArr[i].setY(y+pieceArr[i].getY());

        }

    }

    public void konumkopyala(Pit pit){
        for(int i=0; i<12; i++){
            this.pieceArr[i].x = pit.pieceArr[i].getX();
            this.pieceArr[i].y = pit.pieceArr[i].getY();

        }

    }


}