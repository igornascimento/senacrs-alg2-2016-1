package app;

import java.util.ArrayList;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

import model.GraphicObject;

public class Labirinto
	extends GraphicApplication
	implements MouseObserver
{

	private GraphicObject[] objects;
	private ArrayList<?> arrayConfig;
	
	/**
	 * Recebe um array de configuracao para a definicao 
	 * das imgs a serem utilizadas
	 * @param conf {{imgSrc, x, y, w, h}, ...}
	 */
	private Labirinto(ArrayList<?> conf){
		this.arrayConfig = conf;
	}
	
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		for (GraphicObject o : objects)
			o.draw(canvas);
	}

	@Override
	protected void loop() {

	}

	@Override
	protected void setup() {
		setResolution(Resolution.HIGHRES);
		createGraphicObjects(arrayConfig);
		
		for (MouseObserver mo : objects)
			addMouseObserver(MouseEvent.CLICK, mo);
		
		addMouseObserver(MouseEvent.CLICK, this);
		
		redraw();
	}

	private void createGraphicObjects(ArrayList<?> arrConf) {
		this.objects = new GraphicObject[ arrConf.size() ];
		for (int i=0; i<arrConf.size(); i++) {
			objects[0] = new GraphicObject(arrConf[i][0], arrConf[i][1], arrConf[i][2], arrConf[i][3]);
			objects[0].resize(arrConf[i][4], arrConf[i][5]);
		}
	}

	@Override
	public void notify(MouseEvent arg0, int arg1, Point arg2) {
		redraw();
	}

}
