import javax.swing.*;
import java.awt.*;


public class YazBoz extends JPanel {

    int N = 114;

    ImageIcon pl1back = new ImageIcon("image/mancalaPanelPlayer1.png");
    ImageIcon pl2back = new ImageIcon("image/mancalaPanelPlayer2.png");



    ImageIcon background;
    JLabel jlBackground;
    Pit[] player1 = {new Pit(291 + 5 * N, 217), new Pit(291 + 4 * N, 217), new Pit(291 + 3 * N, 217), new Pit(291 + 2 * N, 217), new Pit(291 + N, 217), new Pit(291, 217),};
    Pit[] player2 = {new Pit(291, 217 + N), new Pit(291 + N, 217 + N), new Pit(291 + 2 * N, 217 + N), new Pit(291 + 3 * N, 217 + N), new Pit(291 + 4 * N, 217 + N), new Pit(291 + 5 * N, 217 + N)};
    Pit[] secilenPlayer = player1;
    Pit[] otherPlayer = player2;
    Pit mainPit1 = new Pit(110, 280);
    Pit mainPit2 = new Pit(1050, 280);
    boolean yenihak = false;
    boolean karsiCift = false;
    boolean sonTas = false;
    boolean sonTas2= false;
    int indexTutucu = 0;



    int score1 = 0;
    int score2 = 0;


    YazBoz() {
        /*for(int i = 0; i<6; i++){
            player2[i].numberOfPiece=0;
            player1[i].numberOfPiece=0;
            if(i == 5 || i ==4 || i == 3){
                player2[i].numberOfPiece=1;
                player1[i].numberOfPiece=1;

            }

        }*/

        setLayout(null);
        this.background = pl1back;
        jlBackground = new JLabel(background);
        jlBackground.setBounds(0, 0, 1263, 679);
        add(jlBackground);
        //player1[0].pieceArr[0].setVisible(false);
    }

    public void nextRaund() {
        if (secilenPlayer == player1) {
            secilenPlayer = player2;
            otherPlayer = player1;
            jlBackground.setIcon(pl2back);
            jlBackground.repaint();
        } else if (secilenPlayer == player2) {
            secilenPlayer = player1;
            otherPlayer = player2;
            jlBackground.setIcon(pl1back);
            jlBackground.repaint();

        }
    }


