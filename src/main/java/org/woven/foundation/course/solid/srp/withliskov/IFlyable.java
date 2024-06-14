package org.woven.foundation.course.solid.srp.withliskov;

/**
 * Liskov Substitution principle - Functions that use pointers or references to <b>base</b> classes
 * must be able to use objects of <b>derived</b> classes without knowing it
 * here fly behaviour is substitutable for their base/derived class of IFlyable , hence compiles with LSP
 * <p>
 * Interface Segregation Principle states that clients should not be forced to implement interfaces they don't use.
 *</p>
 * We have seggregated Fluable and Swimmable behaviour
 */

public interface IFlyable {
    void fly();
}
