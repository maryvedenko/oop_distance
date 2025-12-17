package polyclinic;

public class OutpatientsCard {

    public static final int DEFAULT_POLICY_NUMBER = 0;
    public static final String DEFAULT_ADDRESS = "";

    private String firstName;
    private String lastName;
    private String address;
    private int policyNumber;

    // Конструктор: ім'я + прізвище (policy=0, address="")
    public OutpatientsCard(String firstName, String lastName) {
        this(firstName, lastName, DEFAULT_ADDRESS, DEFAULT_POLICY_NUMBER);
    }

    // Конструктор: ім'я + прізвище + адреса (policy=0)
    public OutpatientsCard(String firstName, String lastName, String address) {
        this(firstName, lastName, address, DEFAULT_POLICY_NUMBER);
    }

    // Конструктор: ім'я + прізвище + адреса + номер поліса
    public OutpatientsCard(String firstName, String lastName, String address, int policyNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = (address == null) ? DEFAULT_ADDRESS : address;
        this.policyNumber = policyNumber;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = (address == null) ? DEFAULT_ADDRESS : address; }

    @Override
    public String toString() {
        return "OutpatientsCard{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", policyNumber=" + policyNumber +
                '}';
    }
}