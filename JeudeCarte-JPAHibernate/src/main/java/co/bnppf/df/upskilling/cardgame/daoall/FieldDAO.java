package co.bnppf.df.upskilling.cardgame.daoall;

import co.bnppf.df.upskilling.cardgame.model.Field;
import javax.persistence.EntityManager;


public class FieldDAO extends Dao<Field> {

    public FieldDAO(EntityManager em) {
        super(em, Field.class);
    }


//    Connection c;
//
//    public FieldDAO(Connection c) {
//        this.c = c;
//    }
//
//    public void persist(List<Field> fieldList) throws SQLException {
//
//        for (int i = 0; i < fieldList.size(); i++) {
//            String inserCmd = "INSERT INTO field (id , card_type, card_cost , field_color, field_mananbrpoints)"
//                    + " VALUES(DEFAULT, ?, ?, ? , ?);";
//            try (PreparedStatement ps = c.prepareStatement(inserCmd, Statement.RETURN_GENERATED_KEYS)) {
//
//                ps.setString(1, fieldList.get(i).getCardType().name());
//                ps.setInt(2, fieldList.get(i).getCost());
//                ps.setString(3, fieldList.get(i).getColor().name());
//                ps.setInt(4, fieldList.get(i).getManaPointsNbr());
//                ps.addBatch();
//                ps.executeBatch();
//
//                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        fieldList.get(i).setId(generatedKeys.getInt(1));
//                    } else {
//                        throw new SQLException("Persisting field failed, no ID obtained.");
//                    }
//                }
//
//            }
//
//        }
//    }
//
//    public List<Field> readField () throws SQLException {
//
//            String ReadCmd = "SELECT * FROM field WHERE " + "?" + " LIKE " + "?" + ";";
//
//            String ReadCmd2 = "SELECT * FROM field WHERE id >1 ;";
//
//            try (PreparedStatement ps = c.prepareStatement(ReadCmd2)) {
////                Condtions et criteres a rajouter dans param de fonction si on utiliser ci-dessous
////                ps.setString(1, "%" + condition + "%");
////                ps.setString(2, "%" + criteria + "%");
//
//                List<Field> fieldListRead = new ArrayList<>();
//
//                ResultSet rs = ps.executeQuery();
//                while ( rs.next() )
//                {
//                    Field field = new Field();
//                    field.setId( rs.getInt("id"));
//                    CardType ct = CardType.valueOf(rs.getString("card_type"));
//                    field.setCardType (ct);
//                    field.setCost(rs.getInt("card_cost"));
//                    FieldColor fc = FieldColor.valueOf(rs.getString("field_color"));
//                    field.setColor(fc);
//                    //field.setColor((FieldColor) rs.getObject("field_color"));
//                    field.setManaPointsNbr(rs.getInt("field_mananbrpoints"));
//
//                    fieldListRead.add(field);
//                }
//                rs.close();
//
//                return fieldListRead;
//
//
//            }
//
//        }
////
////      ==> On met souvent a jour tout l'objeyt considéré (dans notre cas Field :
////          De fait, on considère qu'il faut MAJ toutes les colonnes/attibuts considérés
////          Sur base de données relationnelle, la MAJ doit se faire sur :
////              - soit 1 ID unique
////              - soit un ensemble défini d'objet (d'ID considéré)
//
//    /**
//     *
//     * @param idToUpdate int value correspondy to field object id
//     * @throws SQLException : stating the status of SQL requested
//     */
//
//
///*
//    public Integer updateField(Field fieldUpdated) throws SQLException {
//
//        //  field data to update : id , card_type, card_cost , field_color, field_mananbrpoints
//
//            String updateFieldCmd = "UPDATE field SET " +
//                    "card_type = ? ," +
//                    "card_cost = ? ," +
//                    " field_color = ? ," +
//                    "field_mananbrpoints = ? " +
//                    "WHERE id = " + "?" + " ;";
//
//            try (PreparedStatement ps = c.prepareStatement(updateFieldCmd)) {
//
//                  ps.setString(1, fieldUpdated.getCardType().name());
//                  ps.setInt(2, fieldUpdated.getCost());
//                  ps.setString(3, fieldUpdated.getColor().name());
//                  ps.setInt(4, fieldUpdated.getManaPointsNbr());
//                  ps.setInt(5, fieldUpdated.getId());
//                return ps.executeUpdate();
//            }
//    }
//
////    Ancien code avec MAJ uniquement sur 1 des attributs/colonnes de la table/objet field
////
////    public void updateField(Integer idToUpdate) throws SQLException {
////
////
////        //  divers colonnes à MAJ : id , card_type, card_cost , field_color, field_mananbrpoints
////
////            String updateCostCmd = "UPDATE field SET field_mananbrpoints = ? WHERE id = " + "?" + " ;";
////
////            try (PreparedStatement ps = c.prepareStatement(updateCostCmd)) {
////
////                  ps.setInt(2, idToUpdate);
////                  ps.setInt(1, 88);
////                ps.executeUpdate();
////            }
////    }
//
//    public void deleteField(Integer idToDelete) throws SQLException {
//
//
//        String deleteCmd = "DELETE FROM field WHERE id = " + "?" + " ;";
//
//        try (PreparedStatement ps = c.prepareStatement(deleteCmd)) {
//
//            ps.setInt(1, idToDelete);
//            ps.executeUpdate();
//        }
//    }


}

