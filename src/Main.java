import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение Счетчик калорий!");
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int cmd = scanner.nextInt();

            if (cmd == 1) {
                //Ввести количество шагов за определённый день
                System.out.println("Введите номер месяца (от 0 до 11):");
                int month = scanner.nextInt();
                System.out.println("Введите номер дня (от 1 до 30):");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов, пройденных в этот день:");
                int steps = scanner.nextInt();
                stepTracker.setSteps(month, day, steps);
            } else if (cmd == 2) {
                //Напечатать статистику за определённый месяц
                System.out.println("Введите номер месяца (от 0 до 11):");
                int month = scanner.nextInt();
                if (month >= 0 && month < 12) {
                    stepTracker.printStepsPerDay(month);
                    stepTracker.printTotalSteps(month);
                    stepTracker.printMaxSteps(month);
                    stepTracker.printMeanSteps(month);
                    stepTracker.printDistance(month);
                    stepTracker.printCalories(month);
                    stepTracker.printBestSeries(month);
                }
                else
                    System.out.println("Номер месяца должен быть в диапазоне от 0 до 11!");
            } else if (cmd == 3) {
                //Изменить цель по количеству шагов в день
                System.out.println("Укажите новую цель по количеству шагов в день:");
                stepTracker.setGoalSteps(scanner.nextInt());
            } else if (cmd == 4) {
                //Выйти из приложения
                System.out.println("Выход из программы..");
                return;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите одно из следующих действий: ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}
