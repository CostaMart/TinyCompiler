package it.unisannio.symbolTable;

public class SymbolTableFactory {
	
	static SymbolTable symbol;
	
	public static SymbolTable getInstance() {
		if (symbol == null) {
            symbol = new SymbolTable();
            }
		return symbol;
	}

}
