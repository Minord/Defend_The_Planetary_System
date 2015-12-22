package com.minord.game.jam.dtps;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.minord.game.jam.dtps.Pantallas.PantallaBase;
import com.minord.game.jam.dtps.Pantallas.PantallaJuego;

public class Defend_The_Planetary_System extends Game{
	
	private AssetManager manager;
	
	private PantallaBase pantallaJuego;
	
	@Override
	public void create () {		
		manager = new AssetManager();
		
		manager.load("StarsBackGround.jpg", Texture.class);
		manager.load("CuadradoVioletaOLoQueSea.png", Texture.class);
		manager.load("badlogic.jpg", Texture.class);
		manager.load("PersonajeBoseto.png", Texture.class);
		manager.load("Metroid.png", Texture.class);
		manager.finishLoading();
		pantallaJuego = new PantallaJuego(this);
		setScreen(pantallaJuego);
	}
	
	public AssetManager getManager() {
		return manager;
	}	
}