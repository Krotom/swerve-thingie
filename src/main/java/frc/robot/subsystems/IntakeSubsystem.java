package frc.robot.subsystems;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;



public class IntakeSubsystem extends SubsystemBase{
    private TalonFX deployMotor = new TalonFX(kDeployMotorID);
    private TalonFX intakeMotor = new TalonFX(kIntakeMotorID);

    private final MotionMagicVoltage openerMagic = new MotionMagicVoltage(0).withEnableFOC(true);
    private final VoltageOut rollerVoltageOut = new VoltageOut(0).withEnableFOC(true);

    private Integer intakeIndex = 0;
    
    // constructor
    public IntakeSubsystem() {
        
    }

    @Override
    public void periodic() {
        setIntakePosition();
        handleRoller();
    }

    // methods
    public void setIntakePosition() {
        deployMotor.setControl(openerMagic.withPosition(intakePositions[intakeIndex]));
    }

    public void setIntakeIndex(Integer index) {
        intakeIndex = index;
    }

    public void handleRoller(){
        if(deployMotor.getPosition().getValueAsDouble()>3.0){
            setRollerVoltage(11.0);
        }
    }

    public void setRollerVoltage(Double voltage) {
        intakeMotor.setControl(rollerVoltageOut.withOutput(voltage));
    }
}
