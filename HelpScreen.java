import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tutorial Screen for the game
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class HelpScreen extends World
{

    /**
     * Constructor for objects of class HelpScreen.
     * 
     */
    public HelpScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        Label title = new Label("Tutorial", 80);
        Label back = new Label("w: back to main menu", 30);
        addObject(title, 150, 50);
        addObject(back, getWidth()-300, getHeight()-50);
    }
    public void act(){
        if(Greenfoot.isKeyDown("w")){
            TitleScreen titlWorld = new TitleScreen();
            Greenfoot.setWorld(titlWorld);
        }
    }
}
