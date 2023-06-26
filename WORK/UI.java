package WORK;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Counter_id counter;
    private Store store;
    private Lottery lottery;
    private ArrayList<Toy> toys;

    public void showStore(ArrayList<Toy> toys) {

        System.out.printf("%-5s%-15s%-10s%-22s\n", "ID", "НАЗВАНИЕ", "КОЛИЧ-ВО", "ЧАСТОТА");
        for (Toy toy : toys)
            System.out.printf("%-5d%-15s%-10d%-22f\n", toy.getId(), toy.getName(), toy.getQuantity(),
                    toy.getFrequency());

    }

    public void userMenu(Store store, Counter_id counter, ArrayList<Toy> toys) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n         ВЫБЕРИТЕ ПУНКТ ИЗ МЕНЮ:\n" +
                    "1 - ПОКАЗАТЬ СПИСОК ВСЕХ ИГРУШЕК В ЛОТЕРЕЕ\n" +
                    "2 - НАЧАТЬ ЛОТЕРЕЮ\n" +
                    "3 - ИЗМЕНИТЬ ЧАСТОТУ ВЫПАДЕНИЯ ИГРУШКИ ПО ЕЕ ID\n" +
                    "4 - ДОБАВИТЬ ИГРУШКУ В СПИСОК\n" +
                    "5 - УДАЛИТЬ ИГРУШКУ ИЗ СПИСКА\n" +
                    "6 - ИЗМЕНИТЬ ДАННЫЕ ИГРУШКИ\n" +
                    "7 - ВЫХОД ИЗ ПРОГРАММЫ");

            Scanner in = new Scanner(System.in);

            String user_input = in.next();
            if (user_input.contains("1")) {
                System.out.println("\nИГРУШКИ В ЛОТЕРЕЕ:");
                showStore(store.getToys());
            } else if (user_input.contains("2")) {
                Lottery lottery = new Lottery(store.getToys());
                lottery.choiceOfPrizesRandom(store.getToys());
                Toy prizeToy = lottery.getPrizeToy();
                if (prizeToy != null) {
                    System.out.println("\nВЫИГРАННАЯ ИГРУШКА: " + prizeToy.getName() + '\n');
                }
            } else if (user_input.contains("3")) {
                System.out.println("ВВЕДИТЕ ID: ");
                int id = Integer.parseInt(in.next());
                System.out.println("ВВЕДИТЕ НОВУЮ ЧАСТОТУ: ");
                double newFrequency = Double.parseDouble(in.next());
                if (newFrequency > 0 && newFrequency < 100) {
                    if (!store.changeToyFrequency(id, newFrequency)) {
                        System.out.println("ТАКОГО ID НЕ СУЩЕСТВУЕТ");
                    } else {
                        System.out.println("ЧАСТОТА УСПЕШНО ИЗМЕНЕНА\n");
                    }
                } else {
                    System.out.println("НОВАЯ ЧАСТОТА ДОЛЖНА БЫТЬ В ДИАПАЗОНЕ ОТ 0 ДО 100\n");
                }

            } else if (user_input.contains("4")) {

                System.out.println("ВВЕДИТЕ НАЗВАНИЕ ДЛЯ НОВОЙ ИГРУШКИ: ");
                String name = in.next();
                System.out.println("ВВЕДИТЕ КОЛИЧЕСТВО НОВОЙ  ИГРУШКИ: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag1 = true;
                System.out.println("ВВЕДИТЕ ЧАСТОТУ ВЫПАДЕНИЯ НОВОЙ ИГРУШКИ: ");
                double frequency = Double.parseDouble(in.next());
                while (flag1) {
                    if (frequency > 0 && frequency < 100) {
                        flag1 = false;
                    } else {
                        System.out.println("ЧАСТОТА ВЫПАДЕНИЯ ИГРУШКИ ДОЛЖНА БЫТЬ В ДИАПАЗОНЕ ОТ 0 ДО 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                store.addToy(new Toy(counter.getId(), name, quantity, frequency));
                System.out.println("НОВАЯ ИГРУШКА УСПЕШНО ДОБАВЛЕНА В СПИСОК! ");

            } else if (user_input.contains("5")) {
                System.out.println("ВВЕДИТЕ НАЗВАНИЕ УДАЛЯЕМОЙ ИГРУШКИ: ");
                String name = in.next();
                store.deleteToyFromStore(toys, name);
            } else if (user_input.contains("6")) {
                System.out.println("ВВЕДИТЕ НАЗВАНИЕ ИГРУШКИ ДЛЯ ИЗМЕНЕНИЯ ЕЕ ДАННЫХ: ");
                String name = in.next();
                System.out.println("ВВЕДИТЕ КОЛИЧЕСТВО ИГРУШЕК: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag2 = true;
                System.out.println("ВВЕДИТЕ ЧАСТОТУ ВЫПАДЕНИЯ ИГРУШКИ: ");
                double frequency = Double.parseDouble(in.next());
                while (flag2) {
                    if (frequency > 0 && frequency < 100) {
                        flag2 = false;
                    } else {
                        System.out.println("ВВЕДИТЕ ЧАСТОТУ ВЫПАДЕНИЯ ИГРУШКИ В ДИАПАЗОНЕ ОТ 0 ДО 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                if (store.changeToy(name, quantity, frequency)) {
                    System.out.println("ДАННЫЕ ИГРУШКИ  " + name + " УСПЕШНО ИЗМЕНЕНЫ!");
                } else {
                    System.out.println(name + " ТАКОЙ НЕТ В ЛОТЕРЕЕ!");
                }

            }

            else {
                flag = false;

            }
        }

    }

}