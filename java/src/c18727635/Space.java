package c18727635;

import java.util.ArrayList;
//import ddf.minim.*;
//import ddf.minim.analysis.FFT;

import ie.tudublin.Visual;
import processing.data.Table;
import processing.data.TableRow;

public class Space extends Visual {

    public ArrayList<Star>stars = new ArrayList<Star>();	//holds array of star co-ords from star.csv file
    
  /*  Minim minim;
	AudioSample as;

	int frameSize = 1024;
	int sampleRate = 44100;
    FFT fft;
    
    float frameToSecond = sampleRate / (float) frameSize;
*/


    public void settings() {
        size(800, 800, P3D);    //size of screen
        // fullScreen(P3D, SPAN);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

          //  as.stop();
			//as.trigger();
        }
    }

    float posX, posY;
    float radiusX, radiusY;
    float theta;


    public void setup() {
        colorMode(HSB);
        noCursor();

        setFrameSize(256);

        startMinim();
        loadAudio("dpATW.mp3");
        // getAp().play();
        // startListening();
        //	as = minim.loadSample("dpATW.mp3", frameSize);
	    //fft = new FFT(frameSize, sampleRate); 

        loadStars();


        posX = posX = 0;

        radiusX = centX - 130;
        radiusY = centY - 170;

        theta = 0;
    }

    float smoothedBoxSize = 0;

    float planetBase = centY + 170; //bottom of center planet
    float craterY[] = {planetBase - 95,planetBase - 80, planetBase - 110, planetBase - 15, planetBase - 90, planetBase - 130};
    float craterX[] = {centX - 86, centX - 60, centX -30,centX + 25, centX + 65, centX + 105};
    float craterW[] = {15,15,17,15,15,15};
    float craterH[] = {12,12,14,12,12,12};


    float leg_l_size = 25;
    float leg_r_size = 25;
    float leg_temp = 40;
    float leg_temp2 = 0;

    float a = 0;

    
    int radius = min(width, height) / 2;
    float secondsRadius = radius * 0.72f;
  
    float s = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
    
  /*  int countZeroCrossings()
	{
		int count = 0;

		for(int i = 1 ; i < as.bufferSize() ; i ++)
		{                                                                      
			if (as.left.get(i-1) > 0 && as.left.get(i) <= 0)
			{
				count ++;
			}
		}
		return count;
	}*/





    public void loadStars()
	{
		Table s = loadTable("star.csv", "header");
		for(TableRow row:s.rows())
		{
			Star x = new Star(row);				//add the stars to star array
			stars.add(x);
		}
		
    }
    
    public void displayStars() {
       // starStar = map(s.getStarX(), 1, 200, )
       for(Star s: stars){

          // println(s);                                        //draw little ellipses using the csv file that are stars
           fill(255);
           ellipse(s.getStarX(),s.getStarY(), 2,2); // does not work, could not figure out why the csv file is not read correctly
       }
    }

    public void moonSun() {
        centX = width/2;        
        centY = height/2;
        float orbitX = centX;       
        float orbitY = centY;
        float orbitRadius = 230;
        float orbitSpeed = PI/16;
        float sphereRadius = 50;
        fill(255);
        
        float radian = orbitSpeed * getAmplitude();
        float drawX = orbitX + orbitRadius * cos(radian);   //moon an small planet x co ord relative to centX
        float drawY = orbitY + orbitRadius * sin(radian);
        
      
        ellipse(drawX, drawY, sphereRadius, sphereRadius ); //moon 
        fill(0);                                                          
        ellipse(drawX-10, drawY -5, sphereRadius - 10, sphereRadius-10); //creates crescent

        float sunX = -(drawX-10) + width;
        float sunY = -(drawY-5) + height;
        
        fill(85, 76, 100);
        ellipse(sunX, sunY, sphereRadius - 10, sphereRadius-10); // green planet
        //line()

       
    }

    public void deathStar(){
        int dcX = width - 250;
        int dcY = height - 100;
        fill(66,17,83);
        ellipse(dcX, dcY, 180, 165);                //was trying to implement FFT to use sine waves to draw a green laser shooting from the deathstar
        fill(66,17,53);
        ellipse(dcX - 10, dcY - 20, 80, 70);
        noFill();
        ellipse(dcX - 12, dcY - 20, 40, 35);
        line(dcX- 50, dcY -30, dcX + 33, dcY-10);
        line(dcX, dcY - 55, dcX - 20, dcY + 10);
    }



    public void spaceShip(){

        float shipBodyX = mouseX;
        float shipBodyY = mouseY;
        noStroke();                                                     //spaceship with alien that flies around on mouseX and mouseY
        fill(14,11,86);
        ellipse(shipBodyX,shipBodyY, 70, 40);
        fill(14,28,68);
        ellipse(shipBodyX , shipBodyY - 8, 27, 30);
        fill(85, 76, 100);
        ellipse(shipBodyX, shipBodyY - 5, 14, 17);     //alien head
        fill(0);
        stroke(10);
        line(shipBodyX-2, shipBodyY - 8, shipBodyX-2, shipBodyY - 5);   // eyes
        line(shipBodyX + 2, shipBodyY - 8, shipBodyX + 2, shipBodyY - 5); //eyes
        line(shipBodyX -2, shipBodyY - 3, shipBodyX + 2, shipBodyY - 3); //mouth
        
        
        
    }
                    

    public void drawPlanet() {
        fill(293, 15, 152);
        ellipse(centX, centY, 320, 290);        //center planet

        if(getAmplitude() == 0) 
        {
            

            fill(26,33,23);
            for(i = 0; i< craterX.length; i++)
            {
                ellipse(craterX[i], craterY[i],craterW[i], craterH[i]);     //array of craters drawn to starting position
            }
          
        }
        else if(getAmplitude() > 0)
        {       
            for(i=0;i<craterX.length; i++)
            {
                fill(10);
                ellipse(craterX[i], craterY[i], craterW[i], craterH[i]);

              
                craterY[i] = craterY[i] - (getAmplitude() * 12);

               if(craterY[i] < centY)
               {
                craterW[i] = craterW[i] - (getAmplitude() * 2);
                craterH[i] = craterH[i] - (getAmplitude() * 2);
               }
               else
               {
                craterW[i] = craterW[i] + (getAmplitude() * 2);
                craterH[i] = craterH[i] + (getAmplitude() * 2);

               }
               if(craterY[i] < ((centY - 168) +leg_r_size))
               {
                   craterY[i] = planetBase - 50;
               }
            }
        }

    }
    


    public void astronaut() 
    {
        fill(0,0,100);
        rect(centX - 15, centY - 218, 17, 10); // neck
        rect(centX - 22, centY - 230, 33, 5);
        ellipse(centX - 6, centY - 225, 28, 24);// head
        fill(0, 0, 0);
        rect(centX - 16, centY - 230, 20, 5); // visor
        fill(293, 15, 152);
        // noStroke();
        rect(centX - 13, centY - 222, 12, 7);
        line(centX - 11, centY - 218, centX - 3, centY - 218);

        // stroke(255,0,0);
        fill(277, 90, 71);
        rect(centX - 22, centY - 213, 35, 45); // torso
        rect(centX-32, centY - 212, 10,37); // Left A
        rect(centX+12, centY - 213, 10, 37); // Right A


        fill(0,0,255);
        triangle(centX - 7, centY - 185, centX-17, centY -212, centX + 5, centY - 212);//suit shirt
        fill(0,12,100);
        line(centX - 7, centY -165, centX - 7, centY - 211);
        stroke(255, 0, 0);

    
        //LEG ANIMATIONS 
        if(getAmplitude() == 0)
        {
            fill(277, 90, 71);
            rect(centX - 22, centY - 168, 12, leg_l_size); // Left L
            rect(centX + 1, centY - 168, 12, leg_r_size); // Right L                //legs in initial position before music
        }
        else if(getAmplitude() > 0) 
        {
            
            leg_r_size = (leg_r_size *  - getAmplitude());     
            leg_l_size = (leg_r_size * getAmplitude());                 //amplitude affects the size of the legs

            
            if (leg_r_size > -0.5 || leg_l_size < -0.5 )
            {
                leg_r_size = 30;
                leg_l_size = 17;
            }
            else if( leg_r_size < -0.5 || leg_l_size > -0.5)
            {
                leg_r_size = 17;
                leg_l_size = 30;
            }
  
            fill(277, 90, 71);
            rect(centX - 22, centY - 168, 12, leg_l_size); // Left L        //draw legs
            rect(centX + 1, centY - 168, 12, leg_r_size); // Right L
            try
            {
                Thread.sleep(100);          //pause the leg movement for .1 second
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            leg_temp2 = leg_r_size;
            leg_r_size = leg_l_size;        //swap leg sizes to give impression of walking
            leg_l_size = leg_temp2;         //one leg is shorter than the opposite during walk at any given time
        }
    }

    public void cube()
    {
        float angle = 0;                    
        translate(0, 0, -250);
        float boxSize = 50 + (getAmplitude() * 300); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
        
        
        rotateY(angle);
        rotateX(angle);        
        strokeWeight(1);
        fill(136,100,62);
        box(smoothedBoxSize);
        noFill();
        
        angle += 0.01f;
    }   
    
   // float lerpedw = 0;
	//float average = 0;

   /* public void FFT_laser()
    {
        float cy = height / 2;
		float sum = 0;
		for(int i = 0 ; i < as.bufferSize() ; i ++)
		{
			stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);                                                      //I sincerely wanted to implement FFT but left it to last which was a terrible 
			line(i, cy, i, cy + as.left.get(i) * cy);               //mistake since I had already been working on this assignment for months
			sum += abs(as.left.get(i));                             //without ever using it.
		}
		average = sum / as.bufferSize();

		float w  = average * 1000;
		lerpedw = lerp(lerpedw, w, 0.1f);
		noStroke();
		fill(
			map(average, 0, 1, 0, 255)
			, 255
			, 255
        );
        

        int count = countZeroCrossings();

		float freq = count * frameToSecond;
		textSize(22);
		text("Zero crossings frequency: " + freq, 100, 50);

		fft.window(FFT.HAMMING);
		fft.forward(as.left);

		stroke(255);
		int highestBin = 0;
		for(int i = 0 ; i < fft.specSize() ; i ++)
		{
			line(i, 0, i, fft.getBand(i) * 100);
			if (fft.getBand(i) > fft.getBand(highestBin))
			{
				highestBin = i;
			}
		}

		float freq1 = fft.indexToFreq(highestBin);

		fill(255);
		text("FFT Freq: " + freq1, 100, 100);
    }*/
    

    

    public void draw()
    {
        calculateAverageAmplitude();  //get amplitude
        background(0); //draw space background
        displayStars(); //wanted ellipses to draw, they would not load correctly 
        drawPlanet();   //center planet, includes crates receeding to the horizon and appearing at bottom
        astronaut();    //robot, includes walking animations
        moonSun();      //the planets orbiting the big planet
        spaceShip();
        deathStar();    //wanted to incorporate FFT with this function for a laser
        cube();         
    }   
        
        
        
       
        
        
    
       
       
}