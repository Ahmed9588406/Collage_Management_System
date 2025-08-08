package Model;

public class Department {
    private int ID;
    private String title;

    public Department(){}
    public Department(int ID,Database database){

    }

    public int getID(){
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
