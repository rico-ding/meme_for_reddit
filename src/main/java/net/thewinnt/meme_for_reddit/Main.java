package net.thewinnt.meme_for_reddit;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {

  public static void main(String[] args) {
    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    config.setForegroundFPS(60);
    config.setResizable(false);
    config.setWindowedMode(500, 500);
    config.setTitle("Made by u/thewinnt");
    new Lwjgl3Application(new MemeApp(), config);
  }

}
