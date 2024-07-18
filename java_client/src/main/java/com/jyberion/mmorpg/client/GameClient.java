package com.jyberion.mmorpg.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.jyberion.mmorpg.client.networking.NetworkClient;
import com.jyberion.mmorpg.client.ui.LoginScreen;

public class GameClient extends ApplicationAdapter {
    private Screen screen;
    private NetworkClient networkClient;

    @Override
    public void create() {
        networkClient = new NetworkClient("localhost", 8558);
        networkClient.connect();
        setScreen(new LoginScreen(this, networkClient));
    }

    public void setScreen(Screen screen) {
        if (this.screen != null) {
            this.screen.hide();
        }
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (screen != null) {
            screen.render(Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void dispose() {
        if (screen != null) {
            screen.hide();
            screen.dispose();
        }
    }
}
