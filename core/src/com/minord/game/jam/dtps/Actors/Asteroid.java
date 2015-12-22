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

public class Asteroid extends Actor{
	
	private Texture t;
	private Body body;
	private World world;
	private Fixture fixture;
	
	public Asteroid(Texture t,World world, Vector2 postion){
		this.world = world;
		this.t = t;
		
		BodyDef def = new BodyDef();
		def.position.set(postion);
		def.type = BodyDef.BodyType.StaticBody;
		body = this.world.createBody(def);
		
		PolygonShape asteroidShape = new PolygonShape();
		asteroidShape.setAsBox(0.5f, 0.5f);
		fixture = body.createFixture(asteroidShape, 3);
		fixture.setUserData("Asteroid");
		asteroidShape.dispose();
		
		setSize(PIXELS_IN_METER,PIXELS_IN_METER);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		this.setPosition((body.getPosition().x - 0.5f) * PIXELS_IN_METER, (body.getPosition().y - 0.5f) * PIXELS_IN_METER);
		batch.draw(t, this.getX(), this.getY(), this.getWidth() * 3,this.getHeight() * 3);
	}
		
	public void act(float batch){
			
	}
	public void detach(){
		t.dispose();
	}}