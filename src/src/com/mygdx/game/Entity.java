package src.com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Entity {
	int x, y;
	Vector2 wPos;
	int width, height;
	public Color color;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;

		wPos = worldPosition(x, y);
		width = 50;
		height = 20;
		color = Color.WHITE;
	}

	public void update() {
		wPos = worldPosition(x, y);
	}

	public void renderSprite() {
		// TODO
	}

	public Vector2 worldPosition(int x, int y) {
		return new Vector2(Tile.WIDTH * x, Tile.HEIGHT * y);
	}

	public void renderOutline(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(wPos.x + (Tile.WIDTH) / 4, wPos.y + (Tile.HEIGHT) / 4, (Tile.WIDTH) / 2,
				(Tile.WIDTH) / 2);
	}
}
