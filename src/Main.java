import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String login, pass;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Авторизация");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width= 600, height=300;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JOptionPane pane = new JOptionPane();
        if (pane.showConfirmDialog(frame, "Вы хотите зарегистрироваться?", "Вопрос", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
            while (true) {
                login = pane.showInputDialog(frame, "Введите логин", "Логин", JOptionPane.QUESTION_MESSAGE);
                if (login==null)
                    System.exit(0);
                else
                    if (login.length()>5&&login.lastIndexOf(" ")==-1) break;
            }

            JPasswordField pf = new JPasswordField();
            while (true) {
                if (pane.showConfirmDialog(frame, pf, "Введите пароль для логина "+login, JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) //если нажата отмена, то выходим из приложения
                    System.exit(0);
                else {
                    pass = new String(pf.getPassword());
                    if (pass.length() > 8 && // Проверка длины
                            pass.lastIndexOf(" ") == -1 && // Проверка пробелов
                            pass.chars().filter(Character::isDigit).count() > 0 && // Проверка на минимум 1 цифру
                            pass.chars().filter(Character::isLetter).count() > 0) // Проверка на минимум 1 букву
                        break;
                }
            }
            pf.setText(""); // Обнуляем пароль в диалоге для ввода нового
            while (true) {
                if (pane.showConfirmDialog(frame, pf, "Повторите пароль для логина "+login, JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) // Если нажата отмена, то завершаем работу программы
                    System.exit(0);
                else  // Иначе проверяем пароль, и если он совпадает, то выходим из цикла
                    if (new String(pf.getPassword()).equals(pass))//
                        break;
            }
            pane.showMessageDialog(frame,"Вы успешно зарегистрировались","Успешная регистрация", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(true);
        }
        else  System.exit(0);
    }
}