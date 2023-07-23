package com.logo.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LogoScreenTest extends Game {

	public SpriteBatch batch;

	@Override
	public void create () {

		batch = new SpriteBatch();
		this.setScreen(new LogoScreen(this));
	}

	@Override
	public void render () {
		super.render(); 
	}

	public void dispose() {
		batch.dispose();	
	}
}