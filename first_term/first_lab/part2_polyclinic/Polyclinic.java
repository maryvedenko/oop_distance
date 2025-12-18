package polyclinic;

import java.util.Arrays;

public class Polyclinic {

    private int number;
    private String address;
    private OutpatientsCard[] cards;

    public Polyclinic(int number, String address) {
        this(number, address, new OutpatientsCard[0]);
    }

    public Polyclinic(int number, String address, OutpatientsCard[] cards) {
        this.number = number;
        this.address = address;
        this.cards = cards;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPatientsCount() {
        return cards.length;
    }

    public OutpatientsCard getCardByPolicy(int policyNumber) {
        for (OutpatientsCard card : cards) {
            if (card.getPolicyNumber() == policyNumber) {
                return card;
            }
        }
        return null;
    }

    public OutpatientsCard[] getCardsByAddress(String address) {
        int count = 0;
        for (OutpatientsCard card : cards) {
            if (card.getAddress().equals(address)) {
                count++;
            }
        }

        OutpatientsCard[] result = new OutpatientsCard[count];
        int index = 0;
        for (OutpatientsCard card : cards) {
            if (card.getAddress().equals(address)) {
                result[index++] = card;
            }
        }
        return result;
    }

    public void addCard(OutpatientsCard card) {
        cards = Arrays.copyOf(cards, cards.length + 1);
        cards[cards.length - 1] = card;
    }

    public void removeCardByPolicy(int policyNumber) {
        int index = -1;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getPolicyNumber() == policyNumber) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            OutpatientsCard[] newCards = new OutpatientsCard[cards.length - 1];
            for (int i = 0, j = 0; i < cards.length; i++) {
                if (i != index) {
                    newCards[j++] = cards[i];
                }
            }
            cards = newCards;
        }
    }

    public OutpatientsCard[] getAllCards() {
        return cards;
    }

    public OutpatientsCard[] getCardsSortedByAddress() {
        OutpatientsCard[] sorted = Arrays.copyOf(cards, cards.length);
        Arrays.sort(sorted, (a, b) -> a.getAddress().compareTo(b.getAddress()));
        return sorted;
    }
}