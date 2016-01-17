package com.minord.game.jam.dtps.Actors;

import static com.minord.game.jam.dtps.Constantes.PIXELS_IN_METER;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bala extends Actor{
	
	private World w;
	private Body b;
	private Fixture f;
	private Texture t;
	private Vector2 fo;
	private boolean force_aply = true;
	public float t_life = 3.0f;
	
	public Bala(World w, Texture t, Vector2 position, Vector2 fu){
		this.w = w;
		this.t = t;
		this.fo = fu;
		
		BodyDef def = new BodyDef();
		def.position.set(position);
		def.type = BodyDef.BodyType.DynamicBody;
		b = this.w.createBody(def);
		
		PolygonShape enemigo = new PolygonShape();
		enemigo.setAsBox(0.01f, 0.01f);
		this.f = b.createFixture(enemigo,3);
		this.f.setUserData("Bala");
		enemigo.dispose();
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		 setPosition((b.getPosition().x) * PIXELS_IN_METER, (b.getPosition().y) * PIXELS_IN_METER);
		 batch.draw(t, getX(), getY(), 8, 8);
    }
	@Override
	public void act(float batch){
		if(force_aply){
			b.applyForceToCenter((fo.x - b.getPosition().x) / 2, (fo.y - b.getPosition().y) / 2, true);
			force_aply = false;
		}
		t_life -= batch;
		if(t_life < 0){
			remove();
			b.destroyFixture(f);
		}
	}
}
