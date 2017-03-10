package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	//SpriteBatch batch;
	Texture img;

	private Texture ok;
	private SpriteBatch batch;
	private int width, height;
	private int widthOk, heightOk;
	@Override
	public void create () {
		ok = new Texture("ok.png");
		batch = new SpriteBatch();
	 width=Gdx.graphics.getWidth();
	 height=Gdx.graphics.getHeight();
		widthOk=ok.getWidth();
		heightOk=ok.getHeight();
	}
	@Override
	public void dispose(){

			ok.dispose();
		batch.dispose();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,0,1.5f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
batch.begin();



		batch.draw(ok, 200,200,250,250 );
		batch.end();
	}
	

}
