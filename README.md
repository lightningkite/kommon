# Kommon (LK)

 Maven: [ ![Download](https://api.bintray.com/packages/lightningkite/com.lightningkite.krosslin/kommon/images/download.svg) ](https://bintray.com/lightningkite/com.lightningkite.krosslin/kommon/_latestVersion) 

Contains things that are expected by basically everything cross-platform.

```
repositories {
    maven { url 'https://dl.bintray.com/lightningkite/com.lightningkite.krosslin' }
    ...
}
...
dependencies {
    ...
    //Depending on the version you need
    api "com.lightningkite:kommon-metadata:${lokalizeVersion}"
    api "com.lightningkite:kommon-jvm:${lokalizeVersion}"
    api "com.lightningkite:kommon-js:${lokalizeVersion}"
    api "com.lightningkite:kommon-iosarm64:${lokalizeVersion}"
    api "com.lightningkite:kommon-iosx64:${lokalizeVersion}"
    and more!
}```

## Features

- `ConcurrentHashMap`
- `WeakHashMap`
- Various extensions for collections
    - Live collection mapping (`.mapping{}`)
    - Tree walking sequence
    - Stack operators for lists
    - `addSorted`
- Handling bits
- Various things with text
- Atomic structures for all platforms
    - `AtomicReference<T>`
    - `AtomicInt`
    - `AtomicLong`

## Things that still need done

I'll gladly accept help!

- `WeakHashMap` for Native
- `ConcurrentHashMap` for Native
