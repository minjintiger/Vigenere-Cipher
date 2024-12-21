# Vigenere-Cipher

This cipher has a keyword with an alphabetic string of length m. It encrypts m alphabetic characters at a time by adding from the plaintext.
For decryption, using same keyword as used before in encryption, It decrypts m alphabetic characters by substracting from the ciphertext.

Suppose m = 4 and the keyword is LOVE,

Example(Encryption)

    Input: VIGENERE

    Input(in mod 26):   21    8    6    4    13    4    17    4
    Key:             +  11   14   21    4    11   14    21    4 
                        ---------------------------------------
    Output(in mod 26):   6   22    1    8    24   18    12    8           

    Output: GWBIYSMI

Example(Decryption)

    Input: GWBIYSMI

    Input(in mod 26):    6   22    1    8    24   18    12    8
    Key:             -  11   14   21    4    11   14    21    4 
                        ---------------------------------------
    Output(in mod 26):  21    8    6    4    13    4    17    4           

    Output: VIGENERE
