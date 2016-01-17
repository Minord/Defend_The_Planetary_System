package com.minord.game.jam.dtps.Box2D;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class GameContactListener implements ContactListener{
	
	public boolean isDead = false;
	public boolean isHurt = false;

	private boolean areColider(Contact contact, Object userA, Object userB){
		Object userDataA = contact.getFixtureA().getUserData();
		Object userDataB = contact.getFixtureB().getUserData();
		
		if(userDataA == null || userDataB == null){
			return false;
		}
		
		return ((userDataA.equals(userA)) && (userDataB.equals(userB))) || ((userDataB.equals(userB)) && (userDataA.equals(userA)));
	}
	
	@Override
	public void beginContact(Contact contact) {
		if(areColider(contact,"Personaje","Bala")){
			isDead = true;
		}
		if(areColider(contact,"Personaje","Enemigo")){
			isHurt = true;
		}
	}

	@Override
	public void endContact(Contact contact) {
		if(areColider(contact,"Personaje","Enemigo")){
			isHurt = false;
		}
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
