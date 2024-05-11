public class ToyRaffle {
    public static void main(String[] args) {
        ToyMachine machine = new ToyMachine();


        machine.addToy(new Toy(1, "Мяч", 10, 30));
        machine.addToy(new Toy(2, "Кукла", 5, 30));
        machine.addToy(new Toy(3, "Машинка", 15, 40));
        machine.addToy(new Toy(3, "Железная дорога", 15, 20));
        machine.addToy(new Toy(3, "Набор машинок", 15, 35));
        machine.addToy(new Toy(3, "Воздушный шар", 15, 45));
        machine.addToy(new Toy(3, "Кубикрубика", 15, 40));


        machine.updateToyWeight(2, 40);


        Toy winningToy = machine.drawToy();
        if (winningToy != null) {
            System.out.println("Выиграна игрушка: " + winningToy.getName());
        } else {
            System.out.println("Все игрушки были разыграны.");
        }
    }
}