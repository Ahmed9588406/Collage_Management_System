package Controller;

import Model.Database;

public class TestDB {
    public static void main(String[] args) {
        Database db = new Database();
        if (db.getStatement() != null) {
            System.out.println("✅ Connection is ready to use.");
        } else {
            System.out.println("❌ Connection failed.");
        }
    }
}

