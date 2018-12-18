import java.lang.Math;

public class Planet{

    // Current x position
    public double xxPos;

    // Current y position
    public double yyPos;

    // Current velocity in the x direction
    public double xxVel;

    // Current Velocity in the y direction
    public double yyVel;

    public double mass;

    public String imgFileName;

    static final double G = 6.67e-11;

    public Planet (double xP, double yP, double xV, double yV, double m, String img ){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    };

    public double calcDistance(Planet planetIn){
        // Calculating the distance between planet 1 & planet 2
        // (x2 - x1),(y2 - y1)
        double dx = ((planetIn.xxPos) - (this.xxPos));
        double dy = ((planetIn.yyPos) - (this.yyPos));

        double r = Math.sqrt(((dx)*(dx)) + ((dy)*(dy)));

        return r;
    };

    public double calcForceExertedBy (Planet planetIn){

        double r = calcDistance(planetIn);
        double f = ((G)*(this.mass)*(planetIn.mass)) / (r*r);

        return f;
    };

    public double calcForceExertedByX (Planet planetIn){

        double f = calcForceExertedBy(planetIn);

        double dx = ((planetIn.xxPos) - (this.xxPos));

        double r = calcDistance(planetIn);

        double fX = ((f)*(dx)) / (r);

        return fX;
    };

    public double calcForceExertedByY (Planet planetIn){

        double f = calcForceExertedBy(planetIn);

        double dy = ((planetIn.yyPos) - (this.yyPos));

        double r = calcDistance(planetIn);

        double fY = ((f)*(dy)) / (r);

        return fY;
    };

    public double calcNetForceExertedByX(Planet [] planetIn){

        double fNetX = 0;

        for (Planet each : planetIn){
            if (this.xxPos == each.xxPos && this.yyPos == each.yyPos){
              continue;
            }
            else{
                fNetX += calcForceExertedByX(each);
            }
        }

        return fNetX;

    };

    public double calcNetForceExertedByY(Planet [] planetIn){

        double fNetY = 0;

        for (Planet each : planetIn){
            if (this.xxPos == each.xxPos && this.yyPos == each.yyPos){
                continue;
            }
            else{
                fNetY += calcForceExertedByY(each);
            }
        }

        return fNetY;

    };



}