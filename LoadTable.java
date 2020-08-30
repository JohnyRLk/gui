


import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;

public class LoadTable {
    public  void loadData(JTable table){
        {JFileChooser fileChooser = new JFileChooser();
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File document = fileChooser.getSelectedFile();
                try{
                    Scanner scanner = new Scanner(document);
                    int i  = 0;
                    FileReader file_read = new FileReader(document);
                    LineNumberReader line_number = new LineNumberReader(file_read);
                    line_number.skip(Long.MAX_VALUE);
                    i = line_number.getLineNumber();
                    DefaultTableModel  table_template = (DefaultTableModel) table.getModel();
                    int w;
                    w = i;
                    i =0;
                    for (int e = 0; e < w+1; e++){
                        String s = scanner.nextLine();
                        String holder [] = s.split(",");
                        String imie  = holder[0];
                        String nazwisko  = holder[1];
                        String stanowisko = holder[2];
                        String doswiadczenie = holder[3];
                        String wyplata = holder[4];
                            Object[] Row = {imie, nazwisko, stanowisko, doswiadczenie,wyplata};
                            table_template.addRow(Row);
                     }
                     scanner.close();
             }
            catch (FileNotFoundException ex) {
                Inormation.informationUser("Plik nie znaleziony");
             } catch (IOException e) {
                Inormation.informationUser("Blad podczasodczytu");
             }
             catch (IndexOutOfBoundsException | NoSuchElementException e) {
                Inormation.informationUser("Plik niepoprawnie zapisany");
              
            }
         }};


                };
                public void Add(JTable table, String name, String noname, String position, String experience, String salary){
                    DefaultTableModel table_template = (DefaultTableModel) table.getModel();
                    Object[] Row = {name,noname, position,experience,salary};
                    table_template.addRow(Row);            
                }
                public  void Chenge(JTable table,  String name, String noname, String position, String experience, String salary, int number){
                    DefaultTableModel table_template = (DefaultTableModel) table.getModel();
                    table_template.setValueAt(name, number, 0);
                    table_template.setValueAt(noname, number, 1);
                    table_template.setValueAt(position , number, 2);
                    table_template.setValueAt(experience, number, 3);
                    table_template.setValueAt(salary, number, 4);
                }
                public void Delete(JTable table, int number){
                    DefaultTableModel table_template = (DefaultTableModel) table.getModel();
                    table_template.removeRow(number - 1);
            
                }

                    public void Save(JTable table){
                        {JFileChooser save_file = new JFileChooser();
                        if(table.getRowCount() > 0){
                            if(save_file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                                File file = save_file.getSelectedFile();
                                try{
                                    FileWriter file_table = new FileWriter(file);
                                    for(int i = 0;  i<table.getRowCount(); i++){
                                        for(int j = 0; j < 5; j++){
                                            Object get_value_from = table.getValueAt(i, j);
                                            file_table.write(get_value_from.toString());
                                            if(j < 4)
                                                file_table.write(",");
                                            }
                                            file_table.write("\r\n");
                                        }
                                        file_table.close();
                                    
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }
                                }

                            }else{
                                Inormation.informationUser("Plik jest pusty");
                            }
                        }
                        }
                
                    }
                

