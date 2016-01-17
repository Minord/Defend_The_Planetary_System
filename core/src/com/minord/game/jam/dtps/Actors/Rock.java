package com.minord.game.jam.dtps.Actors;

import static com.minord.game.jam.dtps.Constantes.PIXELS_IN_METER;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Rock extends Actor{
	private Body body;
	private World world;
	private Fixture fixture;
	
	public Rock(float size, Texture texture, World world, Vector2 position){
		this.world = world;
		
		BodyDef def = new BodyDef();
		def.position.set(position);
		def.type = BodyDef.BodyType.StaticBody;
		body = this.world.createBody(def);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(size);
		fixture = body.createFixture(circle, 3);
		fixture.setUserData("Rock");
		circle.dispose();
		
		setSize(PIXELS_IN_METER,PIXELS_IN_METER);
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		 setPosition((body.getPosition().x - 0.25f) * PIXELS_IN_METER, (body.getPosition().y - 0.5f) * PIXELS_IN_METER);
		 //batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}
}
