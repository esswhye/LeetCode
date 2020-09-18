package septchallenge;


import java.util.ArrayList;
import java.util.List;

/*
1041. Robot Bounded In Circle
On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



Example 1:

Input: "GGLLGG"
Output: true
Explanation:
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: "GG"
Output: false
Explanation:
The robot moves north indefinitely.
Example 3:

Input: "GL"
Output: true
Explanation:
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...


Note:

1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}
 */
public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBoundedV2("GLR"));
    }

    public static boolean isRobotBounded(String instructions) {

        int x = 0;
        int y = 0;
        int direction = 0;
        int[] array = new int[2];
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'G') {
                if (direction == 0) {
                    y++;
                } else if (direction == 90) {
                    x++;
                } else if (direction == 180 || direction == -180) {
                    y--;
                } else if (direction == -90) {
                    x--;
                }
            } else if (instructions.charAt(i) == 'L') {

                direction -= 90;
            }
            //R
            else {
                direction += 90;
            }
            if (direction == 360 || direction == -360)
                direction = 0;
        }
        System.out.println(x + "," + y);
        return true;
    }


    public static boolean isRobotBoundedV2(String instructions) {
        //current x y pos, fixed directions
        int x = 0, y = 0, pos = 0;
        //  N,    E,     S,        W
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < instructions.length(); i++) {

            if (instructions.charAt(i) == 'R') {
                //Avoid getting arrayoutofbound %dir.length get the remainder of the element.
                pos = (pos + 1) % directions.length;
            } else if (instructions.charAt(i) == 'L') {
                pos = (pos + 3) % directions.length;
            } else {
                x = x + directions[pos][0];
                y = y + directions[pos][1];
            }

        }
        // if pos more than 1  direction only has 1
        return x == 0 && y == 0 || pos != 0;

    }
}
