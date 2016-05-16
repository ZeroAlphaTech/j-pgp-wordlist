# j-pgp-wordlist

Java Implementation of the PGP Word List

## Usage

Include the dependency in your `pom.xml` file:

```xml
<dependency>
    <groupId>technology.zeroalpha.security</groupId>
    <artifactId>j-pgp-wordlist</artifactId>
    <version>0.2.0-SNAPSHOT</version>
</dependency>
```

You can then instantiate either `PGPWordListConverter` (for full access to the utility and convenience methods), or `PGPWordList` for direct access to the hexadecimal <-> PGP Word mappings:

```java
// To use utility and convenience methods
final PGPWordListConverter pgpWordListConverter = new PGPWordListConverter();

// For direct access to mappings
final PGPWordList pgpWordList = new PGPWordList();
```

Both classes are thread-safe.

## Version History

**0.1**: Convert between hexadecimal values and their associated PGP Words.

**0.1.1**: Added project name to POM, as required by Maven Central

