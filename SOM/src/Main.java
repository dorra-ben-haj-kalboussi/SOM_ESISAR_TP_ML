
public class Main {
	private DisplayFrame display; 
	Neuron[][] SOM; 
	
	public float[] input; 
	
	public int nx=0; 
	public int ny=0; 
	public float min=1; 
	
	public Main() {
		
		//Initialize structures
		input = new float[3]; 
		
		SOM= new Neuron[20][20]; 
		for(int i=0; i<20; i++) {
			for (int j=0; j<20; j++) {
				SOM[i][j]= new Neuron(3); 
			}
		}
		
		// Initialize DisplayFrame
		display= new DisplayFrame(this); 
		
		for (int k=0; k<100000; k++) {
			for (int c=0; c<3; c++) {
				input[c]=(float) Math.random(); 
			}
			
			if (Math.random()<0.25) {
				input[0]=input[0]/4+0.75f; 
				input[1]=input[1]/4; 
				input[2]=input[2]/4; 
			}
					
					
			// Compute Neurons
			for (int i=0; i<20; i++) {
				for (int j=0; j<20; j++) {
					SOM[i][j].compute(input); 
				}
			}
		
		
			// Déterminer les coordonnées nx et ny du neurone avec la valeur minimale
			min=1; 
			for (int i=0; i<20; i++) {
				for (int j=0; j<20; j++) {
					if (SOM[i][j].output<min) {
						min=SOM[i][j].output; 
						nx=i; 
						ny=j; 
					}
				}
				
			}
			
			for (int i=0; i<20; i++) {
				for (int j=0; j<20; j++) {
					SOM[i][j].learn(input, neighbor((nx-i)*(nx-i)+(ny-j)*(ny-j))); 
				}
			}
			
		}
		display.repaint(); 
	
}
	
	// Mise à jour des neurones
	public float neighbor (float x) {
		return (float) Math.exp(-x/(8)); 
	}
	
	public static void main(String[] args) {
		new Main(); 
	}
}
