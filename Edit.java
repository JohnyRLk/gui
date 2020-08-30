

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Edit {
   
    public void Edit(JTable table, Object number){
        DefaultTableModel table_template = (DefaultTableModel)table.getModel();
        int table_template_number = (int)number -1;
        Object name = table_template.getValueAt(table_template_number, 0);
        Object noname = table_template.getValueAt(table_template_number, 1);
        Object position = table_template.getValueAt(table_template_number, 2);
        Object experience = table_template.getValueAt(table_template_number, 3);
        Object  salary = table_template.getValueAt(table_template_number, 4);

        JFrame frame = new JFrame();
        frame.setBounds(0,0,650,450);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        JLabel name_label = new JLabel("imie");
        name_label.setBounds(40,20,180,20);
        frame.add(name_label);

        JTextField name_edit = new JTextField();
        name_edit.setBounds(250,20,250,20);
        name_edit.setText(String.valueOf(name));
        frame.add(name_edit);
        JLabel noname_label = new JLabel("nazwisko");
        noname_label.setBounds(40,50,180,20);
        frame.add(noname_label);

        JTextField noname_edit = new JTextField();
        noname_edit.setBounds(250,50,250,20);
        noname_edit.setText(String.valueOf(noname));
        frame.add(noname_edit);

        JLabel position_label = new JLabel("stanowisko");
        position_label.setBounds(40,80,180,20);
        frame.add(position_label);
        

        JTextField position_edit = new JTextField();
        position_edit.setBounds(250,80,250, 20);
        position_edit.setText(String.valueOf(position));
        frame.add(position_edit);

        JLabel experience_label = new JLabel("doswiadczenie");
        experience_label.setBounds(40,110,180,20);
        frame.add(experience_label);

        JTextField experience_edit = new JTextField();
        experience_edit.setText(String.valueOf(experience));
        experience_edit.setBounds(250,110,250, 20);
        frame.add(experience_edit);

        JLabel salary_label= new JLabel("wyplata");
        salary_label.setBounds(40,140,180,20);
        frame.add(salary_label);

        JTextField salary_edit = new JTextField();
        salary_edit.setBounds(250,140,250, 20);
        salary_edit.setText(String.valueOf(salary));
        frame.add(salary_edit);

        JButton change= new JButton("Zapisz zmiany");
        change.setBounds(250,190,190,20);;
        frame.add(change);

        
        LoadTable table_value = new LoadTable();
        change.addActionListener(e -> table_value.Chenge(table, name_edit.getText(), noname_edit.getText(), position_edit.getText(), experience_edit.getText(), salary_edit.getText(), table_template_number));
        change.addActionListener(e -> frame.setVisible(false));






    }
}