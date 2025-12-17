package polyclinic;

public class PolyclinicTest {
    public static void main(String[] args) {
        Polyclinic p = new Polyclinic(12, "Одеса, вул. Прикладна 1");

        OutpatientsCard c1 = new OutpatientsCard("Іван", "Петренко", "Одеса, вул. Морська 10", 111111);
        OutpatientsCard c2 = new OutpatientsCard("Марія", "Іванова", "Одеса, вул. Морська 10", 222222);
        OutpatientsCard c3 = new OutpatientsCard("Олег", "Сидоренко", "Одеса, вул. Сонячна 5", 333333);

        p.addCard(c1);
        p.addCard(c2);
        p.addCard(c3);

        System.out.println("Total patients: " + p.getTotalPatients());
        System.out.println("Find by policy 222222: " + p.getCardByPolicyNumber(222222));

        OutpatientsCard[] byAddr = p.getCardsByAddress("Одеса, вул. Морська 10");
        System.out.println("By address Морська 10: " + byAddr.length);

        System.out.println("Delete 111111: " + p.deleteCard(111111));
        System.out.println("Total patients after delete: " + p.getTotalPatients());

        OutpatientsCard[] sorted = p.getCardsSortedByAddress();
        System.out.println("Sorted by address:");
        for (OutpatientsCard c : sorted) System.out.println(c);
    }
}