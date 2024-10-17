package it.unisannio.paradigmi.symbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    // hash table -> records in the table are indexed by their lex
    private final Map<String, List<Record>> table = new HashMap<String, List<Record>>();

    // create a new record in the table
    public void put(String lex, int token, int beginLine, int endLine, int beginColumn, int endColumn){
        if (!table.containsKey(lex)) table.put(lex, new ArrayList<Record>());
        List<Record> l = table.get(lex);
        l.add(new Record(token, beginLine, endLine, endColumn, beginColumn));
    }

    // get record info using lex and position in text
    public Record getRecord(String lex,  int beginLine, int beginColum){
        List<Record> l = table.get(lex);
        if (l == null) return null;
        return l.stream().filter((r)-> r.beginColumn == beginColum && r.beginLine == beginLine).findFirst().orElse(null);
    }

    // Metodo per stampare la symbol table
    public void printTable() {
        for (Map.Entry<String, List<Record>> entry : table.entrySet()) {
            List<Record> records = entry.getValue();

            // Stampa l'intestazione della tabella per ogni entry
            System.out.println("\n\n");
            System.out.printf("Tabella per lessema: %s%n", entry.getKey());
            System.out.printf("%-10s %-10s %-10s %-10s %-10s%n", "token", "ILinea", "FLinea", "IColonna", "FColonna");
            System.out.println("--------------------------------------------------------------");

            // Stampa i record associati a quella chiave
            for (Record record : records) {
                System.out.printf("%-10s %-10d %-10d %-10d %-10d%n",
                        record.token, record.beginLine, record.endLine,
                        record.beginColumn, record.endColumn);
            }

            System.out.println("--------------------------------------------------------------");
        }
    }




    public class Record {
        int token; // token
        int beginLine; // punto di inizio del lessema nel codice (rispetto alla linea)
        int endLine; // punto di fine lessema nel codice (rispetto alla linea)
        int beginColumn; // punto di inizio lessema nel codice (rispetto alla colonna)
        int endColumn; // punto di fine lessema nel codice (rispetto alla colonna)

        public Record(int token, int beginLine, int endLine, int endColumn, int beginColumn) {
            this.token = token;
            this.beginLine = beginLine;
            this.endLine = endLine;
            this.endColumn = endColumn;
            this.beginColumn = beginColumn;
        }


        public int getToken() {
            return token;
        }

        public int getBeginLine() {
            return beginLine;
        }

        public int getEndLine() {
            return endLine;
        }

        public int getEndColumn() {
            return endColumn;
        }

        public int getBeginColumn() {
            return beginColumn;
        }

    }

}
