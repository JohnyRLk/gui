
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Delete {
    public void Delete(JTable table) {
        DefaultTableModel table_template = (DefaultTableModel) table.getModel();
        if (table_template.getRowCount() > 0) {
            JFrame frame = new JFrame();
            frame.setBounds(100, 100, 400, 100);
            frame.getContentPane().setLayout(null);
            frame.setResizable(false);
            frame.setVisible(true);

            JLabel row = new JLabel("Numer wiersza do usuniecia");
            row.setBounds(20, 20, 150, 20);
            frame.add(row);

            SpinnerNumberModel choose_value = new SpinnerNumberModel(0, 0, table_template.getRowCount(), 1);
            JSpinner value = new JSpinner(choose_value);
            value.setBounds(170, 20, 100, 20);
            JComponent delete_value = value.getEditor();
            ((JSpinner.DefaultEditor) delete_value).getTextField().setEditable(false);
            frame.add(value);

            JButton delete = new JButton("Usun");
            delete.setBounds(280, 20, 100, 20);
            frame.add(delete);

            LoadTable table_value = new LoadTable();
            delete.addActionListener(e -> table_value.Delete(table, (int) value.getValue()));
            delete.addActionListener(e -> frame.setVisible(false));
        } else {
            JFrame information = new JFrame();
            information.setBounds(100, 100, 300, 100);
            information.getContentPane().setLayout(null);
            information.setResizable(false);
            information.setVisible(true);

            JLabel messege = new JLabel("Tabela nie posiada danych do usuniecia");
            messege.setBounds(20, 20, 230, 20);
            information.add(messege);
        }

    }
}