    public void secim(int secilenKutu) {

        Pit cach = new Pit();
        cach.konumkopyala(secilenPlayer[secilenKutu]);

        //If there are more than one piece
        if (secilenPlayer[secilenKutu].numberOfPiece > 1) {

            //Transforming of the colors of pieces which will move(RED)
            for (int i = 0; i < secilenPlayer[secilenKutu].numberOfPiece - 1; i++) {
                secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 2;
            }
            //Movement of pieces
            for (int i = 0; i < secilenPlayer[secilenKutu].numberOfPiece - 1; i++) {

                //If the piece player moves to his own pit
                if (secilenKutu + i + 1 <= 5) {
                    oynat(secilenKutu, i + 1, secilenPlayer[secilenKutu + i + 1]);

                    //If the last pit is empty
                    if (secilenPlayer[secilenKutu].numberOfPiece - 2 == i && secilenPlayer[secilenKutu + i + 1].numberOfPiece == 0 && otherPlayer[5 - (secilenKutu + i + 1)].numberOfPiece != 0) {
                        sonTas = true;

                        if (secilenPlayer == player1) {
                            oynat(secilenKutu, i + 1, mainPit1);
                            secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                            score1++;
                            repaint();

                        } else {
                            oynat(secilenKutu, i + 1, mainPit2);
                            secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                            score2++;
                            repaint();


                        }


                        karsiSecim(otherPlayer[5 - (secilenKutu + i + 1)]);
                    }
                }

                //Score homestead movement
                else if (secilenKutu + i + 1 == 6) {
                    if (secilenPlayer == player1) {
                        oynat(secilenKutu, i + 1, mainPit1);
                        score1++;
                    } else if (secilenPlayer == player2) {
                        oynat(secilenKutu, i + 1, mainPit2);
                        score2++;
                    }
                    secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;

                }

                //Moving to the opposite side
                else if (secilenKutu + i + 1 > 6 && secilenKutu + i + 1 <=12) {
                    oynat(secilenKutu, i + 1, otherPlayer[secilenKutu + i + 1 - 7]);

                    if(secilenPlayer[secilenKutu].numberOfPiece - 2 == i &&  otherPlayer[secilenKutu + i + 1 - 7].numberOfPiece %2 ==1){
                        karsiCift = true;
                        otherPlayer[secilenKutu + i + 1 - 7].pieceArr[otherPlayer[secilenKutu + i + 1 - 7].numberOfPiece].renk = 1;
                        secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                        otherPlayer[secilenKutu + i + 1 - 7].numberOfPiece++;
                        karsiSecim(otherPlayer[secilenKutu + i + 1 - 7]);

                    }
                }
                //If the number of piece in the pit is even number
                else if (secilenKutu + i + 1 > 12){

                    oynat(secilenKutu, i+1, secilenPlayer[secilenKutu + i + 1 - 13]);

                    //If the last pit is empty
                    if (secilenPlayer[secilenKutu].numberOfPiece - 2 == i && secilenPlayer[secilenKutu + i + 1 - 13].numberOfPiece == 0 && otherPlayer[5 - (secilenKutu + i + 1 - 13)].numberOfPiece != 0) {
                        sonTas = true;
                        sonTas2 = true;

                        if (secilenPlayer == player1) {
                            oynat(secilenKutu, i + 1, mainPit1);
                            secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                            score1++;
                            repaint();

                        } else {
                            oynat(secilenKutu, i + 1, mainPit2);
                            secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                            score2++;
                            repaint();


                        }


                        otherPlayer[5 - (secilenKutu + i + 1 - 13)].pieceArr[otherPlayer[5 - (secilenKutu + i + 1 - 13)].numberOfPiece].renk = 2;
                        secilenPlayer[secilenKutu].pieceArr[(secilenKutu-(secilenKutu + i + 1 - 13))+(5-secilenKutu)+2].renk = 3;
                        indexTutucu = 5 - (secilenKutu + i + 1 - 13)+1;
                        otherPlayer[5 - (secilenKutu + i + 1 - 13)].numberOfPiece++;
                        karsiSecim(otherPlayer[5 - (secilenKutu + i + 1 - 13)]);
                    }


                }
            }

            //Transforming of the colors of pieces(PINK)
            for (int i = 0; i < secilenPlayer[secilenKutu].numberOfPiece - 1; i++) {
                if (secilenKutu + i + 1 <= 5) {

                    if (secilenPlayer[secilenKutu].numberOfPiece - 2 != i || secilenPlayer[secilenKutu + i + 1].numberOfPiece != 0 || sonTas == false) {




                        secilenPlayer[secilenKutu + i + 1].pieceArr[secilenPlayer[secilenKutu + i + 1].numberOfPiece].renk = 1;
                        secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                        secilenPlayer[secilenKutu + i + 1].numberOfPiece++;

                    }
                    if(secilenPlayer[secilenKutu].numberOfPiece - 2 == i && sonTas == true) sonTas = false;




                } else if (secilenKutu + i + 1 == 6) {
                    yenihak = true;
                } else if (secilenKutu + i + 1 > 6 && secilenKutu + i + 1 <= 12) {
                    yenihak = false;

                    if((secilenPlayer[secilenKutu].numberOfPiece - 2 != i ||  karsiCift == false) && (i != indexTutucu || sonTas2 == false)) {


                        System.out.print(i);
                        System.out.print(sonTas2);
                        System.out.println("  b");
                        otherPlayer[secilenKutu + i + 1 - 7].pieceArr[otherPlayer[secilenKutu + i + 1 - 7].numberOfPiece].renk = 1;
                        secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                        otherPlayer[secilenKutu + i + 1 - 7].numberOfPiece++;

                    }
                    if(secilenPlayer[secilenKutu].numberOfPiece - 2 == i) karsiCift = false;
                    if(i == indexTutucu && sonTas2 == true){

                        sonTas2 = false;


                    }


                }

                else if (secilenKutu + i + 1 > 12){
                    if ((secilenPlayer[secilenKutu].numberOfPiece - 2 != i || secilenPlayer[secilenKutu + i + 1 - 13].numberOfPiece != 0 || sonTas == false)) {

                        System.out.println("a");
                        secilenPlayer[secilenKutu + i + 1 - 13].pieceArr[secilenPlayer[secilenKutu + i + 1 - 13].numberOfPiece].renk = 1;
                        secilenPlayer[secilenKutu].pieceArr[i + 1].renk = 3;
                        secilenPlayer[secilenKutu + i + 1 - 13].numberOfPiece++;

                    }

                    if(secilenPlayer[secilenKutu].numberOfPiece - 2 == i && sonTas == true) sonTas = false;



                }
            }
            secilenPlayer[secilenKutu].numberOfPiece = 1;
        }
        //If there is no piece in the pit
        else if (secilenPlayer[secilenKutu].numberOfPiece == 0) {
            yenihak = true;

        }
        //If there is just one piece in the piece
        else if (secilenPlayer[secilenKutu].numberOfPiece == 1) {
            secilenPlayer[secilenKutu].pieceArr[0].renk=2;
            if (secilenPlayer[secilenKutu] == secilenPlayer[5]) {
                if (secilenPlayer == player1) {
                    oynat(secilenKutu, 0, mainPit1);
                    score1++;
                    repaint();
                } else if (secilenPlayer == player2) {
                    oynat(secilenKutu, 0, mainPit2);
                    score2++;
                    repaint();
                }
                secilenPlayer[secilenKutu].pieceArr[0].renk = 3;
                yenihak = true;
                secilenPlayer[secilenKutu].numberOfPiece = 0;
            } else {
                if(secilenPlayer[secilenKutu+1].numberOfPiece == 0 && otherPlayer[5 - (secilenKutu + 1)].numberOfPiece != 0){
                    oynat(secilenKutu, 0, secilenPlayer[secilenKutu + 1]);
                    if(secilenPlayer == player1){
                        oynat(secilenKutu, 0, mainPit1);
                        score1++;
                        repaint();
                    }
                    else{
                        oynat(secilenKutu, 0, mainPit2);
                        score2++;
                        repaint();
                    }
                    secilenPlayer[secilenKutu].pieceArr[0].renk = 3;
                    secilenPlayer[secilenKutu].numberOfPiece = 0;
                    karsiSecim(otherPlayer[5 - (secilenKutu + 1)]);



                }
                else {
                    oynat(secilenKutu, 0, secilenPlayer[secilenKutu + 1]);
                    secilenPlayer[secilenKutu + 1].pieceArr[secilenPlayer[secilenKutu + 1].numberOfPiece].renk = 1;
                    secilenPlayer[secilenKutu].pieceArr[0].renk = 3;
                    secilenPlayer[secilenKutu].numberOfPiece = 0;
                    secilenPlayer[secilenKutu + 1].numberOfPiece++;
                }
            }


        }

        secilenPlayer[secilenKutu].konumkopyala(cach);

    }

