package polyclinic;

public class TestPolyclinic {

    public static void main(String[] args) {

        OutpatientsCard p1 = new OutpatientsCard("Anna", "Ivanova", "Kyiv", 111);
        OutpatientsCard p2 = new OutpatientsCard("Oleh", "Petrenko", "Lviv", 222);

        Polyclinic clinic = new Polyclinic(5, "Main street 10");
        clinic.addCard(p1);
        clinic.addCard(p2);

        System.out.println("Patients count: " + clinic.getPatientsCount());
        System.out.println("Find by policy 111: " +
                clinic.getCardByPolicy(111).getLastName());
    }
}