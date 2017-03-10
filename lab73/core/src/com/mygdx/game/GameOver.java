package com.mygdx.game;

/**
 * Created by Aitor on 05/03/2017.
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameOver implements Screen {
    final Drop game;
    OrthographicCamera camera;

    public GameOver(final Drop gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "GAME OVER ", 200, 150);
        game.font.draw(game.batch, "Presione en cualquier lugar para continuar", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
      //  game.font.draw(game.batch, "Bienvenido a Gremlims ", 300, 150);

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
        game.font.draw(game.batch, "Bienvenido a Gremlims ", 300, 150);

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }





}