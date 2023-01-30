package frc.robot.commands.auto;

import java.util.Map;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Globals;
import frc.robot.subsystems.OmniDrive;

public class RotatetoDir extends SequentialCommandGroup {
    public final static OmniDrive m_omnidrive = new OmniDrive();
    private static double dir = 0;
    private enum CommandSelector {
        POS, NEG
    }

    public static CommandSelector selectCmd12() {
        if (m_omnidrive.getPose().getRotation().getDegrees() > dir)
            return CommandSelector.POS;
        else if (m_omnidrive.getPose().getRotation().getDegrees() < dir){
            return CommandSelector.NEG;
        }
        else 
            return null;
        
    }
    public RotatetoDir(double angle){
        
        super(
            new SelectCommand(
                Map.ofEntries( 
                Map.entry(CommandSelector.POS, new MoveRobotSense(2,2*Math.PI,0,0,0.3,()->m_omnidrive.getPose().getRotation().getDegrees()>angle)), 
                Map.entry(CommandSelector.NEG, new MoveRobotSense(2,-2*Math.PI,0,0,0.3,()->m_omnidrive.getPose().getRotation().getDegrees()<angle))),
                 
            RotatetoDir::selectCmd12
           
        )
        );
        dir = angle;
    }
}
