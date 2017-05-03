package src.com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * highlights the current tile that is being looked at
 * 
 * @author 499154010
 *
 */
public class Cursor {
	int x, y;
	Vector2 wPos;
	private StageText positionText;
	private StageText wPositionText;

	/**
	 * 
	 * @param x
	 *            X position that the cursor initially appears on
	 * @param y
	 *            Y position that the cursor initially appears on
	 */
	Cursor(int x, int y) {
		this.x = x;
		this.y = y;
		wPos = worldPosition(x, y);
		wPositionText = new StageText("");
		positionText = new StageText("");

		Main.container.addActor(wPositionText.label);
		Main.container.addActor(positionText.label);
	}

	float frames = 0;

	/**
	 * updates the world position of the cursor calls the input handler every
	 * 1/10 of a second. calling it 1/10 seconds prevents the cursor from being
	 * moved rapidly allowing it to move a single tile while allowing it to be
	 * held down to move continuously
	 */
	public void update() {
		wPos = worldPosition(x, y);
		frames += Gdx.graphics.getDeltaTime();

		if (frames > 0.1f) {
			inputHandler();
			frames = 0;
		}

	}

	/**
	 * moves the cursor around based on the key that's being pressed
	 */
	public void inputHandler() {
		if (InputHandler.checkKey("Down")) {
			moveCursor(x, y - 1);
		}
		if (InputHandler.checkKey("Left")) {
			moveCursor(x - 1, y);
		}
		if (InputHandler.checkKey("Right")) {
			moveCursor(x + 1, y);
		}
		if (InputHandler.checkKey("Up")) {
			moveCursor(x, y + 1);
		}
	}

	/**
	 * renders the cursors World position, and grid position on the top left
	 * corner
	 */
	public void renderText() {
		wPositionText.update(wPos.toString());
		positionText.update(new Vector2(x, y).toString());
	}

	/**
	 * sets the cursor position to the grid
	 * also prevents the cursor from moving off screen
	 * 
	 * @param x
	 *            horizontal grid position
	 * @param y
	 *            vertical grid position
	 */
	public void moveCursor(int x, int y) {
		System.out.println(wPos);
		if (x >= 0 && y >= 0 && x < TileManager.map.length && y < TileManager.map[1].length) {
			this.x = x;
			this.y = y;
		}
		System.out.println(new Vector2(this.x, this.y));
	}

	/**
	 * The cursor has two different kinds of positions the position that the
	 * cursor exist on a grid the position that the cursor exist in the world
	 * 
	 * @param x
	 *            horizontal grid position
	 * @param y
	 *            vertical grid position
	 * @return the position that the cursor exist in the world
	 */
	public Vector2 worldPosition(int x, int y) {
		return new Vector2(x * Tile.WIDTH, y * Tile.HEIGHT);
	}

	/**
	 * renders the box frame of the cursor
	 * the colour of the cursor is cyan
	 * @param sr
	 */
	public void renderOutline(ShapeRenderer sr) {
		sr.setColor(Color.CYAN);
		sr.rect(x * Tile.WIDTH, y * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT);
		sr.setColor(Color.WHITE);
	}
}
