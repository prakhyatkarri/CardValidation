public class LockerPuzzle {

    public static void main(String[] args) {
        boolean[] lockers = new boolean[100];

        for (int i =1; i < lockers.length; i++) {
            // since student n skips n lockers every time, lockers[n*n] will always remain open
            int n = i * i;

            if (n < lockers.length) {
                lockers[n] = true;
            }
        }

        for (int i = 0; i<lockers.length; i++) {
            if (lockers[i]) {
                System.out.println("Locker " + i + " is open");
            }
        }
    }
}
