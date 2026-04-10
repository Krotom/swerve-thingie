package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.IntakeConstants.IntakeState;;



public class IntakeSubsystem extends SubsystemBase{
    private TalonFX deployMotor;
    private TalonFX intakeMotor;

    private IntakeState intakeState = IntakeState.IDLE;
    
    public IntakeSubsystem() {
        deployMotor = new TalonFX(IntakeConstants.kDeployMotorID);
        intakeMotor = new TalonFX(IntakeConstants.kIntakeMotorID);
    }

    @Override
    public void periodic() {
        intake();
    }

    public void deployIntake() {
        // TODO intake deployment is stub, implement later
    }

    public void intake() {
        if (intakeState == IntakeState.INTAKE) {
            intakeMotor.set(1);
        } else if (intakeState == IntakeState.OUTTURN) {
            intakeMotor.set(-1);
        } else {
            stop();
        }
    }

    public void setOutturn() {
        intakeState = IntakeState.OUTTURN;
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}
