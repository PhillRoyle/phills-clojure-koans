(ns koans.12-creating-functions
  (:require [koan-engine.core :refer :all]))

(defn square [x] (* x x))

(meditations
  "One may know what they seek by knowing what they do not seek"
  (= [true false true] (let [not-a-symbol? (complement symbol?)]
                  (map not-a-symbol? [:a 'b "c"])))

  "Praise and 'complement' may help you separate the wheat from the chaff"
  (= [:wheat "wheat" 'wheat]
       (let [not-nil? (complement nil?)]
         (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil])))

  "Partial functions allow procrastination"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (multiply-by-5 4)))
  #_ (= 120 (let [multiply-by-5 (partial * 5)]
          (multiply-by-5 4 6)))
  ;thought partial was a sort of var-arg, but the above multiplies 4 by 5, and then the result by 6 (or something to that effect)

  "Don't forget: first things first"
  (= [__ __ __ __]
       (let [ab-adder (partial concat [:a :b])]
         (ab-adder [__ __])))

  "Functions can join forces as one 'composed' function"
  (= 25 (let [inc-and-square (comp square inc)]
          (inc-and-square __)))

  "Have a go on a double dec-er"
  (= __ (let [double-dec (comp dec dec)]
          (double-dec 10)))

  "Be careful about the order in which you mix your functions"
  (= 99 (let [square-and-dec ___]
          (square-and-dec 10))))
