import java.util.ArrayList;
import java.lang.Math.*;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Game extends JComponent{
    private static final long serialVersionUID = 918638542296082208L;
    private ArrayList<Blob> game;
    public Game() {
        game = new ArrayList<Blob>();
        Blob b = new Blob(true);
        game.add(b);
        for(int i = 0; i < 10; i++){
            game.add(new Blob(false));
        }
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < game.size(); i++) {
            int x = game.get(i).getXCoord();
            int y = game.get(i).getYCoord();
            int d =game.get(i).getDiameter();
            Ellipse2D.Double circle = new Ellipse2D.Double(x, y, d, d);
            g2.setColor(game.get(i).getColor());
            g2.draw(circle);
            g2.fill(circle);
            update(game.get(i), i);
        }
    }
    public void addBlue(){
        game.add(new Blob(false));
    }
    public void addRed(){
        game.add(new Blob(true));
    }
    public void update(Blob b, int i){
        int x = b.getXCoord();
        int y = b.getYCoord();
        int d = b.getDiameter();
        if(x < 0 || x + 2 * d > main.WIDTH){
            b.hitLateral();
        }
        if(y < 0 || y + 2 * d > main.HEIGHT){
            b.hitVertical();
        }
        for(int j = i + 1; j < game.size(); j++){
            int x1 = x + d / 2;
            int y1 = y + d / 2;
            int x2 = game.get(j).getXCoord() + game.get(j).getDiameter() / 2;
            int y2 = game.get(j).getYCoord() + game.get(j).getDiameter() / 2;
            double radiiDist = Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));
            if(radiiDist < b.getDiameter() / 2 + game.get(j).getDiameter() / 2) {
                if(b.getIsRed() || game.get(j).getIsRed() == true){
                    if(b.getIsRed()){
                        game.remove(j);
                        b.increaseDiameter();
                    } else {
                        game.remove(i);
                        game.get(j).increaseDiameter();
                    } 
                } else {
                    b.hitLateral();
                    b.hitVertical();
                    game.get(j).hitLateral();
                    game.get(j).hitVertical();
                }
                /*
                b.hitLateral();
                b.hitVertical();
                game.get(j).hitVertical();
                game.get(j).hitLateral();
                */
            }
        }
        b.updatePosition();
    }
}

