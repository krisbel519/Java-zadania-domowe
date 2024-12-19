import java.security.MessageDigest;

public class zadanie1 {

    public static void main(String[] args) {
        String lastHash = "4d00d79b6733c9cc066584a02ed03410";
        System.out.println("Wylosowany hash poczatkowy: " + lastHash);

        for (int i = 1; i <= 5; i++) {
            double amount = 20.50 + i * 50;
            Transaction transaction = findTransactionWithNonce(amount, lastHash);
            System.out.println("Obiekt #" + i + ": " + transaction);

        
            lastHash = hashObject(transaction.toString());
            System.out.println("Hash: " + lastHash);
        }
    }

    
    static class Transaction {
        double amount;
        String lastTransaction;
        int nonce;

        Transaction(double amount, String lastTransaction, int nonce) {
            this.amount = amount;
            this.lastTransaction = lastTransaction;
            this.nonce = nonce;
        }

        @Override
        public String toString() {
            return "{amount: " + amount +
                   ", lastTransaction: \"" + lastTransaction + "\"" +
                   ", nonce: " + nonce + "}";
        }
    }

    
    static Transaction findTransactionWithNonce(double amount, String lastTransaction) {
        int nonce = 0;
        String hash = "";
        while (!hash.endsWith("00000")) { 
            Transaction t = new Transaction(amount, lastTransaction, nonce);
            hash = hashObject(t.toString());
            nonce++;
        }
        return new Transaction(amount, lastTransaction, nonce - 1); 
    }

    
    static String hashObject(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка хеширования");
        }
    }
}
