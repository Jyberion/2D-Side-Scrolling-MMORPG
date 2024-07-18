package com.jyberion.mmorpg.client;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class ClientLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("MMORPG Client");
        config.setWindowedMode(800, 600);
        new Lwjgl3Application(new GameClient(), config);
    }
}
