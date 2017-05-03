package src.com.mygdx.game;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class StageText {

	Label label = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
	StringBuilder sb = new StringBuilder();
	
	StageText(String text){
		sb.append(text);
	}
	
	public void update(String text){
		sb.setLength(0);
		sb.append(text);
		
		label.setText(sb);
		sb.setLength(0);
	}
}
