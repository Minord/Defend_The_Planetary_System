package com.minord.game.jam.dtps.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.minord.game.jam.dtps.DataGame;

public class DrawingText extends Actor{
	BitmapFont font_counter;
	BitmapFont f;
	BitmapFont f2;
	
	private float t_f = 0;
	

	public DrawingText(BitmapFont font_counter,BitmapFont font_counter_m,BitmapFont font_counter_m2){
		this.font_counter = font_counter_m;
		this.f = font_counter;
		this.f2 = font_counter_m2;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
		//batch.draw(t, DataGame.pos_camara_x - (Gdx.graphics.getWidth() / 2), DataGame.pos_camara_y - (Gdx.graphics.getHeight() / 2),Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		font_counter.draw(batch, DataGame.NumEnemies + "/32",DataGame.pos_camara_x,DataGame.pos_camara_y + 250);
		if(DataGame.pause){
			f.draw(batch,"Pause",DataGame.pos_camara_x,DataGame.pos_camara_y);
			f2.draw(batch,"Enter to continue",DataGame.pos_camara_x,DataGame.pos_camara_y - 150);
			f2.draw(batch,"Left click to main menu",DataGame.pos_camara_x - 400,DataGame.pos_camara_y - 250);
		}
		if(DataGame.dead){
			f.draw(batch,"Game Over",DataGame.pos_camara_x,DataGame.pos_camara_y);
		}
		if(DataGame.NumEnemies == 0 && t_f < 10){
			f.draw(batch,"Thaks For Playing",DataGame.pos_camara_x - 300,DataGame.pos_camara_y);
			font_counter.draw(batch,"Now put the humans in a stack",DataGame.pos_camara_x - 150,DataGame.pos_camara_y - 200);
			f2.draw(batch, "Minor (@diumix8)", DataGame.pos_camara_x + 400,DataGame.pos_camara_y - 250);
		}
    }
	public void act(float batch){
		if(DataGame.NumEnemies == 0 && t_f < 10){
			t_f += batch;
		}
	}
}
