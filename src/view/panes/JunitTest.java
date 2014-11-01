package view.panes;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.layout.StackPane;

import org.junit.Before;
import org.junit.Test;

import view.TurtleDraw;
import view.controllers.ImagePalette;

import javafx.geometry.Point2D;
public class JunitTest {

	@Test
	public void testTurtleDraw()
	{
		//constructor
		Point2D a = new Point2D(0,0);
		Point2D b = new Point2D(4,4);
		ImagePalette ip = new ImagePalette();
		TurtleDraw myDraw = new TurtleDraw(ip);
		myDraw.drawLine(a,b);
		assertEquals(4.0*Math.sqrt(2),a.distance(b), 0);
		Point2D c = new Point2D(8,4);
		myDraw.drawLine(b,c);
		assertEquals(4, b.distance(c), 0);
		
	}

}