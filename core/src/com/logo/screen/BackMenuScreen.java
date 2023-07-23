package com.logo.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class BackMenuScreen implements Screen {

    Stage stage;
    Skin skin;
    TextureAtlas backButtonAtlas;
    Button backButton;

    public BackMenuScreen(final LogoScreenTest game) {

    stage = new Stage(new StretchViewport(800,480));
    backButtonAtlas = new TextureAtlas(Gdx.files.internal("backButtonsAtlas.atlas"));
    skin = new Skin();
    skin.addRegions(backButtonAtlas);
    Button.ButtonStyle backButtonStyle = new Button.ButtonStyle();
    backButtonStyle.up = skin.getDrawable("backButtonUp");
    backButtonStyle.down = skin.getDrawable("backButtonDown");
    backButton  = new Button(backButtonStyle);
    backButton.setSize(128, 96);
    backButton.setPosition(662, 32);
    backButton.addListener(new ClickListener() {
        public void clicked(InputEvent event, float x, float y) {

            ((Game)Gdx.app.getApplicationListener()).setScreen(new LogoScreen(game));
        }
    });
  

    stage.addActor(backButton);
}

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backButtonAtlas.dispose();
        stage.dispose();
    }
}