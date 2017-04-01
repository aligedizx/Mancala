import javax.swing.*;
import java.awt.*;


public class Piece extends JPanel{
    public final int PINK = 1;
    public final int RED = 2;
    public final int YOK = 3;

    private boolean become = false;


    int renk = 1;

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int x;
    int y;

    public Piece(int renk, int x, int y){
        super();
        this.renk=renk;
        this.x = x;
        this.y = y;


    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        switch (renk) {
            case 1:
                g.setColor(new Color(229,102,255));
                g.fillOval(x-1, y-1, 15, 15);

                g.setColor(Color.pink);
                g.fillOval(x, y, 13, 13);
                break;
            case 2:
                g.setColor(Color.BLACK);
                g.fillOval(x-1, y-1, 15, 15);

                g.setColor(Color.red);
                g.fillOval(x, y, 13, 13);
                break;
            case 3:
                g.setColor(new Color(0,0,0,0));
                g.fillOval(x, y, 13, 13);
                break;
            case 4:
                g.setColor(Color.green);
                g.fillOval(x, y, 13, 13);

        }
    }


}