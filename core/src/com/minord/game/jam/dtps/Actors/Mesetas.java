package com.minord.game.jam.dtps.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Mesetas extends Actor{
	
	private Texture m_1;
	private Texture m_2;
	private Texture m_3;
	private Texture m_4;
	private Texture m_5;
	
	
	private int[] x;
	private int[] y;
	private float[] size_m;
	
	public Mesetas(Texture m_1,Texture m_2,Texture m_3,Texture m_4,Texture m_5){
		this.m_1 = m_1;
		this.m_2 = m_2; 
		this.m_3 = m_3; 
		this.m_4 = m_4; 
		this.m_5 = m_5;
		
		x = new int[5];
		x[0] = 1000;
		x[1] = 810;
		x[2] = 2040;
		x[3] = 3350;
		x[4] = 3780;
		y = new int[5];
		y[0] = 3310;
		y[1] = 1060;
		y[2] = 1480;
		y[3] = 390;
		y[4] = 1710;
		size_m = new float[5];
		size_m[0] = 0.75f;
		size_m[1] = 0.75f;
		size_m[2] = 0.75f;
		size_m[3] = 0.75f;
		size_m[4] = 0.75f;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		batch.draw(m_1, x[0],y[0], m_1.getWidth() * size_m[0], m_1.getHeight() * size_m[0]);
		batch.draw(m_2, x[1],y[1], m_2.getWidth() * size_m[1], m_2.getHeight() * size_m[1]);
		batch.draw(m_3, x[2],y[2], m_3.getWidth() * size_m[2], m_3.getHeight() * size_m[2]);
		batch.draw(m_4, x[3],y[3], m_4.getWidth() * size_m[3], m_4.getHeight() * size_m[3]);
		batch.draw(m_5, x[4],y[4], m_5.getWidth() * size_m[4], m_5.getHeight() * size_m[4]);
	}

}
