public class StepTracker {
    int goalSteps = 10000;
    MonthData[] monthToData;
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    public void setGoalSteps(int goalSteps) {
        if (goalSteps <= 0)
            System.out.println("Количество шагов должно быть больше 0!");
        else {
            this.goalSteps = goalSteps;
            System.out.println("Новая цель по количеству шагов успешно установлена.");
        }
    }

    public void setSteps(int month, int day, int steps) {
        if (month >= 0 && month < 12)
            if (day > 0 && day <= 30)
                if (steps >= 0)
                    monthToData[month].days[day-1] = steps;
                else
                    System.out.println("Количество шагов должно быть не отрицательным!");
            else
                System.out.println("Номер дня должен быть в диапазоне от 1 до 30!");
        else
            System.out.println("Номер месяца должен быть в диапазоне от 0 до 11!");
    }

    public void printStepsPerDay(int month) {
        System.out.println("Статистика по месяцу: " + month);
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (i != monthToData[month].days.length - 1)
                System.out.print(i + 1 + " день: " + monthToData[month].days[i] + ", ");
            else
                System.out.println(i + 1 + " день: " + monthToData[month].days[i]);
        }
    }

    public void printTotalSteps(int month) {
        System.out.println("Общее количество шагов за месяц: " + countTotalSteps(month));
    }

    public void printMaxSteps(int month) {
        System.out.println("Максимальное пройденное количество шагов в месяце: " + countMaxSteps(month));
    }

    public void printMeanSteps(int month) {
        System.out.println("Среднее количество шагов: " + countTotalSteps(month) / monthToData[month].days.length);
    }

    public void printDistance(int month) {
        System.out.println("Пройденная дистанция (в км): " + converter.stepsToDistance(countTotalSteps(month)));
    }

    public void printCalories(int month) {
        System.out.println("Количество сожжённых килокалорий: " + converter.stepsToCalories(countTotalSteps(month)));
    }

    public void printBestSeries(int month) {
        System.out.println("Лучшая серия: " + countBestSeries(month) + " дней");
    }

    private int countTotalSteps(int month) {
        int totalSteps = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            totalSteps += monthToData[month].days[i];
        }
        return totalSteps;
    }

    private int countMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] > maxSteps)
                maxSteps = monthToData[month].days[i];
        }
        return maxSteps;
    }

    private int countBestSeries(int month) {
        int maxDays = 0;
        int countDays = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] >= goalSteps)
                countDays++;
            else {
                if (countDays > maxDays)
                    maxDays = countDays;
                countDays = 0;
            }
        }
        return maxDays;
    }
}


