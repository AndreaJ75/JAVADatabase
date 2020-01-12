import java.sql.*;
import java.util.List;

public class CreatureDao {
        Connection c;

        public CreatureDao(Connection c) {
            this.c = c;
        }

        public void persist(List<Creature> creatureList) throws SQLException {

            for (int i = 0; i < creatureList.size(); i++) {
                String inserCmd = "INSERT INTO creature (id, card_type , card_cost, name, " +
                        "damage, lifepoints)"
                        + " VALUES(DEFAULT, ?, ?, ?, ?, ?);";
                try (PreparedStatement ps = c.prepareStatement(inserCmd, Statement.RETURN_GENERATED_KEYS)) {

                    ps.setString(1, creatureList.get(i).getCardType().name());
                    ps.setInt(2, creatureList.get(i).getCost());
                    ps.setString(3, creatureList.get(i).getName());
                    ps.setInt(4, creatureList.get(i).getDamagePointsNbr());
                    ps.setInt(5, creatureList.get(i).getLifePointNbr());
                    ps.addBatch();
                    ps.executeBatch();

                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            creatureList.get(i).setId(generatedKeys.getInt(1));
                        } else {
                            throw new SQLException("Persisting Creature failed, no ID obtained.");
                        }
                    }
                }

            }
        }
    }

