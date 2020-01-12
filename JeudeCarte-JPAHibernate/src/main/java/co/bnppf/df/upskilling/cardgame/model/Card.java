package co.bnppf.df.upskilling.cardgame.model;

import javax.persistence.*;

@MappedSuperclass
//@Table(name="card")
public abstract class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name="cardType")
    private CardType cardType;
    @Column(name="cost")
    private Integer cost;
//    @OneToOne
//    @JoinColumn(name="fk_field")
//    private Field field;

    public Card() {
    }

    public Card(Integer id, CardType cardType, Integer cost) {
        this.id = id;
        this.cardType = cardType;
        this.cost = cost;
//        this.field = field;
    }

    public Card(CardType cardType, Integer cost) {
        this.cardType = cardType;
        this.cost = cost;
//        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardType getCardType(){
        return cardType;
    }

    public Integer getCost(){
        return cost;
    }


    public void setCardType(CardType cardType){
        this.cardType = cardType;
    }

    public void setCost(Integer cost){
        this.cost = cost;
    }


    public void displayCardType(){
        System.out.println("Type de carte : " + cardType);
    }

    public void displayCostArgs(){
        System.out.println("Cout de la carte : " + this.cost);
    }

    @Override
    public String toString() {
        return cardType.toString() + " " + cost.toString();
    }
}
