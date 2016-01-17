package com.minord.game.jam.dtps.Actors;

import static com.minord.game.jam.dtps.Constantes.PIXELS_IN_METER;
import static com.minord.game.jam.dtps.Constantes.VERTEX_ASTEROID_1;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Asteroid extends Actor{
	
	//private Body bodyGravity;
	//private Fixture fixtureGravity;
	
	private Texture t;

	


	private Body body;
	private World world;
	ArrayList<Fixture> list = new ArrayList<Fixture>();
	
	public Asteroid(Texture t,World world, Vector2 postion){
		this.t = t;
		this.world = world;
		
		BodyDef def = new BodyDef();
		def.position.set(postion);
		def.type = BodyDef.BodyType.StaticBody;
		body = this.world.createBody(def);
		
		for(int i = 0; i < VERTEX_ASTEROID_1.length; i++){
			for(int j = 0; j < VERTEX_ASTEROID_1[i].length / 2; j++){
				
				    float vertex[] = new float[4];

					if((j * 2) + 1 >= VERTEX_ASTEROID_1[i].length){
						vertex[2] = VERTEX_ASTEROID_1[i][2]- 0.10f;
						vertex[3] = VERTEX_ASTEROID_1[i][3]- 0.10f;
					}
					else{
						vertex[2] = VERTEX_ASTEROID_1[i][j * 2]- 0.10f;
						vertex[3] = VERTEX_ASTEROID_1[i][(j * 2) + 1]- 0.10f;
					}
					if((j * 2) - 2 >= 0){
						vertex[0] = VERTEX_ASTEROID_1[i][(j * 2) - 2]- 0.10f;
						vertex[1] = VERTEX_ASTEROID_1[i][(j * 2) - 1]- 0.10f;
					}
					else{
						vertex[0] = VERTEX_ASTEROID_1[i][VERTEX_ASTEROID_1[i].length - 2] - 0.10f;
						vertex[1] = VERTEX_ASTEROID_1[i][VERTEX_ASTEROID_1[i].length - 1] - 0.10f;
						//vertex[0] = 0;
						//vertex[0] = 0;
					}
					
					EdgeShape polygon_temp = new EdgeShape();
					polygon_temp.set(vertex[0], vertex[1], vertex[2], vertex[3]);
					EdgeShape asteroidShape = polygon_temp;
					list.add(body.createFixture(asteroidShape, 3));
					//list.get(j).setUserData("Asteroid");
					asteroidShape.dispose();
			}
		}
		setSize(PIXELS_IN_METER,PIXELS_IN_METER);

		//BodyDef def_Gravity = new BodyDef();
		//def_Gravity.position.set(postion);
		//def_Gravity.type = BodyDef.BodyType.StaticBody;
		//bodyGravity = this.world.createBody(def_Gravity);
		
		//CircleShape Gravity = new CircleShape();
		//Gravity.setRadius(20);
		//fixtureGravity = bodyGravity.createFixture(Gravity,0);
		//fixtureGravity.setSensor(true);
		//fixtureGravity.setUserData("AsteroidGravity");
		//Gravity.dispose();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		this.setPosition((body.getPosition().x) * PIXELS_IN_METER, (body.getPosition().y) * PIXELS_IN_METER);
		//if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			//x_a = Gdx.input.getX();
			//y_a = Gdx.input.getY(); 
		//}
		//if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
			//System.out.println(x_a + " " + y_a);
		//}
		//batch.draw(textureRegion, x_a, y_a);
		batch.draw(t, 0, 0, 5000,5000);
	}
		
	public void act(float batch){
		
	}
	public void detach(){
		
	}
	/*public PolygonShape makePolygon(float[] vertex_base, float size, int numTriangle){
		PolygonShape polygon_temp = new PolygonShape();
		float vertices[] = new float[6];
		int num = numTriangle;
		vertices[0] = (vertex_base[0 + num * 2] / 1024) * size;
		vertices[1] = (vertex_base[1 + num * 2] / 1024) * size;
			
		vertices[2] = ((vertex_base[0 + num * 2] / 1024) * size) + 0.01f;
		vertices[3] = ((vertex_base[1 + num * 2] / 1024) * size);
		if((num * 2) + 3 > VERTEX_ASTEROID_1.length){
			num = 0;
			vertices[4] = (vertex_base[0 + num * 2] / 1024) * size;
			vertices[5] = (vertex_base[1 + num * 2] / 1024) * size;
		}
		else{
			vertices[4] = (vertex_base[2 + num * 2] / 1024) * size;
			vertices[5] = (vertex_base[3 + num * 2] / 1024) * size;
		}
		polygon_temp.set(vertices);
		return polygon_temp;
	}
	private void CreateTriangle(int numTriangle){
		PolygonShape asteroidShape = makePolygon(VERTEX_ASTEROID_1, size, numTriangle);
		fixture[numTriangle] = body.createFixture(asteroidShape, 30);
		fixture[numTriangle].setUserData("Asteroid");
		asteroidShape.dispose();
		setSize(PIXELS_IN_METER,PIXELS_IN_METER);
   	}*/
}