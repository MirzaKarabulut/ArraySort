class ArraySort
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArraySort(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }
   //--------------------------------------------------------------
public void oddEvenSort() {
    boolean sorted = false;
    int shift = 0; // Variable to track the total shift due to removing duplicates
    while (!sorted) {
        sorted = true;
        int numDuplicates = 0; // Track number of duplicates
        // Odd pass
        for (int j = 1; j < nElems - 1; j += 2) {
            if (a[j] == a[j + 1]) {
                a[j + 1] = -1; // Change one of the duplicates to -1
                numDuplicates++;
            } else if (a[j] > a[j + 1]) {
                swap(j, j + 1);
                sorted = false;
            }
        }
        // Even pass
        for (int j = 0; j < nElems - 1; j += 2) {
            if (a[j] == a[j + 1]) {
                a[j + 1] = -1; // Change one of the duplicates to -1
                numDuplicates++;
            } else if (a[j] > a[j + 1]) {
                swap(j, j + 1);
                sorted = false;
            }
        }
        nElems -= numDuplicates; // Adjust number of elements
        shift += numDuplicates; // Accumulate shift due to duplicates
    }
    // Shift array left to remove duplicates
    int index = 0;
    for (int i = 0; i < nElems; i++) {
        if (a[i] != -1) {
            a[index++] = a[i];
        }
    }
    nElems -= shift; // Adjust nElems after removing duplicates
}

   //--------------------------------------------------------------
   public void bubbleSort()
   {
      int out, in;

      for (out = nElems - 1; out > 1; out--) {
         // outer loop (backward)
         for (in = 0; in < out; in++) {
            if (a[in] == a[in + 1]) {
               a[in] = -1;
            } else if (a[in] > a[in + 1]) {
               swap(in, in + 1); // swap them
            } // out of order?
         } // inner loop (forward)
      }
      // Shift array left to remove duplicates
      int shift = 0;
      for (int i = 0; i < nElems; i++) {
         if (a[i] == -1) {
            shift++;
         } else {
            a[i - shift] = a[i];
         }
      }
      nElems -= shift;
   } // end bubbleSort()
//--------------------------------------------------------------
public void insertionSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                if (a[in - 1] == temp) {
                    temp = -1; // Change one of the duplicates to -1
                }
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }

        // Shift array left to remove duplicates
        int shift = 0;
        for (int i = 0; i < nElems; i++) {
            if (a[i] == -1) {
                shift++;
            } else {
                a[i - shift] = a[i];
            }
        }
        nElems -= shift;
    }// end insertionSort()
//--------------------------------------------------------------      
  public void selectionSort() {
    int out, in, min;

    for (out = 0; out < nElems - 1; out++) {
        int numDuplicates = 0; // Track number of duplicates
        min = out;
        for (in = out + 1; in < nElems; in++) {
            if (a[in] == a[min]) {
                a[in] = -1; // Change one of the duplicates to -1
                numDuplicates++;
            } else if (a[in] < a[min]) {
                min = in;
                numDuplicates = 0; // Reset duplicates count if new minimum found
            }
        }
        swap(out, min - numDuplicates); // Move minimum element to out - numDuplicates position
        out -= numDuplicates; // Adjust outer loop index
        nElems -= numDuplicates; // Adjust number of elements
    }

    // Shift array left to remove duplicates
    int shift = 0;
    for (int i = 0; i < nElems; i++) {
        if (a[i] == -1) {
            shift++;
        } else {
            a[i - shift] = a[i];
        }
    }
    nElems -= shift;
}  // end selectionSort()
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class ArraySel
////////////////////////////////////////////////////////////////
class ArrySortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArraySort arr;                 // reference to array
      arr = new ArraySort(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(77);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(88);

      arr.display();                // display items

      arr.selectionSort();          // selection-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class SelectSortApp
////////////////////////////////////////////////////////////////
