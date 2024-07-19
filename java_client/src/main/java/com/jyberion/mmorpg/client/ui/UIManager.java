package com.jyberion.mmorpg.client.ui;

public class UIManager {
    private LoginScreen loginScreen;

    public UIManager(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public void showLoginFailedMessage() {
        loginScreen.showLoginFailedMessage();
    }
}
