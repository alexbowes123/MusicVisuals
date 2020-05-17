package ie.tudublin;

import c18727635.Space;
import c18727635.MyVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Space());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}