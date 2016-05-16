package model;

import java.io.IOException;

import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Drawable;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resizable;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

public class GraphicObject
	implements MouseObserver, Drawable, Resizable
{

	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;

	public GraphicObject(String filename, int x, int y) {
		try {
			this.image = new Image(filename);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	@Override
	public void draw(Canvas canvas) {
		if (image != null)
			canvas.drawImage(image, x, y);
	}

	@Override
	public void notify(MouseEvent evt, int button, Point point) {
		if (x < point.x && x+width > point.x) {
			if (y < point.y && y+height > point.y)
				image = null;
		}
	}

	@Override
	public void resize(int w, int h) {
		this.width = w;
		this.height = h;
		this.image.resize(w, h);
	}

}
