# Simple Quarkus Project with Kotlin

### Architecture
- Java 11
- Quarkus 3.0.1
- Kotlin 1.8.10
- [Mapstruct](https://mapstruct.org) for conversions between domains
- [Kotlin-Logging](https://github.com/oshai/kotlin-logging)
- [JUnit 5](https://junit.org/junit5/docs/current/user-guide) for unit tests
- [Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Hamcrest](http://hamcrest.org/JavaHamcrest) for alternative asserts
- [Kotlin Fixture Magic](https://github.com/wThomas84/kotlin-fixture-magic) for generate random objects
- [Rest Assured](https://rest-assured.io/) for integrations tests

### Instructions
- Clone the project
- Build the application `./gradlew build`
- Alternatively build the native executable `./gradlew build -Dquarkus.package.type=native`
- Run the project: `./gradlew --console=plain quarkusDev`

### About the application
It's a RESTFull API for booking and searching a hotel

### Access the application
```shell
curl --request GET \
--url http://localhost:8080/hotel/6
```


### References
- [Using Kotlin](https://quarkus.io/guides/kotlin)
- [Guide to Kotlin-Logging](https://www.baeldung.com/kotlin/kotlin-logging-library)
