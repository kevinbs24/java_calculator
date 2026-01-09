package calculator.engine;

public class EngineConsoleTest {

    public static void main(String[] args) {
        CalculatorEngine engine = new CalculatorEngine();

        /*test(engine, "3 + 4 * 2", 11);
        test(engine, "10 / 2 + 3", 8);
        test(engine, "8 - 3 * 2", 2);
        test(engine, "6 + 2 * 3 - 1", 11);*/
        
        test(engine, "2 + 3 * 4", 14);
        test(engine, "(2 + 3) * 4", 20);     
        test(engine, "10 / (5 - 3)", 5);     
        test(engine, "(1 + 2) * (3 + 4)", 21);
    }

    private static void test(CalculatorEngine engine, String expr, double expected) {
        double result = engine.evaluate(expr);
        System.out.println(expr + " = " + result + 
            (result == expected ? " ✅" : " ❌ expected " + expected));
    }
}