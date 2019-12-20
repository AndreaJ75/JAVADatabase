public class Field extends Card {

    private Integer id;
    private FieldColor color;
    private Integer manaPointsNbr;

    public Field() {
    }

    public Field(Integer id, CardType cardType, Integer cost,FieldColor color, Integer manaPointsNbr) {
        super(cardType, 0);
        this.id = id;
        this.color = color;
        this.manaPointsNbr = manaPointsNbr;
    }

    public Field(CardType cardType, Integer cost, FieldColor color, Integer manaPointsNbr) {
        super(cardType, 0);
        this.color = color;
        this.manaPointsNbr = manaPointsNbr;
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
