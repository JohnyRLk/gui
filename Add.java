
    import javax.swing.*;


public class Add {
    public void Add(JTable table) {

        JFrame frame = new JFrame();
        frame.setBounds(0,0,650,450);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        JLabel name_label = new JLabel("imie");
        name_label.setBounds(40,20,180,20);
        frame.add(name_label);

        JTextField name_add= new JTextField();
        name_add.setBounds(250,20,250,20);
        frame.add(name_add);

        JLabel noname_label = new JLabel("nazwisko");
        noname_label.setBounds(40,50,180,20);
        frame.add(noname_label);

        JTextField noname_add= new JTextField();
        noname_add.setBounds(250,50,250,20);
        frame.add(noname_add);

        JLabel position_label = new JLabel("stanowisko");
        position_label.setBounds(40,80,180,20);
        frame.add(position_label);
        

        JTextField position_add = new JTextField();
        position_add.setBounds(250,80,250, 20);
        frame.add(position_add);

        JLabel experience_label= new JLabel("doswiadczenie");
        experience_label.setBounds(40,110,180,20);
        frame.add(experience_label);

        JTextField experience_add = new JTextField();
        experience_add.setBounds(250,110,250, 20);
        frame.add(experience_add);

        JLabel salary_label= new JLabel("pensja");
        salary_label.setBounds(40,140,180,20);
        frame.add(salary_label);

        JTextField salary_add = new JTextField();
        salary_add.setBounds(250,140,250, 20);
        frame.add(salary_add);

        JButton add= new JButton("Dodaj pracownika");
        add.setBounds(250,190,190,20);
        frame.add(add);

        LoadTable table_value = new LoadTable();
        add.addActionListener(e -> table_value.Add(table, name_add.getText(),noname_add.getText(), position_add.getText(), salary_add.getText(), experience_add.getText()));
        add.addActionListener(e -> frame.setVisible(false));
   
    }
   
}
