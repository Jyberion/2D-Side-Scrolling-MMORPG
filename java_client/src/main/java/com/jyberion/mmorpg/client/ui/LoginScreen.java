package com.jyberion.mmorpg.client.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jyberion.mmorpg.client.GameClient;
import com.jyberion.mmorpg.client.networking.NetworkClient;

public class LoginScreen implements Screen {
    private Stage stage;
    private Skin skin;
    private TextField usernameField;
    private TextField passwordField;
    private TextButton loginButton;
    private final GameClient gameClient;
    private final NetworkClient networkClient;

    public LoginScreen(GameClient gameClient, NetworkClient networkClient) {
        this.gameClient = gameClient;
        this.networkClient = networkClient;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Load the skin
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create login window
        Window loginWindow = new Window("Login", skin);
        loginWindow.setSize(300, 200);
        loginWindow.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 100);

        usernameField = new TextField("", skin);
        usernameField.setMessageText("Username");
        passwordField = new TextField("", skin);
        passwordField.setMessageText("Password");
        passwordField.setPasswordCharacter('*');
        passwordField.setPasswordMode(true);

        loginButton = new TextButton("Login", skin);
        loginButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                handleLogin();
            }
        });

        loginWindow.add(new Label("Username: ", skin));
        loginWindow.add(usernameField).row();
        loginWindow.add(new Label("Password: ", skin));
        loginWindow.add(passwordField).row();
        loginWindow.add(loginButton).colspan(2).center().row();

        stage.addActor(loginWindow);
    }

    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (networkClient.login(username, password)) {
            gameClient.setScreen(new GameScreen(gameClient, networkClient));
        } else {
            Dialog dialog = new Dialog("Login Failed", skin, "dialog") {
                public void result(Object obj) {
                    System.out.println("result " + obj);
                }
            };
            dialog.text("Invalid username or password.");
            dialog.button("OK", true);
            dialog.show(stage);
        }
    }

    @Override
    public void show() {}

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
}
