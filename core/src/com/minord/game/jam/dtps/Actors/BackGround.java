package com.minord.game.jam.dtps.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minord.game.jam.dtps.DataGame;

public class BackGround extends Actor{
	private Texture t;
	
	public BackGround(Texture t){
		this.t = t;
		
	}
	
	public void act(float batch){
		
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		batch.draw(t, DataGame.pos_camara_x - (2.5f * 128f), DataGame.pos_camara_y - (2f * 128f));
    }
}	
