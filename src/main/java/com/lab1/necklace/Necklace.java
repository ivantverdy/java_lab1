package com.lab1.necklace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.lab1.stone.PreciousStone;
import com.lab1.stone.SemiPreciousStone;
import com.lab1.stone.Stone;

import com.lab1.database.DB;

import java.sql.*;
import java.util.Objects;

public class Necklace {
    private List<Stone> stones;

    public List<Stone> getStones() {
        return stones;
    }

    public Necklace() {
        this.stones = new ArrayList<>();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public double getWeight() {
        return stones.stream().mapToDouble(Stone::getCarat).sum(); // map to double takes stone object and applies getCarat() to each one
    }

    public double getCost() {
        return stones.stream().mapToDouble(Stone::getValue).sum();
    }

    public void sortByValue() {
        stones.sort(Comparator.comparingDouble(Stone::calculateValue));
    }

    public List<Stone> getStonesInPurityRange(double min, double max) {
        List<Stone> stonesInRange = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getPurity() >= min && stone.getPurity() <= max) {
                stonesInRange.add(stone);
            }
        }
        return stonesInRange;
    }

    public void saveToDb() {
        String query = "INSERT INTO stones(name, carat, purity, rarity, type, value) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            //int id = 1;
            for (Stone stone : stones) {
                //ps.setInt(1, id++);
                ps.setString(1, stone.getName());
                ps.setDouble(2, stone.getCarat());
                ps.setDouble(3, stone.getPurity());


                if (stone instanceof PreciousStone pst) {
                    ps.setDouble(4, pst.getRarity());
                    ps.setString(5, "Precious Stone");
                } else if (stone instanceof SemiPreciousStone spst) {
                    ps.setNull(4, java.sql.Types.DOUBLE);
                    ps.setString(5, "Semi Precious Stone");
                }

                ps.setDouble(6, stone.getValue());

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stone> getFromDb() {
        String query = "SELECT * FROM stones";
        List<Stone> stones = new ArrayList<>();
        try (Connection conn = DB.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                //Integer id = rs.getInt("id");
                String name = rs.getString("name");
                double carat = rs.getDouble("carat");
                double purity = rs.getDouble("purity");
                String type = rs.getString("type");
                if("Semi Precious Stone".equals(type)) {
                    SemiPreciousStone semiPreciousStone = new SemiPreciousStone(name, carat, purity);
                    stones.add(semiPreciousStone);
                }
                else {
                    double rarity = rs.getDouble("rarity");
                    PreciousStone preciousStone = new PreciousStone(name, carat, purity, rarity);
                    stones.add(preciousStone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stones;
    }
}
