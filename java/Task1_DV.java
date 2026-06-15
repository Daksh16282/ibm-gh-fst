package fst;

class Human {
    static int population = 0;
    static int populationAll = 0;

    Human() {
        population++;
        populationAll++;
    }

    public void walking() {
        System.out.println("Human is walking");
    }

    public void talking() {
        System.out.println("Human is talking");
    }

}

class Boy {
    static int population = 0;

    Boy() {
        population++;
    }

    public void walking() {
        System.out.println("Boy is walking");
    }

    public void talking() {
        System.out.println("Boy is talking");
    }

}

class Girl {
    static int population = 0;

    Girl() {
        population++;
    }

    public void walking() {
        System.out.println("Girl is walking");
    }

    public void talking() {
        System.out.println("Girl is talking");
    }

}

class Robot {
    static int population = 0;

    Robot() {
        population++;
    }

    public void walking() {
        System.out.println("Robot is walking");
    }

    public void talking() {
        System.out.println("Robot is talking");
    }

}

// ------------------ Implementation Style 2 ---------------------------

class Boy1 extends Human {

    public void walking() {
        System.out.println("Boy1 is walking");
    }

    public void talking() {
        System.out.println("Boy1 is talking");
    }

}

class Girl1 extends Human {

    public void walking() {
        System.out.println("Girl1 is walking");
    }

    public void talking() {
        System.out.println("Girl1 is talking");
    }

}

public class Task1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Boy b1 = new Boy();
        Boy b2 = new Boy();
        Boy b3 = new Boy();

        Girl g1 = new Girl();
        Girl g2 = new Girl();
        Girl g3 = new Girl();

        Robot r1 = new Robot();
        Robot r2 = new Robot();
        Robot r3 = new Robot();

        System.out.println(
                "Number of Humans are :- " + Human.population + " and no of Robots are :- " +
                        Robot.population);

        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
        System.out.println();
        Boy1 b11 = new Boy1();
        Boy1 b12 = new Boy1();
        Boy1 b13 = new Boy1();

        Girl1 g11 = new Girl1();
        Girl1 g12 = new Girl1();
        Girl1 g13 = new Girl1();
        System.out.println(
                "Number of Humans including Boys & Girls are :- " + Human.populationAll + " and no of Robots are :- "
                        + Robot.population);

    }
}
