public class LinearEquation {
    private int xValue1;
    private int yValue1;
    private int xValue2;
    private int yValue2;
    private String firstCoordinates;
    private String secondCoordinates;

    public LinearEquation(String firstCoords, String secondCoords){
        // setting coordinate values for point 1
        int commaSpot = firstCoords.indexOf(",");
        int closingParenthSpot = firstCoords.indexOf(")");
        xValue1 = Integer.parseInt(firstCoords.substring(1,commaSpot));
        yValue1 = Integer.parseInt(firstCoords.substring(commaSpot+2,closingParenthSpot));
        // setting coordinate values for point 2
        int commaSpot2 = secondCoords.indexOf(",");
        int closingParenthSpot2 = secondCoords.indexOf(")");
        xValue2 = Integer.parseInt(secondCoords.substring(1,commaSpot));
        yValue2 = Integer.parseInt(secondCoords.substring(commaSpot+2,closingParenthSpot2));
        // setting coordinate pairs
        firstCoordinates = firstCoords;
        secondCoordinates = secondCoords;
    }

    public String lineInfo(){
        if (xValue1 == xValue2) {
            return "These points are on a vertical line: x=" + xValue1;
        } else {
            // different forms of slope
            String slopeAsFrac = (yValue2 - yValue1) + "/" + (xValue2 - xValue1);
            double slopeAsDouble = (yValue2 - yValue1) / (xValue2 - xValue1);
            double roundedSlope = Math.round(slopeAsDouble*100)/100;

            // if slope is 1 or -1
            if (slopeAsDouble == 1){
                roundedSlope = ;
            }

            // finding y intercept
            double yInter = yValue1 - (roundedSlope * xValue1);

            // calculating distance btwn two points
            double distance = Math.sqrt(Math.pow(xValue2 - xValue1, 2) + Math.pow(yValue2 - yValue1, 2));

            // return
            return "The two points are: " + firstCoordinates + " and " + secondCoordinates + "\n" + "The equation of the line between these points is y=" + slopeAsFrac + "x" + yInter + "\n" + "The slope of this line is: " + roundedSlope + "\n" + "The y-intercept of this line is: " + yInter + "\n" + "The distance between the two points is: " + distance;
        }
    }

}
