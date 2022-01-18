# GitHub Actions Maven Central Test

Pushing a tag does a release.

Local Maven Deploy
```
./gradlew publishMavenJavaPublicationToMavenLocal
```

Central Maven Deploy
```
./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository
```
