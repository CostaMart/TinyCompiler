package it.unisannio.paradigmi.symbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    // hash table -> keys are integer because tokens are treated like enums in JavaCC. If you want to check the value go to ...Constants.java JavaCC generated file
    private final Map<Integer, List<Record>> table = new HashMap<Integer, List<Record>>();

    public void put(int token, String value, int beginLine, int endLine, int beginColumn, int endColumn){
        if (!table.containsKey(token)) table.put(token, new ArrayList<Record>());
        List<Record> l = table.get(token);
        l.add(new Record(value, beginLine, endLine, endColumn, beginColumn));
    }

    public Record getRecord(int token,  int beginLine, int beginColum){
        List<Record> l = table.get(token);
        if (l == null) return null;
        return l.stream().filter((r)-> r.beginColumn == beginColum && r.beginLine == beginLine).findFirst().orElse(null);
    }

    // Metodo per stampare la symbol table
    public void printTable() {
        System.out.println("\n\n");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s%n", "Kind (token)", "lessema", "ILinea", "FLinea", "IColonna", "FColonna");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<Integer, List<Record>> entry : table.entrySet()) {
            List<Record> records = entry.getValue();

            for (Record record : records) {
                System.out.printf("%-20s %-10s %-10d %-10d %-10d %-10d%n",
                        entry.getKey(), record.lex, record.beginLine, record.endLine,
                        record.beginColumn, record.endColumn); // Rimosso l'ambito dalla stampa
            }
        }
    }


    public class Record {
        String lex; // lessema
        int beginLine; // punto di inizio del lessema nel codice (rispetto alla linea)
        int endLine; // punto di fine lessema nel codice (rispetto alla linea)
        int beginColumn; // punto di inizio lessema nel codice (rispetto alla colonna)
        int endColumn; // punto di fine lessema nel codice (rispetto alla colonna)

        public Record(String lex, int beginLine, int endLine, int endColumn, int beginColumn) {
            this.lex = lex;
            this.beginLine = beginLine;
            this.endLine = endLine;
            this.endColumn = endColumn;
            this.beginColumn = beginColumn;
        }


        public String getLex() {
            return lex;
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
