package src.com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Cursor {
	int x, y;
	Vector2 wPos;
	private StageText positionText;
	private StageText wPositionText;
	
	Cursor(int x, int y) {
		this.x = x;
		this.y = y;
		wPos = worldPosition(x,y);
		wPositionText = new StageText("");
		positionText = new StageText("");
		
		Main.container.addActor(wPositionText.label);
		Main.container.addActor(positionText.label);
	}

	
	float frames = 0;
	
	public void update(){
		wPos = worldPosition(x,y);
		frames += Gdx.graphics.getDeltaTime();
		
		if(frames > 0.1f){
			if(InputHandler.checkKey("Down")){
				moveCursor(x,y-1);
			}
			if(InputHandler.checkKey("Left")){
				moveCursor(x-1,y);
			}
			if(InputHandler.checkKey("Right")){
				moveCursor(x+1,y);
			}
			if(InputHandler.checkKey("Up")){
				moveCursor(x,y+1);
			}
			frames = 0;
		}
	}
	
	public void renderText(){
		wPositionText.update(wPos.toString());
		positionText.update(new Vector2(x,y).toString());
	}
	
	/**
	 * 		if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			moveCursor(x, y - 1);
		}
		if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			moveCursor(x - 1, y);
		}
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			moveCursor(x + 1, y);
		}
		if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			moveCursor(x, y + 1);
		}
		
	 * @param x
	 * @param y
	 */
	
	public void moveCursor(int x, int y){
		
		System.out.println(new Vector2(x,y));
		Vector2 wBounds = worldPosition(TileManager.map.length,TileManager.map[1].length);
		
		System.out.println(wPos);
		if(x >= 0 && y >= 0 && wPos.x < wBounds.x && wPos.y < wBounds.y){
			this.x = x;
			this.y  = y;	
		}
	}
	
	public Vector2 worldPosition(int x, int y){
		return new Vector2(x * Tile.WIDTH,y * Tile.HEIGHT);
	}
	
	public void renderOutline(ShapeRenderer sr){
		sr.setColor(Color.CYAN);
		sr.rect(x * Tile.WIDTH, y * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT);
		sr.setColor(Color.WHITE);
	}
}
