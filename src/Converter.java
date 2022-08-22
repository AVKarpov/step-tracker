public class Converter {
    private final double STEP_LENGTH = 0.00075;
    private final double STEP_CAL = 0.05;


    public double stepsToDistance(int totalSteps){
        return totalSteps * STEP_LENGTH;
    }

    public double stepsToCalories(int totalSteps)
    {
       return totalSteps * STEP_CAL;
    }
}
