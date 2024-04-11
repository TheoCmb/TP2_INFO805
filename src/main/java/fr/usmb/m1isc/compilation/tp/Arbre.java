package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;
import java.util.List;

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


    List<String> tablet = new ArrayList<>();
    public List<String> getLetVar(List<String> tablet){
        if (operator=="let"){
            // System.out.println("let detecté");
            // System.out.println("Ajout de " + ag.getOperator() + " dans tablet !!!");
            tablet.add(ag.getOperator());
        }
        if (ag!=null){
            if (ag.getOperator() != null || ag.getValue()!= null){
                ag.getLetVar(tablet);
            }
        }
        if (ad!=null){
            if (ad.getOperator() != null || ad.getValue()!= null){
                ad.getLetVar(tablet);
            }
        }
        return tablet;
    }

    public String getAssembleurPart(){
        String res = "";
        switch (operator) {
            case "+":
                res += ag.getAssembleurPart();
                res += ad.getAssembleurPart();
                res += "\npop ebx";
                res += "\npop eax";
                res += "\nadd eax, ebx";
                res += "\npush eax";
                break;
        
            default:
                res += "\nmov eax, " + ag.getValue();
                break;
        }
        return res;
    }

    public String exercice1(){
        String str = "";
        str += "DATA SEGMENT\n";
        List<String> varlet = getLetVar(tablet);
        for (int i = 0; i<varlet.size(); i++){
            str += "\t";
            str += varlet.get(i);
            str += " DD\n";
        }
        // System.out.println("size : " + varlet.size());
        str += "DATA ENDS\nCODE SEGMENT\n";
        str += getAssembleurPart();
        return str;
    }

    /**
     * Fonction qui va demarrer toutes celles qui servent à tester les fonction utiles à la réalisation du TP
     */
    public void start(){
        System.out.println("\nGeneration de l'arbre :\n");
        System.out.println(this.toString()); 
        System.out.println("\nGeneration du code assembleur :\n");
        System.out.println(this.exercice1());
    }
}
