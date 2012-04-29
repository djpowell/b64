# b64

Provides a data-reader and print-method support for base64-encoded byte-arrays.

## Usage

Add the library as a dependency to your project.  In Leiningen:

```clojure
  [net.djpowell/b64 "0.1.0"]
```

Ensure that the library has been loaded by requiring it from your `ns` form:

```clojure
  (:require [net.djpowell.b64.core])
```

You can now embed byte arrays in code by using base-64 encoded literals:

```clojure
  #djpowell/b64 "SGVsbG8gV29ybGQh"
```

Example:

```clojure
  (String. #djpowell/b64 "SGVsbG8gV29ybGQh" "us-ascii")
```

`=>`

```clojure
  "Hello world!"
```

## License

Copyright (C) 2012 David Powell

Distributed under the Eclipse Public License, the same as Clojure.
