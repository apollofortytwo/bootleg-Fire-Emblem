package src.com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class Main implements ApplicationListener {

	boolean[][] map = new boolean[50][50];
	public static Stage stage;

	CameraController controller;
	
	public OrthographicCamera cam;
	ShapeRenderer sr;
	TileManager tm;
	MapManager mm;
	public static VerticalGroup container;

	@Override
	public void create() {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 400);
		cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);

		stage = new Stage();

		container = new VerticalGroup().reverse();
		container.setPosition(0, Gdx.graphics.getHeight());
		container.left();
		
		
		stage.addActor(container);
		
		mm = new MapManager(cam);
		for(int i = 0; i < 20; i ++){
			mm.addEntity(i, 0);
		}
		
		controller = new CameraController(cam);
		
		Gdx.input.setInputProcessor(controller);
		
		sr = new ShapeRenderer();
	}

	public void update() {
		mm.update();
		cam.update();
		controller.update();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		sr.setProjectionMatrix(cam.combined);
	
		sr.setAutoShapeType(true);
		sr.begin();
		mm.renderOutline(sr);
		
		sr.end();

		stage.draw();
		
		update();
	}


	@Override
	public void dispose() {

	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
	
	
	
}
