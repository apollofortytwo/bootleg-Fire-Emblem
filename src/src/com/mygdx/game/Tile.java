package src.com.mygdx.game;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Tile {
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	int x, y;
	Rectangle bounds;
	Color color = Color.WHITE;
	
	
	Tile(int x, int y) {
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public void update() {

	}

	public void renderSprite() {
		// TODO
	}

	public void renderOutline(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(x, y, bounds.width, bounds.height);
		sr.setColor(Color.WHITE);
	}
}
