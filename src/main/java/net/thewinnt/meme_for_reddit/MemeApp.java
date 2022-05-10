package net.thewinnt.meme_for_reddit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.ScreenUtils;

public class MemeApp extends ApplicationAdapter {
  SpriteBatch batch;
  Texture img;
  BitmapFont font;
  FreeTypeFontGenerator gen;

  @Override
  public void create() {
    batch = new SpriteBatch();
    img = new Texture("meme_bg.jpg"); // load the background
    // load the font
    gen = new FreeTypeFontGenerator(Gdx.files.internal("segoeui.ttf"));
    FreeTypeFontParameter parameter = new FreeTypeFontParameter();
    parameter.size = 28;
    parameter.color = Color.BLACK;
    font = gen.generateFont(parameter);
  }

  @Override
  public void render() {
    ScreenUtils.clear(0, 0, 0, 1);
    batch.begin();
    batch.draw(img, 0, 0, 500, 500); // draw the background
    // draw the text
    drawCenteredText(font, batch, "Making a meme\nwith Photoshop", 375, 375);
    drawCenteredText(font, batch, "Making a meme\nwith code", 375, 125);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    img.dispose();
    gen.dispose();
    font.dispose();
  }

  /**
   * Draws some text centered at a specific coordinate
   * 
   * @param font  The font to use
   * @param batch The batch to draw the text at
   * @param text  The text to draw
   * @param x     The x-coordinate of the center point
   * @param y     The y-coordinate of the center point
   */
  private static void drawCenteredText(BitmapFont font, Batch batch, String text, float x, float y) {
    font.draw(batch, text, centerTextX(x, font, text), centerTextY(y, font, text));
  }

  /**
   * Centers the text around some x coordinate
   * 
   * @param x    The center coordinate
   * @param font The font that the text uses
   * @param text The text itself
   * @return The coodinate to place the text at
   */
  private static int centerTextX(float x, BitmapFont font, String text) {
    GlyphLayout layout = new GlyphLayout();
    layout.setText(font, text);
    return (int) (x - layout.width / 2);
  }

  /**
   * Centers the text around some y coordinate
   * 
   * @param y    The center coordinate
   * @param font The font that the text uses
   * @param text The text itself
   * @return The coodinate to place the text at
   */
  private static int centerTextY(float y, BitmapFont font, String text) {
    GlyphLayout layout = new GlyphLayout();
    layout.setText(font, text);
    return (int) (y + layout.height / 2);
  }

}
