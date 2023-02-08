package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Astar.Layout;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

public class CP6 extends SequentialCommandGroup{
  private final static Arm m_arm = RobotContainer.m_arm;
  private static double trolley_x = 1.45,
                        trolley_y = 4.35;
  private static double target_x = 0.15,
                        target_y = 2.9;   
  
  public CP6(){
    super(
      new MoveCamera(290),
      new GotoTrolley(Layout.Convert_mm_Pose2d(Layout.T1Pos)),
      new TrolleyHolder(1),
      new GotoColor(Layout.Convert_mm_Pose2d(Layout.RedPos)),
      new TrolleyHolder(0)
    );
  }
}
