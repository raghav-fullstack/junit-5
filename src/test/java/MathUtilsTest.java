import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.Assumptions.*;

import java.lang.annotation.Repeatable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@EnabledOnJre(JRE.JAVA_11)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    void beforeAll(){
        System.out.println("\n Init the test...");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();

        //testReporter.publishEntry("Running the test :"+testInfo.getDisplayName() +"  with tags: " +testInfo.getTags());
        //System.out.println("Running the test :"+testInfo.getDisplayName() +"  with tags: " +testInfo.getTags());
    }


    @AfterEach
    void afterEach(){
        System.out.println("\n Cleaning up....");
    }


    @AfterAll
    void afterAll(){
        System.out.println("Cleaned up all.");
    }

    @Disabled
    @Test
    @DisplayName("Add two integers")
    @Tag("Math")
    void add() {
        assertEquals(4, MathUtils.add(2, 2));
    }

    @Tag("Math")
    @Nested
    @DisplayName("Add multiple doubles")
    class testAdd{

        @Test
        @DisplayName("Add two positive doubles")
        void addTwoPositiveNos(){
            assumeTrue(true);
            assertEquals(4, MathUtils.add(2D, 2D));
        }

        @Test
        @DisplayName("Add two positive & negative doubles")
        void addNegativePositiveNos(){
            assumeTrue(true);
            assertEquals(0, MathUtils.add(-4D, 2D, 2D));
        }

        @Test
        @DisplayName("Add three negative doubles")
        void addNegativeNos(){
            assumeTrue(true);
            assertEquals(-8, MathUtils.add(-4D, -2D, -2D));
        }

    }

    @Tag("Math")
    @Test
    @DisplayName("Multiply With Doubles")
    void multiply() {

        //testReporter.publishEntry(testInfo.getTags());
        System.out.println("Running the test :"+testInfo.getDisplayName() +"  with tags: " +testInfo.getTags());
        assertAll(
                () -> assertEquals(4, MathUtils.multiply(2, 2)),
                () -> assertEquals(-4, MathUtils.multiply(2, -2)),
                () -> assertEquals(4, MathUtils.multiply(-2, -2)),
                () -> assertEquals(0, MathUtils.multiply(1, 0)));
    }

    @Tag("Circle")
    @Test
    @DisplayName("Validate circle area with 1 radius.")
    void testComputeCircleAreaWithRadius1() {

        assertEquals(3.14, mathUtils.computeCircleArea(1), "Should return right value.");
    }

    @Tag("Circle")
    @RepeatedTest(3)
    @DisplayName("Validate circle area 3 times.")
    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
        System.out.println("Running the test "+testInfo.getDisplayName()+"  with tags " +testInfo.getTags());
        repetitionInfo.getCurrentRepetition();
        assertEquals(314.0, mathUtils.computeCircleArea(10.0), "Should return right value.");
    }

    @Tag("Math")
    @Test
    @DisplayName("Divide with zero exception")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw exception.");


    }


}