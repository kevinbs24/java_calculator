package calculator.engine;

public enum Operator {

	ADD('+', 1),
	SUBTRACT('-', 1),
	MULTIPLY('*', 2),
	DIVIDE('/', 2);
	
	public final char symbol;
	public final double precedence;
	
	Operator(char symbol, int precedence) {
		this.symbol = symbol;
		this.precedence = precedence;
	}

	public static Operator fromChar(char c) {
		
		for(Operator op:values()) {
			
			if(op.symbol == c) 
				return op;
		}
			throw new IllegalArgumentException("Unknown Operator " + c);
	}
	
	public double apply(double a, double b) {
		
		switch(this) {
		
		case ADD : return a + b;
		case SUBTRACT : return a - b;
		case MULTIPLY : return a * b;
		case DIVIDE : return a / b;
		}
		throw new IllegalStateException("Unexpected operator");
	}
}
