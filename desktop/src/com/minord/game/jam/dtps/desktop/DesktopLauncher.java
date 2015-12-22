package com.minord.game.jam.dtps.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.minord.game.jam.dtps.Defend_The_Planetary_System;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Defend The_Planetary_System";
		config.resizable = true;
		config.width = 640;
		config.height = 360;
		config.vSyncEnabled = true;
		new LwjglApplication(new Defend_The_Planetary_System(), config);
	}
}