    public void karsiSecim(Pit hedef) {
        Pit cach = new Pit();
        cach.konumkopyala(hedef);


        //Becoming red of moving pieces
        for (int i = 0; i < hedef.numberOfPiece; i++) {
            hedef.pieceArr[i].renk = 2;
        }

        if (otherPlayer == player1) {
            karsiKuyuOynat(hedef, mainPit2);
            score2 += hedef.numberOfPiece;
            repaint();

        } else if (otherPlayer == player2) {
            karsiKuyuOynat(hedef, mainPit1);
            score1 += hedef.numberOfPiece;
            repaint();

        }

        for (int i = 0; i < hedef.numberOfPiece; i++) {
            hedef.pieceArr[i].renk = 3;
        }

        hedef.konumkopyala(cach);
        hedef.numberOfPiece = 0;


        int control = 0;
        for(int i = 0; i<6; i++){
            control += secilenPlayer[i].numberOfPiece;

        }
        if(control == 0) yenihak = true;


    }


    public int oynat(int secilenKutu, int i, Pit hedef) {

        Thread yatay = new Thread() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    if (secilenPlayer[secilenKutu].pieceArr[i].x != hedef.pieceArr[hedef.numberOfPiece].getX()) {
                        if (secilenPlayer[secilenKutu].pieceArr[i].x <= hedef.pieceArr[hedef.numberOfPiece].getX()) {
                            secilenPlayer[secilenKutu].pieceArr[i].x += 1;
                        } else secilenPlayer[secilenKutu].pieceArr[i].x -= 1;

                    } else break;
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        yatay.start();

        Thread dikey = new Thread() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    if (secilenPlayer[secilenKutu].pieceArr[i].y != hedef.pieceArr[hedef.numberOfPiece].getY()) {
                        if (secilenPlayer[secilenKutu].pieceArr[i].y <= hedef.pieceArr[hedef.numberOfPiece].getY()) {
                            secilenPlayer[secilenKutu].pieceArr[i].y += 1;
                        } else secilenPlayer[secilenKutu].pieceArr[i].y -= 1;
                    } else break;
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        dikey.start();


        while(true) {
            if (yatay.isAlive() == false && dikey.isAlive() == false) {
                return 0;
            }
        }



    }



