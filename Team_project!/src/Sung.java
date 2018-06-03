public class Sung extends Player implements Fieldclean {
    private int hp;
    private int speed;
    private int accel;
    private int x;
    private int y;
    static final int cool_time = 40;
    private int cool_check=0;
    private boolean skill_act = true;
    
    Map p = new Map();

	@Override
	public void fieldClean() {
		if(skill_act) {
			run();
			for(int i = 0; i < 20; i++)
				p.exist_arr[i] = 0;
			this.hp += MAX_HP / 2;
			skill_act = false;
		}	
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

<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'master' of https://github.com/AdvancedProgramming-Team-Project/Singletons.git
