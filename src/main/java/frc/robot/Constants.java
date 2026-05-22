// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.CANBus;

import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;

public class Constants {

    public static class MotorConstants{
        public static final CANBus RIO = new CANBus("rio");
        public static final CANBus CANIVORE = new CANBus("Canivore");

        public static final Integer CONVEYOR_MOTOR_ID = 10;
        public static final Integer FEEDER_L_MOTOR_ID = 55;
        public static final Integer FEEDER_R_MOTOR_ID = 58;
        public static final Integer INTAKE_RIGHT_ID = 54;
        public static final Integer INTAKE_LEFT_ID = 56;
        public static final Integer INTAKE_OPENER_MOTOR_ID = 25; 
        public static final Integer INTAKE_CANCODER_MOTOR_ID = 99; 
        public static final Integer SHOOTER_LU_MOTOR_ID = 57;
        public static final Integer SHOOTER_LD_MOTOR_ID = 51;
        public static final Integer SHOOTER_RU_MOTOR_ID = 52;
        public static final Integer SHOOTER_RD_MOTOR_ID = 50;
        public static final Integer HOOD_MOTOR_ID = 53;
        public static final Integer CAN_RANGE_ID = 29;
    }

    public static class LimelightConstants{
        public static final String LIMELIGHT_1_NAME = "limelight-shooter";
        public static final String LIMELIGHT_2_NAME = "limelight-two";
    }

    public static class FeederConstants{}

    public static class ShooterConstants{
        public static final Double STATOR_CURRENT_LIMIT = 80.0;

        public static final Double CRUISE_VELOCITY = 999999999.0;
        public static final Double ACCERELATION = 200.0;
        public static final Double JERK = 0.0;

        public static final Double kS = 0.25;
        public static final Double kV = 0.12;
        public static final Double kA = 0.01;
        
        public static final Double kP = 0.0;
        public static final Double kI = 0.3;
        public static final Double kD = 0.0;
    }

    public static class IntakeConstants {
        public static final Double STATOR_CURRENT_LIMIT = 60.0;

        public static final Double CRUISE_VELOCITY = 600.0;
        public static final Double ACCERELATION = 300.0;
        public static final Double JERK = 0.0;

        public static final Double kS = 0.25;
        public static final Double kV = 0.15;
        public static final Double kA = 0.01;
        
        public static final Double kP = 9.0;
        public static final Double kI = 0.0;
        public static final Double kD = 0.1;

        public static final Double FORWARD_LIMIT = 20.5;
        public static final Double REVERSE_LIMIT = -0.02;

        public static final Double CRUISE_VELOCITY_SLOT1= 80.0;
        public static final Double ACCERELATION_SLOT1 = 60.0;
        public static final Double JERK_SLOT1 = 60.0;

        public static final Boolean FORWARD_LIMIT_ENABLED = true;
        public static final Boolean REVERSE_LIMIT_ENABLED = true;
        
        public static final Double[] SETPOINTS = {3.4, 16.5};
        public static final Integer CLOSE_INTAKE_INDEX = 0;
        public static final Integer OPEN_INTAKE_INDEX = 1;

        public static final Integer STARTING_INDEX = 0;
    }

    public static class HoodConstants{
        public static final Double STATOR_CURRENT_LIMIT = 20.0;

        public static final Double CRUISE_VELOCITY = 1000.0;
        public static final Double ACCERELATION = 1000.0;
        public static final Double JERK = 0.0;

        public static final Double kS = 0.0;
        public static final Double kV = 0.0;
        public static final Double kA = 0.0;
        
        public static final Double kP = 12.5;
        public static final Double kI = 0.0;
        public static final Double kD = 0.0;
        
        public static final Double FORWARD_LIMIT = 0.0;
        public static final Double REVERSE_LIMIT = 0.0;

        public static final boolean FORWARD_LIMIT_ENABLED = false;
        public static final boolean REVERSE_LIMIT_ENABLED = false;
    }

    public static class FieldConstants{
        public static final Integer HUB_X_INDEX = 0;
        public static final Integer HUB_Y_INDEX = 1;
        public static final Integer FEEDING_1_X_INDEX = 2;
        public static final Integer FEEDING_1_Y_INDEX = 3;
        public static final Integer FEEDING_2_X_INDEX = 4;
        public static final Integer FEEDING_2_Y_INDEX = 5;
        public static final Integer AREA_STARTING_INDEX = 6;
        public static final Integer AREA_ENDING_INDEX = 7;
        public static final Integer TRENCH_STARTING_INDEX = 8;
        public static final Integer TRENCH_ENDING_INDEX = 9;

        public static final Double RED_HUB_X = 12.0;
        public static final Double RED_HUB_Y = 4.0;
        public static final Double RED_FEEDING_AREA_1_X = 14.0;
        public static final Double RED_FEEDING_AREA_1_Y = 2.0;
        public static final Double RED_FEEDING_AREA_2_X = 14.0;
        public static final Double RED_FEEDING_AREA_2_Y = 6.0;
        public static final Double RED_AREA_STARTING_X = 11.0;
        public static final Double RED_AREA_ENDING_X = 18.0;
        public static final Double RED_TRENCH_STARTING_X = 11.0;
        public static final Double RED_TRENCH_ENDING_X = 13.0;
        
        public static final Double BLUE_HUB_X = 4.6;
        public static final Double BLUE_HUB_Y = 4.0;
        public static final Double BLUE_FEEDING_AREA_1_X = 2.0;
        public static final Double BLUE_FEEDING_AREA_1_Y = 2.0;
        public static final Double BLUE_FEEDING_AREA_2_X = 2.0;
        public static final Double BLUE_FEEDING_AREA_2_Y = 6.0;
        public static final Double BLUE_AREA_STARTING_X = -2.0;
        public static final Double BLUE_AREA_ENDING_X = 5.5;
        public static final Double BLUE_TRENCH_STARTING_X = 3.5;
        public static final Double BLUE_TRENCH_ENDING_X = 5.5;

        public static final Double[] NO_FEED_ZONE_X = {5.5, 11.0};
        public static final Double[] NO_FEED_ZONE_Y = {3.0, 5.0};

        public static Double[] RED_POSITIONS = {
            RED_HUB_X, RED_HUB_Y,
            RED_FEEDING_AREA_1_X, RED_FEEDING_AREA_1_Y,
            RED_FEEDING_AREA_2_X, RED_FEEDING_AREA_2_Y,
            RED_AREA_STARTING_X, RED_AREA_ENDING_X,
            RED_TRENCH_STARTING_X, RED_TRENCH_ENDING_X
        }; 

        public static Double[] BLUE_POSITIONS = {
            BLUE_HUB_X, BLUE_HUB_Y,
            BLUE_FEEDING_AREA_1_X, BLUE_FEEDING_AREA_1_Y,
            BLUE_FEEDING_AREA_2_X, BLUE_FEEDING_AREA_2_Y,
            BLUE_AREA_STARTING_X, BLUE_AREA_ENDING_X,
            BLUE_TRENCH_STARTING_X, BLUE_TRENCH_ENDING_X
        };
    }
}

