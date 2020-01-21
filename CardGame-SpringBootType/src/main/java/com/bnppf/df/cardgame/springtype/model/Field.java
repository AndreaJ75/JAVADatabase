package com.bnppf.df.cardgame.springtype.model;

import javax.persistence.*;

@Entity
@Table(name="field")

public class Field extends Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_seq")
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "fieldcolor")
    private FieldColor color;
    @Column(name="field_mananbrpoints")
    private Integer manaPointsNbr;


    public Field() {
    }

    public Field(Integer id, CardType cardType, Integer cost,FieldColor color, Integer manaPointsNbr) {
        super(cardType, 0);
        this.id = id;
        this.color = color;
        this.manaPointsNbr = manaPointsNbr;
//        this.card = card;
    }

    public Field(CardType cardType, Integer cost, FieldColor color, Integer manaPointsNbr) {
        super(cardType, 0);
        this.color = color;
        this.manaPointsNbr = manaPointsNbr;
//        this.card = card;
    }


    public FieldColor getColor() {
        return color;
    }

    public Integer getManaPointsNbr() {
        return manaPointsNbr;
    }

    public Integer getId() { return id;}


    public void setColor(FieldColor color) {
        this.color = color;
    }

    public void setManaPointsNbr(Integer manaPointsNbr) {
        this.manaPointsNbr = manaPointsNbr;
    }

    public void setId(Integer id) { this.id = id; }


    @Override
    public void displayCostArgs() {
        super.displayCostArgs();

        System.out.println("Card color : " + color + "\n" + "Mana Points Number : " + manaPointsNbr + "\n");

    }

    @Override
    public String toString() {

        String string = super.toString() + " " + color.toString() + " " + manaPointsNbr.toString() ;

        return string;
    }
}

