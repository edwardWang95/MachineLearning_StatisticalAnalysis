package Machine_Learning.OR_XOR;

/**
 * Reference link:
 * http://stackoverflow.com/questions/4719633/java-simple-neural-network-setup
 * Created by edwardwang on 8/16/16.
 */
public class OR_XOR_Manager {
    public static void main (String [] args) {
        OR_XOR_Perceptron xor = new OR_XOR_Perceptron(0.5f);
        OR_XOR_Perceptron left = new OR_XOR_Perceptron(1.5f);
        OR_XOR_Perceptron right = new OR_XOR_Perceptron(0.5f);
        left.setWeight(-1.0f);
        right.setWeight(1.0f);
        xor.connect(left, right);

        for (String val : args) {
            OR_XOR_Perceptron op = new OR_XOR_Perceptron(0.0f);
            op.setWeight(Boolean.parseBoolean(val));
            left.connect(op);
            right.connect(op);
        }

        xor.fire();

        System.out.println("Result: " + xor.isFired());

    }
}
