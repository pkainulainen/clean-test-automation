package com.cleantestautomation.assertjdb.todoitem;

/**
 * Identifies the index of the database table row which contains the information
 * of each todo item that's found from our test data.
 */
public enum TodoItemTableRow {

    FINISH_ALL_EXERCISES(1),
    NEW_TODO_ITEM(0),
    READ_ALL_LESSONS(0);
    private int index;

    TodoItemTableRow(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
