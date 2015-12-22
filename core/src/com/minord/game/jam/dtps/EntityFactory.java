package com.minord.game.jam.dtps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.minord.game.jam.dtps.Actors.Asteroid;
import com.minord.game.jam.dtps.Actors.BackGround;
import com.minord.game.jam.dtps.Personaje.Personaje;

public class EntityFactory {
	
	private AssetManager manager;
	
	public EntityFactory(AssetManager manager){
		this.manager = manager;
	}
	
	public Personaje PersonajeEntity(World w,Vector2 p){
		Texture tex;
		tex = manager.get("PersonajeBoseto.png", Texture.class);
		return new Personaje(w,tex,p);
	}
	
	public BackGround backGroundEntity(){
		Texture t = manager.get("StarsBackGround.jpg");;
		return new BackGround(t);
	}
	
	public Asteroid AsteroidEntity(World world, Vector2 position){
		Texture t = manager.get("Metroid.png");
		return new Asteroid(t, world, position);
	}
}