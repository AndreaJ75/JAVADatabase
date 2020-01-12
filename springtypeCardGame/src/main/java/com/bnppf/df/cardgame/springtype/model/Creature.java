package com.bnppf.df.cardgame.springtype.model;

public class Creature extends Card {
    private Integer id;
    private String name;
    private Integer damagePointsNbr;
    private Integer lifePointNbr;


    public Creature(){
    }
    public Creature(Integer id, CardType cardType, Integer cost, String name, Integer damagePointsNbr, Integer lifePointNbr){
        super(cardType, cost);
        this.id = id;
        this.name = name;
        this.damagePointsNbr = damagePointsNbr;
        this.lifePointNbr = lifePointNbr;
    }

    public Creature(CardType cardType, Integer cost, String name, Integer damagePointsNbr, Integer lifePointNbr){
        super(cardType, cost);
        this.name = name;
        this.damagePointsNbr = damagePointsNbr;
        this.lifePointNbr = lifePointNbr;
    }

    public Integer getId() { return id;    }

    public String getName() {
        return name;
    }

    public Integer getDamagePointsNbr(){
        return damagePointsNbr;
    }

    public Integer getLifePointNbr(){
        return lifePointNbr;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamagePointsNbr(Integer damagePointsNbr) {
        this.damagePointsNbr = damagePointsNbr;
    }

    public void setLifePointNbr(Integer lifePointNbr) {
        this.lifePointNbr = lifePointNbr;
    }

    @Override
    public void displayCostArgs() {
        super.displayCostArgs();

        System.out.println("Creature Name : " + name + "\n" + "Damage Number of points : " + damagePointsNbr +
                "\n" + " Life Number of points : " + lifePointNbr + "\n");

    }

}
