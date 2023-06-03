import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Shape
{
    GreenfootImage sq = new GreenfootImage("shapes/square.png");
    public Square(){
        super(10);
        sq.scale(50, 50);
        setImage(sq);
    }
}
