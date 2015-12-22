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

public class Personaje extends Actor{
	
	private Texture t;
	private Body b;
	private World w;
	private Fixture f;
	
	public Personaje(World w, Texture t, Vector2 position){
		this.w = w;
		this.t = t;
		
		BodyDef def = new BodyDef();
		def.position.set(position);
		def.type = BodyDef.BodyType.DynamicBody;
		b = this.w.createBody(def);
		
		PolygonShape personaje = new PolygonShape();
		personaje.setAsBox(0.25f, 0.5f);
		f = b.createFixture(personaje,3);
		f.setUserData("Personaje");
		personaje.dispose();
		
		
		
		setSize(PIXELS_IN_METER,PIXELS_IN_METER);
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		 setPosition((b.getPosition().x - 0.25f) * PIXELS_IN_METER, (b.getPosition().y - 0.5f) * PIXELS_IN_METER);
		 batch.draw(t, getX(), getY(), getWidth() / 2, getHeight());
    }
	
	public void act(float batch){
		Vector2 position_t = b.getPosition(); 

		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			b.applyLinearImpulse(-5f * batch, 0f , position_t.x, position_t.y, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			b.applyLinearImpulse(5f * batch, 0f , position_t.x, position_t.y, true);
		} 
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			b.applyLinearImpulse(0f ,-5f * batch, position_t.x, position_t.y, true);
		} 
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			b.applyLinearImpulse(0f ,5f * batch, position_t.x, position_t.y, true);
		}
	}
	public void detach(){
		b.destroyFixture(f);
		w.destroyBody(b);
	}
}
