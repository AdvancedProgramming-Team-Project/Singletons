package hong;
import javax.swing.JLabel;

class player{
   int count = 0;

   public void move() {
      System.out.println("move");
   }
   public void jump() {
      System.out.println("jump");
   }
   public void collision() {
      System.out.println("collision");
      count++;
   }
}

class enermy extends JLabel{
   public enermy(int x, int y) {
      this.setText("enermy");
      this.setBounds(x,y,50,50);
      this.setVisible(true);
      }
}

class monster extends enermy{

   public monster(int x, int y) {
      super(x, y);
      // TODO Auto-generated constructor stub
   }
   
}

public class game extends Thread {
   gui g;
   player p = new player(); //나중에 싱글톤으로 만들어서 받아오기
   int hp = 1000;

   public game() {
      
   }
   public game(gui g) {
      this.g =g;
   }

   @Override
   public void run() {
      while(hp!=0) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         if(p.count>5) {
            g.label.setVisible(true);
         }
         if(g.jump == 1) {
            p.jump();
            p.collision();
            System.out.println(p.count);
            g.jump = 0;
         }
         else {
            p.move();
            p.collision();
            System.out.println(p.count);            
         }
         
      }
   }
   public static void main(String args[]) {
      game g1 = new game();
      gui GUI = new gui(g1);
      Thread t1 = new game(GUI);
      t1.start();
      GUI.setVisible(true);

   }
}
