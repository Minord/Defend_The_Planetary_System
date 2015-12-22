package com.minord.game.jam.dtps.Box2D;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class BodyDefFactory {
	public static BodyDef Personaje_BD(){
		BodyDef def = new BodyDef();
		def.position.set(0,0);
		def.type = BodyDef.BodyType.DynamicBody;
		return def;
	}
}
