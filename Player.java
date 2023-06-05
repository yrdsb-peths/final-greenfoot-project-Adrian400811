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
    SimpleTimer shootTimer = new SimpleTimer();
    SimpleTimer modeTimer = new SimpleTimer();
    GreenfootImage tank = new GreenfootImage("DiepTank.png");
    private boolean autoShoot = false;
    private int hp = 100;
    private int speed = 2;
    /**
     * Constructor of Player class
     */
    public Player(){
        tank.scale(50,50);
        setImage(tank);
    }

    public void act()
    {
        // gun always turn to mouse
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null){
            turnTowards(m.getX(), m.getY());
        }
        
        // movement
        if(Greenfoot.isKeyDown("w")){
            setLocation(getExactX(), getExactY()-speed);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getExactX()-speed, getExactY());
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getExactX(), getExactY()+speed);
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getExactX()+speed, getExactY());
        }
        if(shootTimer.millisElapsed() > 500 && (Greenfoot.isKeyDown("space") || autoShoot)){
            shoot();
            shootTimer.mark();
        }
        if(modeTimer.millisElapsed() > 100 &&Greenfoot.isKeyDown("e")){
            MyWorld world = (MyWorld) getWorld();
            if(autoShoot){
                autoShoot = false;
                world.printAutoMode(false);
            } else {
                autoShoot = true;
                world.printAutoMode(true);
            }
            modeTimer.mark();
        }
        // detect collusion with shapes
        if(isTouching(Shape.class) ) { 
            hp += -1;
        }
        
        // end game if hp = 0
        if(hp <= 0){
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }
    }
    public void shoot(){
        Bullet b = new Bullet(getRotation());
        MyWorld world = (MyWorld) getWorld();
        world.addObject(b, this.getX(), this.getY());
    }
}
