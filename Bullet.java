import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet is being shot by the player to cause damage to the shapes
 * 
 * @author Adrian Lee
 * @version W1 Jun 2023
 */
public class Bullet extends SmoothMover
{
    public int dmg = 5;
    public double spd = 2.00;
    public Bullet(){
        
    }
    public Bullet(int tdmg){
        dmg = tdmg;
    }
    public Bullet(double tspd){
        spd = tspd;
    }
    public Bullet(int tdmg, double tspd){
        dmg = tdmg;
        spd = tspd;
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
