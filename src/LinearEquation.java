public class LinearEquation {
    private int xValue1;
    private int yValue1;
    private int xValue2;
    private int yValue2;
    private String firstCoordinates;
    private String secondCoordinates;
    private double slope;
    private String slopeAsFrac;
    private String yInt;


    public LinearEquation(int x1, int y1, int x2, int y2){
        // setting coordinate values for point 1
        xValue1 = x1;
        xValue2 = x2;
        yValue1 = y1;
        yValue2 = y2;
        firstCoordinates = "(" + x1 + "," + y1 + ")";
        secondCoordinates = "(" + x2 + "," + y2 + ")";

        // band aid approach!
        setUpSlope();
        yIntercept();
    }

    private void setUpSlope() {
        // different forms of slope
        String slopeAsFrac = (yValue2 - yValue1) + "/" + (xValue2 - xValue1);

        // making sure double negative in slopeasfrac gets printed as a positive
        if (yValue2-yValue1 < 0 && xValue2-xValue1 < 0){
            slopeAsFrac = (yValue2 - yValue1)*-1 + "/" + (xValue2 - xValue1)*-1;
        } else if (yValue1 == yValue2){
            slopeAsFrac = "";
        }

        // returning a whole number instead of a reducable fraction
        if ((yValue2 - yValue1)%(xValue2-xValue1) == 0){
            double newSlopeAsFrac = (yValue2-yValue1)/(xValue2-xValue1);
            slopeAsFrac = String.valueOf(newSlopeAsFrac);
        }


        // if slope is 1 or -1
        if (slope() == 1){
            slopeAsFrac = "";
        } else if (slope() == -1){
            slopeAsFrac = "-";
        }

        this.slopeAsFrac= slopeAsFrac;
    }

    public double slope(){

        // converting slope to a double & rounding it
        double slopeAsDouble = (double)(yValue2 - yValue1) / (xValue2 - xValue1);
        double roundedSlope = Math.round(slopeAsDouble*100)/(double)100;

        return roundedSlope;
    }

    public double yIntercept(){
        // finding y intercept
        double yInter = yValue1 - (slope() * xValue1);

        String yIntercept = "";
        if (yInter > 0){
            yIntercept = "+ " + yInter;
        } else if (yInter < 0){
            yIntercept = "- " + (yInter*-1);
        }
        yInt = yIntercept;

        return yInter;
    }

    public String equation(){
        return "y = " + slopeAsFrac + "x " + yInt;
    }

    public double distance(){
        // calculating and returning distance btwn two points
        double distance = Math.sqrt(Math.pow(xValue2 - xValue1, 2) + Math.pow(yValue2 - yValue1, 2));
        distance = Math.round(distance*100)/(double)100;
        return distance;
    }

    public String lineInfo(){
        if (xValue1 == xValue2) {
            return "These points are on a vertical line: x=" + xValue1;
        } else {
            // return
            return "The two points are: " + firstCoordinates + " and " + secondCoordinates + "\n" + "The equation of the line between these points is " + equation() + "\n" + "The slope of this line is: " + slope() + "\n" + "The y-intercept of this line is: " + yIntercept() + "\n" + "The distance between the two points is: " + distance();
        }
    }

    public String coordinateForX(double userXCoord){
        return "(" + userXCoord + "," + (slope()*userXCoord + yIntercept()) + ")";
    }

}
