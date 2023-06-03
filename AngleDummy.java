import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AngleDummy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AngleDummy extends Actor
{
    /**
     * Act - do whatever the AngleDummy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null){
            turnTowards(m.getX(), m.getY());
        }
    }
    public int getMouseAngle(){
        return getRotation();
    }
}
