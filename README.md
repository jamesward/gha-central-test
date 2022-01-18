# GitHub Actions Maven Central Test

Pushing a tag does a release.

Local Maven Deploy
```
./gradlew publishMavenJavaPublicationToMavenLocal
```

Get your gpg private key
```
gpg --armor --export-secret-keys <key id>
```

Set env vars:
- `SONATYPE_USERNAME`
- `SONATYPE_PASSWORD`
- `GPG_PRIVATE_KEY`
- `GPG_PASSPHRASE`

Central Maven Deploy
```
./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository
```
