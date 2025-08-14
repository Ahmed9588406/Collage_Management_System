package Model;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
    private int ID;
    private String Name;

    public Department(){}
    public Department(int ID){
        this.ID = ID;
    }
    public Department(int ID,Database database){
        String select = "SELECT * FROM `departments` WHERE `ID` = "+ID+";";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            rs.next();
            setID(rs.getInt("ID"));
            setName(rs.getString("Name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getID(){
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name){
        this.Name = name;
    }
    public void print(){
        System.out.println("ID:\t"+getID());
        System.out.println("Name:\t"+getName());
        System.out.println("----------------------------\n");
    }
    public void create(Database database){
        String insert = "INSERT INTO `departments`(`ID`,`Name`) "
                + "VALUES ('"+getID()+"', '"+getName()+"');";
        try {
            database.getStatement().execute(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Database database){
        String update = "UPDATE `departments` SET `Name`='"+getName()+"' WHERE `ID` = "+getID()+"";
        try {
            database.getStatement().execute(update);
            System.out.println("Department Updated Successfully");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(Database database){
        String delete = "DELETE FROM `departments` WHERE `ID` = "+ID+";";
        try{
            database.getStatement().execute(delete);
            System.out.println("Department Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
