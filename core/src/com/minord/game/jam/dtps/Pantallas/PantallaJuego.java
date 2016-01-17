package com.minord.game.jam.dtps.Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.minord.game.jam.dtps.DataGame;
import com.minord.game.jam.dtps.Defend_The_Planetary_System;
import com.minord.game.jam.dtps.EntityFactory;
import com.minord.game.jam.dtps.InputProcesorDtps;
import com.minord.game.jam.dtps.Box2D.GameContactListener;
import com.minord.game.jam.dtps.Personaje.Personaje;
import com.minord.game.jam.dtps.Actors.Asteroid;
import com.minord.game.jam.dtps.Actors.BackGround;
import com.minord.game.jam.dtps.Actors.Bala;
import com.minord.game.jam.dtps.Actors.DrawingText;
import com.minord.game.jam.dtps.Actors.Enemigo;
import com.minord.game.jam.dtps.Actors.Mesetas;

public class PantallaJuego extends PantallaBase{
	
	private Stage stage;
	
	private World world;
		
	private Personaje personaje;
	
	private BackGround background;
	
	private Asteroid asteroid;
		
	private Box2DDebugRenderer renderer;
	
	private OrthographicCamera  camara;
	
	private Vector3 posicion;
	
	private GameContactListener game_contact_listener;
	
	private Texture BackGround;
	
	private boolean DebugMode;
	
	private boolean is_resumen;
	
	private ShaderProgram shader;		
	
	private Mesetas mesetas;
		
	private Music m;
	
	private float i = 0;
	
	ArrayList<Bala> l = new ArrayList<Bala>();
	
	ArrayList<Enemigo> l2 = new ArrayList<Enemigo>();
	
	EntityFactory factory = new EntityFactory(MainGame.getManager());
	
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	FreeTypeFontParameter parameter2; 
	FreeTypeFontParameter parameter3; 
	
	BitmapFont font1;
	BitmapFont font2;
	BitmapFont font3;

	
	private DrawingText text;
	
