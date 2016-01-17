package com.minord.game.jam.dtps.Personaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import static com.minord.game.jam.dtps.Constantes.PIXELS_IN_METER;

import java.util.ArrayList;

public class Personaje extends Actor{
	
	private Texture t;
	public Body b;
	private World w;
	private Fixture f;
		
	private float x_referencia , y_referencia;
	
	public boolean isDead = false;
	
	public ArrayList<Float> l = new ArrayList<Float>();
	public ArrayList<Float> l2 = new ArrayList<Float>();

	private float x_M, y_M;

	public Personaje(World w, Texture t, Vector2 position){
		this.w = w;
		this.t = t;
		
		BodyDef def = new BodyDef();
		def.position.set(position);
		def.type = BodyDef.BodyType.DynamicBody;
		b = this.w.createBody(def);
		
		PolygonShape personaje = new PolygonShape();
		personaje.setAsBox(0.10f, 0.10f);
		this.f = b.createFixture(personaje,3);
		this.f.setUserData("Personaje");
		personaje.dispose();
		setSize(PIXELS_IN_METER,PIXELS_IN_METER);
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		 setPosition((b.getPosition().x - 0.10f) * PIXELS_IN_METER, (b.getPosition().y - 0.10f) * PIXELS_IN_METER);
		 batch.draw(t, getX(), getY(), 24, 24);
    }
	
	public void act(float batch){
		Vector2 position_t = b.getPosition();
		if(!isDead){
			Controls(position_t, batch);
		}
	}
	public void detach(){
		b.destroyFixture(f);
		w.destroyBody(b);
	}
	private void Controls(Vector2 position_t,float batch){

		if(ControlCursor()){
			x_M = Gdx.input.getX() - (Gdx.graphics.getWidth() / 2);
			y_M = (Gdx.graphics.getHeight() / 2) - Gdx.input.getY();
			b.applyForceToCenter(x_M / 50, y_M / 50, true);
			if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
				b.applyForceToCenter(x_M / 25, y_M / 25, true);
			}
 		}
		b.applyForceToCenter(-(b.getLinearVelocity().x),-(b.getLinearVelocity().y), true);
	}
	
	public float GetAngleOf2Vectors(Vector2 u, Vector2 v){
		float X = u.x - v.x;
		float Y = u.y - v.y;
				
		float angle_temp = 0;
		if(((X > 0) && (Y > 0))){
			angle_temp = ((float) Math.atan(Y / X) * 90) / 1.60f;
		} 
		else if(((X < 0) && (Y >= 0))){
			angle_temp = 180 + ((float) Math.atan(Y / X) * 90) / 1.60f;
		}
		else if(((X < 0) && (Y < 0))){
			angle_temp = 180 + ((float) Math.atan(Y / X) * 90) / 1.60f;
		}
		else if(((X >= 0) && (Y < 0))){
			angle_temp = 360 + ((float) Math.atan(Y / X) * 90) / 1.60f;
		}
		return angle_temp;
	}

	private boolean ControlCursor(){
		boolean temp;
		if(Gdx.input.getX() == x_referencia && Gdx.input.getY() == y_referencia){
			Gdx.input.setCursorPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
			temp = false;
		} else {
			temp = true;
		}
		x_referencia = Gdx.input.getX();
		y_referencia = Gdx.input.getY();
		return temp;
	}
}
