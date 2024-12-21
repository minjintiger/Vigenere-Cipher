import java.util.Scanner;

// This program will encrypt and decrypt a message using the Vigenere Cipher

public class VigenereCipher {

    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        String key = "VigenereCipher"; // default key

        System.out.println("Vigenere Cipher");
        System.out.println("If you would like to use your own key, enter 1. If you would like to use the default key, enter 0.");
        int keyChoice = inputScanner.nextInt();
        if (keyChoice == 1){
            System.out.println("Enter the key: ");
            key = inputScanner.next();
            if (!key.matches("[a-zA-Z]+")){
                System.out.println("Invalid key");
                inputScanner.close();
                return;
            }
        }
        key = key.toUpperCase();
        while(true){
            System.out.println("Would you like to encrypt(1) or decrypt(2)? Enter 1 or 2");
            int choice = inputScanner.nextInt();
            if(choice == 1){
                encryption(key, inputScanner);
            }
            else if(choice == 2){
                decryption(key, inputScanner);
            }
            else {
                System.out.println("Invalid choice");
            }
            System.out.println("Would you like to continue? Enter 1 to continue or 0 to exit");
            int continueChoice = inputScanner.nextInt();
            if(continueChoice == 0){
                break;
            }
        }

        inputScanner.close();
    }
    // This function will take a string and print the encrypted string
    private static void encryption(String key, Scanner inputScanner){
        System.out.println("Enter the string to encrypt without space: ");
        inputScanner.nextLine();
        String inputString = inputScanner.nextLine();
        if(inputString.length() == 0 || !inputString.matches("[a-zA-Z]+")){
            System.out.println("Invalid string");
            return;
        }
        inputString = inputString.toUpperCase();
        String encryptedString = "";
        int keyIndex = 0;
        // Add the key to the string
        for(int i = 0; i < inputString.length(); i++){
            char c = inputString.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                encryptedString += (char)((c + key.charAt(keyIndex) - 2 * 'A') % 26 + 'A');
                keyIndex = (keyIndex + 1) % key.length();
            }
            else{
                encryptedString += c;
            }
        }
        System.out.println("Encrypted string: " + encryptedString);
    }
    // This function will take a string and print the decrypted string
    private static void decryption(String key, Scanner inputScanner){
        System.out.println("Enter the string to decrypt without space: ");
        inputScanner.nextLine();
        String inputString = inputScanner.nextLine();
        if(inputString.length() == 0 || !inputString.matches("[a-zA-Z]+")){
            System.out.println("Invalid string");
            return;
        }
        inputString = inputString.toUpperCase();
        String decryptedString = "";
        int keyIndex = 0;
        // Subtract the key from the string
        for(int i = 0; i < inputString.length(); i++){
            char c = inputString.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                decryptedString += (char)((c - key.charAt(keyIndex) + 26) % 26 + 'A');
                keyIndex = (keyIndex + 1) % key.length();
            }
            else{
                decryptedString += c;
            }
        }
        System.out.println("Decrypted string: " + decryptedString);
    }
}