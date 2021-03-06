package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class EnemyPlane extends Plane {
	
	public EnemyPlane(GamePanel panel) {
		super(panel, 3, "midPlane1.png");
		this.hp = 4;
	}
	
	public void loadWeapons() {
		//装配子弹
		ArrayList<Weapon> bullets = new ArrayList<Weapon>();
		for(int i=0;i<1000;i++) {
			bullets.add(new EnemyBullet(panel));
		}
		//装配导弹
		ArrayList<Weapon> missiles = new ArrayList<Weapon>();
		for(int i=0;i<5;i++) {
			missiles.add(new Missile(panel));
		}
		this.magazine = new Magazine(bullets, missiles);
	}
	
	@Override
	public void heartBeat() {
		// TODO Auto-generated method stub
		super.heartBeat();
		Random r = new Random();
		int num = r.nextInt();
		if(num%50 == 0) {
			this.fireBullet();
		}
		if(num%100 == 0) {
			this.fireMissile();
		}
	}
}
