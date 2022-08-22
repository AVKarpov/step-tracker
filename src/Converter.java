public class Converter {
    private static final double STEP_LENGTH = 0.00075;
    private static final double STEP_CAL = 0.05;


    public double stepsToDistance(int totalSteps){
        return totalSteps * STEP_LENGTH;
    }

    public double stepsToCalories(int totalSteps)
    {
       return totalSteps * STEP_CAL;
    }
}
