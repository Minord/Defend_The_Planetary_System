package com.minord.game.jam.dtps.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.minord.game.jam.dtps.Defend_The_Planetary_System;

public class PantallaInicio extends PantallaBase{
	
	private SpriteBatch batch;
	private Texture fondo;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter; 
	BitmapFont font;
	public PantallaInicio(Defend_The_Planetary_System gamePrincipal) {
		super(gamePrincipal);
		batch = new SpriteBatch();
	}
	@Override
	public void show() {	
		generator  = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pixelic_War.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 120;
		font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose();
		fondo = MainGame.getManager().get("img/Stars.png");
	}
	@Override
	public void render(float delta) {
		batch.begin();
		Gdx.gl.glClearColor(0.12f, 0.13f, 0.266f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			MainGame.SetPantallaJuego();
		}
		
		font.draw(batch, "Clik To Play", 100, 200);
		batch.draw(fondo,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

	}
	@Override
	public void dispose() {
		
	}
}
