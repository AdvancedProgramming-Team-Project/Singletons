import java.math.*;

public abstract class Player extends Thread implements Move, Collision, Jump, Die {
    static final int MAX_HP = 100;
    static final int MAX_SPEED = 10;
    static final int P_WIDTH = 10;
    private static int count;
    private static int speed;
    private static int angle;
    private int hp;
    private int checking;
    private boolean is_Alive;
    Map p = new Map();
    private Item it;
    private double p_rad = angle*Math.PI / 180;
    
    public void die() {
    	for(int i = 0; i < 20; i++)
			p.exist_arr[i] = 0;
    	hp = 0;
    	is_Alive = false;
    }
    private boolean check(int num1, int wid1, int num2, int wid2) {
    	int left1 = num1 - wid1;
    	int right1 = num1 + wid1;
    	int left2 = num2 - wid2;
    	int right2 = num2 + wid2;
    	int[] array = {left1, right1, left2, right2};
    	for(int i = 0; i < 4; i++) {
    		if(array[i] >= 360) 			// angle 변수 오버플로우 막도록 360 넘어가면 줄여주기
    			array[i] -= 360;
    		if(array[i] < 0)
    			array[i] += 360;
    	}
    	if((left1 <= right2) && (left1 <= left2))
    		return true;
    	else if((left2 <= right1) && (left2 <= left1))
    		return true;
    	else
    		return false;
    }
    @Override
    public boolean monster_collide(Map p) {
    	for(int k = 0; k < p.c_M; k++) {
    		if(check(angle, P_WIDTH, p.m[k].angle, p.m[k].E_WIDTH))
    			return true;
    	}
    	return false;
    }
    public boolean obstacle_collide(Map p) {
    	for(int k = 0; k < p.c_O; k++) {
    		if(check(angle, P_WIDTH, p.o[k].angle, p.o[k].E_WIDTH))
    			return true;
    	}
    	return false;
    }
    public boolean item_collide(Map p){
    	for(int k = 0; k < p.c_I; k++) {
    		if(check(angle, P_WIDTH, p.i[k].angle, p.i[k].I_WIDTH))
    			return true;
    	}
    	return false;
    }
    public void move(Map p) {
    	 angle += this.speed;       // 속도만큼 각도 올려주기
    	 if(angle >= 360) 			// angle 변수 오버플로우 막도록 360 넘어가면 줄여주기
    		 angle -= 360;
    	 
    	 if(monster_collide(p) || obstacle_collide(p)) {
    		 gameOver();
    	 }
    	 if(item_collide(p)) {
    		p.i[checking].change_Speed();
    		p.i[checking].delete();
    	 }
    }
    public void jump(Map p) {
    	if(angle >= 180)
    		angle -= 180;
    	else
    		angle += 180;
    	
    	if(monster_collide(p)) {
    		p.m[checking].delete();
    	}
    	if(obstacle_collide(p)) {
    		gameOver();
    	}
    	if(item_collide(p)) {
    		p.i[checking].change_Speed();
    		p.i[checking].delete();
    	}
    }
	@Override
	public void run() {
		super.run();
	}


}
