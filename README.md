Reference Repo : https://github.com/koushikkothagal/junit-5-basics-course


Testing annotation

Class level annotations

@EnabledOnJre(JRE.JAVA_11)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

Method level annotations
@Disabled
@Test
@DisplayName("Add two integers")

following are few important methods

assertEqual();
assertAll();
assumeTrue();

@RepeatedTest(no of repeatations)(in place of @Test)



Following are the hooks, which are available for Junit 5.0 
@BeforeAll
@AfterAll
@BeforeEach
@AfterEach

Note: We can also create subclass with @Nested annotation in order to make things 
better arranged.