package polyclinic;

import java.util.Arrays;

public class Polyclinic {

    public static final OutpatientsCard[] DEFAULT_CARDS = new OutpatientsCard[0];

    private int number;
    private String address;
    private OutpatientsCard[] cards;

    // номер + адреса (масив = 0)
    public Polyclinic(int number, String address) {
        this(number, address, DEFAULT_CARDS);
    }

    // номер + адреса + масив пацієнтів
    public Polyclinic(int number, String address, OutpatientsCard[] cards) {
        this.number = number;
        this.address = (address == null) ? "" : address;
        this.cards = (cards == null) ? DEFAULT_CARDS : Arrays.copyOf(cards, cards.length);
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = (address == null) ? "" : address; }

    public int getTotalPatients() {
        return cards.length;
    }

    public OutpatientsCard getCardByPolicyNumber(int policyNumber) {
        for (OutpatientsCard c : cards) {
            if (c != null && c.getPolicyNumber() == policyNumber) return c;
        }
        return null;
    }

    public OutpatientsCard[] getCardsByAddress(String address) {
        String target = (address == null) ? "" : address;

        int count = 0;
        for (OutpatientsCard c : cards) {
            if (c != null && target.equals(c.getAddress())) count++;
        }

        OutpatientsCard[] result = new OutpatientsCard[count];
        int idx = 0;
        for (OutpatientsCard c : cards) {
            if (c != null && target.equals(c.getAddress())) result[idx++] = c;
        }
        return result;
    }

    // видалення по номеру поліса (масив "стискається")
    public boolean deleteCard(int policyNumber) {
        int pos = -1;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null && cards[i].getPolicyNumber() == policyNumber) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return false;

        OutpatientsCard[] newArr = new OutpatientsCard[cards.length - 1];
        int k = 0;
        for (int i = 0; i < cards.length; i++) {
            if (i == pos) continue;
            newArr[k++] = cards[i];
        }
        cards = newArr;
        return true;
    }

    // додавання в кінець (масив розширюється на 1)
    public void addCard(OutpatientsCard card) {
        OutpatientsCard[] newArr = new OutpatientsCard[cards.length + 1];
        for (int i = 0; i < cards.length; i++) newArr[i] = cards[i];
        newArr[cards.length] = card;
        cards = newArr;
    }

    // повертає масив карток (копія)
    public OutpatientsCard[] getCards() {
        return Arrays.copyOf(cards, cards.length);
    }

    // повертає масив карт, відсортований за адресами (копія)
    public OutpatientsCard[] getCardsSortedByAddress() {
        OutpatientsCard[] copy = Arrays.copyOf(cards, cards.length);

        // просте сортування (bubble) без колекцій
        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1 - i; j++) {
                String a1 = (copy[j] == null || copy[j].getAddress() == null) ? "" : copy[j].getAddress();
                String a2 = (copy[j + 1] == null || copy[j + 1].getAddress() == null) ? "" : copy[j + 1].getAddress();
                if (a1.compareToIgnoreCase(a2) > 0) {
                    OutpatientsCard tmp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = tmp;
                }
            }
        }
        return copy;
    }
}