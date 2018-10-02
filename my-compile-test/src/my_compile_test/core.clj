(ns my-compile-test.core
  (:require
   [cljs.compiler :as compiler]
   [cljs.analyzer :as analyzer]
   [clojure.tools.reader :as reader]))


(compiler/emit-str (analyzer/analyze {} '(+ 1 1)))

(compiler/emit-str
 (analyzer/analyze
  {}
  (reader/read-string
   "((fn foo [x] (js/print x)) 42)")))

(println
 (compiler/emit-str (analyzer/analyze {} "(print \"test\")")))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
