package Machine_Learning.OR_XOR;

import java.util.ArrayList;

/**
 * Created by edwardwang on 8/16/16.
 */
public class OR_XOR_Perceptron {
    private ArrayList<OR_XOR_Perceptron> inputs;
    private float weight;
    private float threshhold;
    private boolean fired;

    public OR_XOR_Perceptron (float t) {
        threshhold = t;
        fired = false;
        inputs = new ArrayList();
    }

    public void connect (OR_XOR_Perceptron ... ns) {
        for (OR_XOR_Perceptron n : ns) inputs.add(n);
    }

    public void setWeight (float newWeight) {
        weight = newWeight;
    }

    public void setWeight (boolean newWeight) {
        weight = newWeight ? 1.0f : 0.0f;
    }

    public float getWeight () {
        return weight;
    }

    public float fire () {
        if (inputs.size() > 0) {
            float totalWeight = 0.0f;
            for (OR_XOR_Perceptron n : inputs) {
                n.fire();
                totalWeight += (n.isFired()) ? n.getWeight() : 0.0f;
            }
            fired = totalWeight > threshhold;
            return totalWeight;
        }
        else if (weight != 0.0f) {
            fired = weight > threshhold;
            return weight;
        }
        else {
            return 0.0f;
        }
    }

    public boolean isFired () {
        return fired;
    }
}
