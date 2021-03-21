# Sort 

## Arrays.sort

### 1. Use Quicksort on small arrays
~~~java
// Use Quicksort on small arrays
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
~~~
286 size보다 작은 경우 Quicksort를 사용한다. 

