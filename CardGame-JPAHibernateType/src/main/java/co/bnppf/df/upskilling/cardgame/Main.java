package co.bnppf.df.upskilling.cardgame;

import co.bnppf.df.upskilling.cardgame.daoall.*;
//import co.bnppf.df.Upskilling.cardgame.model.Creature;

import co.bnppf.df.upskilling.cardgame.daoall.Dao;
import co.bnppf.df.upskilling.cardgame.model.Card;
import co.bnppf.df.upskilling.cardgame.model.Field;
import org.hibernate.type.descriptor.java.CharacterArrayTypeDescriptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    // Creation de var Factory statique :

    private static EntityManagerFactory factory;


    public static void main(String[] args) throws Exception{


        // Data persistence des donénes JPA

        String persistenceUnitName= "demo-jpa-1"; // defined in persistence.xml
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<String, Object>();
        for (String envName : env.keySet()) {
            if (envName.contains("DB_USER")) {
                configOverrides.put("javax.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("DB_PASS")) {
                configOverrides.put("javax.persistence.jdbc.password", env.get(envName));
            }
            if (envName.contains("DB_URL")) {
                configOverrides.put("javax.persistence.jdbc.url", env.get(envName));
            }
        }
        factory = Persistence.createEntityManagerFactory(persistenceUnitName
                   ,configOverrides);

        EntityManager em= factory.createEntityManager();

        // ***********************************************************************************************
        // **          ACCES DRIVERS+ URL(serveurs virtuel Postgres)                                  ****
        // **          CRUD SUR BASES DE DONNES : FIELD + CREATURE                                    ****
        //************************************************************************************************
//
//
//        try {
//            // Utilisation du driver adapté a Postgres (défini dans le pom.xml)
//
//            Class.forName("org.postgresql.Driver");
//
//            // Acces a l'URL où se situe la Base de donnees postgres (sous notre Docker)
//            // voir le nom de la Database (PGDATA sous Kitelematic)
//
//            String URL = "jdbc:postgresql://localhost:5432/postgres";
//
//            try (Connection conn = DriverManager.getConnection(URL, "change", "change")) {
//
//                // *********************************************************************
//                // CREATE :     Creation des cartes en base de donnees - version JDBC  *
//                //**********************************************************************
//
//                // Creation des tables Terrain et Creature a vide en Bases de données :
//
//                 createTables(conn);
//
//                // Lecture du CSV avec les Terrains + Ecriture sur table Terrains
//
                List<Field> res = new ArrayList<Field>();
                List<Field> resPersist = new ArrayList<Field>();
                CsvReader reader = new CsvReader();
                res = reader.readField("src/test/Field.csv");
                System.out.println("Enreg Field " + res.get(0).getId());
                for (Field field: res) {
                    FieldDAO fieldDAO = new FieldDAO(em);
                    fieldDAO.create(field);
                    resPersist.add(field);
                }

//                // Lecture du CSV avec les Creature + Ecriture sur table Creature
//                List<Creature> res2 = new ArrayList<Creature>();
//                CsvReader reader2 = new CsvReader(conn);
//                res2 = reader2.readCreature("src/test/Creature.csv");
//                System.out.println("Enreg Creature = " + res2.get(0).getName());
//
//
//                // *********************************************************************
//                // *   READ :          Lecture de table  - version JDBC                *
//                // *********************************************************************
//
//                // Lecture de table Terrain
//                // A decommenter si utilisation de critères et condition de selection
//                // fieldListRead = fieldDao.readField ("%field_color",   "%white");
//                List<Field> fieldListRead = new ArrayList<>();
//                FieldDAO fieldDao = new FieldDAO(conn);
//                fieldListRead = fieldDao.readField();
//                System.out.println("Field read = " + fieldListRead.get(1).toString());
//
//
//                // *********************************************************************
//                // *   UPDATE :       MAJ sur TABLE      - version JDBC                *
//                // *********************************************************************
//
//                // MAJ de la table Terrain
//
//                  FieldDAO fieldDao2 = new FieldDAO(conn);
//                  Field fieldUpdated = new Field(5, CardType.FIELD,3, FieldColor.green, 88);
//                  int resUpdate = fieldDao2.updateField(fieldUpdated);
//                  System.out.println(resUpdate);
//
//                // *********************************************************************
//                // *   DELETE :       DELETE sur TABLE      - version JDBC             *
//                // *********************************************************************
//
//                // DELETE de record de la table Terrain
//
//                FieldDAO fieldDAO3 = new FieldDAO(conn);
//                fieldDAO3.deleteField(11);
//
//            }
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    private static void createTables (Connection conn) throws SQLException {
//        try (Statement s = conn.createStatement()) {
//            s.execute(createFieldTable);
//            s.execute(createCreatureTable);
//        }
//
    }
}