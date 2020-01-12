import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {


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


        // ***********************************************************************************************
        // **          ACCES DRIVERS+ URL(serveurs virtuel Postgres)                                  ****
        // **          CRUD SUR BASES DE DONNES : FIELD + CREATURE                                    ****
        //************************************************************************************************


        try {
            // Utilisation du driver adapté a Postgres (défini dans le pom.xml)

            Class.forName("org.postgresql.Driver");

            // Acces a l'URL où se situe la Base de donnees postgres (sous notre Docker)
            // voir le nom de la Database (PGDATA sous Kitelematic)

            String URL = "jdbc:postgresql://localhost:5432/postgres";

            try (Connection conn = DriverManager.getConnection(URL, "db-Andy", "Koala75")) {
                //try (Connection conn = DriverManager.getConnection(URL, "change", "change")) {
                // *********************************************************************
                // CREATE :     Creation des cartes en base de donnees - version JDBC  *
                //**********************************************************************

                // Creation des tables Terrain et Creature a vide en Bases de données :

                 createTables(conn);

                // Lecture du CSV avec les Terrains + Ecriture sur table Terrains

                List<Field> res = new ArrayList<Field>();
                CsvReader reader = new CsvReader(conn);
                res = reader.readField("src/test/Field.csv");
                System.out.println("Enreg Field " + res.get(0).getId());

                // Lecture du CSV avec les Creature + Ecriture sur table Creature
                List<Creature> res2 = new ArrayList<Creature>();
                CsvReader reader2 = new CsvReader(conn);
                res2 = reader2.readCreature("src/test/Creature.csv");
                System.out.println("Enreg Creature = " + res2.get(0).getName());


                // *********************************************************************
                // *   READ :          Lecture de table  - version JDBC                *
                // *********************************************************************

                // Lecture de table Terrain
                // A decommenter si utilisation de critères et condition de selection
                // fieldListRead = fieldDao.readField ("%field_color",   "%white");
                List<Field> fieldListRead = new ArrayList<>();
                FieldDAO fieldDao = new FieldDAO(conn);
                fieldListRead = fieldDao.readField();
                System.out.println("Field read = " + fieldListRead.get(1).toString());


                // *********************************************************************
                // *   UPDATE :       MAJ sur TABLE      - version JDBC                *
                // *********************************************************************

                // MAJ de la table Terrain

                  FieldDAO fieldDao2 = new FieldDAO(conn);
                  Field fieldUpdated = new Field(5, CardType.FIELD,3, FieldColor.green, 88);
                  int resUpdate = fieldDao2.updateField(fieldUpdated);
                  System.out.println(resUpdate);

                // *********************************************************************
                // *   DELETE :       DELETE sur TABLE      - version JDBC             *
                // *********************************************************************

                // DELETE de record de la table Terrain

                FieldDAO fieldDAO3 = new FieldDAO(conn);
                fieldDAO3.deleteField(11);

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