// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants.*;

public class MotorConfig {
    public static TalonFXConfiguration configShooter(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        //config.CurrentLimits.StatorCurrentLimit = ShooterConstants.STATOR_CURRENT_LIMIT; 

        config.MotionMagic.MotionMagicCruiseVelocity = ShooterConstants.CRUISE_VELOCITY; 
        config.MotionMagic.MotionMagicAcceleration = ShooterConstants.ACCERELATION; 
        config.MotionMagic.MotionMagicJerk = ShooterConstants.JERK;

        config.Slot0.kS = ShooterConstants.kS;
        config.Slot0.kV = ShooterConstants.kV;
        config.Slot0.kA = ShooterConstants.kA;

        config.Slot0.kP = ShooterConstants.kP;
        config.Slot0.kI = ShooterConstants.kI;
        config.Slot0.kD = ShooterConstants.kD;

        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        return config;
    }
    
    public static TalonFXConfiguration configShooterRight(){
        TalonFXConfiguration config = configShooter();
        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        return config;
    }

    public static TalonFXConfiguration configIntakeOpener(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = IntakeConstants.STATOR_CURRENT_LIMIT; 

        config.MotionMagic.MotionMagicCruiseVelocity = IntakeConstants.CRUISE_VELOCITY;
        config.MotionMagic.MotionMagicAcceleration = IntakeConstants.ACCERELATION;
        config.MotionMagic.MotionMagicJerk = IntakeConstants.JERK;

        config.Slot0.kS = IntakeConstants.kS;
        config.Slot0.kV = IntakeConstants.kV;
        config.Slot0.kA = IntakeConstants.kA;

        config.Slot0.kP = IntakeConstants.kP;
        config.Slot0.kI = IntakeConstants.kI;
        config.Slot0.kD = IntakeConstants.kD;

        config.SoftwareLimitSwitch.ForwardSoftLimitThreshold = IntakeConstants.FORWARD_LIMIT; 
        config.SoftwareLimitSwitch.ForwardSoftLimitEnable = IntakeConstants.FORWARD_LIMIT_ENABLED;
        config.SoftwareLimitSwitch.ReverseSoftLimitThreshold = IntakeConstants.REVERSE_LIMIT;
        config.SoftwareLimitSwitch.ReverseSoftLimitEnable = IntakeConstants.REVERSE_LIMIT_ENABLED;

        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        //config.Feedback.FeedbackRemoteSensorID = MotorConstants.INTAKE_CANCODER_MOTOR_ID;
        //config.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RemoteCANcoder;

        return config;
    }

    public static TalonFXConfiguration configIntake(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.OpenLoopRamps.VoltageOpenLoopRampPeriod = 0.3;
        return config;
    }

    public static TalonFXConfiguration configFeeder(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.OpenLoopRamps.VoltageOpenLoopRampPeriod = 0.1;
        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        return config;
    }

    public static TalonFXConfiguration configFeederReverse(){
        TalonFXConfiguration config = configFeeder();
        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        return config;
    }

    public static TalonFXConfiguration configRevolver(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.OpenLoopRamps.VoltageOpenLoopRampPeriod = 1.0;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        return config;
    }

    public static TalonFXConfiguration configRevolverReverse(){
        TalonFXConfiguration config = configRevolver();
        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        return config;
    }
 
    public static TalonFXConfiguration configHood(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = HoodConstants.STATOR_CURRENT_LIMIT; 

        config.MotionMagic.MotionMagicCruiseVelocity = HoodConstants.CRUISE_VELOCITY; 
        config.MotionMagic.MotionMagicAcceleration = HoodConstants.ACCERELATION; 
        config.MotionMagic.MotionMagicJerk = HoodConstants.JERK;

        config.Slot0.kS = HoodConstants.kS;
        config.Slot0.kV = HoodConstants.kV;
        config.Slot0.kA = HoodConstants.kA;

        config.Slot0.kP = HoodConstants.kP;
        config.Slot0.kI = HoodConstants.kI;
        config.Slot0.kD = HoodConstants.kD;

        config.SoftwareLimitSwitch.ForwardSoftLimitThreshold = HoodConstants.FORWARD_LIMIT; 
        config.SoftwareLimitSwitch.ForwardSoftLimitEnable = HoodConstants.FORWARD_LIMIT_ENABLED;
        config.SoftwareLimitSwitch.ReverseSoftLimitThreshold = HoodConstants.REVERSE_LIMIT;
        config.SoftwareLimitSwitch.ReverseSoftLimitEnable = HoodConstants.REVERSE_LIMIT_ENABLED;

        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        return config;
    }
}