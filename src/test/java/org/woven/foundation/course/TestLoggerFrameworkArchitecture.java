package org.woven.foundation.course;


import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.junit.jupiter.api.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


@AnalyzeClasses(packages = TestLoggerFrameworkArchitecture.JAVA_UTIL_LOGGING)
public class TestLoggerFrameworkArchitecture {

    public static final String JAVA_UTIL_LOGGING = "java.util.logging";
    public static final String LOGGER = "Logger";

    ArchCondition<JavaClass> havePrivateConstructors
            = new ArchCondition<>("have private constructors") {
        @Override
        public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
            boolean hasPrivateConstructor = javaClass.getConstructors().stream()
                    .anyMatch(constructor -> constructor.getModifiers().contains(JavaModifier.PRIVATE)
                            && constructor.isConstructor());
            String message = String.format("%shave a private constructor", javaClass.getFullName());

            conditionEvents.add(new SimpleConditionEvent(javaClass, hasPrivateConstructor, message));

        }
    };

    ArchCondition<JavaClass> haveNoPublicConstructors
            = new ArchCondition<>("has no public constructor") {
        @Override
        public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
            boolean hasPrivateConstructor = javaClass.getConstructors().stream()
                    .noneMatch(constructor -> constructor.getModifiers().contains(JavaModifier.PUBLIC));
            String message = String.format("%s has no public constructor", javaClass.getFullName());

            conditionEvents.add(new SimpleConditionEvent(javaClass, hasPrivateConstructor, message));

        }
    };

    ArchCondition<JavaClass> hasPublicStaticFinalMethod
            = new ArchCondition<>("does have public/static/final method") {
        @Override
        public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
            boolean hasPublicStaticFinalMethod = javaClass.getMethods().stream()
                    .anyMatch(method -> method.getModifiers().contains(JavaModifier.PUBLIC)
                            && method.getModifiers().contains(JavaModifier.STATIC)
                            && method.getModifiers().contains(JavaModifier.FINAL));

            String message = String.format("%s does have public/static/final method", javaClass.getFullName());

            conditionEvents.add(new SimpleConditionEvent(javaClass, hasPublicStaticFinalMethod, message));
        }
    };

    ArchCondition<JavaClass> hasPublicMethodWithNameLog
            = new ArchCondition<>("does have public method starting with log") {
        @Override
        public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
            boolean hasPublicMethodWithNameLog = javaClass.getMethods().stream()
                    .anyMatch(method -> method.getModifiers().contains(JavaModifier.PUBLIC)
                            && method.isMethod()
                            && method.getName().contains("log"));

            String message = String.format("%s does not have public method starting with log", javaClass.getFullName());

            conditionEvents.add(new SimpleConditionEvent(javaClass, hasPublicMethodWithNameLog, message));
        }
    };

    ArchCondition<JavaClass> haveLimitedMethods
            = new ArchCondition<>("have limited number of methods") {

        @Override
        public void check(JavaClass javaClass, ConditionEvents events) {
            int methodCount = javaClass.getMethods().size();
            // Set your limit here
            int MAX_METHODS = 84;
            if (methodCount > MAX_METHODS) {
                String message = String.format("%s has %d methods, exceeding the limit of %d",
                        javaClass.getName(), methodCount, MAX_METHODS);
                events.add(new SimpleConditionEvent(javaClass, false, message));
            }
        }
    };
    private JavaClasses importedClasses;

    @Test
    void loggersIsSingleton() {
        // Import classes from the specified package
        importedClasses = new ClassFileImporter()
                .importPackages(JAVA_UTIL_LOGGING);

        // Add rules to imported classes
        ArchRule loggersIsSingleton = classes().that().haveSimpleName(LOGGER)
                .should(hasPublicStaticFinalMethod).andShould(havePrivateConstructors);

        // Check the rule against the imported classes
        loggersIsSingleton.check(importedClasses);
    }

    @Test
    void adhereToSingleResponsibilityPrinciple() {
        // Import classes from the specified package
        JavaClasses importedClasses = new ClassFileImporter()
                .importPackages(JAVA_UTIL_LOGGING);

        // Add rules to imported classes
        ArchRule adheresToSRPrinciple = classes().that().haveSimpleName(LOGGER)
                .should(hasPublicMethodWithNameLog);

        // Check the rule against the imported classes
        adheresToSRPrinciple.check(importedClasses);

    }

    @Test
    void adhereToOpenClosedPrinciple() {
        // Import classes from the specified package
        JavaClasses importedClasses = new ClassFileImporter().importPackages(JAVA_UTIL_LOGGING);

        // Define the rule: Logger classes should have private constructors
        ArchRule rule = classes()
                .that().haveSimpleNameEndingWith(LOGGER)
                .should(havePrivateConstructors).andShould(haveNoPublicConstructors);

        // Check the rule against the imported classes
        rule.check(importedClasses);
    }

    @Test
    void adhereToOpenForExtension() {

        ArchRule handlerClassesShouldImplementOrExtend = classes()
                .that().haveSimpleNameEndingWith("Handler") // Check for names ending with "Handler"
                .should().beAssignableTo(Handler.class) // Check if they implement the Handler interface
                .orShould().beAssignableTo(ConsoleHandler.class) // Or extend ConsoleHandler
                .orShould().beAssignableTo(FileHandler.class)// Or extend FileHandler
                .orShould().beAssignableTo(StreamHandler.class); // Or extend  StreamHandler
    }

    @Test
    void adhereToLiskovSubstitutionPrinciple() {
        // Import classes from the specified package
        JavaClasses importedClasses = new ClassFileImporter().importPackages(JAVA_UTIL_LOGGING);

        // Define the rule: Logger classes and their subclasses should be substitutable
        ArchRule rule = classes()
                .that().haveSimpleName(LOGGER) // Adjust this based on your naming convention
                .should().beAssignableTo(Logger.class); // Assuming Logger is your base logger class

        // Check the rule against the imported classes
        rule.check(importedClasses);
    }

    @Test
    void adhereToInterfaceSegregationPrinciple() {
        // Import classes from the specified package
        JavaClasses importedClasses = new ClassFileImporter().importPackages(JAVA_UTIL_LOGGING);

        // Define the rule: Logger interfaces should not have more than a specified number of methods
        ArchRule rule = classes()
                .that().haveSimpleName(LOGGER)
                .should().accessClassesThat().areInterfaces()
                .andShould(haveLimitedMethods);

        // Check the rule against the imported classes
        rule.check(importedClasses);
    }

    @Test
    void handlersShouldDependOnAbstractions() {
        // Import classes from the specified package
        JavaClasses importedClasses = new ClassFileImporter().importPackages(JAVA_UTIL_LOGGING);

        ArchRule rule1 = classes()
                .that().haveFullyQualifiedName(ConsoleHandler.class.getName())
                .should().beAssignableTo(Handler.class);

        ArchRule rule2 = classes()
                .that().haveFullyQualifiedName(Handler.class.getName())
                .should().haveModifier(JavaModifier.ABSTRACT);

        // Check the rule against the imported classes
        rule1.check(importedClasses);
        rule2.check(importedClasses);
    }

}
