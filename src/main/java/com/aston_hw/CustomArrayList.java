package com.aston_hw;

import java.util.*;

public class CustomArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;

    private static final Object[] EMPTY_ARRAY = {};

    private int size = 0;

    transient Object[] arrayList;

    public CustomArrayList() {
        arrayList = EMPTY_ARRAY;
    }

    public CustomArrayList(int capacity) {
        if (capacity > 0) {
            arrayList = new Object[capacity];
        } else if (capacity == 0) {
            arrayList = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal capacity" + capacity);
        }
    }


    public void add(int index, E element) {
        isValidRange(index);
        if (size() == arrayList.length) {
            extendArray(INITIAL_CAPACITY);
        }
        System.arraycopy(arrayList, index, arrayList, index + 1, arrayList.length - (index + 1));
        arrayList[index] = element;
        size++;
    }

    public boolean add(E element) {
        if (size == 0) {
            extendArray(INITIAL_CAPACITY);
            arrayList[size] = element;
        }
        if (size < arrayList.length) {
            arrayList[size] = element;
            size++;
            return true;
        } else if (size == arrayList.length) {
            extendArray(INITIAL_CAPACITY);
            arrayList[size + 1] = element;
            size++;
            return true;
        }
        return false;
    }


    public boolean addAll(Collection<? extends E> collection) {
        Object[] a = collection.toArray();
        int arrayLength = a.length;
        if (arrayLength == 0) {
            return false;
        }
        if (arrayLength > (arrayList.length - size())) {
            extendArray(arrayLength);
        }
        System.arraycopy(a, 0, arrayList, size(), arrayLength);
        size = size + arrayLength;
        return true;
    }


    public void clear() {
        arrayList = EMPTY_ARRAY;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        isValidRange(index);
        return (E) arrayList[index];
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public E remove(int index) {
        isValidRange(index);
        @SuppressWarnings("unchecked") E i = (E) arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - (index - 1));
        size--;
        return i;
    }


    public boolean remove(Object object) {
        int i = 0;
        if (object == null) {
            for (; i < size(); i++) {
                if (arrayList[i] == null) {
                    E remove = remove(i);
                    return true;
                }
            }
        } else {
            for (; i < size(); i++) {
                if (object.equals(arrayList[i])) {
                    E remove = remove(i);
                    return true;
                }
            }
        }
        return false;
    }


    public void sort(Comparator<? super E> comparator) {
        if (comparator == null) {
            sort(arrayList, 0, size - 1, Comparator.naturalOrder());
        } else {
            sort(arrayList, 0, size - 1, comparator);
        }
    }


    public int size() {
        return size;
    }

    private void extendArray(int capacity) {
        Object[] newArray = new Object[arrayList.length + capacity];
        System.arraycopy(arrayList, 0, newArray, 0, size);
        arrayList = newArray;
    }

    private void isValidRange(int index) {
        if (index < 0 || index > arrayList.length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    @SuppressWarnings("rawtypes")
    private void sort(Object[] arr, int left, int right, Comparator comparator) {
        if (left < right) {
            int delimiter = quickSort(arr, left, right, comparator);
            sort(arr, left, delimiter - 1, comparator);
            sort(arr, delimiter, right, comparator);
        }
    }

    @SuppressWarnings("rawtypes, unchecked")
    private int quickSort(Object[] array, int left, int right, Comparator comparator) {
        Object delimiter = array[left + (right - left) / 2];
        while (left <= right) {
            while (comparator.compare(array[left], delimiter) < 0) {
                left++;
            }
            while (comparator.compare(array[right], delimiter) > 0) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(Object[] array, int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
