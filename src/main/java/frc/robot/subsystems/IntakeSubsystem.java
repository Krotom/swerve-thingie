package frc.robot.subsystems;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;



public class IntakeSubsystem extends SubsystemBase{
    private TalonFX deployMotor = new TalonFX(kDeployMotorID);
    private TalonFX intakeLeader = new TalonFX(kIntakeLeaderID);
    private TalonFX intakeFollower = new TalonFX(kIntakeFollowerID);

    private final MotionMagicVoltage openerMagic = new MotionMagicVoltage(0).withEnableFOC(true);
    private final VoltageOut rollerVoltageOut = new VoltageOut(0).withEnableFOC(true);

    private Integer intakeIndex = 0;
    
    public IntakeSubsystem() {}

    @Override
    public void periodic() {
        setIntakePosition();
        handleRoller();
    }

    // Methods
    public void setIntakePosition() {
        deployMotor.setControl(openerMagic.withPosition(intakePositions[intakeIndex]));
    }

    public void setIntakeIndex(Integer index) {
        intakeIndex = index;
    }

    public void handleRoller(){
        if(deployMotor.getPosition().getValueAsDouble()>3.0){
            setRollerVoltage(11.0);
        }else{
            setRollerVoltage(0.0);
        }
    }

    public void setRollerVoltage(Double voltage) {
        intakeLeader.setControl(rollerVoltageOut.withOutput(voltage));
    }
}
