package com.cleantestautomation.assertjdb.useraccount;

/**
 * Identifies the index of the database table row which contains the information
 * of each user account that's found from our test data.
 */
public enum UserAccountTableRow {

    ANNE_OWENS(0),
    LEO_VIRTANEN(1),
    NEW_USER_ACCOUNT(0);
    private int index;

    UserAccountTableRow(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
