package com.bnppf.df.cardgame.springtype.model;

import javax.persistence.*;

@Entity
@Table(name="curse")
public class Curse extends Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curse_seq")
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="explanation")
    private String explanation;

    public Curse(){
    }

    public Curse(Integer id, CardType cardType, Integer cost, String name, String explanation){
        super(cardType,cost);
        this.id = id;
        this.name = name;
        this.explanation = explanation;
    }

    public Curse(CardType cardType, Integer cost, String name, String explanation){
        super(cardType,cost);
        this.name = name;
        this.explanation = explanation;
    }

    public String getName(){
        return name;
    }

    public String getExplanation(){
        return explanation;
    }

    @Override
    public void displayCostArgs() {
        super.displayCostArgs();

        System.out.println("Nom de sortilège : " + name + "\n" + "Explications : " + explanation + "\n");

    }

}
