
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class GUITable extends DefaultTableModel {

  DefaultTableModel model = new DefaultTableModel();
  JPanel panel = new JPanel();
  JTable table = new JTable();
  JButton load = new JButton("Wczytaj plik");
  JFrame frame = new JFrame();
  JButton add = new JButton("Dodaj");
  JButton delete = new JButton("Usun");
  JButton edit = new JButton("Edytuj");
  JButton save = new JButton("Zapiz");
  JTextField find_field = new JTextField("Szukaj Pracownika");
  JTextField sort_more = new JTextField("Wieksze");
  JTextField sort_less = new JTextField("Mniejsze");
  TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
 

  GUITable() {

    String[] columnNames = { "Imie", "Nazwisko", "Stanowisko", "Doswiadczenie", "Wyplata" };

    model.setColumnIdentifiers(columnNames);

    table = new JTable(model);

    JScrollPane sp = new JScrollPane(table);

    table.setEnabled(false);
    table.setBackground(Color.white);
    table.setForeground(Color.black);
    Font size = new Font("", 1, 16);
    table.setFont(size);
    table.setRowHeight(28);
    table.setBounds(40, 50, 220, 520);
    frame.setContentPane(panel);
    frame.pack();

    panel.add(table);
    sp.setVisible(true);
    frame.add(sp);
    frame.setTitle("Dane Pracownikow");
    save.setBounds(150, 220, 100, 25);
    load.setBounds(150, 220, 100, 25);
    add.setBounds(150, 265, 100, 25);
    edit.setBounds(150, 310, 100, 25);
    delete.setBounds(150, 350, 100, 25);
    panel.add(load);
    panel.add(add);
    panel.add(delete);

    delete.setBackground(Color.red);
    panel.add(edit);
    panel.add(save);
    panel.add(find_field);
    JScrollPane scroll = new JScrollPane(table);
    frame.add(scroll);
    frame.setSize(500, 200);
    frame.setVisible(true);
    table.setRowSorter(sorter);

    find_field.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        String text = find_field.getText();

        if (text.trim().length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        String text = find_field.getText();

        if (text.trim().length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("");
      }

    });
    RowFilter<TableModel, Object> select_salary = new RowFilter<>() {
      @Override
      public boolean include(Entry<? extends TableModel, ? extends Object> entry) {
        String text = sort_more.getText();
        int foo;
try {
   foo = Integer.parseInt(text);
}
catch (NumberFormatException e)
{
   foo = 0;
}

        int x = Integer.parseInt(entry.getStringValue(4));
        return x > foo;
      }
    };
    sort_more.addActionListener(new ActionListener()  {
      private boolean filter = true;
      @Override
      public void actionPerformed(ActionEvent arg0) {
      if (filter)
      sorter.setRowFilter(select_salary );
      else
      sorter.setRowFilter(null);
  filter = !filter;
}
      
    });
    panel.add(sort_more);

    RowFilter<TableModel, Object> select_less= new RowFilter<>() {
      @Override
      public boolean include(Entry<? extends TableModel, ? extends Object> entry) {
          String text = sort_less.getText();
          int foo;
  try {
     foo = Integer.parseInt(text);
  }
  catch (NumberFormatException e)
  {
     foo = 0;
  }
  
        int x = Integer.parseInt(entry.getStringValue(4));
        return x < foo;
      }
    };
    sort_less.addActionListener(new ActionListener()  {
      private boolean filter = true;
      @Override
      public void actionPerformed(ActionEvent arg0) {
      if (filter)
      sorter.setRowFilter(select_less );
      else
      sorter.setRowFilter(null);
  filter = !filter;
}
      
    });
    panel.add(sort_less);
   

    LoadTable Table = new LoadTable();
    Delete delete_row = new Delete();
    RowSelect edit_row = new RowSelect();
    Add added = new Add();
    load.addActionListener(e -> Table.loadData(table));
    add.addActionListener(e -> added.Add(table));
    edit.addActionListener(e -> edit_row.Select(table));
    delete.addActionListener(e -> delete_row.Delete(table));
    save.addActionListener(e -> Table.Save(table));
  }

  public static void main(String[] args) {
    new GUITable();
  }
}
