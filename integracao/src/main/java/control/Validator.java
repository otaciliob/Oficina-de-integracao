package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        System.out.println(validateDate(date));*/
    }
    /*
        Verifica se uma data e valida
        data sera valida se o retorno for verdadeiro-(True)
    */
    public static boolean validateDate(String data){
        LocalDate before = LocalDate.parse( data, f);
        return before.isAfter(LocalDate.now());
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

}
