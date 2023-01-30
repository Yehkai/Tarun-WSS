package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.OmniDrive;

public class Rotate extends CommandBase{
    //Grab the subsystem instance from RobotContainer
    private final static OmniDrive m_omnidrive = RobotContainer.m_omnidrive;
    private double dT = 0.02;
    private boolean m_endFlag = false;
    private TrapezoidProfile.Constraints m_constraints;
    private TrapezoidProfile.State m_goal = new TrapezoidProfile.State();
    private TrapezoidProfile.State m_setpoint = new TrapezoidProfile.State();
    private TrapezoidProfile m_profile;
    private double start_pos;
    private final double tgt_pos;
    private int m_dir;

    protected final double m_startSpeed, m_endSpeed;
    protected double m_dist;

    //private final double _startSpeed;

    /**
     * This command moves the robot a certain distance following a trapezoidal speed profile.
     * <p>
     * 
     * @param position - position of the
     * @param maxSpeed - distance to move
     * 
     */
    //This move the robot a certain distance following a trapezoidal speed profile.
    public Rotate(double angle, double maxSpeed)
    {
        
        
        tgt_pos = angle;
        m_startSpeed = 0;
        m_endSpeed = 0;
        m_constraints = new TrapezoidProfile.Constraints(maxSpeed, maxSpeed);
        
     
    }

    
    
    /**
     * Runs before execute
     */
    @Override
    public void initialize()
    {   
        start_pos = m_omnidrive.getPose().getRotation().getDegrees();

        m_goal = new TrapezoidProfile.State(tgt_pos, m_endSpeed);
        m_setpoint = new TrapezoidProfile.State(start_pos, m_endSpeed);
        m_dir = (tgt_pos>0)?1:-1;
        m_endFlag = false;
        
    }
    /**
     * Condition to end speed profile
     */
    public boolean endCondition()
    {
        return false;
    }
    /**
     * Called continously until command is ended
     */
    @Override
    public void execute()
    {
        //time += dT;
        //Create a new profile to calculate the next setpoint(speed) for the profile
        var m_profile = new TrapezoidProfile(m_constraints, m_goal, m_setpoint);
        m_setpoint = m_profile.calculate(dT);
        m_omnidrive.setRobotSpeedType(2, m_setpoint.velocity*m_dir);

        if ((m_setpoint.position>=m_goal.position) || endCondition()) {
            //distance reached or end condition met. End the command
            //This class should be modified so that the profile can end on other conditions like
            //sensor value etc.
            m_omnidrive.setRobotSpeedType(2, m_goal.velocity*m_dir);
            m_endFlag = true;
        }
        
    }

    

    /**
     * Called when the command is told to end or is interrupted
     */
    @Override
    public void end(boolean interrupted)
    {

    }

    /**
     * Creates an isFinished condition if needed
     */
    @Override
    public boolean isFinished()
    {
        return m_endFlag;
    }

}