# Music Visualiser Project

Name: Alexander Bowes

Student Number: c18727635

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
An animation which takes the amplitude of the song 'Around the World' and uses it as an input for creating animations
such as a robot walking, craters on a planet moving, small planets moving in orbit, and a cube.

# Instructions
Run main.java inside TUDublin directory
# How it works
The main method in the file Main.java runs Space.java which has imports for processing and tables as well as extending the file 'Visual'.
In space.java an array is initialised to contain stars which are read in from the star.csv file.

The settings() function sets the size of the screen and the setup() method loads in the file "dpATW.mp3" which is the song that will be used for this assignment. 
Next the function loadStars() loads in the star co ordinates into the Star array.

Arrays created for: 
crater y co ords.
crater x co ords.
crater widths
crater heights
These arrays are later used for drawing the craters on screen.

the loadStars() method loads in the star.csv file into the table
the displayStars() method was intended to draw small ellipses to the screen which would resemble white stars to give the overall visual a space aesthetic but I could not finish this due to time constraints.


The moonSun() method draws the moon and sun(actually a different planet) on screen in relation to the center of the largest planet/moon in the center of the screen and uses the amplitude to change the position of the small asteroids, which gives the impression they are shaking when the large robot walks 


the deathStar() method draws a shape that resembles the iconic death star. I wanted to incorporate FFT and use sine waves in an interesting way like using them as lasers being shot from the death star as it would be a practical use of FFT however due to the fact I already have loaded in the music using "loadAudio", when I use "loadSample" it is as if the music is being played twice or has an echo and severely affects the quality of the visual and music. For this reason and due to time constraints considering this only came to mind today (17/5) as FFT was going to be the last thing I was going to incorporate.

The astronaut() method draws the robot/astronaut and uses the amplitude to move the legs in a convincing way by shrinking,streching and swapping the leg sizes  in accordance to the amplitude. This was one of the earliest methods I wrote.

the spaceShip() method uses the mouse x and y co ordinates and draws shapes which resemble an alien in a space ship, the idea was to allow the viewer to control the alien flying around in space.

The cube() is a derivation of the cube example which I implemented as a representation of cubeVisual to show 3D effects being incorporated.

These methods are called in the draw() method and result in an animation of a robot stomping along a planet with the orbiting planets vibrating while and alien which the user controls flies around and a cube rotates with the death star in the corner.
# What I am most proud of in the assignment

I am most proud of the overall idea I had for this assignment and while it may fail to incorporate all of the features learned over the semester, I enjoyed making it since I chose things that I was passionate about to base my assignment on. I chose music that I love that could play in the background and even incorporated the Artist (1/2 of Daft Punk) into it by drawing the robot in a suit to resemble Thomas Bangalter. I am proud of the attempt made at doing animation that resembles something between 2D and 3D with the craters that receed into the horizon to give a somewhat 3D effect.

I do have one regret/misstep which I could correct which was choosing style over substance, I understand if this assignment does not seem adequate due to the lack of FFT as I was probably too concerned with having a really cool premise for the assignment.

I am also proud about the ambitious nature of it as well as the time invested over the last number of months to create this as well as entering gamesfleadh with a team and submitting a game also. 

I understand that the gamesfleadh was optional but please consider it when assessing the assignment overall.

GAMESFLEADH GAME:
https://www.youtube.com/watch?v=THecwxEyjH8&t=4s

THIS ASSIGNMENT VIDEO:
https://www.youtube.com/watch?v=6xGvjVlofFQ


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

