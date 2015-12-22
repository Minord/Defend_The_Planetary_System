package com.minord.game.jam.dtps.Box2D;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class GameContactListener implements ContactListener{
	
	/*private boolean areColider(Contact contact, Object userA, Object userB){
		Object userDataA = contact.getFixtureA().getUserData();
		Object userDataB = contact.getFixtureB().getUserData();
		
		if(userDataA == null || userDataB == null){
			return false;
		}
		
		return ((userDataA.equals(userA)) && (userDataB.equals(userB))) || ((userDataB.equals(userB)) && (userDataA.equals(userA)));
	}*/
	
	@Override
	public void beginContact(Contact contact) {
		
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

}
