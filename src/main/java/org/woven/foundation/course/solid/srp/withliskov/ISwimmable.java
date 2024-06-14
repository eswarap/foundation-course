package org.woven.foundation.course.solid.srp.withliskov;

/**
 * Liskov Substitution principle - Functions that use pointers or references to <b>base</b> classes
 * must be able to use objects of <b>derived</b> classes without knowing it
 *<p>
 * Here swimming behaviour is substitutable for their base/derived class of IFlyable , hence compiles with LSP
 *</p><p>
 * Interface Segregation Principle states that clients should not be forced to implement interfaces they don't use.
 *</p><p>
 *  We have seggregated Fluable and Swimmable behaviour, so behaviour can be implemented seperately</p>
 */
public interface ISwimmable {
    void swim();
}
