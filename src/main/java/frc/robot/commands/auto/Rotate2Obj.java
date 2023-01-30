package frc.robot.commands.auto;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.OmniDriveOdometry;
import frc.robot.RobotContainer;
import frc.robot.subsystems.OmniDrive;

public class Rotate2Obj extends SequentialCommandGroup{
    public final static OmniDrive m_omnidrive = RobotContainer.m_omnidrive;
    public final static OmniDriveOdometry m_odometry = RobotContainer.m_odometry;
    private static double robot_x = m_omnidrive.getPose().getTranslation().getX(),
                          robot_y = m_omnidrive.getPose().getTranslation().getY();
    private static double angle = 0;
    public Rotate2Obj(double x, double y){
        super(
            new RotatetoDir(angle)
        );
        if (x - m_omnidrive.getPose().getTranslation().getX() > 0.1 || x - m_omnidrive.getPose().getTranslation().getX() < 0.1){
            if (y-m_omnidrive.getPose().getTranslation().getY()>0){
                angle = 0;
            }
            else
                angle = 180;
        }
        else if (y - m_omnidrive.getPose().getTranslation().getY() > 0.1 || y - m_omnidrive.getPose().getTranslation().getY() < 0.1){
            if (x-m_omnidrive.getPose().getTranslation().getX()>0){
                angle = -90;
            }
            else
                angle = 90;
        }
        else 
            angle = -Math.atan2(y - m_omnidrive.getPose().getTranslation().getY(), x - m_omnidrive.getPose().getTranslation().getX());
    }
}
