package hong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class gui extends JFrame {
   public int jump;
   public JPanel contentPane;
   private JButton button;
   public JLabel label;
   private game g;
   
   public gui(game g) {
      this.g = g;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      label = new monster(100,100);
      contentPane.add(label);
      label.setVisible(false);
      
      button = new JButton("Button");
      button.setBounds(333,148,86,76);
      contentPane.add(button);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button)
               jump = 1;
         }
      });
   }

}