    public int karsiKuyuOynat(Pit hedef, Pit mainPit) {



        Thread yatay = new Thread() {
            int control = 0;

            @Override
            public void run() {
                while (true) {
                    if (control == hedef.numberOfPiece) {
                        break;
                    }
                    control = 0;
                    for (int i = 0; i < hedef.numberOfPiece; i++) {
                        repaint();
                        if (hedef.pieceArr[i].x != mainPit.pieceArr[0].x) {
                            if (hedef.pieceArr[i].x < mainPit.pieceArr[0].x) {
                                hedef.pieceArr[i].x++;
                            } else hedef.pieceArr[i].x--;
                            for (int j = 0; j < hedef.numberOfPiece; j++) {
                                if(hedef.pieceArr[j].x == mainPit.pieceArr[0].x) control++;
                            }
                            if(control != hedef.numberOfPiece) control = 0;


                        }
                    }

                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };yatay.start();



        Thread dikey = new Thread() {
            int control = 0;
            @Override
            public void run() {
                while (true) {
                    if (control == hedef.numberOfPiece) {
                        break;
                    }
                    control = 0;
                    for (int i = 0; i < hedef.numberOfPiece; i++) {
                        repaint();
                        if (hedef.pieceArr[i].y != mainPit.pieceArr[0].y) {
                            if (hedef.pieceArr[i].y < mainPit.pieceArr[0].y) {
                                hedef.pieceArr[i].y++;
                            } else hedef.pieceArr[i].y--;
                            for (int j = 0; j < hedef.numberOfPiece; j++) {
                                if(hedef.pieceArr[j].y == mainPit.pieceArr[0].y) control++;
                            }
                            if(control != hedef.numberOfPiece) control = 0;


                        }
                    }

                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };dikey.start();


        while(true) {
            if (yatay.isAlive() == false && dikey.isAlive() == false) {
                return 0;
            }
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        String score1St = Integer.toString(score1);
        String score2St = Integer.toString(score2);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 40));
        g.drawString(score1St,150,350);
        g.drawString(score2St,1077,350);


        for(int i =0; i<6 ; i++){
            for (int j=0; j<12 ; j++){
                player1[i].pieceArr[j].paint(g);

            }
        }



        for(int i =0; i<6 ; i++){
            for (int j=0; j<12 ; j++){
                player2[i].pieceArr[j].paint(g);

            }
        }

    }

}