	public PantallaJuego(Defend_The_Planetary_System gamePrincipal) {
		super(gamePrincipal);
		game_contact_listener = new GameContactListener();
		camara = new OrthographicCamera(Gdx.graphics.getWidth() / 128f, Gdx.graphics.getHeight() / 128f);
		stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
		posicion = new Vector3(stage.getCamera().position); 
		
		world = new World(new Vector2(0,0), true);
        world.setContactListener(game_contact_listener);
        
        DebugMode = false;
        
        ShaderProgram.pedantic = false;
        shader = new ShaderProgram(Gdx.files.internal("shaders/Shader-1.vsh"),Gdx.files.internal("shaders/Shader-1.fsh"));
        stage.getBatch().setShader(shader);
	}
	@Override
	public void show(){		
		generator  = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pixelic_War.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter2 =  new FreeTypeFontParameter();
		parameter3 =  new FreeTypeFontParameter();
		parameter.size = 100;
		parameter2.size = 30;
		parameter3.size = 12;
		font1 = generator.generateFont(parameter);
		font2 = generator.generateFont(parameter2);
		font3 = generator.generateFont(parameter3);
		generator.dispose();
		
		personaje = factory.PersonajeEntity(world, new Vector2(8,8));
		background = factory.backGroundEntity();
		asteroid = factory.AsteroidEntity(world, new Vector2(0,0));
		
		text = new DrawingText(font1,font2,font3);
		
		
		l2.add(factory.EnemigoEntity(world, new Vector2(36.12946f,19.556313f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(38.03013f,21.162043f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(36.284443f,15.009862f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(37.741295f,11.123609f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(33.763496f,9.786193f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(24.394896f,10.853953f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(17.506569f,8.612214f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(13.638282f,7.4306045f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(13.015917f,5.350386f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(19.744242f,6.6345124f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(26.634407f,4.450708f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(27.412203f,1.0320036f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(35.790314f,8.705044f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(15.953884f,13.135447f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(23.330652f,27.45342f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(20.319563f,24.923452f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(16.000000f,16.000000f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(4.216516f,13.751976f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(8.90883f,13.924006f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(6.9223833f,20.610302f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(6.276514f,29.50955f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(13.750099f,31.507313f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(15.6135f,36.16279f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(20.70087f,28.662645f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(17.419329f,24.962702f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(12.39311f,22.730007f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(10.658726f,18.94582f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(9.420653f,16.493793f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(19.138853f,19.864231f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(23.49405f,19.042135f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(27.983456f,18.104641f)));
		l2.add(factory.EnemigoEntity(world, new Vector2(30.286299f,19.628838f)));

		mesetas = factory.MesaetasEntity();
				
		stage.addActor(background);
		
		stage.addActor(asteroid);
		stage.addActor(personaje);
		for(int i = 0; i < l2.size(); i++){
			stage.addActor(l2.get(i));
		}
		stage.addActor(mesetas);
		stage.addActor(text);

		stage.getCamera().position.set(posicion);
		stage.getCamera().update();
				
		renderer = new Box2DDebugRenderer();
		is_resumen = false;
		DataGame.pause = false;
		Gdx.input.setInputProcessor(new InputProcesorDtps());
		
		Gdx.input.setCursorCatched(true);
		m = MainGame.getManager().get("music/bensound-extremeaction.ogg");
		DataGame.NumEnemies = 32;
		DataGame.dead = false;
		}
	
	@Override
	public void hide(){
		
	}
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(0.12f, 0.13f, 0.266f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(is_resumen){
			stage.getBatch().setColor(0, 0, 0, 0.5f);
			if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
				MainGame.SetPantallaMainMenu();
			}
		}
		else{
			for(int i = 0; i < l2.size(); i++){
				l2.get(i).p_p = personaje.b.getPosition();
			}
			personaje.isDead = game_contact_listener.isDead;
			DeadEnemie();
			stage.act();
			ShotManager();
			world.step(delta, 6, 2);	
		}
		if(game_contact_listener.isDead){
			DataGame.dead = true;
			for(int i = 0; i < l.size(); i++){
				l2.get(i).drawDead = true;
			}
			stage.getBatch().setColor(1, 0, 0, 0.5f);
			i += delta;
			if(i > 1){
				MainGame.SetPantallaJuego();
			}
		}
		stage.getCamera().position.set(personaje.getX() + (0.5f * 128f),personaje.getY() + (0.5f * 128f),0);
		camara.position.set(stage.getCamera().position.x / 128f,stage.getCamera().position.y / 128f,stage.getCamera().position.z / 128f);
		DataGame.pos_camara_x = stage.getCamera().position.x;
		DataGame.pos_camara_y = stage.getCamera().position.y;
		stage.draw();
		m.play();
		if(DebugMode){
			camara.update();
			renderer.render(world, camara.combined);
		}
		
		PauseSystem();
		DataGame.RestarValues();
	}
	
	@Override
	public void dispose(){
		BackGround.dispose();
		stage.dispose();
		world.dispose();
	}
	@Override
	public void resume() {
		
	}
	@Override
	public void pause() {
			
		
	}
	private void PauseSystem(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
			stage.getBatch().setColor(1, 1, 1, 1f);
			Gdx.input.setCursorCatched(true);
			is_resumen = false;
			DataGame.pause = false;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			Gdx.input.setCursorCatched(false);
			is_resumen = true;
			DataGame.pause = true;
		}
	}
	@Override
	public void resize(int width, int height){
		shader.begin();
		shader.setUniformf("u_resolution", width, height);
		shader.end();
	}
	
	private void ShotManager(){
		for(int i = 0; i < l2.size(); i++){
			if(l2.get(i).shot){
				l.add(factory.BalaEntity(world, l2.get(i).get_pos_to_bala(), l2.get(i).p_p));
				stage.addActor(l.get(l.size() - 1));
			}
		}
		for(int i = 0; i < l.size(); i++){
			if(l.get(i).t_life < 0){
				l.remove(i);
			}
		}
	}
	
	private void DeadEnemie(){
		if(game_contact_listener.isHurt){
			int e = 0;
			for(int i = 0; i < l2.size(); i++){
				if(i == 0){
					e = i;
				} else{
					if(l2.get(i).getDistance(l2.get(i).b.getPosition().x, l2.get(i).b.getPosition().y, personaje.b.getPosition().x, personaje.b.getPosition().y) <
							l2.get(e).getDistance(l2.get(e).b.getPosition().x, l2.get(e).b.getPosition().y, personaje.b.getPosition().x, personaje.b.getPosition().y)){
						e = i;
					}
				}
			}if(l2.get(e).isAlive){
				DataGame.NumEnemies -= 1;
			}
			l2.get(e).isAlive = false;
		}
	}
}