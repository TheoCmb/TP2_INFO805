package fr.usmb.m1isc.compilation.tp;

public class Arbre {
    private String operator;
    private Integer value;
    private Arbre ag, ad;

    public Arbre() {}

    public Arbre(String operator, Arbre ag, Arbre ad){
        this.operator = operator;
        this.ag = ag;
        this.ad = ad;
        // System.out.println(operator + "\n" + ag.getValue() + " " + ad.getValue());
    }

    public Arbre(Integer value, Arbre ag, Arbre ad){
        this.value = value;
        this.ag = ag;
        this.ad = ad;
        // System.out.println(value + "\n" + ag.getValue() + " " + ad.getValue());
    }

    public Arbre(Integer value){
        this.value = value;
    }

    public Arbre(String operator){
        this.operator = operator;
    }

    public Integer getValue(){
        return value;
    }

    public String getOperator(){
        return operator;
    }

    @Override
    public String toString() {
        String str = "";
        if (!(value==null && operator==null)){
            str += '(';
            if (operator!=null){
                str += " " + operator + " ";
            }
            else{
                str += " " + value + " ";
            }
            if (ag!=null){
                str += " ";
                str += ag.toString();
            }
            if(ad != null){
                str += " ";
                str += ad.toString();
            }
            str += ')';
            return str;
        }
        else{
            return "";
        }
    }
}
