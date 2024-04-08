package fr.usmb.m1isc.compilation.tp;

public class Arbre {
    private String operator;
    private Integer value;
    private Arbre tg, td;

    public Arbre() {}

    public Arbre(String operator, Arbre tg, Arbre td){
        this.operator = operator;
        this.tg = tg;
        this.td = td;
        System.out.println(operator + "\n" + tg.getValue() + " " + td.getValue());
    }

    public Arbre(Integer value, Arbre tg, Arbre td){
        this.value = value;
        this.tg = tg;
        this.td = td;
        System.out.println(value + "\n" + tg.getValue() + " " + td.getValue());
    }

    public Arbre(Integer value){
        this.value = value;
    }

    public Arbre(String operator){
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public Arbre getTg() {
        return tg;
    }

    public Arbre getTd() {
        return td;
    }

    public Integer getValue() {
        return value;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setTg(Arbre tg) {
        this.tg = tg;
    }

    public void setTd(Arbre td) {
        this.td = td;
    }

    @Override
    public String toString() {
        return "monarbre";
    }
}
