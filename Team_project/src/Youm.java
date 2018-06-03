public class Youm extends Player implements FullHP {
    private int hp;
    private int speed;
    private int accel;
    private int x;
    private int y;
    private int cool_time;
    private int cool_check;

    @Override
	public void fullHP() {
    	while()
    	hp = MAX_HP;
	}
    
    public void run() {
		super.run();
		while(cool_check!=cool_time)
		{
			try {
			cool_check++;
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		cool_check=0;
		skill_act = true;
	}

}
