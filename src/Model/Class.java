package Model;

public class Class {

    private String ID;
    private String title;

    public Class(){}
    public Class(int classID,Database database){

    }

    public String getID(){
        return ID;
    }

    public String getTitle(){
        return title;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
