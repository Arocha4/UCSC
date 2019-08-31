// Anotine Rocha
// arocha4
// pa5
// This program solves the Queens problem.
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public class Queens {
    
    public static void main(String[] args){
        
        boolean verbose = false;
        int n = 0, solutions = 0, i;
      
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        try{
            n = Integer.parseInt(args[0]);
        }catch(NumberFormatException e1){     
            if(args[0].equals("-v")){
                verbose = true;  
            }
            else{
                System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
                return;
            
	}
        }catch(ArrayIndexOutOfBoundsException e2){
            System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
            return;
        

	}
        try{
            n = Integer.parseInt(args[1]);
        }catch(NumberFormatException e3){
            System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
            return;
        
	}catch(ArrayIndexOutOfBoundsException e4){    
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        

	int[] board = new int[n + 1];   
        
        for(i = 1; i <= board.length - 1; i++)  
            board[i] = i;
        
        for(i = 1; i <= factorial(n); i++){ 
            nextPermutation(board);     

            if(isSolution(board)){     
                solutions++;
                if(verbose)
                    printArray(board);
            }
           
        }
        System.out.println(n + "-Queens has " + solutions + " solutions");
 
    }
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    

	static void nextPermutation(int[] A){
        int pivot = 0, successor = 0;
        
        for(int i = A.length  - 2; i > 0; i--){ 
            if(A[i] < A[i + 1]){  
                pivot = i;
                break;
            }
        }
        if(pivot == 0){
            reverse(A, 1);
            return; 
            }
        
        for(int i = A.length - 1; i > pivot; i--){
            if(A[i] > A[pivot]){
                successor = i;
                break;
            }
        }
        swap(A, pivot, successor);
        reverse(A, pivot + 1);

        return;
        
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    

	static boolean isSolution(int[] A){      
        int i, j;
        
        for(i = 2; i < A.length; i++){
            for(j = 1; j < i; j++){
                if(A[j] - A[i] == i - j)
                    return false; 
                if(A[i] - A[j] == i - j)
                    return false;
            }
        }
        return true;
    }
    
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    

	static void swap(int[] Q, int i, int j){     
        int temp = Q[i];
        Q[i] = Q[j];
        Q[j] = temp;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    

	static void reverse(int[] T, int i){
        int j = T.length - 1;
        while(i < j){
           swap(T, i, j);
           i++;
           j--;
        }
     }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    	

	static int factorial(int n){
        int i, result = 1;
        
        for(i = 1; i <= n; i++)
            result *= i;
        
        return result;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
	static void printArray(int[] A){
        System.out.print("(");
        for(int i = 1; i < A.length - 2; i++)
            System.out.print(A[i] + ", ");
        System.out.println(A[A.length - 1] + ")");
    }
}

