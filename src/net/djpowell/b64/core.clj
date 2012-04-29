(ns net.djpowell.b64.core
  (:import (java.io Writer)
           (java.nio.charset Charset))
  (:require [clojure.data.codec.base64 :as base64]))

(set! *warn-on-reflection* true)

(def ^Charset ascii (Charset/forName "us-ascii"))

(defn read-b64
  "Convert a base-64 encoded string to a byte array.
  Used by the #djpowell/b64 data-reader."
  [^String s]
  (when-not (string? s)
    (throw (RuntimeException. (str "base-64 literals must be strings, got: " (class s)))))
  (let [enc-bytes (.getBytes s ascii)]
    (base64/decode enc-bytes)))

(def ^:private bytes-class (class (byte-array 0)))

(defmethod print-method bytes-class [^bytes o ^Writer w]
  (.write w "#djpowell/b64 ")
  (let [^bytes enc-bytes (base64/encode o)
        enc-str (String. enc-bytes ascii)
        ]
    (print-method enc-str w)))

(defmethod print-dup bytes-class [^bytes o ^Writer w]
  (print-method o w))
