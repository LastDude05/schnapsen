record Card(String suit, String rank, int points) {

    String label() {
        return suit + " " + rank + " (" + points + ")";
    }
}
