
public class Neuron {
	public float[] weights; 
	public float output; 
	
	public float learnRate=0.02f; 
	
	public Neuron(int size) {
		weights= new float[size]; 
		for (int i=0; i<size; i++) {
			weights[i]=(float)Math.random(); 
		}
	}
	
	//---------Compute----------------
	public void compute(float[] img) {
		output=0; 
		for (int i=0; i<weights.length; i++) {
			output+=(img[i]-weights[i])*(img [i]-weights[i]); 
		}
		output = (float) Math.sqrt(output); 
	}

	//---------Learn----------------
	public void learn(float[] img, float ratio) {
		for (int i=0; i<weights.length; i++) {
			weights[i]+=learnRate * ratio * (img[i]-weights[i]); 
		}
	}

}
