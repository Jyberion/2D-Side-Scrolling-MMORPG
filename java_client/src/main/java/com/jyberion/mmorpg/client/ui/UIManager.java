package com.jyberion.mmorpg.client.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class UIManager {
    private Stage stage;

    public UIManager() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        // Initialize UI components here
    }

    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }
}
