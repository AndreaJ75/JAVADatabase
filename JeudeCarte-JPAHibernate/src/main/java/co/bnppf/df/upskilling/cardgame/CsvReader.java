package co.bnppf.df.upskilling.cardgame;

import co.bnppf.df.upskilling.cardgame.model.CardType;
import co.bnppf.df.upskilling.cardgame.model.Field;
import co.bnppf.df.upskilling.cardgame.model.FieldColor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

//    private Connection c;
//    private FieldDAO fieldDao;
//    private CreatureDao creatureDao;

    private static final String[] HEADERS = {"card-type", "card-cost", "field-color", "field-mana-number-of-points"};
//    private static final String[] HEADERS2 = {"card-type", "card-cost", "creature-name", "damage-number-of-points", "life-number-of-points"};
//
//    public CsvReader(Connection c) {
//        this.c = c;
//        this.fieldDao = new FieldDAO(c);
//        this.creatureDao = new CreatureDao(c);
//    }
    public CsvReader() {
    }

    public List<Field> readField(String filename) throws IOException {

        List<Field> res = new ArrayList<Field>();

        Reader in = new FileReader(filename);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .parse(in);
        for (CSVRecord record : records) {

            String Test1 = record.get("card-cost");
            System.out.println("Test1 value = " + Test1);
            System.out.println("Field co = " + record.get("field-color"));
            Integer Test2 = Integer.parseInt(record.get("card-cost"));

            FieldColor color = FieldColor.valueOf(record.get("field-color"));
            System.out.println("couleur finale : " + color);
            CardType cardType = CardType.valueOf(record.get("card-type"));

            Field field = new Field(
                    cardType,
                    Integer.parseInt(record.get("card-cost")),
                    color,
                    Integer.parseInt(record.get("field-mana-number-of-points")));

            res.add(field);
        }
        //fieldDao.persist(res);
        return res;
    }

//    public List<Creature> readCreature(String filename) throws IOException, SQLException {
//
//        List<Creature> res = new ArrayList<Creature>();
//        Reader in = new FileReader(filename);
//        Iterable<CSVRecord> records = CSVFormat.DEFAULT
//                .withHeader(HEADERS2)
//                .parse(in);
//        for (CSVRecord record : records) {
//
//            CardType cardType2 = CardType.valueOf(record.get("card-type"));
//
//            Creature creature= new Creature(
//                    cardType2,
//                    Integer.parseInt(record.get("card-cost")),
//                    record.get("creature-name"),
//                    Integer.parseInt(record.get("damage-number-of-points")),
//                    Integer.parseInt(record.get("life-number-of-points")));
//
//            res.add(creature);
//        }
//        creatureDao.persist(res);
//        return res;
//    }

}

