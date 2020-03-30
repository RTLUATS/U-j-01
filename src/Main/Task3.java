package Main;

public class Task3 {

    private Integer NumFaculty;
    private String NameEquipment;
    private Integer Quantity;
    private int Prise;

    public boolean setNumFaculty(int numFaculty) {
        if(numFaculty >= 4 && numFaculty >=10) {
            NumFaculty = numFaculty;
            return true;
        }else return false;
    }

    public String getNameEquipment() {
        return NameEquipment;
    }

    public boolean setNameEquipment(String nameEquipment) {
        if (nameEquipment.equals("Принтер") || nameEquipment.equals("Ноутбук") || nameEquipment.equals("ПК")) {
            NameEquipment = nameEquipment;
            return true;
        }
        else return false;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public boolean setQuantity(int quantity) {
        if(quantity >= 0 && quantity <= 10) {
            Quantity = quantity;
            return true;
        }else return false;
    }

    public int getPrise() {
        return Prise;
    }

    public boolean setPrise(int prise) {
        if (prise > 0 && prise < 10000 ) {
            Prise = prise;
            return true;
        }else return false;

    }

    public Integer getNumFaculty() {
        return NumFaculty;
    }

    public Task3(int numFaculty, String nameEquipment, int quantity, int prise) {
        this.NumFaculty = numFaculty;
        this.NameEquipment = nameEquipment;
        this.Quantity = quantity;
        this.Prise = prise;
    }



}