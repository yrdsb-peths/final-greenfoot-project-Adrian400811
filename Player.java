import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player class of the game
 * 
 * @author Adrian Lee 
 * @version W1 Jun 2023
 */
public class Player extends SmoothMover
{
    // Import assets
    GreenfootImage tank = new GreenfootImage("DiepTank.png");
    /**
     * Constructor of Player class
     */
    public Player(){
        tank.scale(50,50);
        setImage(tank);
    }
    
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null){
            turnTowards(m.getX(), m.getY());
        }
        
        if(Greenfoot.isKeyDown("w")){
            setLocation(getExactX(), getExactY()-2);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getExactX()-2, getExactY());
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getExactX(), getExactY()+2);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getExactX()+2, getExactY());
        }
    }
    
    /**
     * TurnTowards - make the object turn to a specific angle 
     * using trigonometry
     */
    // public void turnTowards (MouseInfo mi){
        // turnTowards(mi.getX(), mi.getY());
    // }
    
    // public void turnTowards (int x, int y){
        // double dx = x - getExactX();
        // double dy = y - getExactY();
        // double angle = Math.atan2(dy,dx)*180.0/Math.PI;
        // setRotation( (int)angle );
    // }   
}
