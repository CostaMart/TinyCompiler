package esercizio1;


public class MyNumber {
	String type;
	String value;
	
	public MyNumber(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	public MyNumber multNumberDiv(String operator, MyNumber operator2) {
		
		if (this.type.equals("int") && operator2.type.equals("int")) {

		if (operator.equals("*")) {
			
			return new MyNumber("int",
					Integer.toString(Integer.parseInt(this.value) * Integer.parseInt(operator2.value)));
		} else {
			return new MyNumber("int",
					Integer.toString(Integer.parseInt(this.value) / Integer.parseInt(operator2.value)));
		} 
		
		} else {
			if (operator.equals("*")) {
				return new MyNumber("float",
						Double.toString(Double.parseDouble(this.value) * Double.parseDouble(operator2.value)));
			} else  {
				return new MyNumber("float",
						Double.toString(Double.parseDouble(this.value) / Double.parseDouble(operator2.value)));
			} 
		}
	}
	
	public MyNumber sumSubNumber(String operator, MyNumber operator2) {

		if (this.type.equals("int") && operator2.type.equals("int")) {

			if (operator.equals("+")) {
				return new MyNumber("int",
						Integer.toString(Integer.parseInt(this.value) + Integer.parseInt(operator2.value)));
			} else {
				return new MyNumber("int",
						Integer.toString(Integer.parseInt(this.value) - Integer.parseInt(operator2.value)));
			}

		} else {
			if (operator.equals("+")) {
				
				return new MyNumber("float",
						Integer.toString(Integer.parseInt(this.value) + Integer.parseInt(operator2.value)));
			} else {
				return new MyNumber("float",
						Integer.toString(Integer.parseInt(this.value) - Integer.parseInt(operator2.value)));
			}
		}
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
