package src.com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class MoveSpread {

	Entity entity;
	TileManager tm;

	public static ArrayList<Tile> moveSpread(Entity entity) {
		ArrayList<Tile> highlight = new ArrayList<Tile>();

		return highlight;
	}

	public static void tree(int x, int y, int moves) {
		
		if (moves > 0) {
			tree(x - 1, y, moves - 1);
			tree(x + 1, y, moves - 1);
			tree(x, y + 1, moves - 1);
			tree(x, y - 1, moves - 1);
		}
	}

}
