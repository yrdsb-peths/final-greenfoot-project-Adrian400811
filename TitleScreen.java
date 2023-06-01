import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen of game
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        // Create label entries
        Label title = new Label("A Horrible Copy of diep.io", 70);
        Label start = new Label("Press Space to Start", 30);
        Label help = new Label("Press h for Help",30);
        
        // Put label entries in suitable places
        addObject(title, getWidth()/2, getHeight()/2);
        addObject(start, getWidth()/2, getHeight()/2+100);
        addObject(help, getWidth()/2, getHeight()/2+150);
    }
    public void act(){
        // Detect keys
        if(Greenfoot.isKeyDown("h")){  // To help screen if "h" is pressed
            HelpScreen tutWorld = new HelpScreen();
            Greenfoot.setWorld(tutWorld);
        }
        if(Greenfoot.isKeyDown("space")){  // Start game if "space" is pressed
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
