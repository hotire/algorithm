package com.github.hotire.algorithm.testdome.ex;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class AccountTest {

    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void withdraw() {
        // given
        final Account account = new Account(-20);
        account.deposit(10);

        // when
        final boolean result = account.withdraw(10);

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void deposit() {
        // given
        final Account account = new Account(-20);

        // when
        final boolean result = account.deposit(10);

        // then
        Assert.assertTrue(result);
    }

    @Test
    public void depositNotAcceptNegativeNumber() {
        // given
        final Account account = new Account(-20);

        // when
        final boolean result = account.deposit(-10);

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void withdrawNotAcceptNegativeNumber() {
        // given
        final Account account = new Account(-20);

        // when
        final boolean result = account.withdraw(-10);

        // then
        Assert.assertFalse(result);
    }


    @Test
    public void withdrawLimitOverdraft() {
        // given
        final Account account = new Account(0);
        account.deposit(10);

        // when
        final boolean result = account.withdraw(11);

        // then
        Assert.assertFalse(result);
    }

    @Test
    public void getBalance() {
        // given
        final Account account = new Account(-20);

        // when
        account.deposit(10);
        final double result = account.getBalance();

        // then
        Assert.assertEquals(10.0, result, epsilon);
    }

    @Test
    public void depositAndWithdraw() {
        // given
        final Account account = new Account(-20);
        account.deposit(10);
        account.withdraw(10);

        // when;
        final double result = account.getBalance();

        // then
        Assert.assertEquals(0, result, epsilon);
    }


    @TestFactory
    public Stream<DynamicTest> depositFactory()  {
        class Case {
            private final double deposit;
            private final boolean expected;

            Case(double deposit, boolean expected) {
                this.deposit = deposit;
                this.expected = expected;
            }
        }

        return Stream.of(new Case(10.0, true))
                     .map(it -> DynamicTest.dynamicTest("depositFactory", () -> {

                     }));
    }


}