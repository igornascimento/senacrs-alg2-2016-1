package app;

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
		
		objects = new GraphicObject[5];
		objects[0] = new GraphicObject("images/barbarian.jpg",50,100);
		objects[0].resize(200, 200);
		objects[1] = new GraphicObject("images/halforc.jpg",350,250);
		objects[1].resize(200, 200);
		objects[2] = new GraphicObject("images/treasure.jpg",550,400);
		objects[2].resize(150, 150);
		objects[3] = new GraphicObject("images/door.jpg",600,50);
		objects[3].resize(200, 200);
		objects[4] = new GraphicObject("images/door.jpg",0,300);
		objects[4].resize(150, 200);
		
		for (MouseObserver mo : objects)
			addMouseObserver(MouseEvent.CLICK, mo);
		
		addMouseObserver(MouseEvent.CLICK, this);
		
		redraw();
	}

	@Override
	public void notify(MouseEvent arg0, int arg1, Point arg2) {
		redraw();
	}

}
