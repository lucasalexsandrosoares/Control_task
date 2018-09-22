package jdbc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeraHash {
    private static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) s.append('0');
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    public static String gerarHash(String frase) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(frase.getBytes());
            return stringHexa(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
