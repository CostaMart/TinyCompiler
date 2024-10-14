package it.unisannio.paradigmi.symbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private final Map<String, List<Record>> table = new HashMap<String, List<Record>>();

    public void put(String name, String identifier, int type, int beginLine, int endLine, int beginColumn, int endColumn){
        if (!table.containsKey(name)) table.put(name, new ArrayList<Record>());
        List<Record> l = table.get(name);
        l.add(new Record(identifier, type, beginLine, endLine, endColumn, beginColumn));
    }
    //  lol
    // Metodo per stampare la symbol table
    public void printTable() {
        System.out.println("\n\n");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s%n", "Identificatore", "Tipo", "ILinea", "FLinea", "IColonna", "FColonna");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, List<Record>> entry : table.entrySet()) {
            List<Record> records = entry.getValue();

            for (Record record : records) {
                System.out.printf("%-20s %-10d %-10d %-10d %-10d %-10d%n",
                        record.identifier, record.type, record.beginLine, record.endLine,
                        record.beginColumn, record.endColumn); // Rimosso l'ambito dalla stampa
            }
        }
    }


    class Record {

        String identifier;
        int type;
        int beginLine;
        int endLine;
        int endColumn;
        int beginColumn; // dimensione in byte

        public Record(String identifier, int type, int beginLine, int endLine, int endColumn, int beginColumn) {
            this.identifier = identifier;
            this.type = type;
            this.beginLine = beginLine;
            this.endLine = endLine;
            this.endColumn = endColumn;
            this.beginColumn = beginColumn;

        }
    }

}
