public class Lab2
{
    public static void cleanSquare()
    {
        Robot.load("square.txt");
        Robot.setDelay(0.1);
        makeRowLight();
        makeRowLight();
        makeRowLight();
        makeRowLight();

    }

    public static void darkenComb()
    {
        Robot.load("comb.txt");
        Robot.setDelay(0.05);
        completeRowAndRepeat();
        completeRowAndRepeat();
        completeRowAndRepeat();
        completeRowAndRepeat();
        makeRowDark();
        returnOutofRow();
    }

    public static void makeCheckered()
    {
        Robot.load("blank.txt");
        Robot.setDelay(0.05);
        TwoCheckerBoardRows();
        TwoCheckerBoardRows();
        TwoCheckerBoardRows();
        LastCheckerBoardRow();
    }

    public static void makeTileLight()
    {
        //precondition: Robot is on light tile
        //postcondition: Robot makes the tile in front of it light, and is now standing on it
        Robot.move();
        Robot.makeLight();
    }

    public static void makeRowLight()
    {
        //precondition: Robot is facing a row of dark tiles while standing on a light tile
        //postcondition: Robot is facing another row after making the previous row of tiles light
        makeTileLight();
        makeTileLight();
        makeTileLight();
        makeTileLight();
        makeTileLight();
        Robot.move();
        Robot.turnLeft();
    }

    public static void turnRight()
    {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void makeTilesDark()
    {
        //precondition: Robot is facing a tile that is not dark
        //postcondition: Robot is on a tile and made it dark
        Robot.move();
        Robot.makeDark();
    }

    public static void makeRowDark()
    {
        //precondition: Robot is facing north and is next to a row of light tiles
        //postcondition: Robot is facing east and is at the end of the row after making all the tiles dark
        turnRight();
        makeTilesDark();
        makeTilesDark();
        makeTilesDark();
        makeTilesDark();
        makeTilesDark();
        makeTilesDark();
    }

    public static void nextRow()
    {
        //precondition: Robot is facing east at the end of a row
        //postcondition: Robot is facing north and is standing next to another row
        returnOutofRow();
        turnRight();
        makeTilesDark();
        Robot.move();
    }

    public static void AboutFace()
    {
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void returnOutofRow()
    {
        //precondition: Robot is standing at the end of a row
        //postcondition: Robot moves out of a row and stands on dark tile
        AboutFace();
        Robot.move();
        Robot.move();
        Robot.move();
        Robot.move();
        Robot.move();
        Robot.move();
        Robot.makeDark();
    }

    public static void completeRowAndRepeat()
    {
        //precondition: Robot is facing north and is standing next to a row of light tiles
        //postcondition: Robot makes the row dark, and then comes out of row and stands next to a new row of light tiles
        makeRowDark();
        nextRow();
    }

    public static void CheckerBoardPatternbitbybit()
    {
        //precondition: Robot stands on light tile
        //postcondition: Robot makes one tile dark, and moves up two tiles to another light tile
        Robot.makeDark();
        Robot.move();
        Robot.move();
    }

    public static void AtEndofCheckerBoardRowFacingNorth()
    {
        //precondition: Robot is on the second to last tile of the row facing north
        //postcondition: Robot is standing facing a row of light tiles
        Robot.makeDark();
        Robot.move();
        turnRight();
        Robot.move();
        turnRight();
    }

    public static void AtEndofCheckerBoardRowFacingSouth()
    {
        //precondition: Robot is on the second to last tile of a row facing south
        //postcondition: Robot is facing north at a row of light tiles
        Robot.makeDark();
        Robot.move();
        Robot.turnLeft();
        Robot.move();
        Robot.turnLeft();
    }

    public static void CheckerBoardRow1()
    {
        //precondition: Robot is standing on a light tile, facing a row of light tiles
        //postcondition: Robot is facing south at a row of light tiles
        CheckerBoardPatternbitbybit();
        CheckerBoardPatternbitbybit();
        CheckerBoardPatternbitbybit();
        AtEndofCheckerBoardRowFacingNorth();
    }

    public static void CheckerBoardRow2()
    {
        //precondition: Robot is facing south at a row of light tiles
        //postcondition: Robot is facing north at a row of light tiles after making the previous row dark
        CheckerBoardPatternbitbybit();
        CheckerBoardPatternbitbybit();
        CheckerBoardPatternbitbybit();
        AtEndofCheckerBoardRowFacingSouth();
    }

    public static void LastCheckerBoardRow()
    {   
        //precondition: Robot is facing the last row of light tiles
        //postcondition: Robot makes the second to last tile of the row dark and stops there
        CheckerBoardRow1();
        CheckerBoardPatternbitbybit();
        CheckerBoardPatternbitbybit();
        CheckerBoardPatternbitbybit();
        Robot.makeDark();
    }

    public static void TwoCheckerBoardRows()
    {
        //precondition: Robot is facing north at a row of light tiles
        //postcondition: Robot goes up and down two rows and makes them a checkerboard pattern, and ends at a new row facing north
        CheckerBoardRow1();
        CheckerBoardRow2();
    }

}
