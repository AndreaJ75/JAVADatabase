import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainOld {


    // Creation des tables TERRAIN A VIDE :

    private static final String createFieldTable = "CREATE TABLE IF NOT EXISTS field ("
            + "id SERIAL PRIMARY KEY,"
            + "card_type VARCHAR,"
            + "card_cost INT ,"
            + "field_color VARCHAR ,"
            + "field_mananbrpoints INT"
            + ");";

    // Creation des tables TERRAIN A VIDE :

    private static final String createCreatureTable = "CREATE TABLE IF NOT EXISTS creature ("
            + "id SERIAL PRIMARY KEY, "
            + "card_type VARCHAR,"
            + "card_cost INT,"
            + "name VARCHAR,"
            + "damage INT,"
            + "lifepoints INT"
            + ");";


    public static void main(String[] args) throws Exception{


        // SESSION2 version (test validité)


        System.out.println(" ************** SIMPLE CARD DISPLAY  ---- START ***************");
        Card card1 = new Field(CardType.FIELD, 3, FieldColor.blue, 2);

        card1.displayCardType();
        card1.displayCostArgs();


        Card card2 = new Creature(CardType.CREATURE, 5, "SylverCrush", 7, 5);

        card2.displayCardType();
        card2.displayCostArgs();

        Card card3 = new Curse(CardType.CURSE, 8, "Dynamolition", "Destroy its target covering it with dynamite");

        card3.displayCardType();
        card3.displayCostArgs();

        System.out.println(" ************** SIMPLE CARD DISPLAY ---- END  ***************");

        Card card4 = new Field(CardType.FIELD, 3, FieldColor.red, 5);
        Card card5 = new Creature(CardType.CREATURE, 10, "Vizir", 2, 4);
        Card card6 = new Creature(CardType.CREATURE, 3, "Sarmonce", 3, 24);
        Card card7 = new Field(CardType.FIELD, 3, FieldColor.black, 3);
        Card card8 = new Field(CardType.FIELD, 5, FieldColor.green, 1);
        Card card9 = new Curse(CardType.CURSE, 12, "Barkadam", "Make its owner blow like the wind");
        Card card10 = new Curse(CardType.CURSE, 4, "Biskarros", "Make its owner become invisible");
        Card card11 = new Creature(CardType.CREATURE, 3, "Baloon", 23, 2);
        Card card12 = new Field(CardType.FIELD, 15, FieldColor.white, 11);
        Card card13 = new Curse(CardType.CURSE, 6, "Steaddy", "Makes its target steady");
        Card card14 = new Curse(CardType.CURSE, 7, "Biznage", "Sinks its target");

        List<Field> listField = new ArrayList<Field>();
        List<Creature> listCreature = new ArrayList<Creature>();

        Creature creatu1 = new Creature(CardType.CREATURE, 10, "Vizir", 2, 4);
        listCreature.add(creatu1);

        Field field1 = new Field(CardType.FIELD, 15, FieldColor.white, 11);
        listField.add(field1);

        List<Card> cardCollection = new ArrayList<Card>();
        List<Card> cardsAll = new ArrayList<Card>();

        cardsAll.add(card1);
        cardsAll.add(card2);
        cardsAll.add(card3);
        cardsAll.add(card4);
        cardsAll.add(card5);
        cardsAll.add(card6);
        cardsAll.add(card7);
        cardsAll.add(card8);
        cardsAll.add(card9);
        cardsAll.add(card10);
        cardsAll.add(card11);
        cardsAll.add(card12);
        cardsAll.add(card13);
        cardsAll.add(card14);
        cardsAll.add(card11);

        CardPlayer cardCollect = new CardPlayer(cardCollection, 10);

        // * Piocher toutes les cartes jusqu'à arriver au max de carte prévu pour 1 joueur.
        //cardCollect.drawCard(carte1);

        System.out.println(" **************************************************** ");

        for (Card card : cardsAll) {
            if (cardCollection.size() < cardCollect.getMaxCardNbr()) {
                cardCollect.drawCard(card);
            }
        }

        // * Jouer Carte :
        //System.out.println("selection d'une carte de collection : " + cardCollection.get(0));

        Card firstCard = cardCollection.get(0);
        cardCollect.playCard(firstCard);

        if (firstCard == null) {
            System.out.println("No more linked cards");
        } else {
            firstCard.displayCardType();
        }

        // * Afficher Jeu-Carte
        System.out.println(" **************************************************** ");

        cardCollect.displayPlayerGame();

        System.out.println(" **************************************************** ");

        System.out.println(" Valeur de tostring : " + field1.toString());

        // ********************************************************
        // Creation des cartes en base de donnees - version JDBC  *
        //*********************************************************

        try {
            // Utilisation du driver adapté a Postgres (défini dans le pom.xml)

            Class.forName("org.postgresql.Driver");

            // Acces a l'URL où se situe la Base de donnees postgres (sous notre Docker)
            // voir le nom de la Database (PGDATA sous Kitelematic)

            String URL = "jdbc:postgresql://localhost:5432/postgres";

            try (Connection conn = DriverManager.getConnection(URL, "change", "change")) {

                // Creation des tables a vide en Bases de données
                 createTables(conn);

                // Creation des Terrains en Base de données
//
//                List<Field> res = null;
//                CsvReader reader = new CsvReader(conn);
//                res = reader.readField("/Users/admin/Documents/DF_PROJECT/JeuCarteDB/src/test/Field.csv");

                FieldDAO fieldDao = new FieldDAO(conn);
                fieldDao.persist(listField);


                CreatureDao creatureDao = new CreatureDao(conn);
                creatureDao.persist(listCreature);


                List<Field> fieldListRead = new ArrayList<>();
//               A decommenter si utilisation de critères et condition de selection
                //fieldListRead = fieldDao.readField ("%field_color",   "%white");
                fieldListRead = fieldDao.readField();
                System.out.println("Field read = " + fieldListRead.get(1).toString());

//
//                // Creation des Creatures en Base de données
//                List<Creature> res2 = null;
//                CsvReader reader2 = new CsvReader(conn);
//                res2 = reader2.readCreature("/Users/admin/Documents/DF_PROJECT/JeuCarteDB/src/test/Creature.csv");

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private static void createTables (Connection conn) throws SQLException {
        try (Statement s = conn.createStatement()) {
            s.execute(createFieldTable);
            s.execute(createCreatureTable);
        }
    }

}