package com.jyberion.mmorpg.client.ui;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jyberion.mmorpg.client.GameClient;
import com.jyberion.mmorpg.client.networking.NetworkClient;

public class GameScreen implements Screen {
    private final GameClient gameClient;
    private final NetworkClient networkClient;
    private Stage stage;

    public GameScreen(GameClient gameClient, NetworkClient networkClient) {
        this.gameClient = gameClient;
        this.networkClient = networkClient;
        this.stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        // Initialize your game screen elements here
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
