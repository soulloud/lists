package org.macalester.edu.comp124.lists;


/**
 * An unfinished implementation of an array-based List.
 *
 * @author shilad
 * @param <E>
 */
public class MyArrayList<E> {
	/**
	 * The array elements
	 */
	private E[] elements;
	
	/**
	 * The number of elements currently contained in the list.
	 */
	private int currentSize;

	/**
	 * Creates a new list.
	 */
	public MyArrayList() {
		clear();
	}
	
	/**
	 * Clears the contents of the array.
	 */
	public void clear() {
		elements = newArrayOfE(4);
		currentSize = 0;
	}
	
	/**
	 * Returns the current size of the list.
	 * @return
	 */
	public int size() {
		return currentSize;
	}
	
	/**
	 * Returns the element at position index.
	 * @param index
	 * @return
	 */
	public E get(int index) {
        return elements[index];    // replace this line with the correct code.
	}
	
	/**
	 * Adds a new element to the end of the list:
	 * 
	 * If the array is full, expand the array.
	 * Add the element to the first unused position in the array.
	 * Update the size of the array.
	 * 
	 * @param elem
	 */
	public void add(E elem) {
        if (currentSize == elements.length) {
            E[] tempArray = newArrayOfE(currentSize+1);
            for (int i = 0; i < currentSize; i++) {
                tempArray[i] = elements[i];
            }
            elements = tempArray;
        }
        elements[currentSize] = elem;
        currentSize +=1;
	}

	/**
	 * Inserts a new element at the specified index.
	 * 
	 * If the array is full, expand the array.
	 * Slide the elements of the array starting with index over.
	 * Place the new element in the correct spot of the array.
	 * 
	 * Update the size of the array.
	 * 
	 * @param elem
	 */
	public void add(int index, E elem) {

        E[] tempArray = newArrayOfE(currentSize+1);
        for (int i = 0; i < index; i++) {
            tempArray[i] = elements[i];
        }
        tempArray[index] = elem;
        for (int i = index; i < currentSize; i++) {
            tempArray[i + 1] = elements[i];
        }
        elements = tempArray;
        currentSize +=1;
	}
	
	/**
	 * Doubles the size of the array, copies the old elements
	 * into the new array, and updates elements to point to the
	 * new array.
	 * 
	 * This will be useful for both versions of add().
     * Hint: use newArrayOfE!
	 */
	private void expandSize() {
        E[] tempArray = newArrayOfE(currentSize*2);
        for (int i = 0; i < currentSize; i++) {
            tempArray[i] = elements[i];
        }
        elements = tempArray;
        currentSize = currentSize*2;
	}
	
	/**
	 * Due to some crazy Java constraints, we can't simply create a
	 * new array of elements of class E.  We need to create an array
	 * of class Object and then cast the array to E.
	 * @param capacity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private E[] newArrayOfE(int capacity) {
		return (E[])new Object[capacity];
	}
}
