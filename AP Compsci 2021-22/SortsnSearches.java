
public class SortsnSearches{
    public static void main(String args[]){
        //Sorts
        int[] arr = new int[10];//Changes length of array
        Sorts sort = new Sorts();
        System.out.println("Sorts");
        
        //Selection Sort
        System.out.println("Selection Sort- ");
        sort.Selection(arr);
        System.out.println("");
        
        //Insertion Sort
        System.out.println("Insertion Sort- ");
        sort.Insertion(arr);
        System.out.println("");
        
        //Merge Sort
        System.out.println("Merge Sort- ");
        sort.shuffle(arr);
        System.out.print("Unsorted- ");
        sort.print(arr);
        System.out.print("Sorted- ");
        sort.print(sort.Merge(arr));
        System.out.println("");
        
        
        //Searches
        Searches search = new Searches();
        int n = 5;//The number you are searching for in the search
        arr=sort.Merge(arr);//comment if you want to see Linear Search with an unsorted array
        System.out.println("Searches");
        System.out.print("Array Getting Searched- ");
        sort.print(arr);
        System.out.println("");
        
        //Linear Search
        System.out.println("Linear Search- ");
        search.Linear(arr,n);
        System.out.println("");
        
        
        //Binary Search
        System.out.println("Binary Search- ");
        search.Binary(arr,n);
        System.out.println("");
        
        
    }
}

class Sorts{
    public Sorts(){}
    
    //Sorts array using Selection Sort
    public void Insertion(int[] arr){
        shuffle(arr);//Creates random array
        System.out.print("Unsorted- ");
        print(arr);//Prints that random array
        int temp = 0;
        int k = 0;
        for(int i=1; i<arr.length; i++){
            temp = arr[i];
            k = i;
            while (k>0 && arr[k-1]>temp){//if the number before index is bigger than index
                arr[k] = arr[k-1];//Moves eveything to the right
                k = k-1;
            }
            arr[k] = temp;
        }
        System.out.print("Sorted- ");
        print(arr);//Prints storted array
    }
    
    //Sorts array using Merge Sort(Splits them up)
    public int[] Merge(int[] arr){
        if(arr.length==1)
            return arr;
        int[] a = new int[arr.length/2];
        int[] b = new int[arr.length-(arr.length/2)];
        //fills array a
        for(int i=0; i<a.length; i++){
            a[i]=arr[i];
        }
        //fills array b
        for(int i=0; i<b.length; i++){
            b[i]=arr[i+a.length];
        }
        a = Merge(a);//splits first half
        b = Merge(b);//splits second half
        return Merger(a,b);//Sorts split arrays
    }
    
    //Helps sort Merge arrays(Puts em together)
    public int[] Merger(int[] a, int[] b){
        int ai = 0;//Index for a
        int bi = 0;//Index for b
        int ci = 0;//Index for c
        int[] c = new int[a.length+b.length];//combined array
        while(ai<a.length&&bi<b.length){//Checks if both arrays are empty (get to the end)
            if(a[ai]>=b[bi]){
                c[ci]=b[bi];
                bi++;
            }
            else{
                c[ci]=a[ai];
                ai++;
            }
            ci++;
        }
        while(ai<a.length){//Runs if a is not empty
            c[ci]=a[ai];
            ai++;
            ci++;
        }
        while(bi<b.length){//Runs if b is not empty
            c[ci]=b[bi];
            bi++;
            ci++;
        }
        return c;//Returs sorted Array
    }
    
    //Sorts array using Selection Sort
    public void Selection(int[] arr){
        shuffle(arr);//Creates random array
        System.out.print("Unsorted- ");
        print(arr);//Prints that random array
        int temp = 0;
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            min=arr[i];
            for(int k=i+1; k<arr.length; k++){
                if(arr[k]<min){//If a new min is found it sets min to value and remembers place
                    min = arr[k];
                    temp = k;//remembers k/index for when out of loop
                }
            }
            //Checks if num has changed
            if(min != arr[i]){//If it has nothing changes and skips number
                arr[temp]=arr[i];
                arr[i]=min;
            }
        }
        System.out.print("Sorted- ");
        print(arr);//Prints storted array
    }
    
    //Shuffles Array
    public void shuffle(int[] arr){
        for(int i=0; i<arr.length; i++){//fills array
            arr[i]= (int)(Math.random()*20+1);
        }
    }
    
    //Prints Arrays
    public void print(int[] arr){
        for(int i=0; i<arr.length; i++){//fills array
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}

class Searches{
    public Searches(){}
    
    //Linear Search
    //Array can be sorted or unsorted
    public void Linear(int[] arr, int num){
        int index = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==num){
                index = i;
                break;//Stops loop when num is found
            }
        }
        if(index != -1)
            System.out.println(num+" is at place "+index+" in the array");
        else
            System.out.println(num+" was not found in the array");
    }
    
    //Binary Search
    //Array has to be sorted
    public void Binary(int[] arr, int num){
        int index = -1;
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;
        while(index == -1){//Stops when an index is found
            if(start>end)
                break;//Stops array if index isn't found
            if(arr[mid]<num){
                start=mid+1;
            }
            if(arr[mid]>num){
                end=mid-1;
            }
            if(arr[mid]==num)
                index = mid;
            mid = (start+end)/2;//Sets mid to the middle of the array
        }
        if(index != -1)
            System.out.println(num+" is at place "+index+" in the array");
        else
            System.out.println(num+" was not found in the array");
    }
}