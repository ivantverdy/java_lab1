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
        return stones.stream().mapToDouble(Stone::calculateValue).sum();
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
        String query = "INSERT INTO stones(id, name, carat, purity, rarity, type, value) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            int id = 1;
            for (Stone stone : stones) {
                ps.setInt(1, id++);
                ps.setString(2, stone.getName());
                ps.setDouble(3, stone.getCarat());
                ps.setDouble(4, stone.getPurity());

                if (stone instanceof PreciousStone pst) {
                    ps.setDouble(5, pst.getRarity());
                    ps.setString(6, "Precious Stone");
                    ps.setDouble(7, pst.calculateValue());
                } else if (stone instanceof SemiPreciousStone spst) {
                    ps.setNull(5, java.sql.Types.DOUBLE);
                    ps.setString(6, "Semi Precious Stone");
                    ps.setDouble(7, spst.calculateValue());
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getFromDb() {
        String query = "SELECT * FROM stones";
        try (Connection conn = DB.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                double carat = rs.getDouble("carat");
                double purity = rs.getDouble("purity");
                if (Objects.equals(name, "Semi Precious Stone")) {
                    double rarity = java.sql.Types.DOUBLE;
                } else {
                    double rarity = rs.getDouble("rarity");
                }
                String type = rs.getString("type");
                double value = rs.getDouble("value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
