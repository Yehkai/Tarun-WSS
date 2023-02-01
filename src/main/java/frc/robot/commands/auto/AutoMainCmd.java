package frc.robot.commands.auto;

import java.util.Map;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Globals;
import frc.robot.RobotContainer;
import frc.robot.Astar.Layout;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Sensor;
import frc.robot.subsystems.Vision;
import frc.robot.commands.auto.MoveRobotSense;
import frc.robot.commands.auto.LoopCmd;




/**
 * DriveMotor class
 * <p>
 * This class creates the inline auto command to drive the motor
 */
public class AutoMainCmd extends SequentialCommandGroup
{   
    int count = 0;
    double temp;
    private final static Sensor m_sensor = RobotContainer.m_sensor;
    private final static Vision m_vision = RobotContainer.m_vision;
    private final static Arm m_arm = RobotContainer.m_arm;

	public AutoMainCmd() 
    {
        
        
        super(
        
        // new MovetoB(new Pose2d(0.96, 1.1, new Rotation2d(0))),
        
        // new MovetoB(new Pose2d(1.2, 0.35, new Rotation2d(0))),
        // new ReadWOB(),
        // new MovetoB(Layout.Convert_mm_Pose2d(Layout.PickUpBinPos)),
        // new Align2Line(),
        // new WaitCommand(2),
        // new InstantCommand(()-> m_vision.getWOBItems()),
        // new ViewItem(),
        // new LoopCmd(new SortItems(), ()->Globals.WOBLoopCondition())
        // new MoveRobot(1, -0.1, 0, 0, 0.3)
        
        // new RotatetoDir(RobotContainer.m_omnidrive.Rotate2Obj(0.5,1.1))//working
      
        //new AlignRobot()
            new ViewItem(),
            new LoopCommands(new ProcessSeq())
            // new GotoTrolley(0.15, 4.35)
        //new CP3()
        // new CP2()
        // new CP3()
        // new CP4()
        // new CP6()
        // new RotatetoDir(45)
        // new GotoTrolley(0.15, 4.35)
        // new Rotate2Obj(0.15, 4.35)
        // new Rotate(45, 0.3)
            //new LoopCmd(new TestMotion(), ()->(++Globals.LoopCnt)>5 ) /// loop cmd
                // new TestMotion(),
                // new TestMotion(),
                // new TestMotion(),
                // new TestMotion(),
                // new TestMotion()
                // new MoveRobot(0, 0.0875, 0, 0, 0.4),
                // // new WaitCommand(2),
                // new MovetoB(new Pose2d(0.96, 1.6, new Rotation2d(0))),
                // new MovetoB(new Pose2d(0.96, 1.1, new Rotation2d(0))),
                // new MoveRobot(0, 0.0875, 0, 0, 0.4),
                // // new WaitCommand(2),
                // new MovetoB(new Pose2d(0.96, 1.6, new Rotation2d(0))),
                // new MovetoB(new Pose2d(0.96, 1.1, new Rotation2d(0))),
                // new MoveRobot(0, 0.0875, 0, 0, 0.4),
                // // new WaitCommand(2),
                // new MovetoB(new Pose2d(0.96, 1.6, new Rotation2d(0))),
                // new MovetoB(new Pose2d(0.96, 1.1, new Rotation2d(0))),
                // new MoveRobot(0, 0.0875, 0, 0, 0.4),
                // // new WaitCommand(2),
                // new MovetoB(new Pose2d(0.96, 1.6, new Rotation2d(0))),
                // new MovetoB(new Pose2d(0.96, 1.1, new Rotation2d(0))),
                // new MoveRobot(0, 0.0875, 0, 0, 0.4),
                // // new WaitCommand(2),
                // new MovetoB(new Pose2d(0.96, 1.6, new Rotation2d(0))),
                // new MovetoB(new Pose2d(0.96, 1.1, new Rotation2d(0)))
              );
            
    }
    @Override
    public void initialize(){
        
        super.initialize();
        RobotContainer.m_omnidrive.initialise();
        RobotContainer.m_arm.initialize();
    }
}
