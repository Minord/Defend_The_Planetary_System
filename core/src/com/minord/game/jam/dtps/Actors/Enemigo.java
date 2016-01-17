package com.minord.game.jam.dtps.Actors;

import static com.minord.game.jam.dtps.Constantes.PIXELS_IN_METER;

import java.util.Random;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemigo extends Actor{
	
	private TextureRegion tr;
	public Body b;
	private World w;
	private Fixture f;	
	private Random r;
	private Sound s;
	private boolean shot2 = false;
	public boolean shot = false;
		
	private float Time_For_Shot;
	
	public boolean isAlive = true;
	
	public Vector2 p_p;
	
	public boolean drawDead;
	
	public Enemigo(World w, Texture t, Vector2 position,Sound s){
		this.w = w;
		this.tr = new TextureRegion(t);
		this.s = s;
		
		BodyDef def = new BodyDef();
		def.position.set(position);
		def.type = BodyDef.BodyType.DynamicBody;
		b = this.w.createBody(def);
		
		PolygonShape enemigo = new PolygonShape();
		enemigo.setAsBox(0.10f, 0.10f);
		this.f = b.createFixture(enemigo,3);
		this.f.setUserData("Enemigo");
		enemigo.dispose();
				
		r = new Random();
		p_p = new Vector2(0,0);
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		 setPosition((b.getPosition().x) * PIXELS_IN_METER, (b.getPosition().y) * PIXELS_IN_METER);
		 if(isAlive){
			 batch.draw(tr, getX() - 12, getY() - 32, 12, 32, 24, 64, 1, 1, (float) Math.toDegrees(b.getAngle()));
		 } else{
			 batch.setColor(1, 0, 0, 0.5f);
			 batch.draw(tr, getX() - 12, getY() - 32, 12, 32, 24, 64, 1, 1, (float) Math.toDegrees(b.getAngle()));
			 if(!drawDead){
				 batch.setColor(1, 1, 1, 1);
			 }
		 }
    }
	public void act(float batch){
		if(isAlive){
			shot = false;
			Ai();
			if(Time_For_Shot >= 1){
				shot2 = true;
				Time_For_Shot = 0;
			}
			else{
				Time_For_Shot += batch;
				shot2 = false;
			}
		}
	}
	private void Ai(){
		if(r.nextInt(100) == 25){
			float x = (r.nextFloat() - 0.5f) * 10;
			float y = (r.nextFloat() - 0.5f) * 10;
			b.applyForceToCenter(x,y, true);
		}
		if(getDistance(b.getPosition().x, b.getPosition().y, p_p.x, p_p.y) <= 3){
			b.setTransform(b.getPosition(),(float) Math.toRadians(getAngleTwoPoints(b.getPosition().x, b.getPosition().y, p_p.x, p_p.y)));
			b.setAngularVelocity(0);
			Shot();
		}
	}
	private void Shot(){
		if(shot2){
			shot = true;
			s.play(1.0f);
		}
	}
	public float getDistance(float d1, float d2, float d3, float d4){
		float a1 = d1;
		float a2 = d2;
		float a3 = d3;
		float a4 = d4;
		
		a1 = a3 - a1;
		a2 = a4 - a2;
		
		a1 = a1 * a1;
		a2 = a2 * a2;
		
		a1 = a1 + a2;
		
		a1 = (float) Math.sqrt(a1);

		return a1;
	}
	private float getAngleTwoPoints(float d1, float d2, float d3, float d4){
		float var1 = d3 - d1;
		float var2 = d4 - d2;
		if(var1 >= 0 && var2 >= 0){
			return (float) Math.toDegrees(Math.atan(var2 / var1)) + 90;
		}
		else if(var1 <= 0 && var2 >= 0){
			return (float) Math.toDegrees(Math.atan(var2 / var1)) + 180 + 90;
		}
		else if(var1 <= 0 && var2 <= 0){
			return (float) Math.toDegrees(Math.atan(var2 / var1)) + 180 + 90;
		}
		else if(var1 >= 0 && var2 <= 0){
			return (float) Math.toDegrees(Math.atan(var2 / var1)) + 360 + 90;
		}
		return 0;
	}
	public Vector2 get_pos_to_bala(){
		float y = (float) Math.sin(Math.toDegrees(b.getAngle())) * 0.2f;
		return new Vector2(b.getPosition().x, b.getPosition().y - y);
	}
}
