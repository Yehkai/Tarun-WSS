package frc.robot;

//Put all global variables here
public class Globals
{
    static public int menuItem;

    static public final int DNUM = 4;
    static public int debug[] = new int[DNUM];
    static public String[] debugNames = new String[] {"debug0", "debug1", "debug2", "debug3"};
    public static double convertPxToM = 0.000590;//0.0006075; // 0.56/800 , 0.00058 good // Resolution
    public static double camera_offset = 0.09;
    public static double arm_offset_y = 0.13; // 0.125
    public static double arm_offset_z = 0.25;
    public static double gripper_offset = 0.16;
    public static double CokeRatio = 0.85;
    public static int LoopCnt =0;
    /*
     *  Jagabee = 0
     *  Dettol  = 1
     *  Coke    = 2
     */
    public static int curItemType = 0;
    public static double curItemX;
    public static double curItemY;
    public static double curX=0;
    public static double curY=0;
    /*
     *  Red   = 0
     *  Green = 1
     *  Blue  = 2
     */
    public static int curTarget = 0;
    /*
     *  Bin1 = 0
     *  Bin2 = 1
     */
    public static int curBin = 0;
    /*
     *  Line detection = 0
     *  Object Detection = 1
     *  Work Order Board = 2
     */
    public static int cvMode = 0;
    /*
	   *                                              J|D|C              
	   *                                            R|x|x|x|
	   *                                            G|x|x|X|
	   *                                            B|x|x|x|
     * 
     *  This array stores the number of items in each target area
	   */
    public static int[][] Targets = new int[][] {};

    public static double curDir = 0; 
    // End condition for pick and place
    // NOTE: 2d array has 3 columns but there are 4 objects
    public static boolean WOBLoopCondition(){
      // loops targets
    for(Globals.curTarget = 0; Globals.curTarget < 3; Globals.curTarget++) { 
      // loops items
      for(Globals.curItemType = 0; Globals.curItemType < 4; Globals.curItemType++) {
        // IF curItem is not any of the cokes
        if(Globals.curItemType==0 || Globals.curItemType==1){
          // while array is not empty
          while (Globals.Targets[Globals.curTarget][0]>0) { 
              // check if box contains item
            if(RobotContainer.m_vision.getObjects()[Globals.curItemType*3]>0){ 
              // when last object is picked up, move on to 2nd pick up bin
              if((RobotContainer.m_vision.getObjects()[0*3]+RobotContainer.m_vision.getObjects()[1*3]+RobotContainer.m_vision.getObjects()[2*3]+RobotContainer.m_vision.getObjects()[3*3])==1)
                Globals.curBin++;
  
              Globals.curItemY = RobotContainer.m_vision.getObjects()[Globals.curItemType*3+2];
              Globals.curItemX = RobotContainer.m_vision.getObjects()[Globals.curItemType*3+1];
              Globals.Targets[Globals.curTarget][0]--; // decrements ONLY the column[0] with coke
              return false;
             }
            else // if box does not contain current item carry on
              break;
           }
         }
        // If the item is not coke
        else{
          while (Globals.Targets[Globals.curTarget][Globals.curItemType-1]>0) { 
          // check if box contains item
            if(RobotContainer.m_vision.getObjects()[Globals.curItemType*3]>0){ 
              // when last object is picked up, move on to 2nd pick up bin
              if((RobotContainer.m_vision.getObjects()[0*3]+RobotContainer.m_vision.getObjects()[1*3]+RobotContainer.m_vision.getObjects()[2*3]+RobotContainer.m_vision.getObjects()[3*3])==1)
                Globals.curBin++;

              Globals.curItemY = RobotContainer.m_vision.getObjects()[Globals.curItemType*3+2];
              Globals.curItemX = RobotContainer.m_vision.getObjects()[Globals.curItemType*3+1];
              Globals.Targets[Globals.curTarget][Globals.curItemType-1]--;
              return false;
            }
            else // if box does not contain current item carry on
              break; 
          }
        }
      }
    }
    return true;
  }
}