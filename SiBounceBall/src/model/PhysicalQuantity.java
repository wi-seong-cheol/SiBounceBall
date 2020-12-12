package model;

import java.util.ArrayList;

import viewModel.gamecomponents.*;
import viewModel.moveengine.Accel;

public class PhysicalQuantity {
	public static SpawnBall ball;
	public static Spawn object;
	public static ArrayList<Accel> constForces;
	public static int ballIndex = 0;
	public static int collideObjIdx;
	public static double collidePos;
	public static final int X = 800;
	public static final int Y = 600;
	public static final double GRAVITY = 1500;
	public static final double DRAG = 0;
	public static final double BOUNCE = 1.0013;
	public static long timePassed = 0;
	public static long curTime = 0;
	public static long lastTime = 0;
	public static double timeFraction = 0.0;
}
