package com.minord.game.jam.dtps;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.minord.game.jam.dtps.Pantallas.PantallaBase;
import com.minord.game.jam.dtps.Pantallas.PantallaInicio;
import com.minord.game.jam.dtps.Pantallas.PantallaJuego;

public class Defend_The_Planetary_System extends Game{
	
	private AssetManager manager;
	
	private PantallaBase pantallaJuego,pantallaInicio;
	
	@Override
	public void create () {		
		manager = new AssetManager();
		
		manager.load("img/Gild/Meseta-1.png", Texture.class);
		manager.load("img/Gild/Meseta-2.png", Texture.class);
		manager.load("img/Gild/Meseta-3.png", Texture.class);
		manager.load("img/Gild/Meseta-4.png", Texture.class);
		manager.load("img/Gild/Meseta-5.png", Texture.class);
		manager.load("img/Gild/AsteroideQueVaQuedandoBien-OnlyRock.png", Texture.class);
		manager.load("img/Person.png", Texture.class);
		manager.load("img/En.png", Texture.class);
		manager.load("sound/Shot.ogg", Sound.class);
		manager.load("music/bensound-extremeaction.ogg", Music.class);
		manager.load("img/Bala.png", Texture.class);
		manager.load("img/Stars.png", Texture.class);
		manager.finishLoading();
		pantallaInicio = new PantallaInicio(this);
		setScreen(pantallaInicio);
	}
	
	public AssetManager getManager() {
		return manager;
	}
	public void SetPantallaJuego(){
		pantallaJuego = new PantallaJuego(this);
		setScreen(pantallaJuego);
	}
	public void SetPantallaMainMenu(){
		setScreen(pantallaInicio);
	}
}