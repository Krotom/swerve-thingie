// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Optional;

import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class Constants {
    public class IntakeConstants {
        public static final int kDeployMotorID = 0;
        public static final int kIntakeMotorID = 0;
        public static enum IntakeState {
            IDLE,
            INTAKE,
            OUTTURN
        }
    }

    public class VisionConstants {
        public static final InterpolatingDoubleTreeMap DIST_TIME_MAP = new InterpolatingDoubleTreeMap();

        static {
            // (Mesafe metre, Süre saniye)
            DIST_TIME_MAP.put(0.0, 0.00); // Başlangıç noktası
            DIST_TIME_MAP.put(1.0, 0.07); // Yakın mesafe, çok hızlı
            DIST_TIME_MAP.put(2.0, 0.15); // Ortalama hız düşmeye başlıyor
            DIST_TIME_MAP.put(3.0, 0.24); 
            DIST_TIME_MAP.put(4.0, 0.34); 
            DIST_TIME_MAP.put(5.0, 0.45); 
            DIST_TIME_MAP.put(6.0, 0.57); // Uzak mesafe, hava direnci etkisini gösteriyor
            DIST_TIME_MAP.put(8.0, 0.85); // Ekstrem menzil
        } // FIXME stub values, replace with actual values after testing
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
        public static final Integer RAMP_STARTING_INDEX = 8;
        public static final Integer RAMP_ENDING_INDEX = 9;

        public static final Double RED_HUB_X = 12.0;
        public static final Double RED_HUB_Y = 4.0;
        public static final Double RED_FEEDING_AREA_1_X = 14.0;
        public static final Double RED_FEEDING_AREA_1_Y = 1.0;
        public static final Double RED_FEEDING_AREA_2_X = 14.0;
        public static final Double RED_FEEDING_AREA_2_Y = 7.0;
        public static final Double RED_AREA_STARTING_X = 11.0;
        public static final Double RED_AREA_ENDING_X = 16.0;
        public static final Double RED_RAMP_STARTING_X = 11.0;
        public static final Double RED_RAMP_ENDING_X = 13.0;
        
        public static final Double BLUE_HUB_X = 4.6;
        public static final Double BLUE_HUB_Y = 4.0;
        public static final Double BLUE_FEEDING_AREA_1_X = 2.0;
        public static final Double BLUE_FEEDING_AREA_1_Y = 1.0;
        public static final Double BLUE_FEEDING_AREA_2_X = 2.0;
        public static final Double BLUE_FEEDING_AREA_2_Y = 7.0;
        public static final Double BLUE_AREA_STARTING_X = 0.0;
        public static final Double BLUE_AREA_ENDING_X = 5.5;
        public static final Double BLUE_RAMP_STARTING_X = 3.5;
        public static final Double BLUE_RAMP_ENDING_X = 5.5;

        public static Double[] RED_POSITIONS = {
            RED_HUB_X, RED_HUB_Y,
            RED_FEEDING_AREA_1_X, RED_FEEDING_AREA_1_Y,
            RED_FEEDING_AREA_2_X, RED_FEEDING_AREA_2_Y,
            RED_AREA_STARTING_X, RED_AREA_ENDING_X,
            RED_RAMP_STARTING_X, RED_RAMP_ENDING_X
        }; 

        public static Double[] BLUE_POSITIONS = {
            BLUE_HUB_X, BLUE_HUB_Y,
            BLUE_FEEDING_AREA_1_X, BLUE_FEEDING_AREA_1_Y,
            BLUE_FEEDING_AREA_2_X, BLUE_FEEDING_AREA_2_Y,
            BLUE_AREA_STARTING_X, BLUE_AREA_ENDING_X,
            BLUE_RAMP_STARTING_X, BLUE_RAMP_ENDING_X
        };
        
        public static Double[] getAlliancePositions() {
            Optional<Alliance> alliance = DriverStation.getAlliance();
            if (alliance.isPresent()) {
                if (alliance.get() == Alliance.Red) {
                    return RED_POSITIONS;
                }
            }

            return BLUE_POSITIONS;
        }
    }
}
