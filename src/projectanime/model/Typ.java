package projectanime.model;

public enum Typ {
    SERIES, MOVIE, OVA;

    public String toNormalCase() {
        if(name().equals("SERIES")){
            return "Series";
        } else
        if (name().equals("MOVIE")) {
            return "Movie";
        }
        return name();
    }
}
