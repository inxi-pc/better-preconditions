package com.github.choonchernlim.betterPreconditions.preconditions

import com.github.choonchernlim.betterPreconditions.exception.BooleanFalsePreconditionException
import com.github.choonchernlim.betterPreconditions.exception.BooleanTruePreconditionException
import com.github.choonchernlim.betterPreconditions.exception.ObjectNullPreconditionException
import spock.lang.Specification

import static com.github.choonchernlim.betterPreconditions.preconditions.PreconditionFactory.expect

class BooleanToBeTruePreconditionsSpec extends Specification {

    def "toBeTrue - true == true should be ok"() {
        when:
        def actualValue = expect(true).toBeTrue().check()

        then:
        actualValue
    }

    def "toBeTrue - false == true should throw BooleanFalsePreconditionException"() {
        when:
        expect(false).toBeTrue().check()

        then:
        def error = thrown(BooleanFalsePreconditionException.class)
        error.message == "Boolean [ false ] must be true" as String
    }

    def "toBeTrue - null == true should throw ObjectNullPreconditionException"() {
        when:
        expect(null as Boolean).toBeTrue().check()

        then:
        def error = thrown(ObjectNullPreconditionException.class)
        error.message == "Boolean [ null ] must not be null" as String
    }

    def "not.toBeTrue - false != true should be ok"() {
        when:
        def actualValue = expect(false).not().toBeTrue().check()

        then:
        !actualValue
    }

    def "not.toBeTrue - null != true should throw ObjectNullPreconditionException"() {
        when:
        expect(null as Boolean).not().toBeTrue().check()

        then:
        def error = thrown(ObjectNullPreconditionException.class)
        error.message == "Boolean [ null ] must not be null" as String
    }

    def "not.toBeTrue - true != true should throw BooleanTruePreconditionException"() {
        when:
        expect(true).not().toBeTrue().check()

        then:
        def error = thrown(BooleanTruePreconditionException.class)
        error.message == 'Boolean [ true ] must not be true'
    }

}
