public class SortingAlgorithms {
    private int[] data = new int[] {5,7,4,6,1,10,9,3,8,2};
    private int size=10;

    void insertionSort(){
        int tmp,j=0;
        for(int i=1;i<size;i++){
            if(data[i]<data[i-1]) {
                j=i-1;
                while (j>=0 && data[i]<data[j]) {
                    j--;
                }
                if(j!=-1) {
                    tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }
    void selectSort(){

    }

    void mergeSort(){

    }
    void quickSort(){

    }
    void heapSort(){

    }

    public static void main(String[] args){
        SortingAlgorithms sortingAlgo = new SortingAlgorithms();
        sortingAlgo.insertionSort();
    }
}
