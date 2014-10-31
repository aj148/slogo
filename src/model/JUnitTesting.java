package model;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.layout.StackPane;

import org.junit.Before;
import org.junit.Test;
public class JUnitTesting {

	@Test
	public void testTurtle()
	{
		//constructor
		Turtle a=new Turtle(4);
		assertEquals(a.getID(), 4.0, 0);
		a.setHeading(90.5);
		assertEquals(90.5, a.getHeading(), 0);
		a.towards(1, -1);
		assertEquals(135.0, a.getHeading()%360, 0);
		a.setXAndY(50,  50);
		assertEquals(50, a.getNewLocation().getX(), 0);
	}
	
}
