package com.minord.game.jam.dtps.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.minord.game.jam.dtps.DataGame;
import com.minord.game.jam.dtps.Defend_The_Planetary_System;
import com.minord.game.jam.dtps.EntityFactory;
import com.minord.game.jam.dtps.Box2D.GameContactListener;
import com.minord.game.jam.dtps.Personaje.Personaje;
import com.minord.game.jam.dtps.Actors.Asteroid;
import com.minord.game.jam.dtps.Actors.BackGround;

public class PantallaJuego extends PantallaBase{
	
	private Stage stage;
	
	private World world;
	
	private AssetManager manager_game;
	
	private Personaje personaje;
	
	private BackGround background;
	
	private Asteroid asteroid;
	
	private Box2DDebugRenderer renderer;
	
	private OrthographicCamera  camara;
	
	private Vector3 posicion;
	
	
	private Texture BackGround;
	
	private boolean DebugMode;
	

	public PantallaJuego(Defend_The_Planetary_System gamePrincipal) {
		super(gamePrincipal);
		this.manager_game = gamePrincipal.getManager();
		camara = new OrthographicCamera(640f / 128f, 360 / 128f);
		stage = new Stage(new FitViewport(640,360));
		posicion = new Vector3(stage.getCamera().position); 
		
		world = new World(new Vector2(0,0), true);
        world.setContactListener(new GameContactListener());
        
        DebugMode = false;
	}
	@Override
	public void show(){
		EntityFactory factory = new EntityFactory(manager_game);
		
		personaje = factory.PersonajeEntity(world, new Vector2(0,0));
		background = factory.backGroundEntity();
		asteroid = factory.AsteroidEntity(world, new Vector2(1,1));
		
		stage.addActor(background);
		stage.addActor(personaje);
		stage.addActor(asteroid);
		
		
		
		stage.getCamera().position.set(posicion);
		stage.getCamera().update();
		
		renderer = new Box2DDebugRenderer();
	}
	
	@Override
	public void hide(){
		
	}
	
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		world.step(delta, 6, 2);
		stage.getCamera().position.set(personaje.getX() + (0.5f * 128f),personaje.getY() + (0.5f * 128f),0);
		camara.position.set(stage.getCamera().position.x / 128f,stage.getCamera().position.y / 128f,stage.getCamera().position.z / 128f);
		DataGame.pos_camara_x = stage.getCamera().position.x;
		DataGame.pos_camara_y = stage.getCamera().position.y;
		stage.draw();
		if(DebugMode){
			camara.update();
			renderer.render(world, camara.combined);
		}
	}
	
	@Override
	public void dispose(){
		BackGround.dispose();
		stage.dispose();
		world.dispose();
	}
	
}