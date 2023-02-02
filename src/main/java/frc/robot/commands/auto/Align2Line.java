package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Globals;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Sensor;
import frc.robot.subsystems.Vision;

public class Align2Line extends SequentialCommandGroup{
  private final static Arm m_arm = RobotContainer.m_arm;
  private final static Sensor m_sensor = RobotContainer.m_sensor;
  private final static Vision m_vision = RobotContainer.m_vision;

  public Align2Line(){
    super(
      new MoveArm(new Translation2d(0.33,0.24), 0.5), // Line detection position
      new InstantCommand(()-> m_arm.setCameraAngle(280)),
      new InstantCommand(()-> Globals.cvMode = 0),
      new InstantCommand(m_vision::setcvMode),
      new AlignRobot(),
      new InstantCommand(()-> Globals.cvMode=-1),
      new InstantCommand(m_vision::setcvMode),
      new MoveRobotSense(1, 0.3, 0, 0,0.25, ()-> m_sensor.getIRDistance()<=15)
    );
  }
  
}
