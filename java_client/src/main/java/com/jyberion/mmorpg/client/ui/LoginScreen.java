package com.jyberion.mmorpg.client.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jyberion.mmorpg.client.GameClient;
import com.jyberion.mmorpg.client.networking.NetworkClient;

public class LoginScreen implements Screen {
    private Stage stage;
    private Skin skin;
    private TextField usernameField;
    private TextField passwordField;
    private Label messageLabel;
    private NetworkClient networkClient;
    private GameClient gameClient;

    public LoginScreen(GameClient gameClient, NetworkClient networkClient) {
        this.gameClient = gameClient;
        this.networkClient = networkClient;
        networkClient.setUiManager(new UIManager(this)); // Set UIManager in NetworkClient
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        messageLabel = new Label("", skin);
        table.add(messageLabel).colspan(2).align(Align.center);
        table.row().pad(10, 0, 0, 10);

        usernameField = new TextField("", skin);
        usernameField.setMessageText("Username");
        table.add(usernameField).width(200).colspan(2);
        table.row().pad(10, 0, 0, 10);

        passwordField = new TextField("", skin);
        passwordField.setMessageText("Password");
        passwordField.setPasswordCharacter('*');
        passwordField.setPasswordMode(true);
        table.add(passwordField).width(200).colspan(2);
        table.row().pad(10, 0, 0, 10);

        TextButton loginButton = new TextButton("Login", skin);
        loginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                networkClient.login(username, password);
            }
        });

        table.add(loginButton).colspan(2);
    }

    public void showLoginFailedMessage() {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                messageLabel.setText("Login failed. Please try again.");
                messageLabel.setColor(1, 0, 0, 1);
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }

    @Override
    public void show() {}

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
        skin.dispose();
    }
}
