package array;

public class sorting {
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return this.array;
    }

    public void sortArray() {
        int temp;
		for(int i = 1; i < this.array.length; i++){
			for (int j = 0; j < this.array.length - i; j++){
				if(this.array[j] > this.array[j+1]){
					temp = this.array[j];
					this.array[j] = this.array[j+1];
					this.array[j+1] = temp;
				}
			}	
		}
    }
}
