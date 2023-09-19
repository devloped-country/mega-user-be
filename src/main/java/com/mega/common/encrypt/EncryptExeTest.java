package com.mega.common.encrypt;

public class EncryptExeTest {

    public static void main(String[] args) {
        EncryptUtils encryptUtils = new EncryptUtils();

        String salt = encryptUtils.getSalt();

        System.out.println("salt = " + salt);

        String salt2 = new String(salt);

        String encrypt = encryptUtils.getEncrypt("찬현892201*", salt);
        String encrypt1 = encryptUtils.getEncrypt("찬현892201*", salt2);

        System.out.println(encrypt == encrypt1);

        System.out.println("encrypt = " + encrypt);
        System.out.println("encrypt1 = " + encrypt1);
    }
}
