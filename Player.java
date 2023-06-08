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
    private int exp = 1;
    private int level = 0;
    private double bulSpeed = 2.50;
    private int shootInterval = 500;

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
        if(Greenfoot.isKeyDown("i")){
            incExp(5);
        }
        if(shootTimer.millisElapsed() > shootInterval && (Greenfoot.isKeyDown("space") || autoShoot)){
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
            MyWorld world = (MyWorld) getWorld();
            world.updateHpBar(this.hp);
        }
        
        // end game if hp = 0
        if(hp <= 0){
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void shoot(){
        Bullet b = new Bullet(getRotation(), bulSpeed);
        MyWorld world = (MyWorld) getWorld();
        world.addObject(b, this.getX(), this.getY());
    }

    public void incExp(int ex){
        if(hp < 100+(50*(level-1))){
            hp += ex;
        }else{
            exp += ex;
        }
        if(exp>(100*level)){
            level += 1;
            exp = 0;
            hp += 25;
            speed += 1;
            bulSpeed += 1.50;
            shootInterval = shootInterval/4*3;
        }
        MyWorld world = (MyWorld) getWorld();
        world.updateHpBar(hp);
        world.updateExp(exp);
        world.updateLv(level);
    }
}
