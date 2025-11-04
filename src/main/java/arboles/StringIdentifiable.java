package arboles;

public class StringIdentifiable implements Identifiable {

    private String model;

    public StringIdentifiable(String s) {
        model = s;
    }

    @Override
    public String getId() {
        return model.substring(0,1);
    }

    @Override
    public String toString() {
        return model;
    }
}
