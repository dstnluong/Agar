import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class main {
    private static Game agar = new Game();
    private static final JFrame frame = new JFrame();
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 680;
    private static final Color background = new Color(255, 255, 255);
    public static void main(String  [] args){
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Dustin Luong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);

        JButton addBlue = new JButton("Add Blue");
        addBlue.setBounds(303, 60, 95, 30);
        addBlue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agar.addBlue();
            }
        });
        JButton addRed = new JButton("Add Red");
        addRed.setBounds(453, 60, 95, 30);
        addRed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                agar.addRed();
            }
        });

        frame.add(addRed);
        frame.add(addBlue);
        frame.add(agar);
        frame.setVisible(true);
        while(true){
            try {
                Thread.sleep(17);
                agar.repaint();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    /*
    public main(){
        frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Agar.io");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);
        System.out.print(0);
        frame.add(agar);
        System.out.print(1);
        frame.setVisible(true);
        while(true){
            try {
                Thread.sleep(17);
                agar.repaint();
                System.out.print(2);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args){
        SwingUtilities.invokeLater(main::new);
    }
    */
}
