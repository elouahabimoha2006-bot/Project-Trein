public class Locomotief {

    private String type;
    private int maxWagons;

    public Locomotief(String type) {
        this.type = type;
        this.maxWagons = type.equals("Class 374") ? 14 : 12;
    }

    public int getMaxWagons() {
        return maxWagons;
    }

    @Override
    public String toString() {
        return type + " (max wagons: " + maxWagons + ")";
    }
}