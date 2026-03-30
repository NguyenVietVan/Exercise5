package entity;

public class Worker extends Staff {
    private int rank;
    public Worker(String name, int age, Gender gender, String address) {
        super(name, age, gender, address);
    }

    public Worker(String name, int age, Gender gender, String address, int
            rank) {
        super(name, age, gender, address);
        this.rank = rank;
    }
    @Override
    public String toString() {
        return super.toString() + "Position: Worker [rank=" + rank + "]";
    }
}
