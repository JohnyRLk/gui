import javax.swing.*;

public class Inormation {
    public static void informationUser(String info){

        JFrame infoFrame = new JFrame();
        infoFrame.setBounds(100,100,300,100);
        infoFrame.getContentPane().setLayout(null);
        infoFrame.setResizable(false);
        infoFrame.setVisible(true);
        JLabel massege = new JLabel(info);
        massege.setBounds(20, 20, 230, 20);
        infoFrame.add(massege);
    }
}