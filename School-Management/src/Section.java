public class Section {

    private int id;;
    private int cID;
    private int tID;
    
    public Section(int id, int cID, int tID) {
        this.id = id;
        this.cID = cID;
        this.tID = tID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }
    
}
