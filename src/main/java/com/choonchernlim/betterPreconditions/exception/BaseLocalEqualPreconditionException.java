package com.choonchernlim.betterPreconditions.exception;

import org.joda.time.base.BaseLocal;

/**
 * This exception is thrown if the first value is equal to second value.
 */
public class BaseLocalEqualPreconditionException extends PreconditionException {

    /**
     * Constructs a new exception with an error message.
     *
     * @param firstBaseLocalValue  First base local value
     * @param firstBaseLocalLabel  First base local label
     * @param secondBaseLocalValue Second base local value
     * @param secondBaseLocalLabel Second base local label
     */
    public BaseLocalEqualPreconditionException(final BaseLocal firstBaseLocalValue,
                                               final String firstBaseLocalLabel,
                                               final BaseLocal secondBaseLocalValue,
                                               final String secondBaseLocalLabel) {
        super(String.format("%s [ %s ] must not be equal to %s [ %s ]",
                            firstBaseLocalLabel,
                            firstBaseLocalValue,
                            secondBaseLocalLabel,
                            secondBaseLocalValue));
    }
}
