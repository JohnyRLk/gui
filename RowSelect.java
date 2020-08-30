
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RowSelect {
    public  void Select(JTable table){

        DefaultTableModel table_template = (DefaultTableModel) table.getModel();

        if(table_template.getRowCount() > 0){

            JFrame frame_edit = new JFrame();
            frame_edit.setBounds(100, 100, 400, 100);
            frame_edit.getContentPane().setLayout(null);
            frame_edit.setResizable(false);
            frame_edit.setVisible(true);
   
            SpinnerNumberModel choose_value = new SpinnerNumberModel(0, 0, table_template.getRowCount(), 1);
            JSpinner value = new JSpinner(choose_value);
            value.setBounds(170, 20, 100, 20);
            JComponent editor = value.getEditor();
            ((JSpinner.DefaultEditor) editor).getTextField().setEditable(false);
            frame_edit.add(value);
            
            JButton accept = new JButton("Akceptuj");
            accept.setBounds(280, 20, 100, 20);
            frame_edit.add(accept);

            JLabel number_row = new JLabel("Podaj numer wiersza");
            number_row.setBounds(20,20,150,20);
            frame_edit.add(number_row);

            Edit new_edit = new Edit();
            accept.addActionListener(e -> new_edit.Edit(table, value.getValue()));
            accept.addActionListener(e -> frame_edit.setVisible(false));
        }else{
            JFrame information = new JFrame();
            information.setBounds(100, 100, 300, 100);
            information.getContentPane().setLayout(null);
            information.setResizable(false);
            information.setVisible(true);
            JLabel messege = new JLabel("Tabela nie posiada danych do edycji");
            messege.setBounds(20, 20, 230, 20);
            information.add(messege);
        }

    }
}