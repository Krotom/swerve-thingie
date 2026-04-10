package frc.robot.subsystems;

import com.ctre.phoenix6.controls.StaticBrake;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;



public class IntakeSubsystem extends SubsystemBase{
    private TalonFX deployMotor = new TalonFX(kDeployMotorID);
    private TalonFX intakeMotor = new TalonFX(kIntakeMotorID);

    private IntakeState intakeState = IntakeState.IDLE;
    private DeployState deployState = DeployState.RESTRACTED;

    private final StaticBrake brake = new StaticBrake();
    
    // constructor
    public IntakeSubsystem() {
        
    }

    @Override
    public void periodic() {
        intake();
    }


    // methods
    public void pushIntake() {
        deployMotor.set(kDeployMotorSpeed);
        deployState = DeployState.PUSHING;
    }

    public void retractIntake() {
        deployMotor.set(-kDeployMotorSpeed);
        deployState = DeployState.RESTRACTING;
    }

    public void intake() {
        if (intakeState == IntakeState.INTAKE) {
            intakeMotor.set(1);
        } else if (intakeState == IntakeState.OUTTURN) {
            intakeMotor.set(-1);
        } else {
            stopIntaking();
        }
    }

    public void setOutturn() {
        intakeState = IntakeState.OUTTURN;
    }

    public void stopIntaking() {
        intakeMotor.setControl(brake);
    }

    public void stopHopper() {
        deployMotor.setControl(brake);
    }
}
