package com.minord.game.jam.dtps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.minord.game.jam.dtps.Actors.Asteroid;
import com.minord.game.jam.dtps.Actors.BackGround;
import com.minord.game.jam.dtps.Actors.Bala;
import com.minord.game.jam.dtps.Actors.Enemigo;
import com.minord.game.jam.dtps.Actors.Mesetas;
import com.minord.game.jam.dtps.Actors.Rock;
import com.minord.game.jam.dtps.Personaje.Personaje;

public class EntityFactory {
	
	private AssetManager manager;
	
	public EntityFactory(AssetManager manager){
		this.manager = manager;
	}
	
	public Personaje PersonajeEntity(World w,Vector2 p){
		//Texture tex;
		Texture t = manager.get("img/Person.png");
		return new Personaje(w,t,p);
	}
	
	public BackGround backGroundEntity(){
		Texture t = manager.get("img/Stars.png");
		return new BackGround(t);
	}
	public Asteroid AsteroidEntity(World world, Vector2 position){
		Texture t = manager.get("img/Gild/AsteroideQueVaQuedandoBien-OnlyRock.png");
		return new Asteroid(t, world, position);
	}
	
	public Rock RockEntity(World world, Vector2 position){
		return new Rock(0.5f, null, world, position);
	}
	
	public Mesetas MesaetasEntity(){
		Texture t2 = manager.get("img/Gild/Meseta-1.png");
		Texture t3 = manager.get("img/Gild/Meseta-2.png");
		Texture t4 = manager.get("img/Gild/Meseta-3.png");
		Texture t5 = manager.get("img/Gild/Meseta-4.png");
		Texture t6 = manager.get("img/Gild/Meseta-5.png");
		return new Mesetas(t2,t3,t4,t5,t6);
	}
	public Enemigo EnemigoEntity(World world, Vector2 position){
		Texture t = manager.get("img/En.png");
		Sound s = manager.get("sound/Shot.ogg");
		return new Enemigo(world, t, position, s);
	}
	
	public Bala BalaEntity(World world, Vector2 position, Vector2 Force){
		Texture t = manager.get("img/Bala.png");
		return new Bala(world, t, position, Force);
	}
}