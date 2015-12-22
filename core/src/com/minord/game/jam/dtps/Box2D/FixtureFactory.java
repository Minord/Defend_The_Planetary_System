package com.minord.game.jam.dtps.Box2D;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class FixtureFactory {
	public static Fixture Personaje_F(Body Personaje){
		PolygonShape personaje = new PolygonShape();
		personaje.setAsBox(0.5f, 0.5f);
		Fixture fixture = Personaje.createFixture(personaje,3);
		personaje.dispose();
		return fixture;
	}
}
