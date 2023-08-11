package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.common.DateTimeService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.cleantestautomation.assertjdb.jooq.tables.UserAccount.USER_ACCOUNT;

/**
 * Provides CRUD operations for user accounts.
 */
@Repository
class UserAccountRepository {

    private final DateTimeService dateTimeService;
    private final DSLContext jooq;

    @Autowired
    UserAccountRepository(DateTimeService dateTimeService, DSLContext jooq) {
        this.dateTimeService = dateTimeService;
        this.jooq = jooq;
    }

    /**
     * Creates a new user account.
     * @param input The information of the created user account.
     * @return  The information of the created user account.
     */
    @Transactional
    public UserAccount create(CreateUserAccount input) {
        var currentDateAndTime = dateTimeService.getCurrentDateAndTime().toOffsetDateTime();
        var result = jooq.insertInto(USER_ACCOUNT)
                .columns(
                        USER_ACCOUNT.CREATION_TIME,
                        USER_ACCOUNT.DATE_OF_BIRTH,
                        USER_ACCOUNT.EMAIL_ADDRESS,
                        USER_ACCOUNT.GRANT_MARKETING_PERMISSION,
                        USER_ACCOUNT.NAME,
                        USER_ACCOUNT.MODIFICATION_TIME,
                        USER_ACCOUNT.PASSWORD,
                        USER_ACCOUNT.STATUS
                )
                .values(
                        currentDateAndTime,
                        input.getDateOfBirth(),
                        input.getEmailAddress(),
                        input.isGrantMarketingPermission(),
                        input.getName(),
                        currentDateAndTime,
                        input.getPassword(),
                        input.getStatus().name()
                )
                .returning(
                        USER_ACCOUNT.ID,
                        USER_ACCOUNT.DATE_OF_BIRTH,
                        USER_ACCOUNT.EMAIL_ADDRESS,
                        USER_ACCOUNT.GRANT_MARKETING_PERMISSION,
                        USER_ACCOUNT.NAME,
                        USER_ACCOUNT.STATUS
                )
                .fetchOptional().get();

        return UserAccount.getBuilder()
                .withId(result.getId())
                .withDateOfBirth(result.getDateOfBirth())
                .withEmailAddress(result.getEmailAddress())
                .withGrantMarketingPermission(result.getGrantMarketingPermission())
                .withName(result.getName())
                .withStatus(UserAccountStatus.valueOf(result.getStatus()))
                .build();
    }

    /**
     * Deletes the information of an existing user account.
     * @param id    The id of the deleted user account.
     * @return  The information of the deleted user account. If the deleted
     *          user account isn't found from the database, this method
     *          returns <code>null</code>.
     */
    @Transactional
    public UserAccount delete(Long id) {
        return jooq.delete(USER_ACCOUNT)
                .where(USER_ACCOUNT.ID.eq(id))
                .returning(
                        USER_ACCOUNT.ID,
                        USER_ACCOUNT.DATE_OF_BIRTH,
                        USER_ACCOUNT.EMAIL_ADDRESS,
                        USER_ACCOUNT.GRANT_MARKETING_PERMISSION,
                        USER_ACCOUNT.NAME,
                        USER_ACCOUNT.STATUS
                )
                .fetchOptional()
                .map(result -> UserAccount.getBuilder()
                        .withId(result.getId())
                        .withDateOfBirth(result.getDateOfBirth())
                        .withEmailAddress(result.getEmailAddress())
                        .withGrantMarketingPermission(result.getGrantMarketingPermission())
                        .withName(result.getName())
                        .withStatus(UserAccountStatus.valueOf(result.getStatus()))
                        .build())
                .orElse(null);
    }

    /**
     * Updates the information of an existing user account.
     * @param input The new information of the updated user account.
     * @return  The new information of the updated user account. If the updated
     *          user account isn't found from the database, this method returns
     *          <code>null</code>.
     */
    @Transactional
    public UserAccount update(UpdateUserAccount input) {
        var currentDateAndTime = dateTimeService.getCurrentDateAndTime().toOffsetDateTime();
        return jooq.update(USER_ACCOUNT)
                .set(USER_ACCOUNT.DATE_OF_BIRTH, input.getDateOfBirth())
                .set(USER_ACCOUNT.GRANT_MARKETING_PERMISSION, input.isGrantMarketingPermission())
                .set(USER_ACCOUNT.MODIFICATION_TIME, currentDateAndTime)
                .set(USER_ACCOUNT.NAME, input.getName())
                .set(USER_ACCOUNT.VERSION, USER_ACCOUNT.VERSION.add(1))
                .where(USER_ACCOUNT.ID.eq(input.getId()))
                .returning(
                        USER_ACCOUNT.ID,
                        USER_ACCOUNT.DATE_OF_BIRTH,
                        USER_ACCOUNT.EMAIL_ADDRESS,
                        USER_ACCOUNT.GRANT_MARKETING_PERMISSION,
                        USER_ACCOUNT.NAME,
                        USER_ACCOUNT.STATUS
                )
                .fetchOptional()
                .map(result -> UserAccount.getBuilder()
                        .withId(result.getId())
                        .withDateOfBirth(result.getDateOfBirth())
                        .withEmailAddress(result.getEmailAddress())
                        .withGrantMarketingPermission(result.getGrantMarketingPermission())
                        .withName(result.getName())
                        .withStatus(UserAccountStatus.valueOf(result.getStatus()))
                        .build())
                .orElse(null);
    }
}
