package frc.robot.commands.auto;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.OmniDrive;

public class Rotate2Obj extends SequentialCommandGroup{
    public final static OmniDrive m_omnidrive = new OmniDrive();
    private static double robot_x = m_omnidrive.getPose().getTranslation().getX(),
                          robot_y = m_omnidrive.getPose().getTranslation().getY();
    private static double angle = 0;
    public Rotate2Obj(double x, double y){
        super(
            new RotatetoDir(angle)
        );
        if (x - robot_x==0){
            if (y-robot_y>0){
                angle = 0;
            }
            else
                angle = 180;
        }
        else if (y - robot_y==0){
            if (x-robot_x>0){
                angle = -90;
            }
            else
                angle = 90;
        }
        else 
            angle = -Math.atan2(y - robot_y, x - robot_x);
    }
}
