package src.com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MapManager {
	OrthographicCamera cam;
	EntityManager em;
	TileManager tm;
	Cursor cursor;
	boolean lockOn = false;


	
	MapManager(OrthographicCamera cam) {
		em = new EntityManager(cam);
		tm = new TileManager(20, 20, cam);
		tm.initMap();
		this.cam = cam;
		cursor = new Cursor(0,0);

	}

	public void renderSprites() {

	}

	public void renderOutline(ShapeRenderer sr) {
		tm.renderOutline(sr);
		em.renderOutline(sr);
		cursor.renderOutline(sr);
		cursor.renderText();

	}

	public void update() {
		tm.update();
		em.update();
		cursor.update();

		if (Gdx.input.isKeyJustPressed(Keys.L)) {
			lockOn = !lockOn;
		}

		if (lockOn) {
			cam.position.x = cursor.wPos.x;
			cam.position.y = cursor.wPos.y;
		}

		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			for (Entity entity : em.enlist) {
				if (entity.x == cursor.x && entity.y == cursor.y) {
					entity.color = Color.RED;
				}
			}
		}

	}

	public void addEntity(int x, int y) {
		em.addEntity(new Entity(x, y));
	}

}
