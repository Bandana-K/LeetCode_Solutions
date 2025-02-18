class Solution {
    public boolean isBoomerang(int[][] points) {

        if(points[0][0] == points[1][0] && points[0][1] == points[1][1]) return false;  // check if point1 and point2 are same return false
        if(points[1][0] == points[2][0] && points[1][1] == points[2][1]) return false;  // check if point2 and point3 are same return false
        if(points[0][0] == points[2][0] && points[0][1] == points[2][1]) return false;  // check if point1 and point3 are same return false

        // Given the 3 points, to check if they are not in same line, we can calculate the slope for any 2 set of points.
        // If the slope is same all 3 are in same lines, else not. But calculating slope might give error of divide by 0.

        //check for x-axis
        double slope1 = Math.abs(1.0 * (points[1][1] - points[0][1])/(points[1][0] - points[0][0]));
        double slope2 = Math.abs(1.0 * (points[2][1] - points[1][1])/(points[2][0] - points[1][0]));

        System.out.println("slope1 = " + slope1 + " slope2 = " + slope2);
        return slope1 != slope2;
    }
}