package fr.usmb.m1isc.compilation.tp;

public class Tuple {

    private Integer value;
    private Arbre sa;

    public Tuple(Integer value, Arbre sa) {
        this.value = value;
        this.sa = sa;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Arbre getSa() {
        return sa;
    }

    public void setSa(Arbre sa) {
        this.sa = sa;
    }
}
