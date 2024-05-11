import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyMachine {
    private List<Toy> toys;

    public ToyMachine() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                normalizeWeights();
                break;
            }
        }
    }

    public Toy drawToy() {
        if (toys.isEmpty()) {
            return null;
        }

        double randomWeight = new Random().nextDouble() * getTotalWeight();
        double cumulativeWeight = 0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomWeight <= cumulativeWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    saveWinningToy(toy);
                    return toy;
                }

            }
        }


        return null;
    }

    private double getTotalWeight() {
        double total = 0;
        for (Toy toy : toys) {
            total += toy.getWeight();
        }
        return total;
    }

    private void normalizeWeights() {
        double totalWeight = getTotalWeight();
        for (Toy toy : toys) {
            toy.setWeight(toy.getWeight() / totalWeight * 100);
        }
    }

    private void saveWinningToy(Toy toy) {
        try (FileWriter writer = new FileWriter("winning_toys.txt", true)) {
            writer.write(String.format("ID: %d, Name: %s\n", toy.getId(), toy.getName()));
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}