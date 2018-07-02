import java.util.Random;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.JComponent;
public class Blob extends JComponent {
    private static final long serialVersionUID = 918638542296082208L;
    private boolean isRed = true;
    private int diameter, xCoord, yCoord, xRate, yRate;
    private Color color;
    private final Random rn = new Random();
    public Blob(boolean isRed) {

        this.isRed = isRed;
        if(isRed){
            diameter = 50;
            color = new Color(255, 51, 0);
        } else {
            diameter = 25;
            color = new Color(0, 102, 255);
        }
        xCoord = rn.nextInt(main.WIDTH - diameter); 
        yCoord = rn.nextInt(main.HEIGHT - diameter);
        xRate = rn.nextInt(10) - 5;
        yRate = rn.nextInt(10) - 5;
    }
    public void updatePosition(){
        xCoord += xRate;
        yCoord += yRate;
    }
    public int getXCoord() {
        return xCoord;
    }
    public int getYCoord() {
        return yCoord;
    }
    public int getDiameter() {
        return diameter;
    }
    public Color getColor() {
        return color;
    }
    public void increaseDiameter(){
        diameter += 5;
    }
    public void hitLateral(){
        xRate *= -1;
    } 
    public boolean getIsRed(){
        return isRed;
    }
    public void hitVertical(){
        yRate *= -1;
    }
}
