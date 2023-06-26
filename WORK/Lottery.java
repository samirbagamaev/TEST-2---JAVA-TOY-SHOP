//ЛОТЕРЕЯ

package WORK;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Lottery {
    private ArrayList<Toy> prizes;              // список призов
    private ArrayList<Toy> toys;
    private String prizeFilePath;

    UI ui = new UI();

    public Lottery(ArrayList<Toy> toys) {
        this.prizes = new ArrayList<Toy>();
        this.toys = toys;
        prizeFilePath = FileClear.filename;


    }

    public ArrayList<Toy> getPrizes() {
        return prizes;
    }

    public String getPrizeFilePath() {
        return prizeFilePath;
    }


    public void choiceOfPrizesRandom(ArrayList<Toy> toys) {
        prizes.clear();

        for (Toy toy : toys) {
            double random = Math.random() * 100;

            if (random < toy.getFrequency()) {
                prizes.add(toy);

            }
        }
        System.out.println("\nПРИЗЫ:");
        ui.showStore(prizes);
    }

    public Toy getPrizeToy() {
        if (!prizes.isEmpty()) {

            Toy prizeToy = prizes.remove(0);

            prizeToy.setQuantity(prizeToy.getQuantity() - 1);


            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("ОШИБКА!!!");
            }

            return prizeToy;
        } else {
            System.out.println("ИГРУШКИ ЗАКОНЧИЛИСЬ");
            return null;
        }
    }

}
