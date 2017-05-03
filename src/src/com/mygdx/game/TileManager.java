package src.com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileManager {

	public static Tile[][] map;
	Tile SelectedTile = null;
	int width, height;
	OrthographicCamera cam;
	
	TileManager(int width, int height, OrthographicCamera cam) {
		map = new Tile[width][height];
		this.width = width;
		this.height = height;
		this.cam = cam;
	}

	public void initMap() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				map[x][y] = new Tile(x * Tile.WIDTH, y * Tile.HEIGHT);
			}
		}
	}
	
	public void renderOutline(ShapeRenderer sr){
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				map[x][y].renderOutline(sr);
			}
		}
	}

	public void update() {
//		if (Gdx.input.isTouched()) {
//			float mouseX = Gdx.input.getX();
//			float mouseY = Gdx.input.getY();
//			Vector3 cords = new Vector3(mouseX,mouseY,0);
//			cam.unproject(cords);
//			System.out.println(cords);
//			
//			for (int x = 0; x < width; x++) {
//				for (int y = 0; y < height; y++) {
//					if(map[x][y].bounds.contains(cords.x,cords.y)){
//						map[x][y].color = Color.BLUE;
//					}
//				}
//			}	
//			
//		}
		
	
	
	}
	
}
