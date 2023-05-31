package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import model.dao.EmprestimoDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aluno
 */
public class Validator {

    private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    public static void main(String[] args) {

        /*String password = "MinhaSenha@123";
            boolean hasSpecialChars = validatePassword(password);
            System.out.println("A senha contém caracteres especiais? " + hasSpecialChars);
            System.out.println(validateRG("410670327"));
            String date = "01/06/2023";
            System.out.println(f.format(LocalDate.now()));
            System.out.println(LocalDate.parse(date, f));
            System.out.println(LocalDate.now());
            System.out.println(validateDate(date));
            EmprestimoDao Dao = new EmprestimoDao();
            System.out.println(Dao.restricao2(116743815));*
            String senha = "senha123";
            String hash;
            try {
            hash = gerarHash("senha");
            System.out.println("hash armazenado: "+hash);
            System.out.println("igual ?:"+validateHash("senha123", hash));
            } catch (Exception ex) {
            //Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Deu Ruim -|-" + ex);
            }*/
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            System.out.println(algorithm);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        Verifica se uma data e valida
        data sera valida se o retorno for verdadeiro-(True)
     */
    public static boolean validateDate(String data) {
        LocalDate depois = LocalDate.parse(data, f);
        return depois.isAfter(LocalDate.now());
        //retorna true se a data recebida via paramentro vem depois da data atual
    }

    public static boolean validateDate(LocalDate data) {
        return data.isAfter(LocalDate.now());
        //retorna true se a data recebida via paramentro vem depois da data atual
    }

    /* Verifica se uma senha e valida
        senha sera valida se o retorno for verdadeiro (True)
     */
    public static boolean validatePassword(String password) {
        String specialChars = "!@#$%^&*_=+-/.,";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (specialChars.contains(String.valueOf(c))) {
                return true;
            }
        }

        return false;
    }

    /* Verifica se um RG e valido
        RG sera valido se o retorno for verdadeiro (True)
     */
    public static boolean validateRG(String rg) {
        //lenght 9
        int[] matriz = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int result = 0;
        try {
            for (int i = 0; i < 8; i++) {

                matriz[i] = Integer.parseInt(String.valueOf(rg.charAt(i)));
                result = result + (matriz[i] * (i + 2));

            }
            result = 11 - Integer.remainderUnsigned(result, 11);
            System.out.println(result);

            return result == Integer.parseInt(String.valueOf(rg.charAt(8)));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }

    }

    public static String gerarHash(String senha) throws Exception {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder texto = new StringBuilder();
        for (byte b : hash) {
            texto.append(String.format("%02X", 0xFF & b));
        }
        return texto.toString();
    }

    public static boolean validateHash(String recebido, String armazenado) throws Exception {
        String result = gerarHash(recebido);
        System.out.println("hash da mesma string:" + result);
        return (armazenado.equals(result));
    }

}
