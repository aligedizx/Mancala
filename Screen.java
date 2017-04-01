import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screen extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    YazBoz yazboz = new YazBoz();
    JPanel gameOverPanel = new JPanel();


    String winner = "";
    boolean action = false;
    int x, y;


    ImageIcon back = new ImageIcon("image/arka_plan.png");
    ImageIcon button = new ImageIcon("image/Button_NewGame.png");
    ImageIcon buttonP = new ImageIcon("image/Button_NewGame_Pressed.png");
    ImageIcon logo = new ImageIcon("image/logo.png");
    JLabel background = new JLabel(back);


    Screen(){

        panel.setLayout(null);

        background.setBounds(0, 0, 1263, 679);

        JLabel Logo = new JLabel(logo);
        Logo.setBounds(311,20, 640,436);

        JButton newGamaButton = new JButton(button);
        newGamaButton.setPressedIcon(buttonP);
        newGamaButton.setBounds(430,470,402,102);
        newGamaButton.addActionListener(this);

        panel.add(newGamaButton);
        panel.add(Logo);
        panel.add(background);

        add(panel);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                x = e.getX();
                y = e.getY();
                action = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }


    public static void main(String[] args) {
        Screen frame = new Screen();
        frame.setSize(1263,679);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(null);

        /*frame.yazboz.player1[0].numberOfPiece=0;
        frame.yazboz.player1[1].numberOfPiece=0;
        frame.yazboz.player1[2].numberOfPiece=0;
        frame.yazboz.player1[3].numberOfPiece=0;
        frame.yazboz.player1[4].numberOfPiece=1;
        frame.yazboz.player1[5].numberOfPiece=1;*/


        /*frame.yazboz.player1[5].numberOfPiece=9;
        frame.yazboz.player1[5].pieceArr[4].renk=1;
        frame.yazboz.player1[5].pieceArr[5].renk=1;
        frame.yazboz.player1[5].pieceArr[6].renk=1;
        frame.yazboz.player1[5].pieceArr[7].renk=1;
        frame.yazboz.player1[5].pieceArr[8].renk=1;
        //frame.yazboz.player1[5].pieceArr[9].renk=1;

        frame.yazboz.player1[0].numberOfPiece = 0;
        frame.yazboz.player1[0].pieceArr[0].renk=3;
        frame.yazboz.player1[0].pieceArr[1].renk=3;
        frame.yazboz.player1[0].pieceArr[2].renk=3;
        frame.yazboz.player1[0].pieceArr[3].renk=3;*/




        Thread oyun = new Thread(){
            @Override
            public void run(){

                while (true){
                    boolean isRaund;
                    if(frame.action == true){
                        //Player 1 Üst Kısım
                        if(frame.yazboz.secilenPlayer == frame.yazboz.player1) {
                            if (frame.y < 310 && frame.y > 235) {
                                //Kutu1
                                if (frame.x > 875 && frame.x < 955) {
                                    frame.yazboz.secim(0);
                                    frame.action = false;

                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu2
                                if (frame.x > 765 && frame.x < 845) {
                                    frame.yazboz.secim(1);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu3
                                if (frame.x > 655 && frame.x < 735) {
                                    frame.yazboz.secim(2);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu4
                                if (frame.x > 540 && frame.x < 620) {
                                    frame.yazboz.secim(3);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu5
                                if (frame.x > 425 && frame.x < 505) {
                                    frame.yazboz.secim(4);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu6
                                if (frame.x > 310 && frame.x < 390) {
                                    frame.yazboz.secim(5);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                            }
                        }
                        //Player2 Alt Kısım
                        if(frame.yazboz.secilenPlayer == frame.yazboz.player2) {
                            if (frame.y > 350 && frame.y < 425) {
                                //Kutu1
                                if (frame.x > 310 && frame.x < 390) {
                                    frame.yazboz.secim(0);;
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu2
                                if (frame.x > 420 && frame.x < 500) {
                                    frame.yazboz.secim(1);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu3
                                if (frame.x > 540 && frame.x < 620) {
                                    frame.yazboz.secim(2);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu4
                                if (frame.x > 650 && frame.x < 730) {
                                    frame.yazboz.secim(3);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu5
                                if (frame.x > 770 && frame.x < 850) {
                                    frame.yazboz.secim(4);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                                //Kutu6
                                if (frame.x > 880 && frame.x < 960) {
                                    frame.yazboz.secim(5);
                                    frame.action = false;


                                    if(frame.yazboz.yenihak == false)
                                        frame.yazboz.nextRaund();
                                    frame.yazboz.yenihak=false;
                                }
                            }
                        }
                        int kayit = 0;
                        int kayit2 = 0;
                        for(int i=0; i<6; i++){
                            kayit += frame.yazboz.secilenPlayer[i].numberOfPiece;
                            kayit2 += frame.yazboz.otherPlayer[i].numberOfPiece;

                        }

                        if(kayit == 0 || kayit2 ==0){
                            if(kayit == 0){
                                for(int i = 0; i<6 ; i++){
                                    if (frame.yazboz.otherPlayer[i].numberOfPiece != 0) {
                                        frame.yazboz.karsiSecim(frame.yazboz.otherPlayer[i]);

                                    }
                                }
                            }
                            else{
                                for(int i = 0; i<6 ; i++){
                                    if (frame.yazboz.secilenPlayer[i].numberOfPiece != 0) {
                                        frame.yazboz.karsiSecim(frame.yazboz.secilenPlayer[i]);

                                    }
                                }


                            }

                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {

                                    if(frame.yazboz.score2 > frame.yazboz.score1) frame.winner = "Player 2 WIN";
                                    else if(frame.yazboz.score2 < frame.yazboz.score1) frame.winner = "Player 1 WIN";
                                    else frame.winner = "No Winner";

                                    frame.gameOver();
                                    frame.repaint();
                                }
                            };
                            SwingUtilities.invokeLater(runnable);


                        }



                    }

                    try
                    {
                        Thread.sleep(20);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }


        };oyun.start();



        //frame.gameOver();


    }

    public void gameOver(){

        JLayeredPane lpane = new JLayeredPane();
        JButton newGamaButton = new JButton(button);
        JLabel gameOver = new JLabel("GAME OVER");

        remove(yazboz);

        gameOverPanel.setBackground(new Color(10,74,61,100));
        gameOverPanel.setLayout(null);
        gameOverPanel.setBounds(0,0,1263, 679);


        JLabel sonuc = new JLabel(winner);





        gameOver.setFont(new Font("Verdana", Font.BOLD, 60));
        gameOver.setBounds(430,50,600,300);
        gameOver.setForeground(Color.white);
        gameOverPanel.add(gameOver);

        sonuc.setFont(new Font("Verdana", Font.BOLD, 60));
        sonuc.setBounds(430,175,600,300);
        sonuc.setForeground(Color.white);
        gameOverPanel.add(sonuc);

        newGamaButton.setPressedIcon(buttonP);
        newGamaButton.setBounds(430,470,402,102);
        newGamaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YazBoz newYazboz = new YazBoz();
                //remove(gameOverPanel);
                remove(lpane);
                yazboz = newYazboz;
                add(yazboz);
                yazboz.setBounds(0,0,1263, 679);
                gameOverPanel.remove(sonuc);
                gameOverPanel.remove(newGamaButton);
                gameOverPanel.remove(gameOver);


                repaint();
                revalidate();
            }
        });

        gameOverPanel.add(newGamaButton);




        lpane.setBounds(0,0,1263, 679);
        lpane.add(yazboz,  new Integer(0), 0);
        lpane.add(gameOverPanel,  new Integer(0), 0);
        add(lpane);
        repaint();



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        remove(panel);
        add(yazboz);
        yazboz.setBounds(0,0,1263, 679);



        repaint();
        revalidate();
    }
}