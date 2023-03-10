/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    /**
     * Motor Constants
     */
    public static final int TITAN_ID        = 42; 
    public static final int MOTOR_NUM       = 3;
    public static final int SERVO           = 0;
    public static final int SERVO_2         = 1;
    public static final int SERVO_3         = 2;
    public static final int SERVO_4         = 3;
    public static final int SERVO_5         = 4;

    /**
     * IO constants
     */
    public static final int DEBUG_PIN       = 8; 
    public static final int INPUT0          = 9;
    public static final int INPUT1          = 11;

    /**
     * Sensors
     */
    public static final int SHARP_1           = 0;
    public static final int SHARP_2           = 1;
    public static final int SONIC_TRIGG     = 12;
    public static final int SONIC_ECHO      = 13;

    //Wheels
    public static final double KWHEELDIAMETER = 0.097;  //wheel diameter
    public static final double KENCODERCNTPR = 1464;  //Count per output shaft rev
    public static final double KENCODERDISTPERPULSE = (KWHEELDIAMETER*Math.PI)/KENCODERCNTPR;

    //PIDs
    public static final int PID_NUM = 3;
    public static final double PID_DT = 0.02;
    public static final boolean PID_THREAD = false;
}
