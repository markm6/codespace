import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class DisplayPanel extends JPanel implements ActionListener {
   private JButton button1;
   private JButton button2;
   private JTextField textField;
   private BufferedImage goomba;
   private String message;
   private boolean toggle;


   public DisplayPanel() {
       toggle = false;
       message = "This is the display panel!";
       button1 = new JButton("Blue");
       button1.addActionListener(this);
       add(button1);


       button2 = new JButton("Green");
       button2.addActionListener(this);
       add(button2);


       textField = new JTextField(15);
       add(textField);


       try {
           goomba = ImageIO.read(new File("src\\goomba.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
   }


   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.setFont(new Font("Arial", Font.BOLD, 16));
       if (toggle) {
           g.setColor(Color.GREEN);
           g.drawRect(45, 10, 200, 30);
           g.setColor(Color.BLUE);
       } else {
           g.setColor(Color.RED);
       }
       g.drawString(message, 50, 30);
       button1.setLocation(50, 100);
       button2.setLocation(150, 100);
       textField.setLocation(50, 60);
   }


   @Override
   public void actionPerformed(ActionEvent e) {
       Object sender = e.getSource();
       repaint();
   }
}
